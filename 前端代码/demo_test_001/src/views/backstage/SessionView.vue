<template>
   <el-button type="primary" round  @click="dialogFormVisible = true">
      新增</el-button>

  <el-table :data="tableData" stripe style="width: 100%">
    <el-table-column prop="sessionid" label="场次ID"  />
    <el-table-column prop="movieid" label="电影" />
    <el-table-column prop="site" label="影院名称" />
    <el-table-column prop="time" label="电影时间" />
    <el-table-column prop="status" label="号厅" />
    <el-table-column fixed="right" label="Operations" width="120">
      <template #default="scope">
        <el-button link type="primary" size="small"  @click="open1(scope.row.sessionid)"
          >删除</el-button
        >
      </template>
    </el-table-column>
  </el-table>



  <el-dialog v-model="dialogFormVisible"  title="新增场次">
    <el-form :model="form">
      <el-form-item label="选择电影"  :label-width="formLabelWidth">
     <el-select v-model="form.movieid" clearable  class="m-2" placeholder="选择电影">
    <el-option
      v-for="item in movieList"
      :key="item.movieid"
      :label="item.title"
      :value="item.movieid"
      />
    </el-select>
  </el-form-item>
  <el-form-item label="影院选择" :label-width="formLabelWidth">
  <el-select v-model="form.site" clearable  class="m-2" placeholder="影院选择">
    <el-option
      v-for="item1 in options"
      :key="item1.id"
      :label="item1.value"
      :value="item1.value"
      />
    </el-select>
  </el-form-item>
  <el-form-item label="时间" style="margin-left: 87px;">
    <el-time-select
    v-model="form.time"
    start="08:30"
    step="00:15"
    end="18:30"
    placeholder="Select time"
  />
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
import { defineComponent, onMounted, reactive, toRefs } from 'vue'
import {getSession,getMovieList,addSession,delSession} from '../../request/api'
import {SessionData} from '../../type/session'

export default defineComponent({
  setup () {
    
    const data = reactive(new SessionData())

    onMounted(()=>{
      getSession().then(res=>{
        data.tableData = res.data.msg
      })

      getMovieList().then(res=>{
        data.movieList  = res.data.mes
        for(var i = 0;i<data.tableData.length;i++){
          for(var j = 0;j<data.movieList.length;j++){
          if(data.tableData[i].movieid ==data.movieList[j].movieid){
            data.tableData[i].movieid = data.movieList[j].title
          }
        }
        }
      })
    })

    const options = [
      {
        id:1,
        value: '万达影院',
        label: '万达影院',
      },
      {
        id:2,
        value: '中影影城',
        label: '中影影城',
      },
      {
        id:3,
        value: '万科影院',
        label: '万科影院',
      }
    ]


    const submit = ()=>{
      console.log(data.form);
      
      addSession(data.form).then(()=>{
        alert("新增成功")
        data.dialogFormVisible = false
        window.location.reload()
      })
    }

    const open1 = (session:number)=>{
      delSession(session).then(res=>{
        console.log(res);
        
        alert("删除成功")
        window.location.reload()
        
      })
    }

    return {...toRefs(data),options,submit,open1}
  }
})
</script>

<style scoped>

</style>