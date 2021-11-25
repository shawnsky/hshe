<template>
  <div>
    <OrgDisplay
      name="Facebook"
      src="https://pic.leetcode-cn.com/f8fd5b104aa30bbd9bba7cf428a63e8c130f1665876e6afa52186d9510936517-fb_icon_325x325.png"
      style="margin: 21px"
    />
    <OrgDisplay
      name="Microsoft"
      src="https://pic.leetcode-cn.com/dc8ca8220e0392cd08f0832bf03d6df599fa081505f307f09fdc91139aa4b54b-c0c9bfecd0329eeeaee48437456956fea5fcb84185f37de7656eabfe54c595e1-unnamed-1.png"
      style="margin: 21px"
    />
    <OrgDisplay
      name="Intel"
      src="https://pic.leetcode-cn.com/9aa36017e6e7765ecd52335a0308ce6b4761145fc14136de808951076ebff401-intel.png"
      style="margin: 21px"
    />
    <OrgDisplay
      name="Google"
      src="https://pic.leetcode-cn.com/45a64add888e66ff6d3c551bed948528715996937b877aaf6fdc08eae74789f5-google-logo-png-open-2000.png"
      style="margin: 21px"
    />
    <OrgDisplay
      name="腾讯"
      src="https://assets.leetcode-cn.com/aliyun-lc-upload/tag/%E8%85%BE%E8%AE%AF/company_logo"
      style="margin: 21px"
    />
  </div>
</template>
<script>
import { defineComponent } from "vue";
import OrgDisplay from "@/components/user/OrgDisplay";
export default defineComponent({
  setup() {
    return {};
  },
  components: {
    OrgDisplay,
  },
});
</script>
