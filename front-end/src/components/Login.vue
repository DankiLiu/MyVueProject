<template>
  <body id="poster">
    <el-form class="login-container" label-position="left"
             label-width="0px" style="background: burlywood">
      <h3 class="login-title">Welcome to Login Page</h3>
      <el-form-item style="margin: 10px">
        <el-input type="text" v-model="loginForm.username"
                  auto-complete="off" placeholder="Account"></el-input>
      </el-form-item>
      <el-form-item style="margin: 10px">
        <el-input type="password" v-model="loginForm.password"
                  auto-complete="off" placeholder="Password"></el-input>
      </el-form-item>
      <el-form-item style="width: 100%">
        <el-button type="primary" style="width: 100%; background: none; border: #42b983"
                   v-on:click="login">Click to Login</el-button>
      </el-form-item>
    </el-form>
  </body>
</template>

<script>

export default {
  name: 'Login',
  data () {
    return {
      loginForm: {
        username: '',
        password: ''
      },
      responseResult: []
    }
  },
  methods: {
    login () {
      this.$axios
        .post('/login', {
          username: this.loginForm.username,
          password: this.loginForm.password
        })
        .then(successResponse => {
          if (successResponse.data.code === 200) {
            console.log('recieve success code 200')
            this.$store.commit('login', this.loginForm)
            var path = this.$route.query.redirect
            console.log('redirecting')
            this.$router.replace({path: path === '/' || path === undefined ? '/index' : path})
          }
        })
        .catch(failResponse => {
        })
    }
  }
}
</script>

<style>
.login-container {
  border-radius: 15px;
  background-clip: padding-box;
  margin: 90px auto;
  width: 350px;
  padding: 35px 35px 15px 35px;
  background: #fff;
  border: 1px solid #eaeaea;
  box-shadow: 0 0 25px #cac6c6;
}

.login_title {
  margin: 0px auto 40px auto;
  text-align: center;
  color: #505458;
}

#poster {
  background:url("../assets/natsume.jpg") no-repeat;
  background-position: center;
  height: 100%;
  width: 100%;
  background-size: cover;
  position: fixed;
}
body{
  margin: 0px;
}
</style>
