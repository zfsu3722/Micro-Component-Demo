import axios from '../request'



export const getItem = () => axios.get("api/v1/start?webTaskId=itemList")


export const getItemDetail = (vid)=> axios.get("/api/v1/start?webTaskId=itemRefundList",{
    params: {
       IRL_itemId:vid
   }
})


getItemDetail().then(r=>{
    console.log(r);
    console.log(123);
})

