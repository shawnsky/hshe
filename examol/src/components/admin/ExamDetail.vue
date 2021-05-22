<template>
  <div>
    <h1>学生完成情况</h1>
    <a-table :columns="columns" :dataSource="users"> 
        <a slot="grade" slot-scope="text">{{ text }}</a>
    </a-table>

    <h1>提交列表</h1>
    <div>
      选择题目 
    <a-select defaultValue="lucy" style="width: 120px" @change="handleChange">
      <a-select-option value="jack">Jack</a-select-option>
    </a-select>

  </div>

    <a-table :columns="columns2" :dataSource="submissions">
        <a slot="problemId" slot-scope="text" :href="'/problem/'+text">{{ text }}</a>

        <span slot="judged" slot-scope="text">
          <a-tag :color="colorMap.get(judgedMap.get(text))" :key="text">
            {{ judgedMap.get(text) }}
          </a-tag>
        </span>
        <a slot="src" slot-scope="text" @click="showModal(text)">查看</a>
      </a-table>

      <a-modal title="学生的答案" v-model="visible" @ok="hideModal" okText="OK">
        <pre>
          {{src}}
        </pre>
    </a-modal>

  </div>
</template>

<script>
import axios from "axios";
const columns = [
  {
    title: "ID",
    dataIndex: "id",
    key: "id"
  },
  {
    title: "昵称",
    dataIndex: "nick",
    key: "nick"
  },
  {
    title: "得分",
    dataIndex: "grade",
    key: "grade",
    scopedSlots: { customRender: 'grade' },
  }
];


const columns2 = [
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
    title: "答案",
    key: "src",
    dataIndex: "src",
    scopedSlots: { customRender: "src" },
  },
  {
    title: "题目",
    dataIndex: "problemId",
    key: "problemId",
    scopedSlots: { customRender: "problemId" },
  },
  {
    title: "语言",
    dataIndex: "lang",
    key: "lang",
  },
    {
    title: "长度",
    dataIndex: "length",
    key: "length",
  },
  {
    title: "运行耗时(ms)",
    dataIndex: "timeUsed",
    key: "timeUsed",
  },
  {
    title: "内存占用(kb)",
    dataIndex: "memoryUsed",
    key: "memoryUsed",
  },
  {
    title: "用户",
    dataIndex: "userId",
    key: "userId",
  },
];

const colorMap = new Map();
colorMap.set("Accepted", "green");
colorMap.set("Wrong Answer", "red");
colorMap.set("Compile Error", "orange");
colorMap.set("Time Limit Exceed", "orange");
colorMap.set("Memory Limit Exceed", "orange");
colorMap.set("Compile Error", "orange");

const judgedMap = new Map();
judgedMap.set(0,"Accepted");
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
      columns2,
      colorMap,
      judgedMap,
      users: [],
      submissions: [],
      problems: [],
      examId: "",
      visible: false,
      src: ""
    };
  },
  mounted() {
    this.examId = this.$route.params.id;
    this.fetchAnalysis();
    this.fetchSubmission();
    this.fetchProblems();
    
  },
  methods: {
    fetchAnalysis() {
      axios
        .get("/api/analysis?topic_id=" + this.examId+'', {
          headers: {
            "Access-Token": window.localStorage.getItem("token")
          }
        })
        .then(resp => {
          this.users = resp.data.data;
        });
    },
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
          })
          this.submissions = raw;
        });
    },
    fetchProblems() {
      axios
        .get("/api/t/" + this.examId, {
          headers: {
            "Access-Token": window.localStorage.getItem("token")
          }
        })
        .then(resp => {
          this.problems = resp.data.data;
          var raw = this.problems.problemListItemVos;
          raw.forEach(e => {
            if (e.submitNum == null || e.submitNum == 0) {
              e.ratio = '无';
            } else {
              e.ratio = e.acceptNum/e.submitNum;
            }
            
          })

          this.problems.problemListItemVos = raw;
        });
    },
    readableDate(date) {
      if (date == "") {
        return "无";
      }
      return new Date(parseInt(date))
        .toLocaleString()
        .replace(/:\d{1,2}$/, " ");
    },
    showModal(src) {
      console.log("showmodal"+src)
      this.src = src;
      this.visible = true;
    },
    hideModal() {
      this.visible = false;
    },
  }
};
</script>
