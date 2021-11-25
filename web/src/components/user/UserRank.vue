<template>
  <div class="rank_list">
    <a class="rank_item" href="">
      <span class="rank_num rank_num_special">1</span>
      <span class="rank_title">chen</span>
      <span class="rank_desc">Amazon</span>
      <span class="rank_update">完成16道题目</span>
    </a>
    <a class="rank_item" href="">
      <span class="rank_num rank_num_special">2</span>
      <span class="rank_title">meChat</span>
      <span class="rank_desc">腾讯</span>
      <span class="rank_update">完成12道题目</span>
    </a>
    <a class="rank_item" href="">
      <span class="rank_num rank_num_special">3</span>
      <span class="rank_title">孤独的扫地僧</span>
      <span class="rank_desc">百度</span>
      <span class="rank_update">完成8道题目</span>
    </a>
    <a class="rank_item" href="">
      <span class="rank_num">4</span>
      <span class="rank_title">xiaoning</span>
      <span class="rank_desc">美团</span>
      <span class="rank_update">完成2道题目</span>
    </a>
    <a class="rank_item" href="">
      <span class="rank_num">5</span>
      <span class="rank_title">siza!</span>
      <span class="rank_desc">腾讯</span>
      <span class="rank_update">完成1道题目</span>
    </a>
  </div>
</template>

<script>
import { defineComponent } from "vue";
export default defineComponent({
  setup() {
    return {};
  },
  components: {
  },
});
</script>


<style scoped>
.rank_list {
  background-color: #f8f8f8;
  border-radius: 4px;
  padding: 12px 0;
}
.rank_list .rank_item {
  display: block;
  position: relative;
  margin: 0 20px;
  padding: 15px 40px;
}
.rank_list .rank_num {
  position: absolute;
  left: 4px;
  margin-top: -4px;
  color: #666;
  font-size: 26px;
  line-height: 30px;
  user-select: none;
}
.rank_num_special {
  -webkit-text-fill-color: transparent;
  -webkit-background-clip: text;
  background-image: linear-gradient(180deg, #ffb821 0, #ff5c38 45%, #ff1459);
}
.rank_list .rank_title {
  margin-right: 80px;
  color: #111;
  font-size: 1rem;
  font-weight: 500;
  line-height: 1.25rem;
  display: block;
}
.rank_list .rank_desc {
  color: #999;
  font-size: 13px;
}
.rank_list .rank_update {
  position: absolute;
  top: 20px;
  right: 20px;
  color: #999;
  font-size: 13px;
  white-space: nowrap;
}
</style>
