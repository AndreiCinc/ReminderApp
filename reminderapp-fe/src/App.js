import React from 'react';
import './App.css';
import List from './component/list/list.component.js';
import CreateEvent from './component/createEvent/createEvent.component.js';
import LogIn from './component/logIn/logIn.component.js';
import Register from './component/register/register.component.js';
import MainPage from './component/mainPage/MainPage.js';
import {Route, BrowserRouter as Router, Switch, Link} from 'react-router-dom';

function App() {

  return (
    <div className="App">
	    <Router>
		    <Route path="/" exact component={LogIn}/>
		    <Route path="/register" component={Register}/>
			<Route path="/mainPage" component={MainPage}/>
	    </Router>
    </div>
  );
}

export default App;
