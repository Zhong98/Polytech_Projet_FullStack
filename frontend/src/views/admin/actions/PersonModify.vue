<template>
  <div class="g-container">
    <el-form :model="form" label-width="120px" label-position="top" size="large">
      <el-form-item label="Prénom et Nom">
        <el-col :span="11">
          <el-input v-model="form.firstname" placeholder="Prénom"/>
        </el-col>
        <el-col :span="2" class="text-center">
          <span class="text-gray-500">-</span>
        </el-col>
        <el-col :span="11">
          <el-input v-model="form.lastname" placeholder="Nom"/>
        </el-col>
      </el-form-item>
      <el-form-item label="Email">
        <el-input v-model="form.email"/>
      </el-form-item>
      <el-form-item label="Mot de passe">
        <el-input v-model="form.password"/>
      </el-form-item>
      <el-form-item label="Role">
        <el-select v-model="form.role" placeholder="Merci de sectionner le role">
          <el-option v-if="isDisable" label="Super Admin" value="0"/>
          <el-option v-if="isDisable" label="Administrateur" value="1"/>
          <el-option label="Médecin" value="2"/>
        </el-select>
      </el-form-item>

      <el-form-item label="Centre de rattachement (Centre ID)">
        <el-input v-model="form.centerID" :disabled="!isDisable"/>
      </el-form-item>

      <el-form-item>
        <el-button type="primary" @click="onSave">Enregistrer</el-button>
        <el-button @click="onCancel">Annuler</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script setup>
import {ElMessage, ElMessageBox} from 'element-plus'
import {backOfficeMenu} from "@/store/backOfficeMenu";
import {updatePerson} from "@/utils/people/updatePerson.js";

const router = useRouter();
const route = useRoute();
const action = route.query.action;

const store = backOfficeMenu();
let {pageIndex, person, center} = store;
let isDisable = pageIndex == '4' //Juste Super Admin peut choisir administrateur et super admin, pour Centre de rattachement aussi

const form = reactive({
  firstname: person.firstname || '',
  lastname: person.lastname || '',
  email: person.email || '',
  password: person.password || '',
  role: '',
  centerID: center.id || ''
})

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

const onSave = () => {
  ElMessageBox.confirm(
      'Voulez-vous vraiment enregistrer ces modifications?',
      'Attention',
      {
        confirmButtonText: 'Oui',
        cancelButtonText: 'Non',
        type: 'warning',
      }
  )
      .then(() => {
        console.log(action);
        if (action!='add'){
          form.id=person.id;
        }
        console.log(form);
        updatePerson(form).then(res => {
          if (res == 200) {
            ElMessage({
              type: 'success',
              message: 'Sauvegarde terminée',
            })
          }
        })
      })
      .catch(() => {
        ElMessage({
          type: 'info',
          message: 'Sauvegarde annulée',
        })
      })
}
</script>


<style scoped lang="scss">
.g-container {
  padding: 2vw;
}

.el-form-item--large {
  --font-size: 20px;
}

.el-input--large {
  font-size: 20px;
}

.el-button {
  font-size: 20px;
}
</style>
