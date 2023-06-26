<template>
  <div class="page-container">
    <div class="left-section">
      <el-page-header @back="goBack">
        <template #content>
          <span class="text-large font-600 mr-3">详情</span>
        </template>
      </el-page-header>

      <!-- 左侧电影信息 -->
      <div>
        <div class="title">{{ cinemaInfo.movieName }}</div>
        <div class="titleInfo">
          <div>{{ cinemaInfo.name }}</div>
          <div>{{ cinemaInfo.cinema_name }}</div>
          <div>{{ cinemaInfo.showTime }}</div>
        </div>
        <div class="centerInfo">
          <div class="centerInfo2">
            <span>{{ cinemaInfo.seatTypeList[0].name }}</span>
            <img
              style="width: 20px"
              :src="cinemaInfo.seatTypeList[0].icon"
            />
          </div>
          <div class="centerInfo2">
            <span>{{ cinemaInfo.seatTypeList[1].name }}</span>
            <img
              style="width: 20px"
              :src="cinemaInfo.seatTypeList[1].icon"
            />
          </div>
          <div class="centerInfo2">
            <span>{{ cinemaInfo.seatTypeList[2].name }}</span>
            <img
              style="width: 20px"
              :src="cinemaInfo.seatTypeList[2].icon"
            />
          </div>
        </div>
        <div class="screen">
          <div class="screen-text">屏幕方向</div>
        </div>
      </div>
    </div>
    <div class="right-section">
      <!-- 右侧座位选择和确认选座按钮 -->
      <div
        v-for="(seatItem, index) in cinemaInfo.seatList"
        class="seatClass"
        :key="seatItem.id"
        @click="clickzuowei(seatItem)"
        :style="{
          height: height + 'rem',
          width: width + 'rem',
          top: seatItem.grow * positionDistin + 'rem',
          left: seatItem.gcol * positionDistin + 'rem'
        }"
      >
        <img
          class="seatImgClass"
          :seatId="seatItem.id"
          :seatIndex="index"
          :src="cinemaInfo.seatTypeList[seatItem.type].icon"
        />
      </div>
      <div class="btn" @click="ok">确认选座</div>
    </div>
  </div>
</template>

<script>

import { reactive, onMounted } from 'vue';
import { useRoute,useRouter } from 'vue-router';

import {
  getSessionListById,
  getMovieListById,
  getSeatList,
  findSessionById
} from '../request/api';

export default {
  setup() {
    const routr = useRoute();
    const id = routr.query.id;
    const router = useRouter()
    const cinemaInfo = reactive({
      movieid: "",
      errorCode: 0,
      errorMsg: "",
      name: "",
      movieName: "",
      showTime: "",
      cinema_name: "",
      seatList: [],
      seatTypeList: [
        {
          name: "可选",
          type: "0",
          seats: 1,
          icon: "https://hijinka.oss-cn-shanghai.aliyuncs.com/uploads/mall1/20220307/669dde5d9fe28a377c151cadecb8dd65.png",
          isShow: "1",
          position: "up"
        },
        {
          name: "已选",
          type: "0-1",
          seats: 1,
          icon: "https://hijinka.oss-cn-shanghai.aliyuncs.com/uploads/mall1/20220307/899c7f9e0365ce6d97f9d5fe89ffe878.png",
          isShow: "1",
          position: "up"
        },
        {
          name: "已售",
          type: "0-2",
          seats: 1,
          icon: "https://hijinka.oss-cn-shanghai.aliyuncs.com/uploads/mall1/20220307/123044531581e70133020f0265bcabb2.png",
          isShow: "1",
          position: "up"
        }
      ]
    });

    onMounted(() => {
      getSessionListById(id).then(res => {
        
        cinemaInfo.showTime = res.data.msg[0].time;
        cinemaInfo.cinema_name = res.data.msg[0].site;
        cinemaInfo.name = res.data.msg[0].status + "号厅";
        cinemaInfo.movieid = res.data.msg[0].movieid;
        getMovieListById(cinemaInfo.movieid).then(res1 => {
          cinemaInfo.movieName = res1.data.mes.title;
        });

      });

      getSeatList().then(res => {
        console.log(res);
        findSessionById(cinemaInfo.movieid).then(res1=>{
          console.log(res1);
          for (let j = 0; j < res.data.msg.length; j++) {
            for (let i = 0; i < res1.data.msg.length; i++) {
              if(res.data.msg[j].id == res1.data.msg[i] ){
                res.data.msg[j].type =2
              }
            }
          }
          cinemaInfo.seatList = res.data.msg;
        })
        
      });
    });

    const width = 2;
    const height = 2;
    const positionDistin = 2;
   
    function clickzuowei(val) {
     // console.log(val, "座位信息");
      cinemaInfo.seatList.forEach(item => {
        if (item.id == val.id) {
          if (item.type == 0) {
            item.type = 1;
          } else if (item.type == 1) {
            item.type = 0;
          } else if (item.type == 2) {
            alert("此座位已出售，请重新选择座位");
          } else if (item.type == 3) {
            alert("此座位损坏，正在维修中！");
          }
        }
      });
    }

    function ok() {
      const info = cinemaInfo.seatList.filter(item => {
        return item.type == 1;
      });
      const list = info.map(item => {
        return item.row1 + " 排 " + item.col + " 座 ";
      });

      const list1 = info.map(item => {
        return item.id;
      });
      console.log("选中的座位信息:", info);
      if (info.length == 0) {
        alert("请先选择座位，再确认购买！");
      } else {
        router.push({
          name:"settlement",
          query:{
            list:list1,
            session:id
          }
        })
        alert("当前选中座位:" + list.toString());
      }
    }

    return {
      cinemaInfo,
      width,
      height,
      positionDistin,
      clickzuowei,
      ok
    };
  }
};
</script>

<style scoped>

.seatClass {
  position: absolute;
  margin-top: 18%;
  margin-left: 25%;
}

.seatImgClass {
  position: absolute;
  top: 0;
  left: 0;
  height: 100%;
  margin-left: 7px;
}

.title {
  width: 100%;
  height: 35px;
  background-image: linear-gradient(45deg, #9fa5d5, #aebaf8);
  text-align: center;
  line-height: 35px;
  color: #fff;
  letter-spacing: 2px;
}

.titleInfo {
  display: flex;
  justify-content: space-between;
  font-size: 14px;
  color: #ccc;
  margin-top: 10px;
  padding: 0 10px 0 10px;
}

.centerInfo {
  display: flex;
  justify-content: space-around;
  align-items: center;
  margin-top: 10px;
}

.centerInfo2 {
  display: flex;
  align-items: center;
}

.screen {
  width: 250px;
  border: 30px solid #ccc;
  border-color: #ccc transparent transparent transparent;
  height: 20px;
  margin: auto;
  margin-top: 10px;
}

.screen-text {
  text-align: center;
  white-space: nowrap;
  font-size: 20px;
  font-weight: 600;
  color: #fff;
  margin-top: -30px;
}

.btn {
  position: absolute;
  top: 94%;
  bottom: 0;
  left: 0;
  width: 100%;
  height: 35px;
  background-image: linear-gradient(45deg, #9fa5d5, #aebaf8);
  text-align: center;
  line-height: 35px;
  color: #fff;
}
.page-container{
  margin-top: -1%;
}

</style>