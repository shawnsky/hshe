<template>
  <div>
    <a-card class="tracker_block">
      <a-row type="flex">
        <a-col :flex="1">
          <a-statistic title="参与竞赛" :value="5" style="margin-right: 50px">
            <template #prefix>
              <TrophyTwoTone twoToneColor="#52c41a" />
            </template>
          </a-statistic>
        </a-col>
        <a-col :flex="1">
          <a-statistic title="通过率" :value="56">
            <template #suffix>
              <span>/ 102</span>
            </template>
          </a-statistic>
        </a-col>
      </a-row>
      <a-row>
        <a-col>
          <div id="recent">
            <a-space>
              <span>最近参与了</span>
              <a class="contest_title">
                18电信2班Java练习0118电信
              </a>
            </a-space>
          </div>
        </a-col>
      </a-row>
    </a-card>
  </div>
</template>

<script>
import { defineComponent } from "vue";
import { TrophyTwoTone } from "@ant-design/icons-vue";
export default defineComponent({
  setup() {
    return {};
  },
  components: { TrophyTwoTone },
});
</script>

<style scoped>
.tracker_block {
  padding: 0 12px;
  border-radius: 0.5rem;
  border: 1px solid #f0f0f0;
  --tw-shadow: 0 2px 8px rgba(0, 0, 0, 0.08), 0 1px 2px rgba(0, 0, 0, 0.1);
  box-shadow: var(--tw-ring-offset-shadow, 0 0 #0000),
    var(--tw-ring-shadow, 0 0 #0000), var(--tw-shadow);
}
#recent {
  margin-top: 12px;
  color: grey;
}

#recent .contest_title {
  width: 130px;
  white-space: nowrap;
  overflow: hidden;
  text-overflow: ellipsis;
  font-weight: 500;
  display: block; 
}
</style>
