<template>
  <div class="login-box">
    <el-form ref="ruleFormRef"
             :model="ruleForm"
             status-icon
             :rules="rules"
             label-width="80px"
             class="demo-ruleForm">
      <h2>登录页面</h2>
      <el-form-item label="用户名"
                    prop="username">
        <el-input v-model="ruleForm.username"
                  type="text"
                  autocomplete="off" />
      </el-form-item>
      <el-form-item label="密码"
                    prop="password">
        <el-input v-model="ruleForm.password"
                  type="password"
                  autocomplete="off" />
      </el-form-item>
      <el-form-item>
        <el-button class="log_btn"
                   type="primary"
                   @click="submitForm(ruleFormRef)">登录</el-button>
        <el-button class="log_btn"
                   @click="resetForm">清空</el-button>
      </el-form-item>
      <div class="toReist">
        <el-button link
                   type="primary"
                   @click="register">去注册</el-button>
      </div>
    </el-form>

  </div>
</template>

<script lang="ts">
import { login } from '@/request/api'
import type { FormInstance } from 'element-plus'
import { defineComponent, reactive, ref, toRefs } from 'vue'
import { useRouter } from 'vue-router'
import { LoginData } from '../type/login'

export default defineComponent({
  setup() {
    const data = reactive(new LoginData())
    const ruleFormRef = ref<FormInstance>()
    const router = useRouter()

    const rules = {
      username: [
        {
          required: true, //是否必须字段
          message: '请输入用户名', // 触发的提示信息
          trigger: 'blur', // 触发时机: 当失去焦点时（光标不显示的时候），触发此提示
        },
        {
          min: 3, // 最小字符书
          max: 5, // 最大字符数
          message: '用户名长度需要在3-5个字符之间', // 触发的提示信息
          trigger: 'blur',
        },
      ],
      password: [
        {
          required: true, //是否必须字段
          message: '请输入密码', // 触发的提示信息
          trigger: 'blur', // 触发时机: 当失去焦点时（光标不显示的时候），触发此提示
        },
        {
          min: 3, // 最小字符书
          max: 6, // 最大字符数
          message: '密码长度需要在3-5个字符之间', // 触发的提示信息
          trigger: 'blur',
        },
      ],
    }

    const submitForm = (formEl: FormInstance | undefined) => {
      if (!formEl) return
      formEl.validate((valid: any) => {
        if (valid) {
          login(data.ruleForm).then((res) => {
            console.log(res)
            localStorage.setItem("token", res.data.token)
            router.push('/main')
          })
        } else {
          console.log('error submit!')
          return false
        }
      })
    }
    const resetForm = () => {
      data.ruleForm.password = ''
      data.ruleForm.username = ''
    }
    const register = () => {
      router.push('/register')
    }

    return {
      ...toRefs(data),
      rules,
      ruleFormRef,
      submitForm,
      resetForm,
      register,
    }
  },
})
</script>

<style lang='scss' scoped>
.login-box {
  width: 100%;
  height: 100%;
  background: url('../assets/bg.png');
  padding: 1px;
  text-align: center;
}
.demo-ruleForm {
  width: 500px;
  margin: 200px auto;
  background-color: aliceblue;
  padding: 40px;
  border-radius: 20px;
}
.log_btn {
  width: 48%;
}
h2 {
  margin-bottom: 10px;
}
.toReist {
  float: right;
}
</style>