<template>
  <div class="edit_area">
    <div class="edit_bar">
      <a-space>
        <a-select ref="select" v-model:value="language" style="width: 120px">
          <a-select-option value="java">Java</a-select-option>
          <a-select-option value="cpp">C++</a-select-option>
          <a-select-option value="python">Python3</a-select-option>
          <a-select-option value="go">Go</a-select-option>
          <a-select-option value="javascript">JavaScript</a-select-option>
          <a-select-option value="c">C</a-select-option>
        </a-select>
        <a-button type="text"
          ><template #icon><RollbackOutlined /></template
        ></a-button>
        <a-button type="text"
          ><template #icon><FileOutlined /></template
        ></a-button>
      </a-space>
      <div class="tip">
        <a-badge color="#d1d1d1" />
        <span>代码保存于 2021/11/25 14:26</span>
      </div>
    </div>
    <div class="in-coder-panel">
      <textarea ref="textarea" v-model="code"></textarea>
    </div>
    <div class="action_bar">
      <a-space class="btn_group">
        <a-button type="default" shape="round">暂存代码</a-button>
        <a-button type="primary" shape="round">提交</a-button>
      </a-space>
    </div>
  </div>
</template>

<script>
import {
  reactive,
  defineComponent,
  toRefs,
  getCurrentInstance,
  onMounted,
  onBeforeUnmount,
  ref,
} from "vue";
import { RollbackOutlined, FileOutlined } from "@ant-design/icons-vue";

// ref https://blog.csdn.net/weixin_42950333/article/details/117672285
import _CodeMirror from "codemirror/lib/codemirror";
import "codemirror/lib/codemirror.css";
import "codemirror/theme/juejin.css";
// 自动提示
import "codemirror/addon/hint/show-hint.css";
// 语法高亮库 https://codemirror.net/mode/index.html
import "codemirror/mode/javascript/javascript.js";
import "codemirror/mode/clike/clike.js";

const codemirrorThemList = [];
const requireModules = require.context("codemirror/theme/", false, /\.css$/);
requireModules.keys().forEach((value) => {
  const newValue = value.replace(/^\.\//, "").replace(/\.css$/, "");
  codemirrorThemList.push(newValue);
});
const CodeMirror = window.CodeMirror || _CodeMirror; // 尝试获取全局实例
let coder = null; // 编辑器实例

export default defineComponent({
  components: { RollbackOutlined, FileOutlined },
  name: "codeEditor",
  props: {
    value: {
      type: String,
      default: "",
    },
    scene: {
      type: String,
      default: "look", // add: 新增； edit: 编辑； look: 查看
    },
    eventType: {
      type: String,
      default: "blur", // 可用事件'change', 'blur'等等；具体参考codemirror文档
    },
    theme: {
      type: String,
      default: "3024-day", // 编辑器主题色
    },
  },
  setup(props, { emit }) {
    const { proxy } = getCurrentInstance();
    const language = ref("java");
    const code = ref("");
    const data = reactive({
      code: props.value, // 内部真实的内容
      // 默认配置
      options: {
        mode: "text/x-java", // 不设置的话，默认使用第一个引用
        // 缩进格式
        tabSize: 2,
        // 主题，对应主题库 JS 需要提前引入
        theme: props.theme,
        // 显示行号
        matchBrackets: true,
        lineNumbers: true,
        readOnly:
          props.scene === "add" || props.scene === "edit" ? false : "nocursor", // true: 不可编辑  false: 可编辑 'nocursor' 失焦,不可编辑
      },
      // 初始化
      initialize: () => {
        // 初始化编辑器实例，传入需要被实例化的文本域对象和默认配置
        coder = CodeMirror.fromTextArea(proxy.$refs.textarea, data.options);
        // 此处也可使用'change'事件，不过每次书写的过程中都会触发，为了提高性能，故默认使用'blur'
        coder.on(props.eventType, (coder) => {
          emit("update:value", coder.getValue());
        });
      },
      // 动态引入语法高亮库
      importThemDynamic: () => {
        return new Promise((resolve) => {
          codemirrorThemList.forEach((value) => {
            if (props.theme === value) {
              import(`codemirror/theme/${props.theme}.css`);
              resolve();
            }
          });
        });
      },
    });
    onMounted(() => {
      // console.log('value:', props.value)
      data.importThemDynamic().then(() => {
        data.initialize();
      });
    });
    onBeforeUnmount(() => {
      coder.off(props.eventType);
    });
    return {
      ...toRefs(data),
      language,
      code,
    };
  },
});
</script>

<style>
.edit_area {
  padding: 0 20px;
}
.edit_bar {
  margin-bottom: 10px;
}
.action_bar {
  margin: 20px 0;
}
.edit_bar .tip {
  float: right;
  line-height: 32px;
  height: 32px;
  color: grey;
  user-select: none;
}
.action_bar .btn_group {
  float: right;
}

.in-coder-panel {
  flex-grow: 1;
  display: flex;
  position: relative;
}
.CodeMirror {
  flex-grow: 1;
  text-align: left !important;
  z-index: 1;
  height: 400px;
}
.CodeMirror-code {
  line-height: 19px;
}
</style>
