import React from 'react';
import './App.css';
import List from './component/list/list.component.js';
import CreateEvent from './component/createEvent/createEvent.component.js';


function App() {
  return (
    <div className="App">
      <div className="Title">
        <h4>ReminderApp</h4>
      </div>
      <div>
        <CreateEvent buttonFunction={"Create"} />
      </div>
      <div>
        <List />
      </div>
    </div>
  );
}

export default App;
