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

	return (
	    <div className="App">
	    	<Router>
			    <Switch>
				    <Route path="/logIn" component={LogIn}/>
				    <Route path="/register" component={Register}/>
					<Route path="/mainPage" component={MainPage}/>
				</Switch>
			</Router>
	    </div>
 	);
}
