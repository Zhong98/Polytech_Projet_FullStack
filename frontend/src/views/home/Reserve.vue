<template>
  <div class="container"></div>
  <div class="reserveInfo">
    <div class="return">
      <el-icon color="black" size="24"><Back /></el-icon>
      <span>Prise de rendez-vous vaccination</span>
    </div>
    <el-form
        :model="form"
        label-width="120px"
        label-position="top"
        size="large"
    >
      <el-form-item label="Centre">
        <el-input v-model="form.center" type="textarea" readonly/>
      </el-form-item>
      <el-form-item label="Prénom">
        <el-input v-model="form.firstname" />
      </el-form-item>
      <el-form-item label="Nom">
        <el-input v-model="form.lastname" />
      </el-form-item>
      <el-form-item label="Date">
        <el-col :span="11">
          <el-date-picker
              v-model="form.date1"
              type="date"
              placeholder="Choisir une date"
              style="width: 100%"
          />
        </el-col>
        <el-col :span="2" class="text-center">
          <span class="text-gray-500">-</span>
        </el-col>
        <el-col :span="11">
          <el-time-picker
              v-model="form.date2"
              placeholder="Choisir une heure"
              style="width: 100%"
              format="HH:mm"
          />
        </el-col>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="onSubmit">Réserver</el-button>
        <el-button>Cancel</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script setup>
import { reactive } from 'vue'

// do not use same name with ref
const form = reactive({
  center: '',
  firstname: '',
  lastname:'',
  date1: '',
  date2: '',
})

const onSubmit = () => {
  console.log('submit!')
}
</script>

<style scoped lang="scss">
.container{
  z-index: 0;
}
.reserveInfo{
  position: relative;
  z-index: 9;
  padding: 4vw;
  background: white;
  border-radius: 20px;
  .el-form{
    font-size: 30px;
    .el-form-item--large{
      --font-size: 22px;
    }
    .el-input--large{
      font-size: 20px !important;
    }
  }
}
</style>
