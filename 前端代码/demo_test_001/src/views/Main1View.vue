<template>
  <div class="search-page">
    <el-card>
      <el-form :model="searchForm" inline>
        <el-form-item>
          <el-input v-model="searchForm.keyword" placeholder="请输入关键字"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="search">搜索</el-button>
        </el-form-item>
      </el-form>
    </el-card>

    <el-card v-if="showResults">
      <template v-if="searchresult.length > 0">
        <div class="search-results">
          <h3 class="search-results-title">搜索结果</h3>
          <div class="search-results-container">
            <el-card v-for="result in searchresult" :key="result.movieid" @click="particulars(result.movieid)" class="search-results-card">
              <div class="search-results-card-content">
                <div class="search-results-card-item">
                  <img :src="result.posterurl" alt="商品图片" />
                </div>
                <div class="search-results-card-item">
                  <div class="search-results-card-name">{{ result.title }}</div>
                </div>
               
                <div class="search-results-card-item">
                  <div class="search-results-card-description">{{ result.director }}</div>
                </div>
                <div class="search-results-card-item">
                  <div class="search-results-card-description">{{ result.genres }}</div>
                </div>
                <div class="search-results-card-item">
                  <div class="search-results-card-description">时长：{{ result.duration }} 分钟</div>
                </div>
                <div class="search-results-card-item">
                  <div class="search-results-card-price">{{ result.price }} 元/位</div>
                </div>
              </div>
            </el-card>
          </div>
        </div>
      </template>
      <template v-else>
        <div class="no-results">没有找到匹配的结果</div>
      </template>
    </el-card>
  </div>
</template>

<script lang="ts">
import { defineComponent, ref, reactive, toRefs } from 'vue';
import { findMovie } from '@/request/api';
import { InitData } from '../type/search';
import { useRouter } from 'vue-router'


export default defineComponent({
  setup() {
    const router = useRouter()
    const data = reactive(new InitData());
    const searchForm = ref({
      keyword: '',
    });

    const search = () => {
      const keyword = searchForm.value.keyword;
      if (keyword.trim() === '') {
        data.searchresult = [];
        data.showResults = false;
      } else {
        findMovie(keyword).then((res) => {
          data.searchresult = res.data.msg;
          data.showResults = true;
        });
      }
    };

    const particulars = (value: any) => {
      router.push({
        path: 'particulars/' + value,
        params: {
          id: value,
        },
      })
    }

    return {
      ...toRefs(data),
      searchForm,
      search,
      particulars
    };
  },
});
</script>

<style scoped>
.search-page {
  padding: 20px;
}

.search-results {
  margin-top: 20px;
}

.search-results-title {
  font-size: 20px;
  font-weight: bold;
}

.search-results-container {
  display: flex;
  flex-direction: column;
}

.search-results-card {
  margin-bottom: 20px;
  border-radius: 8px;
  background-color: #f5f7fa;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
}

.search-results-card-content {
  display: flex;
  padding: 20px;
}

.search-results-card-item {
  flex-grow: 1;
  text-align: center;
}

.search-results-card-item img {
  width: 100px;
  height: 100px;
  object-fit: cover;
  border-radius: 50%;
}

.search-results-card-name {
  font-weight: bold;
  margin-top: 10px;
}

.search-results-card-price {
  color: #f60;
  margin-top: 10px;
}

.search-results-card-description {
  margin-top: 10px;
}

.no-results {
  margin-top: 20px;
  text-align: center;
  color: #999;
}
</style>
