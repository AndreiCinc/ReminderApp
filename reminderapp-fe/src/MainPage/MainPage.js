import React from 'react';
import List from '../List/List.js';
import '../LogIn/LogIn.css';
import CreateEvent from '../CreateEvent/CreateEvent.js';
import Cookie from '../Service/CookiesService.js';
import Logout from './Logout.js';
import {Route, BrowserRouter as Router, Switch, Link} from 'react-router-dom';


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
			</div>	: 
			<div>
				<div className="Title">
					<h2>ReminderApp</h2>
				</div>
				<div className="insert">
				<h2>Insert your credentials, please!</h2>
				</div>
				<div style={{"margin-left": '50%'}}>
					<Link to="/logIn">
						<h3>LogIn</h3>
					</Link>
				</div>
			</div>
		
	)
}