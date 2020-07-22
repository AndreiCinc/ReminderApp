import React from 'react';
import logo from './template/logo.svg';
import './App.css';
import title from './component/input/calendar.component.js';

function App() {
  return (
    <div className="App">
      
      {title()}
    </div>
  );
}

export default App;
