<template>
  <div>
    <div class="contest_status_bar">
      <div v-if="status == '进行中'">
        <span class="bar_item running"><ClockCircleOutlined spin /> 进行中</span
        ><span>竞赛开始于 2021/11/25 12:00，00:26:08 后结束</span>
      </div>
      <div v-if="status == '待开始'">
        <span class="bar_item waiting"><ClockCircleOutlined /> 待开始</span>
        <span>竞赛将于 00:26:08 后开始</span>
      </div>
      <div v-if="status == '已结束'">
        <span class="bar_item finished">已结束</span>
        <span>竞赛结束于 2021/11/25 12:00</span>
      </div>
    </div>
    <a-table
      class="ant-table-striped"
      size="middle"
      :columns="columns"
      :data-source="data"
      :rowClassName="
        (record, index) => (index % 2 === 1 ? 'table-striped' : null)
      "
    >
      <template #name="{ text }">
        <router-link :to="{ name: 'Problem', params: { id: text } }">{{
          text
        }}</router-link>
      </template>
      <template #status="{ text }">
        <span class="status_icon" v-if="text == 1"
          ><CheckOutlined style="color: #35a946"
        /></span>
        <span class="status_icon" v-if="text == 0"
          ><MinusOutlined style="color: #9fa5b0"
        /></span>
        <span class="status_icon" v-if="text == -1"
          ><CloseOutlined style="color: #9f7c00"
        /></span>
      </template>
      <template #rate="{ text }">
        <a-rate :value="text" allow-half disabled />
      </template>
    </a-table>
  </div>
</template>
<script>
import { defineComponent } from "vue";
import {
  CheckOutlined,
  MinusOutlined,
  CloseOutlined,
  ClockCircleOutlined,
} from "@ant-design/icons-vue";
const columns = [
  {
    title: "状态",
    dataIndex: "status",
    slots: {
      customRender: "status",
    },
  },
  {
    title: "题目",
    dataIndex: "name",
    slots: {
      customRender: "name",
    },
  },
  {
    title: "通过",
    dataIndex: "accept",
  },
  {
    title: "提交",
    dataIndex: "commit",
  },
  {
    title: "热度",
    dataIndex: "rate",
    slots: {
      customRender: "rate",
    },
  },
];
const data = [
  {
    key: "1",
    status: 1,
    name: "	A+B和C",
    accept: 32,
    commit: 50,
    rate: 2.5,
  },
  {
    key: "2",
    status: 0,
    name: "数字分类",
    accept: 32,
    commit: 50,
    rate: 2.5,
  },
  {
    key: "3",
    status: -1,
    name: "	A+B和C",
    accept: 32,
    commit: 50,
    rate: 2.5,
  },
];
export default defineComponent({
  setup() {
    const status = "进行中";
    return {
      data,
      columns,
      status,
    };
  },
  components: {
    CheckOutlined,
    MinusOutlined,
    CloseOutlined,
    ClockCircleOutlined,
  },
});
</script>
<style scoped>
.ant-table-striped :deep(.table-striped) td {
  background-color: #fafafa;
}
.status_icon {
  padding: 0 8px;
  font-weight: 500;
}
.contest_status_bar {
  color: #666;
  font: 12px/1.5 numFont, PingFangSC-Regular, Tahoma, Microsoft Yahei,
    sans-serif;
  word-break: break-all;
  white-space: nowrap;
  padding: 0;
  display: inline-block;
  position: relative;
  vertical-align: top;
  user-select: none;
  padding: 8px 0 16px 0;
}
.contest_status_bar .bar_item {
  word-break: break-all;
  white-space: nowrap;
  user-select: none;
  font: 12px/1.5 numFont, PingFangSC-Regular, Tahoma, Microsoft Yahei,
    sans-serif;
  box-sizing: content-box;
  outline: 0 none;
  border: 0;
  display: inline-block;
  position: relative;
  margin: 0 10px;
  padding: 0 16px;
  border-radius: 0px;
  font-size: 16px;
  line-height: 30px;
  margin-left: 0;
  color: #fff;
  font-weight: 700;
}
.contest_status_bar .running {
  /* background: linear-gradient(90deg, #ffb821 0, #ff5c38 45%, #ff1459); */
  background-color: #f90716;
}

.contest_status_bar .waiting {
  background-color: #396eb0;
}

.contest_status_bar .finished {
  background-color: #111;
}
</style>
