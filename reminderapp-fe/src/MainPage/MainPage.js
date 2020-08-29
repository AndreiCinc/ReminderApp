import React from 'react';
import List from '../List/List.js';
import '../LogIn/LogIn.css';
import CreateEvent from '../CreateEvent/CreateEvent.js';

export default function MainPage(props) {
	
	return(
		<div>
			<div className="Title">
    			<h2>ReminderApp</h2>
    		</div>
			<List props={props.id}/>
			<CreateEvent />
		</div>
	)
}