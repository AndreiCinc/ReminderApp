import React, { Component, useState} from 'react';
import './list.style.css';
import Card from '../card/card.component.js';

export default function List(props) {

	if (!props.loaded) {
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
				object={props.object} 
			/>
		</div>	
	);
}