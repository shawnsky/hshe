<template>
  <a-layout style="background: #fff">
    <Header />
    <!-- <a-layout-content :style="{ padding: '0 75px', marginTop: '96px' }">
      <div :style="{ background: '#fff', minHeight: '380px' }"><router-view /></div>
    </a-layout-content> -->

    <a-row type="flex">
      <a-col :flex="1"></a-col>
      <a-col :flex="1">
        <div class="user_layout_container">
          <router-view />
        </div>
      </a-col>
      <a-col :flex="1"></a-col>
    </a-row>

    <Footer />
  </a-layout>
</template>
<script>
import { defineComponent } from "vue";
import Header from "@/components/user/Header";
import Footer from "@/components/user/Footer";

export default defineComponent({
  setup() {
    return {};
  },
  components: {
    Header,
    Footer,
  },
});
</script>

<style scoped>
.user_layout_container {
  padding: 20px 50px;
}
</style>
