import React from 'react';
import './App.css';
import List from './List/List.js';
import CreateEvent from './CreateEvent/CreateEvent.js';
import LogIn from './LogIn/LogIn.js';
import Register from './Register/Register.js';
import MainPage from './MainPage/MainPage.js';
import Cookie from './Service/CookiesService.js';
import {Route, BrowserRouter as Router, Switch, Link} from 'react-router-dom';

export default function App() {
	let login  = Cookie.checkLogin();
	console.log(login);
	return (
	    <div className="App">
	    	<Router>
			    <Switch>
			    <Route path="/login" component={LogIn}/>
			    login ? 
				    <Route path="/" component={MainPage}/> :
				    <Route path="/" component={LogIn}/>
					<Route path="/register" component={Register}/>
					<Route path="/login" component={LogIn}/>
				</Switch>
			</Router>
	    </div>
 	);
}
