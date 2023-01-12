<template>
  <div class="Center-container">
    <el-form :model="form" label-width="120px" size="large" label-position="top">
      <el-form-item label="Nom">
        <el-input v-model="form.name" />
      </el-form-item>
      <el-form-item label="Adresse">
        <el-input v-model="form.address" />
      </el-form-item>
      <el-form-item label="Code Postal">
        <el-col :span="11">
          <el-input v-model="form.ZIPcode" />
        </el-col>
      </el-form-item>
      <el-form-item label="Ville">
        <el-col :span="11">
          <el-input v-model="form.city" />
        </el-col>
      </el-form-item>

      <el-form-item>
        <el-button type="primary" @click="onSubmit">Mettre à jour</el-button>
        <el-button @click="onCancel">Annuler</el-button>
      </el-form-item>
      <el-form-item>
        <i class="iconfont icon-renyuan"></i>
      </el-form-item>
    </el-form>
  </div>
</template>

<script setup>
import {backOfficeMenu} from "@/store/backOfficeMenu.js";
import {ElMessageBox} from "element-plus";

const router=useRouter();
const store=backOfficeMenu();
let {center}=store;

const form = reactive({
  name: center.name||'',
  address:center.address||'',
  ZIPcode:center.ZIPcode||'',
  city:center.city||''
})

const onSubmit = () => {
  console.log(form)
}
const onCancel = () => {
  ElMessageBox.confirm(
      'Voulez-vous vraiment annuler ces modifications?',
      'Attention',
      {
        confirmButtonText: 'Oui',
        cancelButtonText: 'Non',
        type: 'warning',
      }
  ).then(() => {router.back();})
}
</script>

<style scoped>
.Center-container{
  padding: 10vh 20vw;
}
.el-form-item--large{
  --font-size: 24px;
}
.el-input--large{
  font-size: 22px;
}
.el-button{
  font-size: 20px;
}
i{
  font-size: 36px;
  cursor: pointer;
}
</style>
