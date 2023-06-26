<template>
  <el-table :data="tableData" stripe style="width: 100%">
    <el-table-column prop="id" label="用户ID" width="180" />
    <el-table-column prop="username" label="用户昵称" width="180" />
    <el-table-column prop="registrationdate" label="注册时间" />
  </el-table>
</template>

<script lang="ts">
import { defineComponent,onMounted,reactive, toRefs } from 'vue'
import{userList} from "../../request/api"
import{UserList} from "../../type/login"


export default defineComponent({
  setup() {

    const data = reactive(new UserList())

    onMounted(()=>{
      userList().then(res=>{
        console.log(res);
        data.tableData = res.data.mes
      })
    })

    return {...toRefs(data)}
  },
})
</script>

<style scoped>
</style>