<template>
  <div class="footer">
    <a-space>
      <img class="logo" alt="logo" src="../../assets/hshe.png" />
      <div class="text">
        <div class="single_line">HSHE project © 2017-2022</div>
        <div class="single_line" style="color: #afafaf">
          &lt;Do have faith in what you're doing/&gt;
        </div>
      </div>
    </a-space>
  </div>
</template>

<style scoped>
.footer {
  position: fixed;
  align-items: center;
  text-align: center;
  bottom: 0;
  z-index: 9999;
  padding: 15px 200px 15px 0;
  width: 100%;
  user-select: none;
}
.text .single_line {
  height: 18px;
  line-height: 20px;
  text-align: left;
}

.logo {
  width: 36px;
  height: 36px;
}
</style>
