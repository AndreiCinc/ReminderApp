import React, { Component } from 'react';

export default class deleteRequest extends React.Component {
	constructor(props) {
		super(props)

		this.state = {
			url: this.props,
		}
	}

	deleteData() {
		fetch("http://localhost:8080/event/ReminderApp/api/v1/event/" + this.state.url,
		{
			method: 'DELETE',
		})
		.catch(err => {
	         console.log('Type send failed', err);
		});
	}
	submitHandler = e => {
		this.deleteData()
		e.preventDefault();
	}
	
	render() {
 		return(
			<div>
				<button type="submit" onClick={this.submitHandler}>Delete</button>
			</div>
		);
	}
}