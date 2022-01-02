<template>
  <div>
  <el-row class="goods" :gutter="20">
  <el-col :span="7" v-for="(item) in tabledata" :key="item.goodsId" :offset="1">
    <el-card :body-style="{ padding: '0px' }" shadow="hover">
      <div style="padding: 10px;" class="goods">
        <img :src="'data:img/png;base64,'+item.img" />   
      </div> 
      <div>        
			  <span>{{item.goodsName}}</span><br> 
      </div>                   
			<div class="goodPrice">                    
			  <span>{{item.goodsPrice}}</span>  
      </div>
      <div>
        <span>{{item.goodsDesc}}</span>
      </div>
      <div>
        <span>{{item.goodsNumber}}</span>
      </div>
      <div>                    
			  <span>{{item.goodsType}}</span>  
      </div>    
      <!-- <div>                    
			  <span>{{$store.getters.getCurrentUser}}</span>  
      </div>          -->
       <div>
        <el-button aligin="right" type="text" class="buttonOne" @click="addGoods(item)">add to cart</el-button>                
			</div> 
    </el-card>
    </el-col>
    <template>
      <el-button size="large" class="buttonTwo"
      @click="viewdetail($store.getters.getCurrentUser)">View cart
      <span hidden="true">{{$store.getters.getCurrentUser}}</span>
      </el-button>  
    </template>
</el-row>
  </div>
</template>
<script>
  import { saveOrder,fetchData } from "@/api/getData.js";
  export default{
      name: "Main",
      data(){ 
      return{ 
        tabledata:[]
      }
    }, 
    methods:{
      async getDetail(){
          try{
             const result =  await fetchData();
             this.tabledata = result.data;
          }catch(error){
                console.log(error)
          }
        },

      addGoods(tabledata){
       //alert(this.$store.getters.getCurrentUser),
        saveOrder(
         tabledata.goodsId,
         tabledata.goodsImg,
         tabledata.goodsName,
         tabledata.goodsPrice,
         tabledata.goodsDesc,
         tabledata.goodsNumber,
         tabledata.goodsType,
         this.$store.getters.getCurrentUser
       ).then(res=>{
         alert(res.data);
         console.log(this.$store.getters.getCurrentUser);
       })
      },
      
      viewdetail:function(username){
        //console.log(username)
        this.$router.replace({name:'ShoppingCart' , params:{IRL_itemId: username}});
      },
   },

      mounted(){
        this.getDetail()
    }
  }
</script>
<style scoped>
.el-card{
  font-size: 12px;
  text-indent: 2em;
  width: 300px;
  height: 380px;
  line-height: 20px;
  margin-bottom: 20px;
  border: 0;
  top: 20px;
}
img{
  width: 200px;
  height: 180px;
}
.goodPrice{
  color: red;
  font-size: 15px;
}
.buttonOne{
  position: auto;
  bottom: 10px;
  padding-left: 180px;

}
</style>
