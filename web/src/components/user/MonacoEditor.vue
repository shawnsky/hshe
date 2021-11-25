<template>
  <div id="monaco-editor-box">
    <div id="monaco-editor" ref="monacoEditor" />
  </div>
</template>
<script>
import { onMounted, defineComponent, ref } from "vue";
import * as monaco from "monaco-editor/esm/vs/editor/editor.main";
export default defineComponent({
  setup() {
    const monacoEditor = ref(null);
    const codeValue = ref("");
    const options = {
      selectOnLineNumbers: true,
      roundedSelection: false,
      readOnly: true, // 只读
      cursorStyle: "line", //光标样式
      automaticLayout: false, //自动布局
      glyphMargin: true, //字形边缘
      useTabStops: false,
      fontSize: 28, //字体大小
      autoIndent: true, //自动布局
      //quickSuggestionsDelay: 500,   //代码提示延时
    };
    const setupEditor = () => {
      console.log(monacoEditor);
      monaco.editor.create(monacoEditor.value, {
        value: "123", // 编辑器初始显示内容
        language: "java", // 支持语言
        theme: "vs-light", // 主题
        selectOnLineNumbers: true, //显示行号
        editorOptions: options.value,
      });
    };
    onMounted(() => {});

    setTimeout(() => {
      setupEditor();
    }, 1000);

    return {
      monacoEditor,
      isSave: true, //文件改动状态，是否保存
      codeValue, //保存后的文本
      setupEditor,
    };
  },
  props: {
    editorOptions: {
      type: Object,
      default: function () {
        return {
          selectOnLineNumbers: true,
          roundedSelection: false,
          readOnly: true, // 只读
          cursorStyle: "line", //光标样式
          automaticLayout: false, //自动布局
          glyphMargin: true, //字形边缘
          useTabStops: false,
          fontSize: 28, //字体大小
          autoIndent: true, //自动布局
          //quickSuggestionsDelay: 500,   //代码提示延时
        };
      },
    },
    codes: {
      type: String,
      default: function () {
        return "<div>请编辑html内容</div>";
      },
    },
  },

  components: {},
});
</script>
<style scoped>
#monaco-editor {
  height: 600px;
  width: 100%;
  padding: 0 20px;
}
</style>
