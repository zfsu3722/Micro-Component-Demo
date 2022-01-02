<template>
  <div>
    <el-container>
      <el-aside width="280px">
        
        <el-menu :default-openeds="['1','2']"
        default-active="1"
        class="el-menu-vertical-demo" 
        :collapse="isCollapse"
        min-height:100px
        >
        <h3>Management system</h3>
          

          <el-submenu index="1">
            <template slot="title"><i class="el-icon-caret-right"></i>Financial reimbursement</template>
            <el-menu-item-group>
              
              <el-menu-item index="1-1"> 
                 <router-link to="/financial/RefundItemList">Reimbursement Details</router-link>
              </el-menu-item>
              <el-menu-item index="1-2"> 
                 <router-link to="/financial/ReimbursementList">Reimbursement List</router-link>
              </el-menu-item>

            </el-menu-item-group>
          </el-submenu>
          <el-submenu index="2">
            <template slot="title"><i class="el-icon-caret-right"></i>
              <router-link to="/goHome">Home page</router-link></template>
          </el-submenu>
        </el-menu>
      </el-aside>
      <el-container>
        <el-header style="text-align: right;font-size: 12px">
         
          <el-dropdown>
            <span style="font-size:12px;text-align:left">set</span>
            <i class="el-icon-setting" style="margin-right: 15px"></i>
           
            <el-dropdown-menu slot="dropdown">
              <el-dropdown-item>Personal information</el-dropdown-item>
              <el-dropdown-item>Log out</el-dropdown-item>
            </el-dropdown-menu>
          </el-dropdown>
    
        </el-header>

        <el-main>
          <router-view/>
        </el-main>
      </el-container>
    </el-container>
  </div>
</template>

<script>
  export default {
   
      name: "Main"
  }
</script>

<style lang="scss" scoped>
.el-header{
  background-color: #2acaff;
  color: #333;
  line-height: 60px;
}

.el-aside{
  color: #333;
  height: 100%;
}
</style>
