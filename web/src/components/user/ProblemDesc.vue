<template>
  <div class="problem_desc">
    <div class="title">最长回文子串</div>
    <div class="desc">
      <p>
        给定区间[-2的31次方,2的31次方]内的3个整数A、B和C，请判断A+B是否大于C。给定区间[-2的31次方,2的31次方]内的3个整数A、B和C，请判断A+B是否大于C。给定区间[-2的31次方,2的31次方]内的3个整数A、B和C，请判断A+B是否大于C。给定区间[-2的31次方,2的31次方]内的3个整数A、B和C，请判断A+B是否大于C。给定区间[-2的31次方,2的31次方]内的3个整数A、B和C，请判断A+B是否大于C。给定区间[-2的31次方,2的31次方]内的3个整数A、B和C，请判断A+B是否大于C。
      </p>
      <strong>样例输入</strong>
      <pre>
4
1 2 3
2 3 4
2147483647 0 2147483646
0 -2147483648 -2147483647</pre>
    <strong>样例输出</strong>
    <pre>
Case #1: false
Case #2: true
Case #3: true
Case #4: false</pre>
    </div>
  </div>
</template>
<script>
import { defineComponent } from "vue";
export default defineComponent({
  setup() {
    return {};
  },
  components: {},
});
</script>
<style scoped>
.problem_desc {
  padding: 0 20px;
}
.title {
  line-height: 1;
  margin: 0;
  padding: 10px 0;
  vertical-align: baseline;
  font-size: 20px;
  color: #2a2a2a;
  border-bottom: 1px solid #f0f0f0;
  width: 100%;
}

.desc {
  padding: 15px 0;
  font-size: 13px;
  line-height: 1.5rem;
}

.desc p {
  letter-spacing: 0.125rem;
  font-size: 14px;
}
pre {
  background-color: #f8f8f8;
  padding: 10px 15px;
  line-height: 1.6;
  font-size: 13px;
  border-radius: 3px;
}
</style>
