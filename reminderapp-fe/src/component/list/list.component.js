import React, { useState, useEffect} from 'react';
import './list.style.css';
import Card from '../card/card.component.js';
import EventService from '../../service/eventService.js';

export default function List(props) {

	const [isLoaded, setLoaded] = useState(true);
	const [data, setData] = useState([]);

	const getData = async () => {
		let reminders = await EventService.getEvents();
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