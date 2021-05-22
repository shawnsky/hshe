<template>
  <div>
    <h1>创建考试</h1>
    <a-select
      style="width: 300px; margin: 8px 0"
      @change="handleChange"
      v-model="classSelected"
    >
      <a-select-option
        v-for="item in classes"
        :key="item.class_id"
        :value="item.class_id"
      >
        {{ item.class_name }}
      </a-select-option>
    </a-select>
    <br />

    <a-input
      placeholder="考试名称"
      style="width: 300px; margin: 8px 16px 8px 0"
      v-model="examTitle"
    />

    <a-range-picker
      :showTime="{ format: 'HH:mm' }"
      format="YYYY-MM-DD HH:mm"
      :placeholder="['考试开始时间', '考试结束时间']"
      @change="onChange"
      @ok="onOk"
    />

    <a-button @click="createExam()" style="margin-left: 16px;">创建</a-button>

    <h1 style="margin: 16px 0">考试列表</h1>
    <a-table :columns="columns" :dataSource="exams">
      <div slot="analysis" slot-scope="text">
        <a @click="enter(text)">查看详情</a>
        <a @click="deleteExam(text)">删除</a>
      </div>
    </a-table>
  </div>
</template>

<script>
import axios from "axios";
import Qs from "qs";

const columns = [
  {
    title: "ID",
    dataIndex: "id",
    key: "id"
  },
  {
    title: "标题",
    dataIndex: "title",
    key: "title"
  },
  {
    title: "描述",
    dataIndex: "description",
    key: "description"
  },
  {
    title: "开始时间",
    dataIndex: "startTime",
    key: "startTime"
  },
  {
    title: "结束时间",
    dataIndex: "endTime",
    key: "endTime"
  },
  {
    title: "创建时间",
    dataIndex: "createTime",
    key: "createTime"
  },
  {
    title: "创建者",
    dataIndex: "creator",
    key: "creator"
  },
  {
    title: "操作",
    dataIndex: "id",
    key: "analysis",
    scopedSlots: { customRender: "analysis" }
  }
];

export default {
  data() {
    return {
      columns,
      classes: [],
      exams: [],
      classSelected: "选择要添加的班级",
      examTitle: "",
      beginTime: "",
      endTime: ""
    };
  },
  mounted() {
    this.fetchClasses();
    this.fetchExam();
  },
  methods: {
    fetchClasses() {
      axios
        .get("/api/c", {
          headers: {
            "Access-Token": window.localStorage.getItem("token")
          }
        })
        .then(resp => {
          console.log(resp.data.data);
          this.classes = resp.data.data;
        });
    },
    fetchExam() {
      axios
        .get("/api/t", {
          headers: {
            "Access-Token": window.localStorage.getItem("token")
          }
        })
        .then(resp => {
          console.log(resp.data.data);
          var rawExams = resp.data.data;
          rawExams.forEach(element => {
            if (element.description == null) {
              element.description = "无";
            }
            element.startTime = this.readableDate(element.startTime);
            element.endTime = this.readableDate(element.endTime);
            element.createTime = this.readableDate(element.createTime);
          });
          this.exams = rawExams;
        });
    },
    handleChange(value) {
      console.log(`selected ${value}`);
    },
    readableDate(date) {
      if (date == "") {
        return "无";
      }
      return new Date(parseInt(date))
        .toLocaleString()
        .replace(/:\d{1,2}$/, " ");
    },
    createExam() {
      let data = {
        title: this.examTitle,
        class_flag: this.classSelected,
        user_id: localStorage.getItem("userId"),
        begin_time: this.beginTime,
        end_time: this.endTime
      };
      axios
        .post("/api/t", data, {
          headers: {
            "Access-Token": window.localStorage.getItem("token")
          }
        })
        .then(resp => {
          console.log(resp.data.data);
          this.fetchExam();
        });
    },
    onChange(value, dateString) {
      console.log("Selected Time: ", value);
      console.log("Formatted Selected Time: ", dateString);
      this.beginTime = dateString[0];
      this.endTime = dateString[1];
    },
    onOk(value) {
      console.log("onOk: ", value);
    },
    enter(id) {
      this.$router.push({
        name: "examAnalysis",
        params: {
          id: id
        }
      });
    },
    deleteExam(id) {
      axios
        .delete("/api/t/"+id, {
          headers: {
            "Access-Token": window.localStorage.getItem("token")
          }
        })
        .then(resp => {
          console.log(resp.data.data);
          this.fetchExam();
        });
    }
  }
};
</script>
