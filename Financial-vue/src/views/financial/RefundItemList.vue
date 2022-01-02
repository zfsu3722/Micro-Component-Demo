<template>
  <div>
    <el-row style="height: 700px;">
      
      <el-table :data="refundItemList" style="width: 100%">
        
        <el-table-column label="Batch No." width="160">
          <template slot-scope="scope">
            <span style="margin-left: 10px">{{ scope.row["serialId"] }}</span>
          </template>
        </el-table-column>

        <el-table-column label="Project ID" width="200">
          <template slot-scope="scope">
            <span style="margin-left: 10px">{{ scope.row["itemId"] }}</span>
          </template>
        </el-table-column>

        <el-table-column label="Project name" width="160">
          <template slot-scope="scope">
            <span style="margin-left: 10px">{{ scope.row["itemName"] }}</span>
          </template>
        </el-table-column>

        <el-table-column label="Total" width="120">
          <template slot-scope="scope">
            <span style="margin-left: 10px">{{ scope.row["total"] }}</span>
          </template>
        </el-table-column>
        <el-table-column label="Refund" width="150">
          <template slot-scope="scope">
            <span style="margin-left: 10px">{{ scope.row["refund"] }}</span>
          </template>
        </el-table-column>

        <el-table-column label="Account" width="200">
          <template slot-scope="scope">
            <span style="margin-left: 10px">{{ scope.row["account"] }}</span>
          </template>
        </el-table-column>

        <el-table-column label="Time" width="130">
          <template slot-scope="scope">
            <i class="el-icon-time"></i>
            <span style="margin-left: 10px">{{ scope.row["refundTime"] }}</span>
          </template>
        </el-table-column>

        <el-table-column label="Manager" width="200">
          <template slot-scope="scope">
            <span style="margin-left: 10px">{{ scope.row["financeStaff"] }}</span>
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

import { getItemDetail } from "@/api/getData.js";
  
  export default {
    name: 'RefundItemList',
    
    
    data() {
      return {
        refundItemList: [],
      }
    },
    mounted: function() {   
      
      this.getItemDetailData()
      
      
    },
    created(){
      
    },
    methods: {
    
      async getItemDetailData(){
     
       const result = await getItemDetail(this.$route.params.IRL_itemId);
       this.refundItemList = result.data
     
      },
    
     
      handleCurrentChange: function(currentPage) {
        this.currentPage = currentPage
      }
  }
}
</script>
