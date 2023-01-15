<template>
  <div class="search">
    <input type="text" :placeholder="txt" @keydown.enter="search" v-model="inputInfo">
    <i class="iconfont icon-sousuo" @click="search"></i>
  </div>
</template>

<script setup>
import {getCenterList} from "@/utils/center/getCenterList.js";
import {reservation} from "@/store/reserve.js";
import {backOfficeMenu} from "@/store/backOfficeMenu.js";
import {getPatient} from "@/utils/rdv/getPatient.js";

const store=reservation();
let {centerList}=storeToRefs(store)

const backOffice=backOfficeMenu();
let {tableData,center,patientData}=storeToRefs(backOffice);

const props=defineProps({
  txt:String,
  table:String,
  date:{
    required:false
  }
})
let inputInfo=ref('');
let {txt,table,date}=toRefs(props)

const search = () => {
  console.log(table.value)
  if (table.value==='center'){
    getCenterList(inputInfo.value).then(res=>{
      centerList.value=res;
      tableData.value=res;
    })
  }else {
    getPatient(date.value,center.value.id,inputInfo.value).then(res=>{
      patientData.value=res;
    })
  }
}
</script>

<style scoped lang="scss">
.search{
  position: relative;
  padding: .2vh 0;
  margin-bottom: 2vh;
  width: 40vw;
  height: 2.5vh;
  display: inline-block;
  border: solid 2px #ccc;
  border-radius: 10px;
  line-height: 2vh;
  input{
    position: absolute;
    left: .5vw;
    height: 80%;
    width: 85%;
    font-size: 28px;
  }
  i{
    position: absolute;
    top: 50%;
    right: .5vw;
    transform: translateY(-50%);
    font-size: 30px;
    color: blue;
    cursor: pointer;
  }
}
</style>
