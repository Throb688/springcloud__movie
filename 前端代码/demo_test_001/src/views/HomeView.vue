<template>
  <div class="common-layout">
    <el-container>
      <el-header>
        <el-menu :default-active="activeIndex2"
                 class="el-menu-demo"
                 mode="horizontal"
                 background-color="#545c64"
                 text-color="#fff"
                 active-text-color="#ffd04b"
                 @select="handleSelect">
          <el-menu-item :index="item.path"
                        v-for="item in list"
                        :key="item.path">
            <span>{{ item.meta.title }}</span>
          </el-menu-item>
        <el-button type="primary" style="
    margin-left: 76%;
    margin-top: 1%;"   text  @click="delToken">退出登录</el-button>
        </el-menu>
       
      </el-header>
      <el-main>
        <router-view></router-view>
      </el-main>
    </el-container>
  </div>
</template>
<script lang="ts">
import { defineComponent, ref } from 'vue'
import { useRouter } from 'vue-router'
export default defineComponent({
  setup() {
    const activeIndex = ref('1')
    const activeIndex2 = ref('1')
    const handleSelect = (key: string, keyPath: string[]) => {
      console.log(key, keyPath)
      router.push(key)
    }
    const router = useRouter()
    const list = router.getRoutes().filter((v) => v.meta.isShow)

    const delToken=()=>{
      localStorage.removeItem('token')
      router.push("/login")
    }
    return { activeIndex, activeIndex2, handleSelect, list,delToken }
  },
})
</script>

<style scoped>
</style>