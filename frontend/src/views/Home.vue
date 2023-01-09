<template>
  <div class="container">
    <h1>Merci d'utiliser notre web pour réserver la vaccination</h1>
  </div>
  <div class="search">
    <p><strong>Touver un centre de vaccination</strong></p>
    <div class="search-box">
      <input type="text" placeholder="Dans quelle ville ?">
      <i class="iconfont icon-sousuo"></i>
    </div>
    <ul class="results">
      <li class="u-clearfix">
        <div class="u-l">Nancy - Tour</div>
        <div class="u-l">Adresse</div>
        <el-button type="primary">Choisir</el-button>
      </li>
      <li class="u-clearfix">
        <div class="u-l">Nancy - Tour</div>
        <div class="u-l">Adresse</div>
        <el-button type="primary">Choisir</el-button>
      </li>
      <li class="u-clearfix">
        <div class="u-l">Nancy - Tour</div>
        <div class="u-l">Adresse</div>
        <el-button type="primary">Choisir</el-button>
      </li>
      <li class="u-clearfix">
        <div class="u-l">Nancy - Tour</div>
        <div class="u-l">Adresse</div>
        <el-button type="primary">Choisir</el-button>
      </li>
    </ul>
    <el-button class="show-more" type="primary">Afficher plus</el-button>
  </div>
</template>

<script setup>

</script>

<style scoped lang="scss">
h1{
  margin-top: 100px;
}
.search{
  position: absolute;
  top: 20%;
  left: 50%;
  transform: translateX(-50%);
  width: 40vw;
  background: white;
  font-size: 26px;
  border-radius: 20px;
  p{
    margin: 1.5vh 0;
  }
  .search-box{
    display: inline-block;
    border: solid 2px #ccc;
    margin-bottom: 1vh;
    input{
      padding:.2vh .5vw ;
      width: 12vw;
      font-size: 24px;
      line-height: 24px;
    }
    i{
      padding: .2vh .34vw;
      font-size: 24px;
      font-weight: bold;
      color: dodgerblue;
      cursor: pointer;
    }
  }
}
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
.show-more{
  margin-bottom: 1vh;
  font-size: 20px;
}
</style>
