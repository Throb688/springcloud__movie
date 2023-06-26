<template>
    <el-button type="primary" round  @click="dialogFormVisible = true">
      新增</el-button>
 

<el-table :data="dataList.comList" style="width: 100%">
  <el-table-column prop="title" label="片名" />
  <el-table-column prop="director" label="导演" />
    <el-table-column prop="actors" label="演员" />
    <el-table-column prop="price" label="价格" />
    <el-table-column prop="duration" label="时长(分钟)" />
    <el-table-column prop="genres" label="类型" />
    <el-table-column prop="releasedate" label="上演时间" />
    <el-table-column fixed="right" label="Operations" width="120">
      <template #default="scope">
        <el-button link type="primary" size="small"  @click="open1(scope.row.movieid)"
          >删除</el-button
        >
        <el-button link type="primary" size="small"  @click="update(scope.row.movieid)">修改</el-button>
      </template>
    </el-table-column>
  </el-table>
  <el-pagination  @current-change="currentChange" @size-change="sizeChange" layout="prev, pager, next" :total="selectData.count*2" />




  <el-dialog v-model="dialogFormVisible" title="新增影片">
    <el-form :model="form">
      <el-form-item label="片名" :label-width="formLabelWidth">
        <el-input v-model="form.title" autocomplete="off" />
      </el-form-item>
      <el-form-item label="导演" :label-width="formLabelWidth">
        <el-input v-model="form.director" autocomplete="off" />
      </el-form-item>
      <el-form-item label="演员" :label-width="formLabelWidth">
        <el-input v-model="form.actors" autocomplete="off" />
      </el-form-item>
      <el-form-item label="价格" :label-width="formLabelWidth">
        <el-input v-model="form.price" autocomplete="off" />
      </el-form-item>
      <el-form-item label="时长(分钟)" :label-width="formLabelWidth">
        <el-input v-model="form.duration" autocomplete="off" />
      </el-form-item>
      <el-form-item label="描述" :label-width="formLabelWidth"> 
        <el-input v-model="form.description" autocomplete="off" />
      </el-form-item>
      <el-form-item label="类型" :label-width="formLabelWidth">
        <el-input v-model="form.genres" autocomplete="off" />
      </el-form-item>
      <el-form-item label="上演时间" :label-width="formLabelWidth">
        <el-input  v-model="form.releasedate" autocomplete="off" />
      </el-form-item>
      
      <el-upload ref="uploadRef" :auto-upload="false" :http-request="upload">
    <template #trigger>
      <el-button type="primary">选择文件</el-button>
    </template>
    <el-button class="ml-3" type="success" @click="submitUpload">
  上传文件
</el-button>

  </el-upload>

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
import { defineComponent,reactive, toRefs,onMounted,ref,computed  } from 'vue'
import{BackData,UploadParams} from "../../type/movie"
import{getMovieList,addMovie,delMovie,getMovieListById,updateMovie} from '../../request/api'
import axios from 'axios'
import type { UploadInstance } from 'element-plus'
import { ElNotification } from 'element-plus'
import { da } from 'element-plus/es/locale'



export default defineComponent({
  setup() {

  const data = reactive(new BackData())
  const dialogTableVisible = ref(false)
  const formLabelWidth = '140px'
  const uploadRef = ref<UploadInstance>()

    onMounted(() => {
      getMovieList().then(res=>{
        data.tableData = res.data.mes
        data.selectData.count = data.tableData.length
      })
    })

    const dataList = reactive({
            comList:computed(()=>{
                return data.tableData.slice((data.selectData.page-1)*data.selectData.pagesize,data.selectData.page*data.selectData.pagesize)
            })
        })


    
      function upload(params: UploadParams) {
        let formData = new FormData();
        
        formData.append('photoRef', params.file);
    
        const server = axios.create({
          baseURL: "http://localhost:8088/",
          timeout: 5000,
          headers: {
            "Content-Type": "multipart/form-data"
          }
        });
        server({
          url: '/movie/movieconsumer/user/uploadTest1',
          method: 'post',
          data: formData,
        }).then((resp) => {
          data.form.posterurl ="http://localhost:9054/images/"+resp.data.data.fileName
          alert("上传成功") 
        });
      }

      function submitUpload() {
        uploadRef.value!.submit()
      }

       const submit = ()=>{
        if(data.form.movieid==""){
          addMovie(data.form).then(()=>{
          data.dialogFormVisible = false
          window.location.reload()
        })
        }else{
          updateMovie(data.form).then(()=>{
            data.dialogFormVisible = false
          window.location.reload()
          })
        }
       
       }

       const open1 = (movieid:number) => {
        alert(movieid)
          ElNotification({
            title: 'Success',
            message: '这个电影删除成功',
            type: 'success',
        })

        delMovie(movieid).then(()=>{
          window.location.reload()
        })
      }


      const update = (movieid:number)=>{
        getMovieListById(movieid).then(res=>{
          console.log(res);
          data.form = res.data.mes
          data.dialogFormVisible = true
        })
      }

      const currentChange=(page:number)=>{
            data.selectData.page=page
        }
        const sizeChange=(pageSize:number)=>{
            data.selectData.pagesize=pageSize
        }

    return {
      ...toRefs(data),
      dialogTableVisible,
      formLabelWidth,
      submitUpload,
      upload,
      uploadRef,
      submit,
      open1,
      update,
      currentChange,
      sizeChange,
      dataList
    }

    
  },
})
</script>

<style scoped>

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