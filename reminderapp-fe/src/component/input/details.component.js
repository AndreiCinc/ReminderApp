import React from 'react';
import '../createEvent/createEvent.style.css';

export default function Details(props) {

	function handleDetails(e) {
		props.handleDetails(e.target.value);
	}
	return (
		<div className="form-group blue-border inline">
			<label for="exampleFormControlTextarea4">Details: </label>
		  	<textarea className="form-control" 
		  		id="exampleFormControlTextarea4" 
		  		rows="3"
		  		onChange={(e) => handleDetails(e)}
		  	>
		  	</textarea>
		</div>
	);
}