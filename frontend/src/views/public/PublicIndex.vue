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
        <div class="u-l">{{item.address}}, {{item.ZIPcode}} {{item.city}}</div>
        <el-button type="primary" @click="toReserve(item)">Choisir</el-button>
      </li>
    </ul>
<!--    <el-button class="show-more" type="primary" size="large" @click="showMore">Afficher plus</el-button>-->
  </div>
</template>

<script setup>
import Search from "@/components/common/Search.vue";
import {reservation} from "@/store/reserve.js";

const store=reservation();
const router=useRouter();

const txt=ref('Dans quelle ville?')
const table=ref('center')

const centerList=[
  {id:'1', name:'CH Nancy', address:'xxxxxxxxx', ZIPcode:'54000', city:'Nancy',},
]

let {centerSelected}=storeToRefs(store);
const toReserve = (item) => {
  centerSelected.value=item;
  router.push({name:"Reserve"});
}
/*const showMore = () => {
  //搜索将所有结果搜出来放到Pinia中，showMore每次多显示2个
}*/
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
  height: 60vh;
  overflow: scroll;
  li{
    position: relative;
    margin: 1vh 5vw;
    border: solid 2px black;
    border-radius: 5px;
    font-size: 22px;
    div{
      margin: .5vh 0 .25vh;
      padding-left: .8vw;
      width: 20vw;
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
