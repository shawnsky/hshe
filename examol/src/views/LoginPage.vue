<template>
  <div class="main" style="height: 100vh;padding: 200px 0 0 0;">
    <a-row :gutter="24">
      <a-col :span="8" :offset="8">
        <h1 style="text-align: center">在线考试系统</h1>
        <div style="border: 4mm ridge rgba(170, 50, 220, .6); padding: 32px">
          <a-form-model
            :model="form"
            :label-col="labelCol"
            :wrapper-col="wrapperCol"
          >
            <a-form-model-item label="学号/工号">
              <a-input v-model="form.id" />
            </a-form-model-item>

            <a-form-model-item label="密码">
              <a-input-password v-model="form.password" />
            </a-form-model-item>

            <a-form-model-item label="用户类型">
              <a-radio-group v-model="form.type">
                <a-radio value="0">
                  我是学生
                </a-radio>
                <a-radio value="1">
                  我是老师
                </a-radio>
              </a-radio-group>
            </a-form-model-item>

            <a-alert
              v-if="isNullError"
              type="error"
              showIcon
              style="margin-bottom: 24px;"
              message="请输入认证信息和选择角色"
            />
            <a-alert
              v-if="isLoginError"
              type="error"
              showIcon
              style="margin-bottom: 24px;"
              message="账户或密码错误"
            />

            <a-form-model-item :wrapper-col="{ span: 14, offset: 4 }">
              <a-button type="primary" @click="onSubmit">
                登录
              </a-button>
            </a-form-model-item>
          </a-form-model>
        </div>
      </a-col>
    </a-row>
  </div>
</template>

<script>
import axios from "axios";
import Qs from "qs";
export default {
  data() {
    return {
      labelCol: { span: 4 },
      wrapperCol: { span: 14 },
      form: {
        id: "",
        password: "",
        type: "",
      },
      isLoginError: false,
      isNullError: false,
    };
  },
  methods: {
    onSubmit() {
      this.doLogin();
    },
    doLogin() {
      let data = {
        id: this.form.id,
        password: this.form.password,
        role: this.form.type,
      };
      if (data.id == "" || data.password == "" || data.role == "") {
        this.isNullError = true;
        return;
      }
      axios
        .post("/api/auth/login", Qs.stringify(data))
        .then((response) => {
          var code = response.data.code;
          if (code == 1) {
            localStorage.setItem("userId", this.form.id);
            localStorage.setItem("role", this.form.type);
            localStorage.setItem("token", response.data.data);
            this.$router.push({ path: "/" });
            // 延迟 1 秒显示欢迎信息
            setTimeout(() => {
              this.$notification.success({
                message: "欢迎",
                description: `欢迎回来`,
              });
            }, 1000);
            this.isLoginError = false;
          } else {
            this.isLoginError = true;
            // do something
          }
        })
        .catch((error) => {
          this.isLoginError = true;
          this.$notification["error"]({
            message: "错误",
            description:
              ((error.response || {}).data || {}).message ||
              "请求出现错误，请稍后再试",
            duration: 4,
          });
        });
    },
  },
};
</script>
