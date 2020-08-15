import React from 'react';
import './App.css';
import List from './component/list/list.component.js';
import CreateEvent from './component/createEvent/createEvent.component.js';
import LogIn from './component/logIn/logIn.component.js';


function App() {

  return (
    <div className="App">
      <div className="Title">
        <h1>ReminderApp</h1>
      </div>
      <div>
       <LogIn />
      </div>
      <div>
      </div>
    </div>
  );
}

export default App;
