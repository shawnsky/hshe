<template>
  <a-row type="flex" class="head under_shadow">
    <a-col :flex="23"></a-col>

    <a-col :flex="1"
      ><div class="status_bar">
        <div class="bar_item">
          <a-dropdown :trigger="['click']">
            <a class="ant-dropdown-link" @click.prevent>
              <a-space>
                <img id="avatar" src="../../assets/default-avatar.png" alt="" />
                <div id="user">Dr. Woo</div>
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
    <a-col :flex="1">
      <router-link :to="{ name: 'Explore' }">
        <a-button><SelectOutlined /> 回到前台</a-button>
      </router-link>
    </a-col>
  </a-row>
</template>
<script>
import { defineComponent, ref } from "vue";
import { SelectOutlined } from "@ant-design/icons-vue";
export default defineComponent({
  setup() {
    const current = ref(["logo"]);
    return {
      current,
    };
  },

  components: { SelectOutlined },
});
</script>

<style scoped>
.head {
  height: 64px;
  user-select: none;
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
  height: 64px;
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
