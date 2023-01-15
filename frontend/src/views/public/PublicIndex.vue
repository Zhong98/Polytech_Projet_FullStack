<template>
  <div class="container">
    <h1>Merci d'utiliser notre web pour réserver la vaccination</h1>
  </div>
  <div class="g-container">
    <p><strong>Touver un centre de vaccination</strong></p>
    <Search :txt="txt" :table="table"></Search>
    <ul class="results">
      <li v-for="(item,index) in centerList"
          :key="index"
          class="u-clearfix">
        <div class="u-l">{{item.name}}</div>
        <div class="u-l" v-if="item.address">{{item.address}}</div>
        <div class="u-l">{{item.zipcode}} {{item.city}}</div>
        <el-button type="primary" @click="toReserve(item)">Choisir</el-button>
      </li>
    </ul>
  </div>
</template>

<script setup>
import Search from "@/components/common/Search.vue";
import {reservation} from "@/store/reserve.js";

const store=reservation();
const router=useRouter();
let {centerSelected,centerList}=storeToRefs(store);

const txt=ref('Dans quelle ville?')
const table=ref('center')
const toReserve = (item) => {
  centerSelected.value=item;
  router.push({name:"Reserve"});
}
</script>

<style scoped lang="scss">
::v-deep(.search){
  width: 22vw;
}
h1{
  margin-top: 100px;
}
.g-container{
  position: absolute;
  top: 20%;
  left: 50%;
  transform: translateX(-50%);
  width: 40vw;
  background: white;
  font-size: 28px;
  border-radius: 20px;
  p{
    margin: 1.5vh 0;
  }
}
::-webkit-scrollbar {
  display: none;
}
.results{
  margin-bottom: 2vh;
  height: 60vh;
  overflow: scroll;
  li{
    position: relative;
    margin: 1vh 5vw;
    height: 7.7vh;
    border: solid 2px black;
    border-radius: 5px;
    font-size: 22px;
    overflow: scroll;
    div{
      margin: .5vh 0 .25vh;
      padding-left: .8vw;
      width: 22vw;
      text-align: left;
    }
    .el-button{
      position: absolute;
      top: 50%;
      right: 4%;
      transform: translateY(-50%);
      font-size: 20px;
    }
  }
}

.show-more{
  margin: 2vh 0;
  font-size: 20px;
}
</style>
