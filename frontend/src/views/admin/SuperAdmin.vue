<template>
  <ul>
    <li>
      <div class="title">
        <span><strong>Super Admin</strong></span>
        <i class="iconfont icon-icon_tianjia" @click="onAdd"></i>
      </div>
      <el-table
          :data="superAdminData"
          height="23vh"
          style="width: 100%"
          stripe
          border
          size="large"
      >
        <el-table-column prop="id" label="ID" width="120"/>
        <el-table-column prop="firstname" label="Prénom" width="140"/>
        <el-table-column prop="lastname" label="Nom" width="140"/>
        <el-table-column prop="email" label="Email" width="400"/>
        <el-table-column prop="password" label="Mot de passe"/>
        <el-table-column label="Actions" width="180" align="center">
          <template #default="scope">
            <i class="iconfont icon-xiugai" @click="onModify(scope.row)"></i>
            <i class="iconfont icon-shanchu" @click="onDelete(scope.row)"></i>
          </template>
        </el-table-column>
      </el-table>
    </li>
    <li>
      <div class="title">
        <span><strong>Administrateur</strong></span>
        <i class="iconfont icon-icon_tianjia" @click="onAdd"></i>
      </div>
      <el-table
          :data="adminData"
          height="23vh"
          style="width: 100%"
          stripe
          border
          size="large"
      >
        <el-table-column prop="id" label="ID" width="120"/>
        <el-table-column prop="firstname" label="Prénom" width="140"/>
        <el-table-column prop="lastname" label="Nom" width="140"/>
        <el-table-column prop="email" label="Email" width="400"/>
        <el-table-column prop="password" label="Mot de passe" width="400"/>
        <el-table-column prop="center" label="Centre"/>
        <el-table-column label="Actions" width="180" align="center">
          <template #default="scope">
            <i class="iconfont icon-xiugai" @click="onModify(scope.row)"></i>
            <i class="iconfont icon-shanchu" @click="onDelete(scope.row)"></i>
          </template>
        </el-table-column>
      </el-table>
    </li>
  </ul>
</template>

<script setup>
import {ElMessage, ElMessageBox} from "element-plus";
import {backOfficeMenu} from "@/store/backOfficeMenu.js";
import {storeToRefs} from "pinia";
const store=backOfficeMenu();
let {person}=storeToRefs(store);
const router=useRouter();

let superAdminData = [
  {id: '1', firstname: 'Zixiao',lastname:'Zhong',email:'980819213zzx@gmail.com',password:'111111111111111111'},
]
let adminData = [
  {id: '1', firstname: 'Zixiao',lastname:'Zhong',email:'980819213zzx@gmail.com',password:'111111111111111111', center: 'Nancy CH'},
]

const onAdd = () => {
  person.value={};
  router.push({name:'PersonModify'});
}
const onModify = (row) => {
  person.value=row;
  router.push({name:'PersonModify'});
}
const onDelete = (row) => {
  ElMessageBox.confirm(
      'Êtes-vous sûr de supprimer cette donnée?',
      'Warning',
      {
        confirmButtonText: 'Confirmer',
        cancelButtonText: 'Annuler',
        type: 'warning',
      }
  )
      .then(() => {
        ElMessage({
          type: 'success',
          message: 'Suppression terminée',
        })
      })
      .catch(() => {
        ElMessage({
          type: 'info',
          message: 'Suppression annulée',
        })
      })
}
</script>

<style scoped lang="scss">
li {
  margin: 2vh 0;

  .title {
    position: relative;
    margin: 2vh 0;
    font-size: 30px;

    i {
      position: absolute;
      right: 5vw;
    }
  }

  .el-table--large {
    font-size: 20px;
  }
}

i {
  font-size: 22px;
  color: blue;
  cursor: pointer;
}

i + i {
  margin-left: 20px;
  color: red;
}
</style>
