import React from 'react';
import './App.css';
import LogIn from './LogIn/LogIn.js';
import Register from './Register/Register.js';
import MainPage from './MainPage/MainPage.js';
import Cookie from './Service/CookiesService.js';
import {Route, BrowserRouter as Router, Switch, Link, Redirect, useHistory} from 'react-router-dom';

function App() {

	let login  = Cookie.checkLogin();
	console.log(login);

	return (
	    <div className="App">
	    	<Router>
			    <Switch>
				    <Route exact path='/' component={MainPage}/>
				    <Route path='/register' component={Register}/>
				    <Route path='/login' component={LogIn}/>
				</Switch>
			</Router>
	    </div>
 	);
}

export default App;
