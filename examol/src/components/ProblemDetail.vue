<template>
  <div>
    <a-breadcrumb style="margin: 16px 0">
      <a-breadcrumb-item>首页</a-breadcrumb-item>
      <a-breadcrumb-item> {{ examTitle }}</a-breadcrumb-item>
      <a-breadcrumb-item> {{ data.title }}</a-breadcrumb-item>
    </a-breadcrumb>
    <div :style="{ background: '#fff', padding: '24px', minHeight: '280px' }">
      <a-page-header @back="() => $router.go(-1)" :title="data.title">
        <div class="content">
          <div class="main">
            <a-descriptions size="small" :column="2">
              <a-descriptions-item label="内存限制"
                >{{ data.memoryLimit }}MB</a-descriptions-item
              >
              <a-descriptions-item label="时间限制">
                {{ data.timeLimit }}ms
              </a-descriptions-item>
              <a-descriptions-item label="创建者">{{
                data.creator
              }}</a-descriptions-item>
              <a-descriptions-item label="创建时间">{{
                readableDate(data.createTime)
              }}</a-descriptions-item>
            </a-descriptions>
          </div>
        </div>
      </a-page-header>
      <div class="desc" style="padding: 16px 25px;line-height:2em">
        {{ data.description }}
      </div>
      <h1 style="padding: 0 25px">输入样例</h1>
      <div
        style="margin: 16px 25px; padding: 8px; border: 1px solid rgb(235, 237, 240)"
      >
        <section>
          <pre>{{ data.inputExample }}</pre>
        </section>
      </div>

      <h1 style="padding: 0 25px">输出样例</h1>
      <div
        style="margin: 16px 25px; padding: 8px; border: 1px solid rgb(235, 237, 240)"
      >
        <section>
          <pre>{{ data.outputExample }}</pre>
        </section>
      </div>
      <h1 style="padding: 0 25px">你的答案</h1>
      <div style="margin: 16px 25px;">
        <a-select defaultValue="Java" style="width: 100%">
          <a-select-option value="java">Java</a-select-option>
        </a-select>
        <codemirror
          name="editor"
          v-model="src"
          style="margin: 16px 0"
        ></codemirror>

        <a-button key="1" type="primary" @click="submit()">
          提交答案
        </a-button>
      </div>
    </div>
  </div>
</template>
<script>
import axios from "axios";
import Qs from "qs";
export default {
  data() {
    return {
      data: {},
      problemId: "",
      examTitle: "",
      src: "",
      lang: "java"
    };
  },
  mounted() {
    this.problemId = this.$route.params.id;
    this.examTitle = this.$route.params.title;
    this.fetchProblem();
  },
  methods: {
    fetchProblem() {
      axios
        .get("/api/p/" + this.problemId, {
          headers: {
            "Access-Token": window.localStorage.getItem("token")
          }
        })
        .then(resp => {
          console.log(resp.data.data);
          this.data = resp.data.data;
        });
    },
    submit() {
      console.log(this.problemId)
      let data = {
        problemId: this.problemId+'',
        src: this.src,
        lang: this.lang
      };
      axios
        .post("/api/s", data, {
          headers: {
            "Access-Token": window.localStorage.getItem("token")
          }
        })
        .then(resp => {
          if (resp.data.code == 0) {
            this.$message.error("系统异常，提交失败");
          } else if (resp.data.code == 1) {
            this.$message.success("提交成功");
          }

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
<style>
tr:last-child td {
  padding-bottom: 0;
}
#components-page-header-demo-responsive .content {
  display: flex;
}
#components-page-header-demo-responsive .ant-statistic-content {
  font-size: 20px;
  line-height: 28px;
}
@media (max-width: 576px) {
  #components-page-header-demo-responsive .content {
    display: block;
  }

  #components-page-header-demo-responsive .main {
    width: 100%;
    margin-bottom: 12px;
  }

  #components-page-header-demo-responsive .extra {
    width: 100%;
    margin-left: 0;
    text-align: left;
  }
}
</style>
