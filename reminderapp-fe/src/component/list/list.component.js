import React, { Component, useState} from 'react';
import './list.style.css';
import Card from '../card/card.component.js';

export default function List(props) {

	const [isLoaded, setLoaded] = useState(props.loaded);

	if (!isLoaded) {
		return(
		<div className="list">
			<div className="lds-spinner">
				<div>
				</div>
				<div>
				</div>
				<div>
				</div>
				<div>
				</div>
				<div>
				</div>
				<div>
				</div>
				<div>
				</div>
				<div>
				</div>
				<div>
				</div>
				<div>
				</div>
				<div>
				</div>
				<div>
				</div>
			</div>
	   	</div>
	);
	}
	return(
		<div className="list">
			<Card 
				title={props.title}
				startDate={props.startDate}
				endDate={props.endDate}
				details={props.details}
			/>
	   	</div>
	);
}