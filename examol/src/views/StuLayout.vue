<template>
  <a-layout id="s-layout" class="layout">
    <a-layout-header>
      <Logo class="logo" title="在线考试系统"></Logo>
      
      <a-menu
        theme="dark"
        mode="horizontal"
        :selectable="false"
        :style="{ lineHeight: '64px' }"
      >
        <a-menu-item key="1"
          ><router-link to="/exam">我的考试</router-link></a-menu-item
        >
        <a-menu-item key="2"
          ><router-link to="/submission">我的答案</router-link></a-menu-item
        >
        <a-menu-item key="4"
          ><router-link to="/help">使用帮助</router-link></a-menu-item
        >
        <a-menu-item key="5" style="float: right">
          <a-dropdown>
            <a class="ant-dropdown-link" @click="e => e.preventDefault()">
              {{ userId }} <a-icon type="down" />
            </a>
            <a-menu slot="overlay">
              <!-- <a-menu-item>
                <router-link to="/profile"> <a href="javascript:;">修改资料</a> </router-link>
              </a-menu-item> -->
              <a-menu-item v-if="isAdmin">
                <router-link to="/admin"> <a>后台管理</a> </router-link>
              </a-menu-item>
              <a-menu-item>
                <a @click="logout()">退出登录</a>
              </a-menu-item>
            </a-menu>
          </a-dropdown>
          <!-- <router-link to="/user">{{ userId }}</router-link> -->
        </a-menu-item>
      </a-menu>
    </a-layout-header>
    <a-layout-content style="padding: 0 200px">
      <router-view />
    </a-layout-content>
    <a-layout-footer style="text-align: center">
      计算机编程类在线考试系统 ©2020
    </a-layout-footer>
  </a-layout>
</template>
<script>
import Logo from '@/components/Logo'
export default {
  components: {Logo },
  data() {
    return {
      userId: localStorage.getItem("userId"),
      isAdmin: localStorage.getItem("role") == '1'
    };
  },
  methods: {
    logout() {
      localStorage.clear();
      this.$router.push({ path: '/login' });
    }
  }
};
</script>
<style>
#s-layout .logo {
  width: 200px;
  height: 31px;
  float: left;
}
</style>
