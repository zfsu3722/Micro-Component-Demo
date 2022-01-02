
<template>
  <div>
    <el-row style="height: 700px;">
      
      <el-table :data="refundItemList" style="width: 100%">


        <el-table-column label="Project ID" width="120">
          <template slot-scope="scope">
            <span style="margin-left: 10px">{{ scope.row["itemId"] }}</span>
          </template>
        </el-table-column>

        <el-table-column label="Project name" width="120">
          <template slot-scope="scope">
            <span style="margin-left: 10px">{{ scope.row["itemName"] }}</span>
          </template>
        </el-table-column>

        <el-table-column label="Start time" width="160">
          <template slot-scope="scope">
            <span style="margin-left: 10px">{{ scope.row["startTime"] }}</span>
          </template>
        </el-table-column>

        <el-table-column label="End time" width="160">
          <template slot-scope="scope">
            <span style="margin-left: 10px">{{ scope.row["endTime"] }}</span>
          </template>
        </el-table-column>
        <el-table-column label="Funds" width="120">
          <template slot-scope="scope">
            <span style="margin-left: 10px">{{ scope.row["total"] }}</span>
          </template>
        </el-table-column>

        <el-table-column label="Project leader" width="140">
          <template slot-scope="scope">
            <span style="margin-left: 10px">{{ scope.row["empName"] }}</span>
          </template>
        </el-table-column>

        <el-table-column label="Contact info " width="140">
          <template slot-scope="scope">
            <i class="el-icon-time"></i>
            <span style="margin-left: 10px">{{ scope.row["empPhoneNo"] }}</span>
          </template>
        </el-table-column>

        <el-table-column label="Status" width="120">
          <template slot-scope="scope">
            <span style="margin-left: 10px">{{ scope.row["finishFlag"] }}</span>
          </template>
        </el-table-column>

        <el-table-column>
          <template slot-scope="scope">
          
          <el-button
            size="large"
            @click="viewdetail(scope.row['itemId'])">Details
          </el-button> 
        </template>
        </el-table-column>
          
        
      </el-table>
    </el-row>
    <el-row>
      <el-pagination @current-change="handleCurrentChange" :current-page="currentPage" :page-size="pagesize" :total="refundItemList.length">
      </el-pagination>
    </el-row>
  </div>
</template>






<script>

import { getItem } from "@/api/getData.js"
  
  export default {
    name: 'RefundItemList',  
    data() {
      return {
        refundItemList: [],
        
      }
    },
    mounted: function() {   
      this.getItemData();
    },

    methods: {
     async getItemData(){
       try{
         const result = await getItem();

       this.refundItemList = result.data
       }catch(error){
         console.lo(error)
       }
     },
      viewdetail:function(item_Id){
        //alert(item_Id);
        this.$router.replace({name:'RefundItemList' , params:{IRL_itemId: item_Id}});

      },

      handleCurrentChange: function(currentPage) {
        this.currentPage = currentPage
      } 
     
  }
}
</script>