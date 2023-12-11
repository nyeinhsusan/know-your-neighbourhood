import React, { Component } from 'react'
import '../App.css'
import ProductService from '../service/ProductService.js'

export class ProductComponent extends Component {

  constructor(props) {
    super(props)
  
    this.state = {
       stores: []
    }
  }

  componentDidMount(){
    ProductService.viewStores()
    .then( (response) => {
        console.log(JSON.stringify(response))
        this.setState({
          stores: response.data
         })
    })
  }

  render() {
    return (
    <div>
        <div className='App'>
            <h1>VIEW Stores</h1>
        </div>

        <table class="table table-hover">
        <thead>
            <tr class="table-secondary">
                <td class="table-secondary">Store Id</td>
                <td class="table-primary">Store Name</td>
                <td class="table-secondary">Store Price</td>
                <td class="table-primary">Store Registration</td>
             
            </tr>
        </thead>

        <tbody>
            {
                this.state.stores.map(store => 
                    <tr class="table-secondary" key={store.storeId}>
                      <td class="table-primary">{store.storeId}</td>
                        <td class="table-primary">{store.storeName}</td>
                        <td class="table-secondary">{store.storePrice}</td>
                        <td class="table-primary">{store.storeRegistration}</td>
                        
                        
                    </tr>
                )
            }
        </tbody>
        </table>

      </div>
    )
  }
}

export default ProductComponent