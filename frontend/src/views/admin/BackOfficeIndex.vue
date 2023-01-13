<template>
  <div class="common-layout">
    <el-container class="main-container">
      <el-header height="6vh">
        <h2>Bienvenu chez back office</h2>
      </el-header>
      <el-container>
        <el-aside width="10vw">
          <el-row class="tac">
            <el-col>
              <el-menu
                  active-text-color="#ffd04b"
                  background-color="#545c64"
                  class="el-menu-vertical-demo"
                  text-color="#fff"
                  @select="selectMenu"
              >
                <el-menu-item index="1">
                  <span>Centres</span>
                </el-menu-item>
                <el-menu-item index="2">
                  <span>Mon centre</span>
                </el-menu-item>
<!--                <el-menu-item index="3" disabled>-->
                <el-menu-item index="3">
                  <span>Planning</span>
                </el-menu-item>
                <el-menu-item index="4">
                  <span>Config.</span>
                </el-menu-item>
              </el-menu>
            </el-col>
          </el-row>
          <el-button type="primary" round size="large" @click="logout">Déconnexion</el-button>
        </el-aside>
        <el-main>
          <router-view></router-view>
        </el-main>
      </el-container>
    </el-container>
  </div>
</template>

<script setup>
import {backOfficeMenu} from "@/store/backOfficeMenu";
import {storeToRefs} from "pinia";

const store=backOfficeMenu();
let {pageIndex}=storeToRefs(store)
const router=useRouter();
const selectMenu = (index) => {
  //Savoir utilisateur cliquer quel item
  pageIndex.value=index;
  if (index==1) router.push({name: 'CenterList'});
  else if (index==2) router.push({name: 'MyCenter'});
  else if (index==3) router.push({name: 'Planning'});
  else router.push({name: 'SuperAdmin'});
}
const logout = () => {
  router.push('/admin');
}
</script>

<style scoped lang="scss">
.common-layout {
  position: absolute;
  top: 0;
  left: 0;
  bottom: 0;
  right: 0;
  .el-container {
    height: 100%;
  }
}

.el-header {
  background: #293150;
  h2 {
    height: 100%;
    font-size: 36px;
    line-height: 6vh;
    color: white;
  }
}

.el-aside{
  position: relative;
  .el-button{
    position: absolute;
    bottom: 4%;
    left: 50%;
    transform: translateX(-50%);
    width: 8.2vw;
    font-size: 20px;
  }
}
.tac{
  height: 100%;
  .el-menu{
    height: 100%;
    padding-top: 3vh;
    .el-menu-item{
      height: 7vh;
    }
    .el-menu-item+.el-menu-item{
      margin-top: 3vh;
    }
    span{
      font-size: 22px;
    }
  }
}
.el-main{
  position: relative;
}
</style>
