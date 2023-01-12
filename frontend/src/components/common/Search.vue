<template>
  <div class="search">
    <input type="text" :placeholder="txt">
    <i class="iconfont icon-sousuo"></i>
  </div>
</template>

<script setup>
import { toRefs } from 'vue'
const props=defineProps({
  txt:String,
  table:String
})
let {txt,table}=toRefs(props)
console.log(txt.value)
//Rechercher dans quel tableau
console.log(table.value)
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
