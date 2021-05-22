<template>
  <div>
    <h1 style="margin: 16px 0">考试列表({{ examsLength }})</h1>
    <div :style="{ background: '#fff', padding: '24px', minHeight: '280px' }">
      <a-list size="large" bordered :dataSource="exams">
        <a-list-item slot="renderItem" slot-scope="item">
          <a @click="enter(item.id)">{{ item.title }}</a>
          <a-badge
            v-if="item.topicStatus == 1"
            status="processing"
            text="考试中"
          />
          <a-badge
            v-if="item.topicStatus == 0"
            status="default"
            text="已结束"
          />
          <a-badge
            v-if="item.topicStatus == -1"
            status="warning"
            text="未开始"
          />
        </a-list-item>
      </a-list>
    </div>
    <h1 style="margin: 16px 0">资源下载</h1>
    <div :style="{ background: '#fff', padding: '24px', minHeight: '280px' }">
      <a-list size="large" bordered :dataSource="files">
        <a-list-item slot="renderItem" slot-scope="item">
          {{ item.name }}
          <a :href="'api' + item.path" style="float: right">下载</a>
        </a-list-item>
      </a-list>
    </div>
  </div>
</template>

<script>
import axios from "axios";
import Qs from "qs";

export default {
  data() {
    return {
      exams: [],
      files: []
    };
  },
  computed: {
    examsLength: function() {
      return this.exams.length;
    }
  },
  mounted() {
    this.fetchExams();
    this.fetchFiles();
  },
  methods: {
    fetchExams() {
      axios
        .get("/api/t?isVo=1", {
          headers: {
            "Access-Token": window.localStorage.getItem("token")
          }
        })
        .then(resp => {
          console.log(resp.data.data);
          this.exams = resp.data.data;
        });
    },
    fetchFiles() {
      axios
        .get("/api/f", {
          headers: {
            "Access-Token": window.localStorage.getItem("token")
          }
        })
        .then(resp => {
          console.log(resp.data.data);
          this.files = resp.data.data;
        });
    },
    enter(key) {
      this.$router.push({
        name: "examDetail",
        params: {
          id: key
        }
      });
    },
    checkLogin() {
      if (
        localStorage.getItem("token") == null ||
        localStorage.getItem("token") == ""
      ) {
        this.$router.push({ path: "/login" });
      }
    }
  }
};
</script>
