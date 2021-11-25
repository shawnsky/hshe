<template>
  <a-layout class="layout">
    <div class="login-form">
      <img id="logo" alt="logo" src="../assets/hshe.png" />
      <h2>登录｜Login</h2>
      <a-form class="form" :model="formState">
        <a-form-item>
          <a-input v-model:value="formState.id" placeholder="用户ID">
            <template #prefix
              ><UserOutlined style="color: rgba(0, 0, 0, 0.25)"
            /></template>
          </a-input>
        </a-form-item>
        <a-form-item>
          <a-input
            v-model:value="formState.password"
            type="password"
            placeholder="密码"
          >
            <template #prefix
              ><LockOutlined style="color: rgba(0, 0, 0, 0.25)"
            /></template>
          </a-input>
        </a-form-item>
        <a-form-item>
          <a-button type="primary" shape="round" block @click="onSubmit()">
            登录
          </a-button>
        </a-form-item>
        <a-alert
          v-if="loginErrVisible"
          message="登录失败"
          :description="loginErrMessage"
          type="error"
          closable
          @close="loginErrVisible = false"
        />
      </a-form>
    </div>
  </a-layout>
</template>
<script>
import { defineComponent, reactive, toRaw, ref } from "vue";
import { UserOutlined, LockOutlined } from "@ant-design/icons-vue";
import { useRouter } from "vue-router";
import { login } from "../request/api";
export default defineComponent({
  setup() {
    const router = useRouter();
    const loginErrVisible = ref(false);
    const loginErrMessage = ref("");
    const formState = reactive({
      id: "",
      password: "",
      role: "1", // FIXME: hardcode
    });

    const onSubmit = () => {
      login(toRaw(formState))
        .then((resp) => {
          localStorage.setItem("token", resp.data);
          if (resp.code != 1) {
            loginErrVisible.value = true;
            loginErrMessage.value = resp.msg;
          } else {
            loginErrVisible.value = false;
            router.push({ name: "Explore" });
          }
        })
        .catch((err) => {
          loginErrVisible.value = true;
          loginErrMessage.value = err;
        });
    };

    return {
      formState,
      onSubmit,
      loginErrVisible,
      loginErrMessage,
    };
  },
  components: {
    UserOutlined,
    LockOutlined,
  },
});
</script>

<style scoped>
.layout {
  height: 100vh;
  background: url("../assets/login-background-1c.jpg");
  background-size: 100% 100%;
}

.layout #logo {
  width: 80px;
  height: 80px;
  margin: 20px;
}

.login-form {
  background: #fff;
  border: 1px solid #fff;
  border-radius: 5px;
  width: 400px;
  position: relative;
  margin: 0 auto;
  padding: 20px;
  top: 50%;
  transform: translateY(-50%);
  text-align: center;
}
</style>
