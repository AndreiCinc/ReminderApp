import React from 'react';
import logo from '../Template/Logout.png';
import Cookies from '../Service/CookiesService.js';
import {Route, BrowserRouter as Router, Switch, Link, Redirect, useHistory} from 'react-router-dom';


export default function Logo() {

	let history = useHistory();
	const handleChange = (e) => {
		history.push("/login")
		Cookies.removeCookie("person");
	}
	return(
		<img 	className="Logout" 
				src={logo} 
				alt={"logo"} 
				onClick={handleChange}
				/>
	)
}