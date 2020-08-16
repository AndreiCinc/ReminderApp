import React from 'react';
import './App.css';
import List from './component/list/list.component.js';
import CreateEvent from './component/createEvent/createEvent.component.js';
import LogIn from './component/logIn/logIn.component.js';
import Register from './component/register/register.component.js';

function App() {

  return (
    <div className="App">
      <div>
       <Register/>
      </div>
    </div>
  );
}

export default App;
