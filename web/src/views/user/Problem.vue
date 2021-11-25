<template>
  <div>
    <a-row type="flex">
      <a-col flex="1"></a-col>
      <a-col flex="3">
        <a-row>
          <!-- theme: https://codemirror.net/demo/theme.html#juejin -->
          <a-col :span="20"> <ProblemDesc /> <CodeMirrorEditor v-model:value="code" scene="edit" theme="juejin"/> </a-col>
          <a-col :span="4"> <ExtraInfo /></a-col> </a-row
      ></a-col>
      <a-col flex="1"></a-col>
    </a-row>
  </div>
</template>
<script>
import { defineComponent } from "vue";
import ProblemDesc from "@/components/user/ProblemDesc";
import ExtraInfo from "@/components/user/ExtraInfo";
// import MonacoEditor from "@/components/user/MonacoEditor";
import CodeMirrorEditor from "@/components/user/CodeMirrorEditor";
const data = [
  "Racing car sprays burning fuel into crowd.",
  "Japanese princess to wed commoner.",
  "Australian walks 100km after outback crash.",
  "Man charged over missing wedding girl.",
  "Los Angeles battles huge wildfires.",
];
export default defineComponent({
  setup() {
    return { data };
  },
  components: { ExtraInfo, ProblemDesc, CodeMirrorEditor },
});
</script>
<style scoped>
.right_widget {
  margin-left: 20px;
}

.title {
  line-height: 1;
  margin: 0;
  padding: 10px 0;
  vertical-align: baseline;
  font-size: 20px;
  color: #2a2a2a;
  border-bottom: 1px solid #f0f0f0;
  width: 100%;
}

.desc {
  padding: 15px 0;
  font-size: 13px;
  line-height: 1.5rem;
}
</style>
