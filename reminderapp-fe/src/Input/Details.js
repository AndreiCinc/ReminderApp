import React from 'react';
import '../CreateEvent/CreateEvent.css';

export default function Details(props) {

	function handleDetails(e) {
		props.handleDetails(e.target.value);
	}
	
	return(
		<div className="form-group blue-border inline">
			<label className="exampleFormControlTextarea4">Details: </label>
		  	<textarea className="form-control" 
		  		id="exampleFormControlTextarea4" 
		  		rows="3"
		  		value={props.value}
		  		onChange={(e) => handleDetails(e)}
		  	>
		  	</textarea>
		</div>
	);
}