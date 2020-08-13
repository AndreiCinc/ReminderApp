import React, { useState} from 'react';
import './card.style.css';
import '../../template/loading.style.css';
import Moment from 'react-moment';
import moment from 'moment';
import 'moment-timezone';
import CardService from '../../service/cardService.js';
import CustomComponent from './popover.component.js'
import DateVerification from '../../service/dateVerification.js';
import UpdateEvent from '../updateEvent/updateEvent.component.js';


export default function Card(props) {

	const deleteReminder = (e, id) => {
		CardService.deleteEvent(id)
		e.preventDefault();
	}

	return(
		props.object.map((object) => { 
			if(DateVerification(object.reminderDate)) {
				let mom = new Date(object.startDate);
				alert("The event starts " + mom);
			}
			return (
			<>
				<div className="card" key = {object.id}>
					<div className="title">
						{object.name}
					</div>
					<div className="start-date">
						Start:
						<Moment format=" MM/DD/YYYY HH:mm">
               				{object.startDate}
               			</Moment>
					</div>
					<div className="end-date">
						End:
						<Moment format=" MM/DD/YYYY HH:mm">
               				{object.endDate}
               			</Moment>
					</div>
					<UpdateEvent
						className="update-button"
						key={object.id}
						id={object.id}
						name={object.name}
						startDate={object.startDate}
						endDate={object.endDate}
						reminderDate={object.reminderDate}
						details={object.details}
					/>
					<CustomComponent 
						className="details-button"
						title={object.name}
						startDate={object.startDate}
						endDate={object.endDate}
						reminder={object.reminderDate}
						details={object.details}
					/>
					<button className="delete-button" onClick={(e) => {deleteReminder(e, object.id)}}><i className="fa fa-trash-o"></i></button>
				</div>
			</>
		);
		})
	);
}