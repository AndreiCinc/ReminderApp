import React, { Component, useState, useEffect} from 'react';
import './list.style.css';
import Card from '../card/card.component.js';
import CardService from '../../service/CardService.js';

export default function List(props) {

	const [isLoaded, setLoaded] = useState(true);
	const [data, setData] = useState([]);

	const getData = async () => {
		let reminders = await CardService.getEvents();
		setLoaded(true);
		setData(reminders)
			
	}
	useEffect( () =>{
		getData()
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