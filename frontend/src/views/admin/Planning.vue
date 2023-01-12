<template>
  <div>
    <input class="centerInfo" type="text" readonly :value="center">
  </div>
  <div class="date">
    <el-calendar v-model="value" @click="onChange(value)"/>
  </div>
  <Search :txt="txt" :table="table"></Search>
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
      <el-table-column prop="name" label="Name" align="center"/>
      <el-table-column label="Etat"  align="center">
        <template #default="scope">
          <i v-if="scope.row.sta" class="iconfont icon-gou"></i>
          <el-button type="primary" round v-else>Valider</el-button>
        </template>
      </el-table-column>
    </el-table>
  </div>
</template>

<script setup>
import Search from '@/components/common/Search.vue'

const center='Nancy CH'

let today=new Date();
const value = ref(today);
let date=ref(today.getDate()+'/'+(today.getMonth()+1)+'/'+today.getFullYear());

const txt = ref('Patient');
const table=ref('Reservation')
const onChange=(value)=>{
  date.value=value.getDate()+'/'+(value.getMonth()+1)+'/'+value.getFullYear()
  //发送http请求,更新patientData

}

const patientData = [
  {name: 'Tom', sta: 1}, //1 est validé, 0 pas encore
  {name: 'Tom', sta: 0},
]

const handleCellClick = (row) => { //Get the row clicked
  row.sta=1;
  //send http request, update status

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
