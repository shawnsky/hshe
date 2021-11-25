<template>
  <div>
    <a-row type="flex">
      <a-col :flex="20">
        <a-space>
          <img
            class="org_logo"
            src="https://pic.leetcode-cn.com/f8fd5b104aa30bbd9bba7cf428a63e8c130f1665876e6afa52186d9510936517-fb_icon_325x325.png"
            alt=""
          />
          <h3 class="segment_title">第 268 场周赛</h3></a-space
        >

        <ProblemTable />
      </a-col>
      <a-col class="right_widget" :flex="1"> </a-col>
    </a-row>
  </div>
</template>
<script>
import { defineComponent } from "vue";

import ProblemTable from "@/components/user/ProblemTable";
export default defineComponent({
  setup() {
    return {};
  },
  components: {
    ProblemTable,
  },
});
</script>
<style scoped>
.right_widget {
  margin-left: 20px;
}
.segment_title {
  font-weight: 500;
  font-size: 1.5rem;
  color: rgba(33, 40, 53, 0.75);
  line-height: 1.75rem;
  margin-top: 20px;
}
.org_logo {
  border-radius: 15%;
  height: 28px;
  width: 28px;
}
</style>
