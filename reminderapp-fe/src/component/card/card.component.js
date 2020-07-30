import React, { Component } from 'react';
import './card.style.css';
import '../../template/loading.style.css';
import Moment from 'react-moment';
import 'moment-timezone';
import CardService from "../../service/CardService.js";

export default function Card(props) {

	const start = (date) => {
		return(
			<Moment format="YYYY/MM/DD">
                {date}
            </Moment>
			)
	}
	const end = (date) => {
		return(
			<Moment format="YYYY/MM/DD">
                {date}
            </Moment>
			)
	}

	const deleteReminder = (id) => {
		CardService.delete(id); 
	}
	return(
		props.object.map((object) => {
			return (
				<div className="card">
					<div className="title">
						{object.name}
					</div>
					<div className="start-date">
						Start: {start(object.startDate)} 
					</div>
					<div className="end-date">
						End: {end(object.endDate)}
					</div>
					<button className="update-button"><i className="fa fa-cog"></i></button>
					<button className="details-button"><i className="fas fa-angle-double-right"></i></button>
					<button className="delete-button" onClick={() => { deleteReminder(object.id) }}><i className="fa fa-trash-o"></i></button>
				</div>
			);
		})
	);
}