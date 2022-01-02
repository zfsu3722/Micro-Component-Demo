import axios from '../request'

export const fetchData = () => axios.get("/shoppingCart?taskId=getGoodsForMail")

export const saveOrder = (goodsId,goodsImg,goodsName,goodsPrice,goodsDesc,goodsNumber,goodsType,loginName) => axios.post("/shoppingCart?taskId=addShoppingCart",{
  "goodsId":goodsId,
  "goodsImg":goodsImg,
  "goodsName":goodsName,
  "goodsPrice":goodsPrice,
  "goodsDesc":goodsDesc,
  "goodsNumber":goodsNumber,
  "goodsType":goodsType,
  "loginName":loginName
})

export const getShoppingCart = (loginName)=> axios.post("/shoppingCart?taskId=renderShoppingCart",{
    "loginName":loginName
})

export const purchaseGoods = (goodsId,couponId,loginName)=> axios.post("/shoppingCart?taskId=clearShoppingCart",{
  "goodsId":goodsId,
  "couponId":couponId,
  "loginName":loginName
})

export const usersLogin = (username,password)=> axios.post("/shoppingCart?taskId=itemLoginList",{
    "IdForUserName":username,
    "IdForPassWord":password
    
  })