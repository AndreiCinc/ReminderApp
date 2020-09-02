import React, { useState, useEffect} from 'react';
import './List.css';
import Card from '../Card/Card.js';
import EventService from '../Service/EventService.js';

export default function List(props) {

	const [isLoaded, setLoaded] = useState(true);
	const [data, setData] = useState([]);

	const getData = async () => {
		let reminders = await EventService.getEventsByPersonId();
		setLoaded(true);
		setData(reminders);	
	}

	useEffect(() => {
		let events = setInterval(() => {
			getData();
		}, 1000);
		return () => clearInterval(events);
	})

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
				object={data} 
			/>
		</div>	
	);
}