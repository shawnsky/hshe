<template>
  <a-row type="flex" class="head under_shadow">
    <a-col :flex="1"></a-col>
    <a-col :flex="3">
      <a-menu class="user_menu" mode="horizontal">
        <a-menu-item key="logo">
          <img id="logo" alt="logo" src="../../assets/hshe-mini.png" />
        </a-menu-item>
        <a-menu-item key="contest">
          <router-link :to="{ name: 'Explore' }">竞赛</router-link>
        </a-menu-item>
        <a-menu-item key="problem"> 题库 </a-menu-item>
        <a-menu-item key="rank"> 排名 </a-menu-item>
        <a-menu-item key="commit">
          <router-link :to="{ name: 'Submit' }">提交记录</router-link>
        </a-menu-item>
      </a-menu>
    </a-col>
    <a-col :flex="1"
      ><div class="status_bar">
        <div class="bar_item">
          <a-dropdown :trigger="['click']">
            <a class="ant-dropdown-link" @click.prevent>
              <a-space>
                <img id="avatar" src="../../assets/default-avatar.png" alt="" />
                <div id="user">chen</div>
              </a-space>
            </a>
            <template #overlay>
              <a-menu>
                <a-menu-item key="0">
                  <a href="">编辑资料</a>
                </a-menu-item>
                <a-menu-item key="1">
                  <a href="">修改密码</a>
                </a-menu-item>
                <a-menu-divider />
                <a-menu-item key="3">退出登录</a-menu-item>
              </a-menu>
            </template>
          </a-dropdown>
        </div>
      </div></a-col
    >
    <a-col :flex="1"></a-col>
  </a-row>
</template>
<script>
import { defineComponent, ref } from "vue";
// import { SettingTwoTone } from "@ant-design/icons-vue";
export default defineComponent({
  setup() {
    const current = ref(["logo"]);
    return {
      current,
    };
  },

  components: {},
});
</script>

<style scoped>
.head {
  height: 50px;
  user-select: none;
}

.head #logo {
  width: 50px;
}

.user_menu {
  height: 50px;
  font-size: 1rem;
}
.under_shadow {
  --tw-shadow: 0 2px 8px rgba(0, 0, 0, 0.08), 0 1px 2px rgba(0, 0, 0, 0.1);
  box-shadow: var(--tw-ring-offset-shadow, 0 0 #0000),
    var(--tw-ring-shadow, 0 0 #0000), var(--tw-shadow);
}
.status_bar {
  display: flex;
  position: relative;
  align-items: center;
  font-size: 1rem;
  height: 50px;
}

.status_bar .bar_item {
  margin: 0 8px;
}

.bar_item a {
  color: #111;
}

#avatar {
  border-radius: 50%;
  height: 25px;
  width: 25px;
}

#user {
  height: 25px;
  line-height: 25px;
}
</style>
