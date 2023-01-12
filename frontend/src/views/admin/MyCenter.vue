<template>
  <div>
    <input class="centerInfo" type="text" readonly :value="center">
  </div>
  <ul>
    <li>
      <div class="title">
        <span><strong>Médecins</strong></span>
        <i class="iconfont icon-icon_tianjia" @click="onAddDoctor"></i>
      </div>
      <el-table
          :data="doctorData"
          height="23vh"
          style="width: 100%"
          stripe
          border
          size="large"
      >
        <el-table-column prop="id" label="ID" width="120"/>
        <el-table-column prop="firstname" label="Prénom" width="110"/>
        <el-table-column prop="lastname" label="Nom" width="110"/>
        <el-table-column prop="email" label="Email" width="360"/>
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
        <span><strong>Réservation</strong></span>
        <i class="iconfont icon-icon_tianjia" @click="onAddReservation"></i>
      </div>
      <el-table
          :data="reserveData"
          height="23vh"
          style="width: 100%"
          stripe
          border
          size="large"
      >
        <el-table-column prop="id" label="ID" width="120"/>
        <el-table-column prop="firstname" label="Prénom" width="110"/>
        <el-table-column prop="lastname" label="Nom" width="110"/>
        <el-table-column prop="date" label="Date" width="180"/>
        <el-table-column prop="hour" label="Heure" width="140"/>
        <el-table-column prop="email" label="Email"/>
        <el-table-column label="Validé" width="160" align="center">
          <template #default="scope">
            <el-icon v-if="scope.row.sta=='1'" style="color: green"><Select /></el-icon>
            <el-icon v-else style="color: red"><CloseBold /></el-icon>
          </template>
        </el-table-column>
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
import {CloseBold} from "@element-plus/icons-vue";
import {Select} from "@element-plus/icons-vue";
import {ElMessage, ElMessageBox} from 'element-plus'
import {backOfficeMenu} from "@/store/backOfficeMenu.js";

const router=useRouter();
const store=backOfficeMenu();
let {center,person,reservation}=storeToRefs(store);
const centerInfo = center.name+', '+center.address+'; '+center.ZIPcode+' '+center.city;

const doctorData = [
  {id: '1', firstname: 'Tom', lastname: 'Clancy',email:'980819213zzx@gmail.com',password:'1111111111111'},
  {id: '2', firstname: 'Tom', lastname: 'Clancy',email:'980819213zzx@gmail.com',password:'2222222222222'},
  {id: '3', firstname: 'Tom', lastname: 'Clancy',email:'980819213zzx@gmail.com',password:'3333333333333'},
]
const reserveData = [
  {id: '1', firstname: 'Tom', lastname: 'Clancy',date:'11/01/2023',hour:'15:40',email:'980819213zzx@gmail.com',sta:'0'},
  {id: '2', firstname: 'Tom', lastname: 'Clancy',date:'11/01/2023',hour:'16:20',email:'980819213zzx@gmail.com',sta:'1'},
  {id: '3', firstname: 'Tom', lastname: 'Clancy',date:'11/01/2023',hour:'13:10',email:'980819213zzx@gmail.com',sta:'0'},
]

const onAddDoctor = () => {
  person.value={};
  router.push({name:'PersonModify'});
}
const onAddReservation = () => {
  reservation.value={};
  router.push({name:'AdminReserve'});
}
const onModify = (row) => {
  if (row.date){
    reservation.value=row;
    router.push({name:'AdminReserve'});
  }else {
    person.value=row;
    router.push({name:'PersonModify'});
  }
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
        //Delete的http请求

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
.el-table--large {
  font-size: 20px;
}
.title {
  position: relative;
  margin: 2vh 0;
  font-size: 30px;

  i {
    position: absolute;
    right: 5vw;
  }
}

.centerInfo {
  margin-bottom: 2vh;
  padding: 0 1vw;
  width: 80vw;
  height: 80px;
  border: solid 2px #ccc;
  border-radius: 15px;
  font-size: 30px;
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
