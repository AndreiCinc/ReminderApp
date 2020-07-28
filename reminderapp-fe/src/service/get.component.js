import React, { Component } from 'react';
import List from '../component/list/list.component.js';
import Card from '../component/card/card.component.js';


export default class GetRequest extends Component {

	constructor(props) {
		super(props);
		this.state = {
			isLoaded: false,
			data: {},
		}
	}

	componentDidMount() {
		fetch('http://localhost:8080/event/ReminderApp/api/v1/event')
		.then((response) => response.json())
		.then((response) => {
			this.setState({
				data: response, 
				isLoaded: true,
			})
		});
	}

	sendData () {
		if (this.state.isLoaded) {
			return(
				<List 
					loaded={this.state.isLoaded}
					object={this.state.data} 
				/>
			);
		}
		return(
			<List loaded={this.state.isLoaded} />
		);
	}

	render() {
		return(
			<div>
				{this.sendData()}
			</div>
		);
	}
}


