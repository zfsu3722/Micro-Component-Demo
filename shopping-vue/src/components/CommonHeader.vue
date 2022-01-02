<template>
  <el-header class="header">
  <div class="l-content">
    <h3 style="color:#fff">Online Shopping</h3>
  </div>
  <div class="r-content">
  <el-dropdown trigger="click" szie="mini">
    
    <span class="el-dropdown-link">
      <img :src="userImg" width="60px" height="40px" class="user" />
    </span>
    <el-dropdown-menu slot="dropdown">
      <el-dropdown-item>Your profile</el-dropdown-item>
      <el-dropdown-item>Log out</el-dropdown-item>
    </el-dropdown-menu>
    <span>{{$store.getters.getCurrentUser}}</span>
  </el-dropdown>
</div>
</el-header>
</template>

<script>
export default {
  data(){
    return{
      userImg: require("../assets/iamges/user.png")
    }
  }
}
</script>

<style scoped>
.el-header{
  display: flex;
  height: 100%;
  align-items: center;
  justify-content: space-between;
}
.l-content{
  display: flex;
  align-items: center;
}
.r-content.user{
  
    width: 20px;
    height: 20px;
    border-radius: 50%;

}
</style>