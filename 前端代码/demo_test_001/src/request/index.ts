import axios from 'axios'

const service=axios.create({
    baseURL:"http://localhost:8088/",
    timeout:5000,
    headers:{
        "Content-type" : "application/json;charset=utf-8"
    }
})
//请求拦截
service.interceptors.request.use((config)=>{
    config.headers = config.headers||{}
    if(localStorage.getItem('token')){
       config.headers.token=localStorage.getItem("token")||""
    }
    return config
})

//响应拦截
//响应拦截


service.interceptors.response.use(
    response=> {
        const res = response.data
        if (res.code !== 200) {
            //请求失败（包括token失效，302，404...根据和后端约定好的状态码做出不同的处理）
            return res
        }else{
            //请求成功
            return res
        }
  },(error)=> {
    return Promise.reject(error)
  }
)

// service.interceptors.response.use(({ data }) => {
//     const code : number = data.data.code
//     if(code != 200){
//         return Promise.reject(data)
//     }
//     return data
// },(err) => {
//     console.log(err)
// })

export default service