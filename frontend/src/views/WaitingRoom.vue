<template>
  <el-result title="Merci d'attendre,trop de demandes maintenant">
    <template #icon>
      <el-image
          src="/public/waiting.jpg"
      />
    </template>
    <template #extra>
      <el-button type="primary" @click="goHomePage" size="large">Back</el-button>
    </template>
  </el-result>
</template>

<script setup>
const router=useRouter();
const goHomePage = () => {
  router.back();
}
</script>

<style scoped>
.el-result{
  --el-result-title-font-size:40px;
}
</style>
