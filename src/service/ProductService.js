import axios from 'axios'

class ProductService{
    viewStores(){
        return axios.get("http://localhost:8080/kyn/dashboard")
    }

    
}

export default new ProductService