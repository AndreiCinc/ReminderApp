import React, { useState } from 'react';
import './title.style.css';


export default function Title(props) {

	const [name, setName] = useState(props.name);

	function handlerName(e) {
		props.handlerName(e);
	}

	return(
		<div className="md-form active-cyan active-cyan-2 mb-3">
		  <input 
		  	className="form-control" 
		  	type="text" 
		  	placeholder={name} 
		  	aria-label="Name"
		  	onChange={(e) => {handlerName(e)}}
		  	/>
		</div>
	);
}