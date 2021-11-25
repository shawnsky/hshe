<template>
  <a-space direction="vertical" style="margin: 8px">
    <a class="org_pic" tabindex="-1" @click="handleClick(video)">
      <img loading="lazy" class="pic" :src="src" style="visibility: visible" />
    </a>
    <a class="org_title" @click="handleClick(video)"> {{ name }}</a>
    最新
  </a-space>
</template>
<script>
import { defineComponent } from "vue";
export default defineComponent({
  setup() {
    return {};
  },
  props: {
    src: {
      type: String,
    },
    name: {
      type: String,
    },
  },
});
</script>
<style>
.org_pic {
  *zoom: 1;
  -webkit-user-select: none;
  -moz-user-select: none;
  -ms-user-select: none;
  display: block;
  position: relative;
  width: 100%;
  user-select: none;
}
.org_pic .pic {
  -o-object-fit: cover;
  display: block;
  width: 80px;
  height: 100%;
  object-fit: cover;
  border-radius: 4px;
  background: #f8f8f8;
  background-color: #ececec;
  background-color: rgba(236, 236, 236, 0.1);
}
.org_title {
  color: #111;
  font-size: 15px;
  -webkit-box-orient: vertical;
  -webkit-line-clamp: 2;
  word-wrap: break-word;
  display: -webkit-box;
  height: auto;
  max-height: 44px;
  overflow: hidden;
  letter-spacing: 1px;
  line-height: 23px;
  white-space: normal;
  word-break: break-all;
 
}
</style>
