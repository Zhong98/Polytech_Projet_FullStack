<template>
  <Search :txt="txt" :table="table"></Search>
  <el-button type="primary" size="large" @click="addCenter">Nouveau</el-button>
  <el-table
      :data="tableData"
      height="80vh"
      style="width: 100%"
      size="large"
      border
      stripe
      lazy
  >
    <el-table-column prop="id" label="ID" width="90"/>
    <el-table-column prop="name" label="Nom" width="520" />
    <el-table-column prop="zipcode" label="Code Postal" width="180" />
    <el-table-column prop="city" label="Ville" width="240" />
    <el-table-column prop="address" label="Adresse" />
    <el-table-column label="Actions" width="160" align="center">
      <template #default="scope">
        <i class="iconfont icon-xiugai" @click="modifyCenter(scope.row)"></i>
        <i class="iconfont icon-renyuan" @click="showCenter(scope.row)"></i>
      </template>
    </el-table-column>
  </el-table>
</template>

<script setup>
import Search from '@/components/common/Search.vue'
import {backOfficeMenu} from "@/store/backOfficeMenu.js";
import {getCenterList} from "@/utils/center/getCenterList.js";

const store=backOfficeMenu();
let {center,tableData}=storeToRefs(store);
const router=useRouter();
const txt=ref('Filtrer');
const table=ref('center');

getCenterList().then(res=>{
  console.log(res)
  tableData.value=res;
})

const addCenter = () => {
  center.value={};
  router.push({
    name:'CenterModify',
    query:{
      action:'add' //Savoir l'action, ajouter ou modifier
    }
  })
}
const modifyCenter = (row) => {
  center.value=row;
  router.push({
    name:'CenterModify',
    query:{
      action:'modify'
    }
  })
}
const showCenter = (row) => {
  center.value=row;
  router.push({name:'MyCenter'})
}
</script>

<style scoped lang="scss">
.el-button{
  position: absolute;
  top: 20px;
  margin-left: 2vw;
  font-size: 20px;
}
.el-table--large{
  font-size: 20px;
}
i{
  font-size: 24px;
  color: blue;
  cursor: pointer;
}
i+i{
  margin-left: 20px;
  color: black;
}
</style>
