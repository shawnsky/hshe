<template>
  <div>
    <h1>添加账号</h1>
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
      name="useradd"
      placeholder="单个添加学生ID，默认密码123456"
      style="width: 300px; margin: 8px 16px 8px 0"
      v-model="userId"
    />

       <a-input
      placeholder="学生姓名"
      style="width: 300px; margin: 8px 16px 8px 0"
      v-model="userNick"
    />

    <a-button @click="registerSingle()">添加</a-button>

    <a-input-group compact style="margin: 16px 0 32px 0">
      <a-input
        name="batuseradd"
        style="width: 300px"
        placeholder="学生ID开始"
        v-model="userIdStart"
      />
      <a-input
        style="width: 300px;"
        placeholder="学生ID结束"
        v-model="userIdEnd"
      />
      <a-button style="margin-left: 16px" @click="registerBatch()">添加</a-button>
    </a-input-group>
    <h1>学生列表</h1>
    <a-table :columns="columns" :dataSource="users"> </a-table>
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
    title: "姓名",
    dataIndex: "nick",
    key: "nick"
  },
  {
    title: "所属班级",
    dataIndex: "class",
    key: "class"
  },
  {
    title: "邮箱",
    dataIndex: "email",
    key: "email"
  },
  {
    title: "提交数",
    dataIndex: "submit",
    key: "submit"
  },
  {
    title: "通过数",
    dataIndex: "accept",
    key: "accept"
  }
];

export default {
  data() {
    return {
      columns,
      classes: [],
      users: [],
      classSelected: "选择要添加的班级",
      userId: "",
      userNick: "",
      userIdStart: "",
      userIdEnd: ""
    };
  },
  mounted() {
    this.fetchClasses();
    this.fetchUser();
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
    fetchUser() {
        axios
        .get("/api/u", {
          headers: {
            "Access-Token": window.localStorage.getItem("token")
          }
        })
        .then(resp => {
          console.log(resp.data.data);
          this.users = resp.data.data;
        });
    },
    handleChange(value) {
      console.log(`selected ${value}`);
    },
    registerSingle() {
      let data = {
        id: this.userId,
        nickname: this.userNick,
        password: "123456",
        classes_flag: this.classSelected
      };
      axios
        .post("/api/u", data, {
          headers: {
            "Access-Token": window.localStorage.getItem("token")
          }
        })
        .then(resp => {
          console.log(resp.data.data);
          this.fetchUser();
        });
    },
    registerBatch() {
      let data = {
        id0: this.userIdStart,
        id1: this.userIdEnd,
        password: "123456",
        classes_flag: this.classSelected
      };
      axios
        .put("/api/u", data, {
          headers: {
            "Access-Token": window.localStorage.getItem("token")
          }
        })
        .then(resp => {
          console.log(resp.data.data);
          this.fetchUser();
        });
    }
  }
};
</script>
