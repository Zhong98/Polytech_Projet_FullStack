<template>
  <div class="reserveInfo">
    <el-form
        :model="form"
        label-width="120px"
        label-position="top"
        size="large"
    >
      <el-form-item label="Centre">
        <el-input :value="centerInfo" type="textarea" readonly/>
      </el-form-item>
      <el-form-item label="Prénom">
        <el-input v-model="form.firstname" />
      </el-form-item>
      <el-form-item label="Nom">
        <el-input v-model="form.lastname" />
      </el-form-item>
      <el-form-item label="Email">
        <el-input v-model="form.email" />
      </el-form-item>
      <el-form-item label="Date">
        <el-col :span="11">
          <el-date-picker
              v-model="form.date"
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
              v-model="form.hour"
              placeholder="Choisir une heure"
              style="width: 100%"
              format="HH:mm"
          />
        </el-col>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="onSubmit(form)">Confirmer</el-button>
        <el-button @click="onCancel">Annuler</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script setup>
import { ElMessageBox } from 'element-plus'
import { SuccessFilled } from '@element-plus/icons-vue'
import {backOfficeMenu} from "@/store/backOfficeMenu.js";
import {updateRdv} from "@/utils/rdv/updateRdv.js";

const store=backOfficeMenu();
let {center,reservation}=store;
const router=useRouter();
const route=useRoute();
const action=route.query.action;

const centerInfo=center.name+', '+center.address+'; '+center.ZIPcode+' '+center.city;
const form = reactive({
  firstname: reservation.firstname||'',
  lastname:reservation.lastname||'',
  email:reservation.email||'',
  date: '',
  hour: '',
})

const onSubmit = () => {
  let reservationSent={
    centerID:center.id+'',
    firstname:form.firstname,
    lastname:form.lastname,
    email:form.email,
    date: form.date.getDate()+'/'+(form.date.getMonth()+1)+'/'+form.date.getFullYear(),
    hour: form.hour.getHours()+':'+form.hour.getMinutes(),
    status:0
  }
  if (action!='add'){
    reservationSent.id=reservation.id;
  }
  updateRdv(reservationSent).then(res=>{
    if (res==200){
      ElMessageBox.alert(
          'La réservation a bien été enregistrée',
          {
            confirmButtonText: 'OK',
            type: 'success',
            icon: markRaw(SuccessFilled),
          }
      )
    }
  })
}
const onCancel = () => {
  ElMessageBox.confirm(
      'Voulez-vous vraiment annuler ces modifications?',
      'Attention',
      {
        confirmButtonText: 'Oui',
        cancelButtonText: 'Non',
        type: 'warning',
      }
  )
      .then(() => {
        router.back();
      })
}
</script>

<style scoped lang="scss">
.return{
  padding: .2vh 0;
  margin-bottom: 1vh;
  font-size: 24px;
  text-align: left;
  line-height: 24px;
  cursor: pointer;
  i{
    font-size: 24px;
  }
  span{
    margin-left: .5vw;
  }
}
.reserveInfo{
  position: relative;
  z-index: 9;
  padding: 4vw;
  width: 28vw;
  background: white;
  border-radius: 20px;

  .el-form-item--large{
    --font-size: 22px;
  }
  .el-input--large{
    font-size: 20px !important;
  }
  .el-button{
    font-size: 20px;
  }
}
</style>
