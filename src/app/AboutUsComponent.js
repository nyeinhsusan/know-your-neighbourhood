import React, { Component } from 'react'
import aboutus from '../img/about.jpg'
export class AboutUsComponent extends Component {
  render() {
    return (
     <div >ABOUT US
                    <img src={aboutus} class="d-block w-100" alt="..."/>
                    </div>
    )
  }
}

export default AboutUsComponent