<template>
  <div>
    <h1>添加文件</h1>
    <a-input
      placeholder="文件标题"
      style="width: 300px; margin: 8px 16px 8px 0"
      v-model="title"
    />

    <a-checkbox @change="onChange">外部链接</a-checkbox>
    <br />
    <a-input
      v-show="isExternal"
      placeholder="资源网络地址（如 https://...）"
      style="width: 300px; margin: 8px 16px 8px 0"
      v-model="url"
    />

    <a-upload
      v-show="!isExternal"
      action="/api/f"
      :multiple="false"
      @change="handleChange"
      :headers="{ 'Access-Token': token }"
    >
      <a-button> <a-icon type="upload" /> Upload </a-button>
    </a-upload>

    <div>
      <a-button @click="uploadResource()" type="primary" style="margin: 16px 0"
        >添加</a-button
      >
    </div>

    <h1>资源列表</h1>
    <a-table :columns="columns" :dataSource="fileList"> </a-table>
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
    title: "名称",
    dataIndex: "name",
    key: "name"
  },
  {
    title: "文件地址",
    dataIndex: "path",
    key: "path"
  }
];

export default {
  data() {
    return {
      token: localStorage.getItem("token"),
      columns,
      fileList: [],
      isExternal: false,
      title: "",
      url: ""
    };
  },
  mounted() {
    this.fetchFiles();
  },
  methods: {
    fetchFiles() {
      axios
        .get("/api/f", {
          headers: {
            "Access-Token": window.localStorage.getItem("token")
          }
        })
        .then(resp => {
          this.fileList = resp.data.data;
        });
    },

    handleChange(info) {
      let file = info.file;
      if (file.status == "done") {
        this.url = file.response.data;
      }
    },
    uploadResource() {
      let data = {
        title: this.title,
        url: this.url
      };
      axios
        .put("/api/f", data, {
          headers: {
            "Access-Token": window.localStorage.getItem("token")
          }
        })
        .then(resp => {
          this.fetchFiles()
        });
    },
    onChange(e) {
      this.isExternal = !this.isExternal;
    }
  }
};
</script>
