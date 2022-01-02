<template>
<div>
  <el-row class="goods" :gutter="20">
  <el-col :span="7" v-for="(item) in tabledata" :key="item.goodsId" :offset="1">
    <el-card :body-style="{ padding: '0px' }" shadow="hover">
      <div class="img">
        <img :src="'data:img/png;base64,'+item.img" alt=""/>
      </div>
      <div>        
			<span>{{item.goodsName}}</span><br> 
      </div>                   
			<div>                    
			<span>{{item.goodsPrice}}</span>  
      </div> 
      <div>                    
			<span><br></span>  
      </div>
      <div>                    
			<span><br></span>  
      </div>
      <div>                    
			<span><br></span>  
      </div>
      <div>                    
			<span>coupon：{{item.couponDesc}}</span>  
      </div> 
      <div>                    
			<span>{{item.couponId}}</span>  
      </div> 
      <div>
        <el-button class="buttonThree"  size="mini" @click.once="payMoney(item.goodsId,item.couponId)">pay</el-button>
      </div>      
    </el-card>
    </el-col>  
</el-row>
</div>
</template> 
<script>
import { getShoppingCart,purchaseGoods } from "@/api/getData.js";
export default{
  data(){ 
    return{ 
      tabledata:[
      ] ,
    } 
  },
  mounted: function(){
    this.getparam(),
    this.getShopping(this.vid)
  },
  methods: {
    async getShopping(username){
      try {
       // alert(username)
        const result = await getShoppingCart(username);
        this.tabledata = result.data
        //alert(tabledata)
        //console.log(result.data)
        //console.log(this.tabledata)
      } catch (error) {
        console.log(error);
      }
    },
      getparam(){
        this.vid=this.$route.params.IRL_itemId   
      },

      async payMoney(goods_Id,coupon_Id){
        // alert(goods_Id)
        console.log(goods_Id),
        console.log(this.$store.getters.getCurrentUser),
        await purchaseGoods(goods_Id,coupon_Id,this.$store.getters.getCurrentUser).then(res=>{
          console.log(res.data),
          alert(res.data);
          this.getparam(),
          this.getShopping(this.vid)
        })
      }
  }
}
</script>

<style scoped>
.el-card{
  font-size: 13px;
  width: 250px;
  height: auto;
  line-height: 20px;
  margin-bottom: 20px;
  border: 0;
  top: 20px;
  word-break: break-all;
  text-indent: 2em;
}
.buttonThree{
  padding-left: 180;
}
img{
  height: 120px;
  width: 150px;
}
</style> 

