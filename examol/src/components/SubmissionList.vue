<template>
  <div>
    <a-breadcrumb style="margin: 16px 0">
      <a-breadcrumb-item>首页</a-breadcrumb-item>
      <a-breadcrumb-item>我的提交</a-breadcrumb-item>
    </a-breadcrumb>
    <div :style="{ background: '#fff', padding: '24px', minHeight: '280px' }">
      <a-table :columns="columns" :dataSource="submissions">
        <a slot="problemId" slot-scope="text" :href="'/problem/' + text">{{
          text
        }}</a>

        <span slot="judged" slot-scope="text">
          <a-tag v-if="text != -1" :color="colorMap.get(judgedMap.get(text))" :key="text">
            {{ judgedMap.get(text) }}
          </a-tag>
          <a-spin v-if="text == -1" /><span v-if="text == -1" style="margin-left: 8px">判题中</span>
        </span>
      </a-table>
    </div>
  </div>
</template>
<script>
import axios from "axios";
import Qs from "qs";
const columns = [
  {
    title: "提交时间",
    dataIndex: "createTime",
    key: "createTime",
    width: "15%"
  },
  {
    title: "状态",
    key: "judged",
    dataIndex: "judged",
    scopedSlots: { customRender: "judged" },
    width: "15%"
  },
  {
    title: "题目",
    dataIndex: "problemId",
    key: "problemId",
    scopedSlots: { customRender: "problemId" }
  },
  {
    title: "语言",
    dataIndex: "lang",
    key: "lang"
  },
  {
    title: "长度",
    dataIndex: "length",
    key: "length"
  },
  {
    title: "运行耗时(ms)",
    dataIndex: "timeUsed",
    key: "timeUsed"
  },
  {
    title: "内存占用(kb)",
    dataIndex: "memoryUsed",
    key: "memoryUsed"
  }
];

const colorMap = new Map();
colorMap.set("Accepted", "green");
colorMap.set("Wrong Answer", "red");
colorMap.set("Compile Error", "orange");
colorMap.set("Time Limit Exceed", "orange");
colorMap.set("Memory Limit Exceed", "orange");
colorMap.set("Compile Error", "orange");

const judgedMap = new Map();
judgedMap.set(0, "Accepted");
judgedMap.set(1, "Wrong Answer");
judgedMap.set(2, "Time Limit Exceed");
judgedMap.set(3, "Output Limit Exceed");
judgedMap.set(4, "Memory Limit Exceed");
judgedMap.set(5, "Runtime Error");
judgedMap.set(6, "Pattern Error");
judgedMap.set(7, "Compile Error");
judgedMap.set(8, "System Error");

export default {
  data() {
    return {
      columns,
      colorMap,
      judgedMap,
      submissions: []
    };
  },
  mounted() {
    this.fetchSubmission();
  },
  methods: {
    fetchSubmission() {
      axios
        .get("/api/s", {
          headers: {
            "Access-Token": window.localStorage.getItem("token")
          }
        })
        .then(resp => {
          var raw = resp.data.data;
          raw.forEach(e => {
            e.createTime = this.readableDate(e.createTime);
          });
          this.submissions = raw.filter(s => s.userId == localStorage.getItem("userId"))
        });
    },
    readableDate(date) {
      if (date == "") {
        return "无";
      }
      return new Date(parseInt(date))
        .toLocaleString()
        .replace(/:\d{1,2}$/, " ");
    }
  }
};
</script>
