<template>
  <el-carousel :interval="4000"
               type="card"
               height="200px">
    <el-carousel-item v-for="item in list"
                      :key="item.movieid">
      <!-- <h3 text="2xl"
          justify="center">{{ item }}</h3> -->
      <img @click="particulars(item.movieid)"
           style="width: 600px; height: 200px;"
           :src="item.posterurl" />
    </el-carousel-item>
  </el-carousel>
  <el-space wrap>
    <el-card v-for="item in list"
             :key="item.movieid"
             class="box-card"
             style="width: 250px; margin-left: 40px; ">
      <el-row>
        <el-col @click="particulars(item.movieid)">
          <el-card shadow="hover"
                   :body-style="{ padding: '0px' }">
            <img :src="item.posterurl"
                 style="width: 200px;height: 200px;"
                 class="image" />
            <div style="padding: 14px">
              <span>{{ item.title }}</span>
              <br>
              <span style="font-size: 1px;">时长：{{ item.duration }} 分钟</span>
              <br>
              <span style="font-size: 1px;">导 演：{{ item.director }}</span>
              <br>
              <span style="font-size: 1px;">上映时间：{{ item.releasedate }}</span>
              <br>
              <span style="font-size: 1px;">价 格{{ item.price }}</span>
              <br>
            </div>
          </el-card>
        </el-col>
      </el-row>

    </el-card>
  </el-space>
</template>

<script lang="ts">
import { defineComponent, onMounted, reactive, ref, toRefs } from 'vue'
import { useRouter } from 'vue-router'
import { getMovieList } from '@/request/api'
import { InitData } from '@/type/movie'
export default defineComponent({
  setup() {
    const router = useRouter()
    const data = reactive(new InitData())
    const currentDate = ref(new Date())
    const particulars = (value: any) => {
      router.push({
        path: 'particulars/' + value,
        params: {
          id: value,
        },
      })
    }
    onMounted(() => {
      getMovieList().then((res) => {
        data.list = res.data.mes
      })
    })
    return { currentDate, particulars, ...toRefs(data) }
  },
})
</script>

<style scoped>
.el-carousel__item h3 {
  color: #475669;
  opacity: 0.75;
  line-height: 200px;
  margin: 0;
  text-align: center;
}

.el-carousel__item:nth-child(2n) {
  background-color: #99a9bf;
}

.el-carousel__item:nth-child(2n + 1) {
  background-color: #d3dce6;
}
.time {
  font-size: 12px;
  color: #999;
}

.bottom {
  margin-top: 13px;
  line-height: 12px;
  display: flex;
  justify-content: space-between;
  align-items: center;
}

.button {
  padding: 0;
  min-height: auto;
}

.image {
  width: 100%;
  display: block;
}
</style>