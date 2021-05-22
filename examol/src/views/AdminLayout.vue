<template>
  <a-layout id="layout-admin-trigger">
    <a-layout-sider
      :trigger="null"
      collapsible
      v-model="collapsed"
      :style="{ minHeight: '100vh' }"
    >
      <Logo class="logo" title="在线考试系统" :showTitle="!collapsed"></Logo>
      <a-menu theme="dark" mode="inline" :defaultSelectedKeys="['1']">
        <a-menu-item key="1">
          <router-link to="/admin/user">
            <a-icon type="user" />
            <span>学生管理</span>
          </router-link>
        </a-menu-item>
        <a-menu-item key="2">
          <router-link to="/admin/exam">
          <a-icon type="video-camera" />
          <span>考试管理</span>
          </router-link>
        </a-menu-item>
        <a-menu-item key="3">
          <router-link to="/admin/problem">
          <a-icon type="upload" />
          <span>题目管理</span>
          </router-link>
        </a-menu-item>
        <a-menu-item key="4">
          <router-link to="/admin/resource">
          <a-icon type="file-add" />
          <span>文件资源管理</span>
          </router-link>
        </a-menu-item>
      </a-menu>
    </a-layout-sider>
    <a-layout>
      <a-layout-header style="background: #fff; padding: 0">
        <a-icon
          class="trigger"
          :type="collapsed ? 'menu-unfold' : 'menu-fold'"
          @click="() => (collapsed = !collapsed)"
        />
      </a-layout-header>
      <a-layout-content
        :style="{
          margin: '24px 16px',
          padding: '24px',
          background: '#fff',
          minHeight: '280px'
        }"
      >
        <router-view />
      </a-layout-content>
    </a-layout>
  </a-layout>
</template>
<script>
import Logo from '@/components/Logo'
export default {
  components: {Logo},
  data() {
    return {
      collapsed: false
    };
  }
};
</script>
<style>
#layout-admin-trigger .trigger {
  font-size: 18px;
  line-height: 64px;
  padding: 0 24px;
  cursor: pointer;
  transition: color 0.3s;
}

#layout-admin-trigger .trigger:hover {
  color: #1890ff;
}

#layout-admin-trigger .logo {
  height: 32px;
  margin: 16px;
}
</style>
