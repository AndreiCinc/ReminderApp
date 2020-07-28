import React, { Component } from 'react';
import './card.style.css';
import '../../template/loading.style.css';


export default function Card(props) {

	return(
		<div className="card">
			<div className="title">
				Event title
			</div>
			<div className="start-date">
				Start: {props.title}
			</div>
			<div className="end-date">
				End: 
			</div>
			<button className="update-button"><i className="fa fa-cog"></i></button>
			<button className="details-button"><i className="fas fa-angle-double-right"></i></button>
			<button className="delete-button"><i className="fa fa-trash-o"></i></button>
		</div>
	);
}