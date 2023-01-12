<template>
  <div class="container"></div>
  <div class="loginInfo">
    <h2 class="title">Log In</h2>
    <el-form
        :model="form"
        label-width="120px"
        size="large"
    >
      <el-form-item label="Email">
        <el-input v-model="form.email" type="text"/>
      </el-form-item>
      <el-form-item label="Mot de passe">
        <el-input v-model="form.password" type="password"/>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="onSubmit">Se connecter</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script setup>
const form = reactive({
  email:'',
  password:''
})

const onSubmit = () => {
  console.log(form)
}
</script>

<style scoped lang="scss">
.container{
  background: url("background2.png") no-repeat;
  background-size: cover;
}
.title{
  margin-bottom: 2.5vh;
  font-size: 32px;
}
.loginInfo{
  position: relative;
  z-index: 9;
  padding: 2.5vw;
  background: white;
  border-radius: 20px;

  .el-form-item--large{
    --font-size: 16px;
  }
  .el-input--large{
    font-size: 20px !important;
  }
  .el-button{
    font-size: 20px;
  }
}
</style>
