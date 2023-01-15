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
import {checkAuth} from "@/utils/checkAuth.js";
import {backOfficeMenu} from "@/store/backOfficeMenu.js";
import {ElMessage} from "element-plus";

const router=useRouter();
const store=backOfficeMenu();
let {userInfo,token,center}=storeToRefs(store);

const form = reactive({
  email:'',
  password:''
})
const onSubmit = () => {
  checkAuth(form.email,form.password).then(res=>{
    if (res=='0'){
      localStorage.removeItem('token');
      ElMessage.error("Email ou mot de passe n'est pas correct.")
    }else if (res=='Too many request'){
      router.push({name:'Wait'});
    } else{
      center.value=res.center;
      userInfo.value=res.person;
      token.value=res.token;
      router.push({name:'Default'});
    }
  })
}
</script>

<style scoped lang="scss">
.container{
  background: url("../../../public/background2.png") no-repeat;
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
