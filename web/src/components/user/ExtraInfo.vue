<template>
  <div class="info">
    <div class="info_item"><RocketOutlined /> 内存限制 64M</div>
    <div class="info_item list_item_striped">
      <HourglassOutlined /> 时间限制 3000ms
    </div>
    <div class="info_item"><EyeOutlined /> 浏览 10</div>
    <div class="info_item list_item_striped">
      <CheckCircleOutlined /> 通过 5
    </div>
    <div class="info_item"><PercentageOutlined /> 通过率 50%</div>
  </div>
</template>

<script>
import { defineComponent } from "vue";
import {
  RocketOutlined,
  HourglassOutlined,
  EyeOutlined,
  CheckCircleOutlined,
  PercentageOutlined,
} from "@ant-design/icons-vue";
export default defineComponent({
  setup() {
    return {};
  },
  components: {
    RocketOutlined,
    HourglassOutlined,
    EyeOutlined,
    CheckCircleOutlined,
    PercentageOutlined,
  },
});
</script>
<style scoped>
.info {
  width: 200px;
  border: 1px solid #f0f0f0;
}
.info_item {
  width: 100%;
  height: 40px;
  line-height: 40px;
  padding: 0 20px;
  user-select: none;
}
.list_item_striped {
  background-color: #f8f8f8;
}
</style>
