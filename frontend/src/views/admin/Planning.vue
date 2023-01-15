<template>
  <div>
    <input class="centerInfo" type="text" readonly :value="centerInfo">
  </div>
  <div class="date">
    <el-calendar v-model="value" @click="onChange(value)"/>
  </div>
  <Search :txt="txt" :table="table" :date="date"></Search>
  <h2>Réservation du {{date}}</h2>
  <div class="patientList">
    <el-table
        :data="patientData"
        height="40vh"
        style="width: 100%"
        stripe
        @cell-click="handleCellClick"
        size="large"
    >
      <el-table-column prop="firstname" label="Prénom" align="center"/>
      <el-table-column prop="lastname" label="Nom" align="center"/>
      <el-table-column label="Etat"  align="center">
        <template #default="scope">
          <i v-if="scope.row.status" class="iconfont icon-gou"></i>
          <el-button type="primary" round v-else>Valider</el-button>
        </template>
      </el-table-column>
    </el-table>
  </div>
</template>

<script setup>
import Search from '@/components/common/Search.vue'
import {backOfficeMenu} from "@/store/backOfficeMenu.js";
import {getRdvByDate} from "@/utils/rdv/getRdvByDate.js";
import {updateRdv} from "@/utils/rdv/updateRdv.js";
import {ElMessage} from "element-plus";
const store=backOfficeMenu();
const txt = ref('Patient');
const table=ref('Reservation')

let {center,patientData}=storeToRefs(store);
const centerInfo=center.value.name+', '+center.value.address+'; '+center.value.zipcode+' '+center.value.city;

let today=new Date();
const value = ref(today);
let date=ref(today.getDate()+'/'+(today.getMonth()+1)+'/'+today.getFullYear());

getRdvByDate(date.value,center.value.id).then(res=>{
      patientData.value=res;
    }
)

const onChange=(value)=>{
  date.value=value.getDate()+'/'+(value.getMonth()+1)+'/'+value.getFullYear()
  //发送http请求,更新patientData
  getRdvByDate(date.value,center.value.id).then(res=>{
        patientData.value=res;
      }
  )
}

const handleCellClick = (row) => { //Get the row clicked
  row.status=1;
  console.log(row);
  //send http request, update status
  updateRdv(row).then(res=>{
    if (res==200){
      ElMessage({
        type: 'success',
        message: 'RDV validé',
      })
    }
  })
}
</script>

<style scoped lang="scss">
.centerInfo {
  margin-bottom: 2vh;
  padding: 0 1vw;
  width: 80vw;
  height: 80px;
  border: solid 2px #ccc;
  border-radius: 15px;
  font-size: 30px;
}

.el-calendar{
  --el-calendar-cell-width:100%;
}

h2{
  margin-bottom: 2vh;
}
.patientList{
  padding: 0 5vw;
}
.el-table-column{
  width: 50vw;
}
i{
  font-size: 22px;
  color: green;
}
.el-table--large{
  font-size: 20px;
}
.el-button{
  font-size: 20px;
}
</style>
