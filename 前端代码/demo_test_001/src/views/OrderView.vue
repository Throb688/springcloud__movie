<template>
 <el-card v-if="OrderList">
      <template v-if="OrderList.length > 0">
        <div class="search-results">
          <div class="search-results-container">
            <el-card v-for="result in OrderList" :key="result.orderid"  class="search-results-card">
              <div class="search-results-card-content">
                <div class="search-results-card-item">
                  <div class="search-results-card-name">订单号：{{ result.orderid }}</div>
                </div>
                <div class="search-results-card-item">
                  <div class="search-results-card-description">{{ result.seatinfo }}</div>
                </div>
                <div class="search-results-card-item">
                  <div class="search-results-card-description">{{ result.ordertime }} </div>
                </div>
                <div class="search-results-card-item">
                  <div class="search-results-card-price">{{ result.price }} 元</div>
                </div>
                <div class="search-results-card-item">
                  <el-button text @click="findMovie(result.sessionid)">
                      立即评价
                  </el-button>
                </div>
              </div>
            </el-card>
          </div>
        </div>
      </template>
      <template v-else>
        <div class="no-results">没有找到匹配的结果</div>
      </template>
    </el-card>



    <el-dialog v-model="dialogFormVisible" :title="title">
    <el-form :model="form">
      <el-form-item label="你的评价：" :label-width="formLabelWidth">
        <el-input v-model="form.evaluatetext " autocomplete="off" />
      </el-form-item>
    </el-form>
    <template #footer>
      <span class="dialog-footer">
        <el-button @click="dialogFormVisible = false">关闭</el-button>
        <el-button type="primary" @click="submit">
          提交
        </el-button>
      </span>
    </template>
  </el-dialog>

</template>

<script lang="ts">
import { defineComponent,reactive, toRefs,onMounted} from 'vue'
import{OrdertInit} from '../type/order'
import {
  findOrderByUserId,
  getSessionListById,
  getMovieListById,addEvaluate
} from '../request/api';
import { useRouter} from 'vue-router'
import {
  Edit
} from '@element-plus/icons-vue'

export default defineComponent({
  setup () {
    const router = useRouter()
    const formLabelWidth = '140px'
    const data = reactive(new OrdertInit())
    const form = reactive({
      evaluatetext : '',
       userid:0,
       movieId:0
    })

    onMounted(() => {
      
    form.userid  = Number(localStorage.getItem("token")+"")
    }),
    form.userid  = Number(localStorage.getItem("token")+"")
    findOrderByUserId(form.userid).then(res=>{
      console.log(form.userid);
      
      data.OrderList = res.data.msg
    })

    const submit = ()=>{
      console.log(form);
      
      addEvaluate(form).then(res=>{
        data.dialogFormVisible = false
        alert("评价成功")
        router.push('/order')
      })
    }

    const findMovie = (val:number)=>{
      getSessionListById(val).then(res=>{
        form.movieId = res.data.msg[0].movieid
        getMovieListById(res.data.msg[0].movieid).then(res1=>{
          data.title = res1.data.mes.title
          data.dialogFormVisible = true
        })
      })
    }


  
    return {...toRefs(data),Edit,form,formLabelWidth,findMovie,submit}
  }
})
</script>

<style scoped>
.search-page {
  padding: 20px;
}

.search-results {
  margin-top: 20px;
}

.search-results-title {
  font-size: 20px;
}

.search-results-container {
  display: flex;
  flex-direction: column;
}

.search-results-card {
  margin-bottom: 20px;
  border-radius: 8px;
  background-color: #f5f7fa;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
}

.search-results-card-content {
  display: flex;
  padding: 20px;
}

.search-results-card-item {
  flex-grow: 1;
  text-align: center;
}

.search-results-card-item img {
  width: 100px;
  height: 100px;
  object-fit: cover;
  border-radius: 50%;
}

.search-results-card-name {

  margin-top: 10px;
}

.search-results-card-price {
 
  margin-top: 10px;
}

.search-results-card-description {
  margin-top: 10px;
}

.no-results {
  margin-top: 20px;
  text-align: center;
  color: #999;
}

.el-button--text {
  margin-right: 15px;
}
.el-select {
  width: 300px;
}
.el-input {
  width: 300px;
}
.dialog-footer button:first-child {
  margin-right: 10px;
}
</style>