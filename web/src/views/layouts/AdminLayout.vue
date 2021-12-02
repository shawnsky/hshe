<template>
  <a-layout style="min-height: 100vh">
    <a-layout-sider v-model:collapsed="collapsed" collapsible>
      <a-space class="logo">
        <img alt="logo" src="../../assets/hshe-mini.png" />
        <span id="text" v-if="!collapsed">master</span>
      </a-space>

      <a-menu theme="dark" v-model:selectedKeys="selectedKeys" mode="inline">
        <a-menu-item key="1">
          <router-link :to="{ name: 'Dashboard' }">
            <pie-chart-outlined />
            <span>系统概览</span>
          </router-link>
        </a-menu-item>
        <a-menu-item key="2">
          <desktop-outlined />
          <span>竞赛管理</span>
        </a-menu-item>
        <a-sub-menu key="sub1">
          <template #title>
            <span>
              <user-outlined />
              <span>用户管理</span>
            </span>
          </template>
          <a-menu-item key="3">创建用户</a-menu-item>
          <a-menu-item key="4">
            <router-link :to="{ name: 'UserTable' }">用户列表</router-link>
          </a-menu-item>
        </a-sub-menu>
        <a-sub-menu key="sub2">
          <template #title>
            <span>
              <team-outlined />
              <span>组织管理</span>
            </span>
          </template>
          <a-menu-item key="5">创建组织</a-menu-item>
          <a-menu-item key="6">组织列表</a-menu-item>
        </a-sub-menu>
        <a-sub-menu key="sub3">
          <template #title>
            <span>
              <file-outlined />
              <span>题库管理</span>
            </span>
          </template>
          <a-menu-item key="7">增加题目</a-menu-item>
          <a-menu-item key="8">题目列表</a-menu-item>
        </a-sub-menu>
      </a-menu>
    </a-layout-sider>
    <a-layout>
      <a-layout-header style="background: #fff; padding: 0">
        <Header />
      </a-layout-header>
      <a-layout-content style="margin: 0 16px">
        <a-breadcrumb style="margin: 16px 0">
          <a-breadcrumb-item>User</a-breadcrumb-item>
          <a-breadcrumb-item>Bill</a-breadcrumb-item>
        </a-breadcrumb>
        <div
          :style="{ padding: '24px', background: '#fff', minHeight: '360px' }"
        >
          <router-view />
        </div>
      </a-layout-content>
      <Footer />
    </a-layout>
  </a-layout>
</template>
<script>
import {
  PieChartOutlined,
  DesktopOutlined,
  UserOutlined,
  TeamOutlined,
  FileOutlined,
} from "@ant-design/icons-vue";
import { defineComponent, ref } from "vue";
import Header from "@/components/admin/Header";
import Footer from "@/components/admin/Footer";
export default defineComponent({
  components: {
    PieChartOutlined,
    DesktopOutlined,
    UserOutlined,
    TeamOutlined,
    FileOutlined,
    Header,
    Footer,
  },

  data() {
    return {
      collapsed: ref(false),
      selectedKeys: ref(["1"]),
    };
  },
});
</script>
<style scoped>
#components-layout-demo-side .logo {
  height: 32px;
  margin: 16px;
  background: rgba(255, 255, 255, 0.3);
}

.site-layout .site-layout-background {
  background: #fff;
}
[data-theme="dark"] .site-layout .site-layout-background {
  background: #141414;
}
.logo {
  height: 60px;
  width: 100%;
  padding: 10px 15px;
}
.logo img {
  width: 50px;
  height: 50px;
}
.logo #text {
  font-size: 1.75rem;
  font-weight: 700;
  height: 50px;
  line-height: 50px;
  user-select: none;
  -webkit-text-fill-color: transparent;
  -webkit-background-clip: text;
  background-image: linear-gradient(180deg, #deeaf8 0, #c9d7e8 45%, #9badc4);
}
</style>
