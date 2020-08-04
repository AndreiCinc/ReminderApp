import React, { Component, useState} from 'react';
import './card.style.css';
import '../../template/loading.style.css';
import Moment from 'react-moment';
import 'moment-timezone';
import CardService from '../../service/CardService.js';
import Modal from './modal.component.js';
import CustomComponent from './popover.component.js'

export default function Card(props) {

	const [openModal, setOpenModal] = useState(false);
	const [openPopper, setOpenPopper] = useState(false);
	const [eventObject, setEventObject] = useState({});

	const deleteReminder = (e, id) => {
		CardService.deleteEvent(id); 
	}
	const handlerOpen = (e) => {
		setOpenModal(!openModal);
	}
	const handlerPopper = (e) => {
		setOpenPopper(!openPopper)
	}
	return(
		props.object.map((object) => {
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
					<button className="update-button" onClick={handlerOpen}>
						<i className="fa fa-cog">
						</i>
					</button>
					<Modal onClose={handlerOpen}/>
					<CustomComponent 
						className="details-button"
						title={object.name}
						startDate={object.startDate}
						endDate={object.endDate}
						details={object.details}
					/>
					<button className="delete-button" onClick={(e) => {deleteReminder(e, object.id)}}><i className="fa fa-trash-o"></i></button>
				</div>
			</>
		);
		})
	);
}