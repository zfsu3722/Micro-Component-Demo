<template>
  <el-aside class="aside" width="260px" style="background-color: rgb(238, 241, 246)">
    <el-menu :default-openeds="['1','2']">
      <el-submenu index="1">
        <template slot="title"><i class="el-icon-message"></i>Online shopping navigation</template>
        <el-menu-item-group>
          <el-menu-item index="1-1">
            <router-link to="Goods">Products</router-link>
          </el-menu-item>
          <!-- <el-menu-item index="1-2">
          <router-link to="ShoppingCart">Cart</router-link>
        </el-menu-item> -->
        </el-menu-item-group>
        <el-submenu index="2">
        <template slot="title"><i class="el-icon-menu"></i>Home page</template>
        <el-menu-item-group>
          <el-menu-item index="2-1">
            <router-link to="/goHome">Return home page</router-link>
          </el-menu-item>
        </el-menu-item-group>
        </el-submenu>
      </el-submenu>
    </el-menu>
  </el-aside>
</template>

<style scoped>
.el-aside {
  background-color: #D3DCE6;
    color: #333;
    text-align: center;
    line-height: 200px;
    height: 100%;
}
</style>