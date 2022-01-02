import axios from 'axios'

const service = axios.create({
    //url = base url + reqeust url
    baseURL : "http://138.138.0.14:9000",
    // baseURL : "http://138.138.0.41:8000",
    timeout: 5000
})

export default service