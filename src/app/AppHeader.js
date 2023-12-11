import React, { Component } from 'react';
import { Link, NavLink } from 'react-router-dom';
import './AppHeader.css';

class AppHeader extends Component {
    render() {

        return (

            <header className="app-header">
                <div className="container">
                    <div className="app-branding">

                       

            <ul className="nav">
                                <li className="nav-item">
                                     <Link to="/" className="app-title">Know Your Neighborhood </Link>
            </li>
           
            <li className="nav-item">
                <a className="nav-link" href="/about">ABOUT US</a>
            </li>

            <li className="nav-item">
                <a className="nav-link" href="/contact">CONTACT US</a>
            </li>

            <li className="nav-item">
                <a className="nav-link" href="/term">TERMS AND CONDITIONS</a>
            </li>

           

           

            </ul>

     

                    </div>

                   

                    <div className="app-options">
                        <nav className="app-nav">
                                { this.props.authenticated ? (
                                    <ul>
                                        <li>
                                            <NavLink to="/profile">PROFILE</NavLink>
                                        </li>
                                        <li>
                                            <NavLink to="/stores">VIEW STORE</NavLink>        
                                        </li>
                                        <li>
                                            <a onClick={this.props.onLogout}>LOGOUT</a>
                                        </li>
                                    </ul>
                                ): (
                                    <ul>
                                        
                                        <li>
                                         <NavLink to="/login">LOGIN</NavLink>       
                                        </li>
                                        <li>
                                            <NavLink to="/signup">SIGNUP</NavLink>        
                                        </li>
                                    </ul>
                                )}
                        </nav>
                    </div>
                </div>
            </header>
        )
    }
}

export default AppHeader;