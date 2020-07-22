import React, { Component } from 'react';

export default class deleteRequest extends React.Component {
	constructor(props) {
		super(props)

		this.state = {
			url: "9a5fcfc4-25e3-4f49-91dc-b29e699ed1c0",
		}
	}

	sendData() {
		console.log(this.state)
		fetch("http://localhost:8080/event/ReminderApp/api/v1/event/" + this.state.url,
		{
			method: 'DELETE',
		})
		.catch(err => {
	         console.log('Type send failed', err);
		});
	}
	submitHandler = e => {
		console.log('is here');
		this.sendData()
		e.preventDefault();
	}
	
	render() {
 		return(
			<div>
				<button type="submit" onClick={this.submitHandler}>Submit</button>
			</div>
		);
	}
}