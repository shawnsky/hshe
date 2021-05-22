<template>
  <div>
    <h1>添加题目</h1>
    <a-select
      placeholder="选择关联考试"
      style="width: 300px; margin: 8px 0"
      @change="handleChange"
    >
      <a-select-option v-for="item in exams" :key="item.id" :value="item.id">
        {{ item.title }}
      </a-select-option>
    </a-select>
    <br />
    <a-input
      name="title"
      placeholder="题目标题"
      style="width: 300px; margin: 8px 16px 8px 0"
      v-model="title"
    />

    <a-textarea
      placeholder="题目描述"
      :rows="8"
      v-model="description"
    ></a-textarea>
    <h1>设置限制</h1>
    <a-input
      placeholder="时间限制（ms）"
      style="width: 300px; margin: 8px 16px 8px 0"
      v-model="timeLimit"
    />
    <a-input
      placeholder="内存限制（MB）"
      style="width: 300px; margin: 8px 16px 8px 0"
      v-model="memLimit"
    />
    <h1>创建测试用例</h1>
    <a-row>
      <a-col :span="12">
        <a-textarea
          placeholder="测试用例输入"
          style="margin-right: 8px"
          v-model="testInput"
        ></a-textarea>
      </a-col>
      <a-col :span="12">
        <a-textarea
          placeholder="测试用例输出"
          style="margin-left: 8px"
          v-model="testOutput"
        ></a-textarea>
      </a-col>
    </a-row>

    <a-button @click="submitProblem()" type="primary" style="margin: 16px 0"
      >添加</a-button
    >
  </div>
</template>

<script>
import axios from "axios";
export default {
  data() {
    return {
      examSelected: "",
      exams: [],
      title: "",
      description: "",
      timeLimit: "1000",
      memLimit: "64",
      testInput: "",
      testOutput: ""
    };
  },
  mounted() {
    this.fetchExam();
  },
  methods: {
    fetchExam() {
      axios
        .get("/api/t", {
          headers: {
            "Access-Token": window.localStorage.getItem("token")
          }
        })
        .then(resp => {
          console.log(resp.data.data);
          this.exams = resp.data.data;
        });
    },
    handleChange(value) {
      this.examSelected = value+'';
    },
    submitProblem() {
      let data = {
        title: this.title,
        topic_flag: this.examSelected,
        description: this.description,
        time_limit: this.timeLimit,
        memory_limit: this.memLimit,
        tests_count: '1',
        user_id: localStorage.getItem("userId"),
        input0: this.testInput,
        output0: this.testOutput
      };
      axios
        .post("/api/p", data, {
          headers: {
            "Access-Token": window.localStorage.getItem("token")
          }
        })
        .then(resp => {
          console.log(resp.data.data);
          if (resp.data.code == 1) {
            this.$message.success("添加题目成功")
          } else {
            this.$message.error("添加失败")
          }
        });
    }
  }
};
</script>
