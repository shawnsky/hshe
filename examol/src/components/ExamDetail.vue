<template>
  <div>
    <div>
      <a-breadcrumb style="margin: 16px 0">
        <a-breadcrumb-item>首页</a-breadcrumb-item>
        <a-breadcrumb-item>{{data.title}}</a-breadcrumb-item>
      </a-breadcrumb>
      <div :style="{ background: '#fff', padding: '24px', minHeight: '280px' }">
        <a-table :columns="columns" :dataSource="data.problemListItemVos">
          <a slot="problem" slot-scope="text, record" @click="enter(record.id, data.title)">{{ text }}</a>
          <span slot="ratio" slot-scope="text">{{ text }}</span>
          <!-- <span slot="customSolved"><a-icon type="smile-o" /> Solved</span> -->
        </a-table>
      </div>
    </div>
  </div>
</template>
<script>
import axios from "axios";
import Qs from "qs";
const columns = [
  // {
  //   dataIndex: "solved",
  //   key: "solved",
  //   slots: { title: "customSolved" },
  //   scopedSlots: { customRender: "solved" },
  //   width: "10%"
  // },
  {
    title: "题目",
    dataIndex: "title",
    key: "problem",
    scopedSlots: { customRender: "problem" }
  },
  {
    title: "答对率",
    key: "ratio",
    dataIndex: "ratio",
    scopedSlots: { customRender: "ratio" },
    width: "10%"
  }
];

export default {
  data() {
    return {
      examId: "",
      data: {},
      columns
    };
  },
  mounted() {
    this.examId = this.$route.params.id;
    this.fetchProblems();
  },
  methods: {
    fetchProblems() {
      axios
        .get("/api/t/" + this.examId, {
          headers: {
            "Access-Token": window.localStorage.getItem("token")
          }
        })
        .then(resp => {
          console.log(resp.data.data);
          this.data = resp.data.data;
          var raw = this.data.problemListItemVos;
          raw.forEach(e => {
            if (e.submitNum == null || e.submitNum == 0) {
              e.ratio = '无';
            } else {
              e.ratio = e.acceptNum/e.submitNum;
            }
            
          })

          this.data.problemListItemVos = raw;
        });
    },
    enter(key, title) {
      this.$router.push({
        name: "problemDetail",
        params: {
          id: key,
          title: title
        }
      });
    }
  }
};
</script>
