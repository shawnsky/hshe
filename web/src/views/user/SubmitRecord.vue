<template>
  <div>
    <a-table :columns="columns" :data-source="data">
      <template #time="{ text }">
        {{ text }}
      </template>
      <template #problem="{ text }">
        <router-link
          :to="{ name: 'Problem', params: { id: 'asdf' } }"
        >{{ text }}</router-link>
      </template>
      <template #customTitle>
        <span>
          <ClockCircleOutlined />
          提交时间
        </span>
      </template>
      <template #tags="{ record }">
        <span>
          <a-tag :color="resultColorDic[record.result]">
            {{ resultTextDic[record.result] }}
          </a-tag>
        </span>
      </template>
      <template #action="{ record }">
        <span>
          <a>源代码 {{ record.name }}</a>
        </span>
      </template>
    </a-table>
  </div>
</template>
<script>
import { ClockCircleOutlined } from "@ant-design/icons-vue";
import { defineComponent } from "vue";
const columns = [
  {
    dataIndex: "time",
    key: "time",
    slots: {
      title: "customTitle",
      customRender: "time",
    },
  },
  {
    title: "题目",
    dataIndex: "problem",
    key: "problem",
    slots: {
      customRender: "problem",
    },
  },

  {
    title: "结果",
    key: "tags",
    dataIndex: "tags",
    slots: {
      customRender: "tags",
    },
  },
  {
    title: "编程语言",
    dataIndex: "language",
    key: "language",
  },
  {
    title: "耗时",
    dataIndex: "timecost",
    key: "timecost",
  },
  {
    title: "内存",
    dataIndex: "memory",
    key: "memory",
  },
  {
    title: "用户",
    dataIndex: "user",
    key: "user",
  },
  {
    title: "操作",
    key: "action",
    slots: {
      customRender: "action",
    },
  },
];
const data = [
  {
    key: "1",
    time: "26秒前",
    problem: "最长回文子串",
    result: 0,
    language: "java",
    timecost: "700ms",
    memory: "20.2MB",
    user: "klm",
  },
  {
    key: "2",
    time: "7天前",
    problem: "最长回文子串",
    result: 1,
    language: "java",
    timecost: "700ms",
    memory: "20.2MB",
    user: "klm",
  },
  {
    key: "3",
    time: "7天前",
    problem: "最长回文子串",
    result: 2,
    language: "java",
    timecost: "700ms",
    memory: "20.2MB",
    user: "klm",
  },
  {
    key: "4",
    time: "7个月前",
    problem: "最长回文子串",
    result: 1,
    language: "java",
    timecost: "700ms",
    memory: "20.2MB",
    user: "klm",
  },
  {
    key: "5",
    time: "7个月前",
    problem: "最长回文子串",
    result: 1,
    language: "java",
    timecost: "700ms",
    memory: "20.2MB",
    user: "klm",
  },
  {
    key: "6",
    time: "4年前",
    problem: "最长回文子串",
    result: 1,
    language: "java",
    timecost: "700ms",
    memory: "20.2MB",
    user: "klm",
  },
  {
    key: "7",
    time: "4年前",
    problem: "最长回文子串",
    result: 1,
    language: "java",
    timecost: "700ms",
    memory: "20.2MB",
    user: "klm",
  },
  {
    key: "8",
    time: "4年前",
    problem: "最长回文子串",
    result: 1,
    language: "java",
    timecost: "700ms",
    memory: "20.2MB",
    user: "klm",
  },
];
export default defineComponent({
  setup() {
    const resultTextDic = [
      "通过",
      "答案错误",
      "时间超限",
      "输出超限",
      "内存超限",
      "运行时错误",
      "格式错误",
      "编译错误",
      "系统错误",
    ];
    const resultColorDic = [
      "green",
      "volcano",
      "geekblue",
      "geekblue",
      "geekblue",
      "geekblue",
      "geekblue",
      "geekblue",
      "geekblue",
    ];
    return {
      data,
      columns,
      resultTextDic,
      resultColorDic,
    };
  },

  components: {
    ClockCircleOutlined,
  },
});
</script>
