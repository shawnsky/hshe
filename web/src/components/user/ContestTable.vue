<template>
  <div>
    <div class="contest_tag_bar">
      <button class="contest_tag_bar_item current">所有</button>
      <button class="contest_tag_bar_item">我的组织</button>
      <button class="contest_tag_bar_item">进行中</button>
      <a-input-search
        v-model:value="value"
        placeholder="搜索"
        style="width: 200px; border-radius: 17px"
        @search="onSearch"
      />
    </div>

    <a-table
      :bordered="false"
      class="ant-table-striped"
      :columns="columns"
      :data-source="data"
      @change="onChange"
      :rowClassName="
        (record, index) => (index % 2 === 1 ? 'table-striped' : null)
      "
    >
      <template #name="{ text }">
        <router-link :to="{ name: 'Contest', params: { id: text } }">
          <a class="contest_title">{{ text }}</a>
          <div class="contest_date">2021-11-21 10:30</div>
        </router-link>
      </template>
      <template #org="{ text }">
        {{ text }}
      </template>
      <template #status="{ text }">
        <a-space>
          <CheckCircleTwoTone twoToneColor="#52c41a" v-if="text == '进行中'" />
          <CloseCircleTwoTone twoToneColor="#eb2f96" v-if="text == '已结束'" />
          <ClockCircleTwoTone v-if="text == '未开始'" />
          {{ text }}
        </a-space>
      </template>
    </a-table>
  </div>
</template>
<script>
import { defineComponent } from "vue";
import {
  CheckCircleTwoTone,
  CloseCircleTwoTone,
  ClockCircleTwoTone,
} from "@ant-design/icons-vue";
const columns = [
  {
    title: "竞赛名称",
    dataIndex: "name",
    slots: {
      customRender: "name",
    },
  },
  {
    title: "组织",
    dataIndex: "org",
    sorter: (a, b) => a.org.localeCompare(b.org),
    slots: {
      customRender: "org",
    },
  },
  {
    title: "时长",
    dataIndex: "duration",
    sorter: (a, b) => a.org.localeCompare(b.org),
  },
  {
    title: "状态",
    dataIndex: "status",
    filters: [
      {
        text: "进行中",
        value: "进行中",
      },
      {
        text: "已结束",
        value: "已结束",
      },
      {
        text: "未开始",
        value: "未开始",
      },
    ],
    filterMultiple: false,
    onFilter: (value, record) => record.status.indexOf(value) === 0,
    sorter: (a, b) => a.status.localeCompare(b.status),
    sortDirections: ["descend", "ascend"],
    slots: {
      customRender: "status",
    },
  },
];
const data = [
  {
    key: "1",
    name: "18电信2班Java练习01",
    org: "Intel",
    duration: "3天0小时",
    status: "进行中",
  },
  {
    key: "2",
    name: "18软工1班面向对象01",
    org: "Google",
    duration: "3小时",
    status: "已结束",
  },
  {
    key: "3",
    name: "18软工2班Java游戏设计01",
    org: "腾讯",
    duration: "2小时",
    status: "未开始",
  },
  {
    key: "4",
    name: "18软工3班Java字符串练习题",
    org: "Shopee",
    duration: "365天",
    status: "进行中",
  },
  {
    key: "5",
    name: "18软工1班面向对象02",
    org: "字节跳动",
    duration: "30分钟",
    status: "进行中",
  },
];
export default defineComponent({
  setup() {
    const onChange = (pagination, filters, sorter) => {
      console.log("params", pagination, filters, sorter);
    };

    return {
      data,
      columns,
      onChange,
    };
  },
  components: {
    CheckCircleTwoTone,
    CloseCircleTwoTone,
    ClockCircleTwoTone,
  },
});
</script>

<style scoped>
.ant-table-striped :deep(.table-striped) td {
  background-color: #fafafa;
}
.contest_title {
  color: #111;
  font-size: 15px;
}
.contest_date {
  font-size: 11px;
  color: grey;
}
.contest_tag_bar {
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
.contest_tag_bar_item {
  word-break: break-all;
  white-space: nowrap;
  user-select: none;
  font: 12px/1.5 numFont, PingFangSC-Regular, Tahoma, Microsoft Yahei,
    sans-serif;
  box-sizing: content-box;
  outline: 0 none;
  border: 0;
  cursor: pointer;
  display: inline-block;
  position: relative;
  margin: 0 10px;
  padding: 0 16px;
  border-radius: 17px;
  background-color: #f8f8f8;
  color: #111;
  font-size: 14px;
  line-height: 32px;
  margin-left: 0;
}
.current {
  background: linear-gradient(90deg, #ffb821 0, #ff5c38 45%, #ff1459);
  background-color: #ff183e;
  color: #fff;
}
</style>
