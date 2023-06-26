<template>
  <el-table :data="tableData" stripe style="width: 100%">
    <el-table-column prop="orderid" label="订单ID"  />
    <el-table-column prop="sessionid" label="场次ID" />
    <el-table-column prop="seatinfo" label="座位信息" />
    <el-table-column prop="price" label="价格"  />
    <el-table-column prop="userid" label="用户ID"  />
  </el-table>
</template>

<script lang="ts">
import { defineComponent, onMounted, reactive, toRefs } from 'vue'
import {OrdertList} from "../../type/order"
import {orderList} from "../../request/api"

export default defineComponent({
  setup () {
    
    const data = reactive(new OrdertList())

    onMounted(()=>{
      orderList().then(res=>{
        console.log(res);
        data.tableData = res.data.meg
      })
    })


    return {...toRefs(data)}
  }
})
</script>

<style scoped>

</style>