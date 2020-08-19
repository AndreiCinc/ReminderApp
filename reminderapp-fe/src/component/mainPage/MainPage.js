import React from 'react';
import List from '../list/list.component.js';
import CreateEvent from '../createEvent/createEvent.component.js';


export default function MainPage() {
	return(
		<div>
			<List />
			<CreateEvent />
		</div>
	)
}