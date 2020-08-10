import React, { useState} from 'react';
import './card.style.css';
import '../../template/loading.style.css';
import Moment from 'react-moment';
import 'moment-timezone';
import CardService from '../../service/cardService.js';
import Modal from './modal.component.js';
import { updateModal, memoPop} from './modal.style.js';
import CustomComponent from './popover.component.js'
import DateVerification  from '../../service/dateVerification.js';
export default function Card(props) {

	const [openModal, setOpenModal] = useState(false);

	const deleteReminder = (e, id) => {
		CardService.deleteEvent(id)
		e.preventDefault();
	}
	const handlerModal = () => {
		setOpenModal(!openModal);
	}
	return(
		props.object.map((object) => { 
			if(DateVerification(object.startDate)) {
				window.open(
				);
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
					<button className="update-button" onClick={(e) => handlerModal(e)}>
						<i className="fa fa-cog">
						</i>
					</button>
					<Modal onClose={handlerModal} isOpen={openModal} id={object.id} style={updateModal}/>
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