import React from 'react';
import logo from '../Template/Logout.png';
import Cookies from '../Service/CookiesService.js';
import {Route, BrowserRouter as Router, Switch, Link, Redirect, useHistory} from 'react-router-dom';


function Logout() {

	const handleChange = (e) => {
		Cookies.removeCookie("person");
	}
	
	return(
		<Link to="/login">
			<img 	className="Logout" 
					src={logo} 
					alt={"logo"} 
					onClick={handleChange}
					/>
		</Link>
	)
}

export default Logout;