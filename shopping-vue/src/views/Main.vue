<template>
<div>
<el-container>
  <el-header>
     <common-header></common-header>
  </el-header>
<el-container>
<el-aside>
  <common-aside></common-aside>
</el-aside>
  <el-main>
    <router-view></router-view>
  </el-main>
</el-container> 
</el-container>
</div> 
</template>

<script>
import CommonHeader from '../components/CommonHeader.vue'
import CommonAside from '@/components/CommonAside.vue'
export default {
  components: {
    CommonHeader,
    CommonAside
  }
}
</script>

<style scoped>
.el-header{
  background-color: #2acaff;
  color: #333;
}
.el-main{
  padding-top: 20px;
}
</style>
