<template>
  <div>
    <a-spin size="large" />
  </div>
</template>
<script>
import { defineComponent } from "vue";
import { useRouter } from "vue-router";

export default defineComponent({
  setup() {
    const router = useRouter();
    const jump = () => {
      router.push({ name: "Login" });
    };

    jump();

    return {};
  },
  components: {
  },
});
</script>
