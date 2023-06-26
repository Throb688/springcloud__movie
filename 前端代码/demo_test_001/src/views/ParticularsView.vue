<template>
  <el-page-header @back="goBack">
    <template #content>
      <span class="text-large font-600 mr-3"> 详情 </span>
    </template>
  </el-page-header>
  <el-divider />
  <div class="demo-image__placeholder">
    <div class="block ">
      <el-image :src="ruleForm.posterurl" />
    </div>
    <div class="block ">
      <el-row>
        <span>
          <h1 style="font-size: 35px;">{{ ruleForm.title }}</h1>
        </span>
      </el-row>
      <br>
      <el-row>
        <span>导 演：{{ ruleForm.director }}</span>
      </el-row>
      <br>
      <el-row>
        <span>主 演：{{ ruleForm.actors }}</span>
      </el-row>
      <br>
      <el-row>
        <span>上映时间：{{ ruleForm.releasedate }}</span>
      </el-row>
      <br>
      <el-row>
        <span>时 长：{{ ruleForm.duration }} 分钟</span>
      </el-row>
      <br>
      <el-row>
        <span style="color: orangered;font-size: 30px">价 格：{{ruleForm.price}} </span>
        <span style="font-size: 1px; margin-top: 19px;">元/位</span>
        <el-button @click="dialogFormVisible = true" size="large"
                   type="danger"
                   style="
                  margin-left: 68px;
                  
        " >马上选座</el-button>
      </el-row>
    </div>
  </div>
  <el-divider />

  <el-row>
    <span>剧情简介</span>
    <span>{{ ruleForm.description }}</span>
  </el-row>
  <el-divider />
  <div>
    <el-card class="comment-card"
             v-for="comment in comments"
             :key="comment.evaluateid">
      <div class="comment-header">
        <span class="comment-author">{{ comment.username }}</span>
      </div>
      <div class="comment-content">{{ comment.evaluatetext }}</div>
      <div class="comment-footer">{{ comment.evaluatetime }}</div>
    </el-card>
  </div>


  

  <el-dialog v-model="dialogFormVisible" title="选择影院和观影时间">
    <el-form :model="sesssionFrom">
      <span>影院选择</span>
      <el-select v-model="sesssionFrom.site" clearable placeholder="请选择影院">
    <el-option
      v-for="item in sessionList"
      :key="item.sessionid"
      :label="item.site"
      :value="item.site"
    />
  </el-select>
  <div>
    <span>场次选择</span>
  <el-select v-model="sesssionFrom.time" clearable placeholder="请选择场次">
    <el-option
      v-for="item in list1"
      :key="item.sessionid"
      :label="item.time"
      :value="item.time"
    />
  </el-select>
  </div>
    </el-form>
    <template #footer>
      <span class="dialog-footer">
        <el-button @click="dialogFormVisible = false">关闭</el-button>
        <el-button type="primary" @click="order">
          去选座
        </el-button>
      </span>
    </template>
  </el-dialog>

</template>

<script lang="ts">
import { defineComponent, onMounted, reactive, toRefs,ref,watch } from 'vue'
import { useRouter, useRoute } from 'vue-router'
import { getMovieListById,getSessionList,findEvaluate } from '../request/api'
import { InitData } from '@/type/movie'

export default defineComponent({
  setup() {
    const router = useRouter()
    const route = useRoute()
    const params: any = route.params
    const data = reactive(new InitData())
    const formLabelWidth = '140px'
    onMounted(() => {
      getMovieListById(params.id).then((res) => {
        data.ruleForm = res.data.mes
      })
      getSessionList(params.id).then((res)=>{
        data.sessionList = res.data.msg
      })
      

      findEvaluate(params.id).then(res=>{
        console.log(res);
        
        data.comments = res.data.mes
      })
    })

    const goBack = () => {
      router.push('/main')
    }

    const order = ()=>{
      const movieid = data.list1.filter(value=>value.time==data.sesssionFrom.time)[0].sessionid
      data.dialogFormVisible = true
      router.push({
        name:"about",
        query:{
          id:movieid
        }
      })
    }

    watch(() => data.sesssionFrom.site,()=>{
        data.list1 =data.sessionList.filter(value=>value.site==data.sesssionFrom.site)
    })

    

    
    return { goBack, ...toRefs(data),order,formLabelWidth}
  },
})
</script>

<style scoped>
.demo-image__placeholder .block {
  padding: 0 0;
  text-align: center;
  /* border-right: solid 1px var(--el-border-color); */
  display: inline-block;
  width: 37%;
  box-sizing: border-box;
  vertical-align: top;
  margin-left: 0%;
}
.demo-image__placeholder .demonstration {
  display: block;
  color: var(--el-text-color-secondary);
  font-size: 14px;
  margin-bottom: 20px;
}
.demo-image__placeholder .el-image {
  padding: 0 5px;
  max-width: 400px;
  max-height: 250px;
}

.demo-image__placeholder.image-slot {
  display: flex;
  justify-content: center;
  align-items: center;
  width: 100%;
  height: 100%;
  background: var(--el-fill-color-light);
  color: var(--el-text-color-secondary);
  font-size: 14px;
}
.demo-image__placeholder .dot {
  animation: dot 2s infinite steps(3, start);
  overflow: hidden;
}
.el-col-24 {
  flex: none;
  margin-left: -15%;
}

.comment-card {
  margin-bottom: 10px;
  padding: 10px;
  border: 1px solid #ccc;
  border-radius: 4px;
}

.comment-header {
  display: flex;
  align-items: center;
  margin-bottom: 5px;
}

.comment-author {
  font-weight: bold;
  margin-left: 10px;
}

.comment-content {
  margin-bottom: 5px;
}

.comment-footer {
  color: #999;
  font-size: 12px;
}

.el-select {
    display: inline-block;
    position: relative;
    vertical-align: middle;
    line-height: 32px;
    margin-left: 15px;
    margin-top: 20px;
}
.el-page-header{
  margin-top: -1%
}
</style>