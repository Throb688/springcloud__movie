<template>
   <el-page-header @back="goBack">
    <template #content>
      <span class="text-large font-600 mr-3"> 详情 </span>
    </template>
  </el-page-header>
  <div class="order-confirmation">
    <h1>订单信息</h1>
    <el-card class="order-details">
      <div class="order-section">
         <p class="order-label">订单id:</p>
        <p class="order-value">{{ order.id }}</p>
      </div>
      <div class="order-section">
        <p class="order-label">价格:</p>
        <p class="order-value">{{ order.totalPrice }} 元</p>
      </div>
      <div class="order-section">
        <p class="order-label">信息:</p>
        <p class="order-value">{{order.info}}</p>
      </div>
      <div class="order-section">
        <p class="order-label">座位信息：</p>
        <p class="order-value">{{ order.quantity }}</p>
      </div>
    </el-card>
    <el-card class="shipping-address">
      <p class="address-label">电影地址:</p>
      <p class="address-value">{{ order.shippingAddress }}</p>
      
    </el-card>
    <el-button class="confirm-button" type="primary" @click="confirmOrder">确认订单</el-button>
    <div>
  </div>
  </div>
</template>

<script lang="ts">
import { defineComponent,reactive, toRefs,onMounted } from 'vue'
import { useRouter,useRoute} from 'vue-router'
import {OrdertData} from '../type/order'
import axios from 'axios'
import { v4 as uuidv4 } from 'uuid';
import {
  getMovieListById,
  getSessionListById,
  getSeatListById,
  addOrder
} from '../request/api';
export default defineComponent({
  setup () {
    const router = useRouter()
    const data = reactive(new OrdertData())
    const route = useRoute()
    

    onMounted(()=>{
        if (Array.isArray(route.query.list)) {
          data.order.session = Number(route.query.session);
           data.seatList = route.query.list.map(item => String(item));
           data.sesssionFrom.seatidInfo = data.seatList
        } else if (route.query.list !== null) {
          data.seatList = [String(route.query.list)];
          data.order.session = Number(route.query.session);
          data.sesssionFrom.seatidInfo = data.seatList
        }

       
        getSessionListById( data.order.session).then(res => {
        data.sesssionFrom.sessionid = data.order.session
        data.order.shippingAddress = res.data.msg[0].site+" "+res.data.msg[0].time
        getMovieListById( res.data.msg[0].movieid).then(res1 => {
         data.order.totalPrice = Number(res1.data.mes.price)*data.seatList.length
         data.order.info = res1.data.mes.title
         data.sesssionFrom.price = data.order.totalPrice
        });
        })
        
        getSeatListById(Array.from(data.seatList)).then(res=>{
          const list = (Array.from(res.data.msg.data.msg) as { row1: string; col: string }[]).map(item => {
            return item.row1 + " 排 " + item.col + " 座 ";
          });
          data.order.quantity=list.toString()
          data.sesssionFrom.seatInfo = data.order.quantity
        })

        const generateOrderNumber = () => {
         return uuidv4().replace(/-/g, '');
        };
      data.order.id = generateOrderNumber();
      data.sesssionFrom.orderid =  data.order.id 
      data.sesssionFrom.userid = Number(localStorage.getItem("token")+"")
  })
  
    const goBack = () => {
      router.push('/main')
    }

    const confirmOrder = async () => {
      try {
    // 发起订单确认请求
    await addOrder(data.sesssionFrom).then(res=>{
      alert("购买成功")
      goBack()
    })
    
     // 打印订单确认接口的返回结果
  } catch (error) {
    console.error(error);
  }
};
    return {
      ...toRefs(data),
      confirmOrder,
      goBack 
    };
  }
})


// const confirmOrder = async () => {
//   try {
//     // 发起订单确认请求
//     const response = await axios.post('/api/confirm-order', {
//       orderId: order.id
//     });
    
//     console.log(response.data); // 打印订单确认接口的返回结果
//   } catch (error) {
//     console.error(error);
//   }
// };

// const OrderConfirmation = {
//   components: {
//     ElButton,
//     ElCard
//   },

</script>

<style scoped>
.order-confirmation {
  display: flex;
  flex-direction: column;
  align-items: center;
}

.order-confirmation h1 {
  margin-bottom: 20px;
  font-size: 24px;
  font-weight: bold;
}

.order-details,
.shipping-address {
  width: 400px;
  padding: 20px;
  margin-bottom: 20px;
  border: 1px solid #ccc;
  border-radius: 4px;
}

.order-value {
  flex: 1;
  word-break: break-all;
}
.order-section {
  display: flex;
  align-items: center;
  margin-bottom: 10px;
}

.order-label {
  flex: 0 0 120px;
  font-weight: bold;
}



.shipping-address .address-label {
  font-weight: bold;
}

.confirm-button {
  width: 200px;
}
</style>
