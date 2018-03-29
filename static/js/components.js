
Vue.component('my-header', {
  props: ['userinfo'],
  template: `<div id="header" class="ui fixed inverted menu">
<div class="ui container">
    <a href="/" class="header item">
        <!-- <img class="logo" src="logo.png"> -->
        HSHE Project
    </a>

    <a href="/topic" class="item">作业</a>
    <a href="/problem" class="item">题目</a>
    <a href="/submission" class="item">提交</a>
    <div class="ui simple dropdown item">
        帮助
        <i class="dropdown icon"></i>
        <div class="menu">
            <a class="item" href="#">API文档</a>
            <div class="divider"></div>
            <div class="header">How to use</div>
     
            <a class="item" href="#">使用指南</a>
            <a class="item" href="#">常见错误</a>
        </div>
    </div>

    <a href="#" class="item right">
        <i class="user icon"></i>
        <span v-if="userinfo.user_nick==null">{{userinfo.user_id}}</span>
        <span v-if="userinfo.user_nick!=null">{{userinfo.user_nick}}</span>
    </a>
    <a class="item" v-on:click="logout" > 退出 </a>
    <button class="tiny ui inverted blue basic button" v-if="userinfo.user_role==1" v-on:click="goMaster"  style="margin: 4px" > 管理后台 </button>
</div>
</div>
`,
methods: {
    logout: function (event) {
        window.localStorage.clear()
        window.location.href = '/login'
      },
      goMaster: function () {
        window.location.href = '/master'
      // window.open("/master")
      }
}
})



Vue.component('my-footer', {
    template: `<div class="ui  vertical footer segment">
    <div class="ui center aligned container">

        <div class="ui  section divider"></div>
        <img src="/img/logo.png" class="ui centered mini image" />
        <div class="ui horizontal  small divided link list">
            <a class="item" href="#">Site Map</a>
            <a class="item" href="#">Contact Us</a>
            <a class="item" href="#">Terms and Conditions</a>
            <a class="item" href="#">Copyright © 2018 HSHE</a>
        </div>
    </div>
</div>`
})

Vue.component('auth-modal', {
    template: `<div class="ui basic modal">
    <div class="ui icon header">
      <i class="user circle icon"></i>
      <span id="modalmsg"></span>
    </div>
    <div class="content">
      <p style="font-size:1.5em">不好意思，必须通过身份认证才可以继续使用本系统。即将自动跳转到登录页面...</p>
    </div>
    <div class="actions">
      <div class="ui green ok inverted button" onclick="javascript:window.location.href='/login'">
        <i class="checkmark icon"></i>
        前往登录
      </div>
    </div>
  </div>`
})


Vue.component('view-loader', {
    template: ` <div id="viewloader" class="ui active centered inline loader"></div>`
})

Vue.component('view-404', {
    template: ` <div class="ui two column grid">
    <div class="column">
        <img style="float:right;" src="/img/404_face.png" width="250px" alt="404 not found" />
    </div>
    <div class="column">
        <h2>
            <strong>Page Not Found!</strong>
        </h2>
        <p>Sorry, but we can't find the page you are looking for...</p>
        <br/>
        <button class="ui primary basic button" v-on:click='goHome'>回到首页</button>
    </div>
</div>`,
methods: {
    goHome: function(){
        window.location.href='/'
    }
}
})



Vue.component('my-pager', {
    template: `<div class="ui  pagination menu">
    <a class="icon item">
      <i class="left chevron icon"></i>
    </a>
    <a class="item">1</a>
    <a class="item">2</a>
    <a class="item">3</a>
    <a class="item">4</a>
    <a class="icon item">
      <i class="right chevron icon"></i>
    </a>
  </div>`
})