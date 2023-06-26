<template>
  <div class="home">
    <el-container>
      <el-header>
        <el-row :gutter="20">
          <el-col :span="4"><img src="../../assets/logo.png"
                 class="logo" />
            <div class="grid-content ep-bg-purple" />
          </el-col>
          <el-col :span="16">
            <h2>后台管理系统</h2>
            <div class="grid-content ep-bg-purple" />
          </el-col>
          <el-col :span="4"
                  class="col-btn"><el-button type="primary"
                       @click="delToken">退出登录</el-button></el-col>
        </el-row>
      </el-header>
      <el-container>
        <el-aside width="200px"><el-menu active-text-color="#ffd04b"
                   background-color="#545c64"
                   class="el-menu-vertical-demo"
                   :default-active="active"
                   text-color="#fff"
                   router>

            <el-menu-item :index="item.path"
                          v-for="item in list"
                          :key="item.path">
              <span>{{ item.meta.title }}</span>
            </el-menu-item>
          </el-menu></el-aside>
        <el-main>
          <router-view></router-view>
        </el-main>
      </el-container>
    </el-container>
  </div>
</template>

<script lang="ts">
import { defineComponent } from 'vue'
import { useRouter, useRoute } from 'vue-router'
export default defineComponent({
  name: 'HomeView',
  setup() {
    const route = useRoute()
    const router = useRouter()
    const list = router.getRoutes().filter((v) => v.meta.backstage)
    const delToken = () => {
      localStorage.removeItem('token')
      router.push('/login')
    }
    return {
      list,
      active: route.path,
      delToken,
    }
  },
  components: {},
})
</script>
<style lang="scss" scoped>
.el-header {
  height: 80px;
  background-color: #a2b87c;
  .logo {
    height: 80px;
  }
  h2,
  .quit-login {
    text-align: center;
    height: 80px;
    line-height: 80px;
    color: #fff;
  }
  .col-btn {
    height: 80px;
    line-height: 80px;
  }
}
.el-aside {
  .el-menu {
    height: calc(100vh - 80px);
  }
}
</style>
