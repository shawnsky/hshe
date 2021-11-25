<template>
  <div>
    <a-row type="flex">
      <a-col :flex="20">
        <h3 class="segment_title">组织</h3>
        <OrgList />

        <h3 class="segment_title">竞赛</h3>
        <ContestTable />
      </a-col>
      <a-col class="right_widget" :flex="1">
        <h3 class="segment_title">排行榜</h3>
        <UserRank />

        <h3 class="segment_title">我的进度</h3>
        <ProgressTracker/>

      </a-col>
    </a-row>
  </div>
</template>
<script>
import { defineComponent } from "vue";
import OrgList from "@/components/user/OrgList";
import UserRank from "@/components/user/UserRank";
import ProgressTracker from "@/components/user/ProgressTracker"
import ContestTable from "@/components/user/ContestTable";
export default defineComponent({
  setup() {
    return {};
  },
  components: {
    ContestTable,
    OrgList,
    UserRank,
    ProgressTracker,
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
  user-select: none;
}
</style>
