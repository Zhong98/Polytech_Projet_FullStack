<template>
  <div class="Center-container">
    <el-form :model="form" label-width="120px" size="large" label-position="top">
      <el-form-item label="Nom">
        <el-input v-model="form.name"/>
      </el-form-item>
      <el-form-item label="Adresse">
        <el-input v-model="form.address"/>
      </el-form-item>
      <el-form-item label="Code Postal">
        <el-col :span="11">
          <el-input v-model="form.zipcode"/>
        </el-col>
      </el-form-item>
      <el-form-item label="Ville">
        <el-col :span="11">
          <el-input v-model="form.city"/>
        </el-col>
      </el-form-item>

      <el-form-item>
        <el-button type="primary" @click="onSubmit">Mettre à jour</el-button>
        <el-button @click="onCancel">Annuler</el-button>
      </el-form-item>
      <el-form-item>
        <i class="iconfont icon-renyuan" @click="showCenter"></i>
      </el-form-item>
    </el-form>
  </div>
</template>

<script setup>
import {backOfficeMenu} from "@/store/backOfficeMenu.js";
import {ElMessage, ElMessageBox} from "element-plus";
import {addCenter} from "@/utils/center/addCenter";
import {updateCenter} from "@/utils/center/updateCenter.js";
import {SuccessFilled, WarningFilled} from "@element-plus/icons-vue";

const router = useRouter();
const route = useRoute();
const action = route.query.action;

const store = backOfficeMenu();
let {center} = store;
const form = reactive({
  name: center.name || '',
  address: center.address || '',
  zipcode: center.zipcode || '',
  city: center.city || ''
})

const onSubmit = () => {
  if (action === 'add') {
    addCenter(form).then(res => {
      if (res == 200) {
        ElMessageBox.alert(
            'Ajouter réussi',
            {
              confirmButtonText: 'OK',
              type: 'success',
              icon: markRaw(SuccessFilled),
            }
        )
      } else {
        ElMessageBox.alert(
            'Erreur se produit',
            {
              confirmButtonText: 'OK',
              type: 'error',
              icon: markRaw(WarningFilled),
            }
        )
      }
    })
  } else {
    form.id = center.id;
    updateCenter(form).then(res => {
      if (res == 200) {
        ElMessageBox.alert(
            'Modifier réussi',
            {
              confirmButtonText: 'OK',
              type: 'success',
              icon: markRaw(SuccessFilled),
            }
        )
      } else {
        ElMessageBox.alert(
            'Erreur se produit',
            {
              confirmButtonText: 'OK',
              type: 'error',
              icon: markRaw(WarningFilled),
            }
        )
      }
    })
  }
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
  ).then(() => {
    router.back();
  })
}
const showCenter = () => {
  if (center.id){
    router.push({name: 'MyCenter'})
  }else {
    ElMessage({
      type: 'warning',
      message: 'Pas de centre',
    })
  }
}
</script>

<style scoped>
.Center-container {
  padding: 10vh 20vw;
}

.el-form-item--large {
  --font-size: 24px;
}

.el-input--large {
  font-size: 22px;
}

.el-button {
  font-size: 20px;
}

i {
  font-size: 36px;
  cursor: pointer;
}
</style>
