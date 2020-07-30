import React from 'react';
import './App.css';
import List from './component/list/list.component.js';
import CreateEvent from './component/createEvent/createEvent.component.js';
import Create from './service/post.component.js';


function App() {
  return (
    <div className="App">
      <div className="Title">
        <h4>ReminderApp</h4>
      </div>
      <div>
        <Create />
      </div>
      <div>
        <List />
      </div>
    </div>
  );
}

export default App;
