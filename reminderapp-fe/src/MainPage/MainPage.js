import React from 'react';
import List from '../List/List.js';
import '../Login/Login.css';
import CreateEvent from '../CreateEvent/CreateEvent.js';
import Cookie from '../Service/CookiesService.js';
import Logout from './Logout.js';
import Login from '../Login/Login.js';
import {Route, BrowserRouter as Router, Switch, Link, Redirect, useHistory} from 'react-router-dom';


export default function MainPage(props) {

	let check = Cookie.checkLogin();

	return(
		check ?
		<div>
			<div className="Title">
    			<h2>ReminderApp</h2>
    		</div>
    		<Logout />
			<List props={props.id}/>
			<CreateEvent />
		</div> :
		<Route to='/login' component={Login} />
	)
}