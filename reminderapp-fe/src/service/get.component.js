import React, { Component } from 'react';
import '../template/loading.style.css';

export default class GetRequest extends Component {

	constructor(props) {
		super(props);
		this.state = {
			isLoaded: false,
			data: [],
		}
	}
	componentDidMount() {
		fetch('http://localhost:8080/event/ReminderApp/api/v1/event')
		.then(ref => ref.json())
		.then(json => {
			this.setState({
				isLoaded: false, 
				data: json,
			});
		})
	}

	render() {
		console.log(data);
		var {isLoaded, data} = this.state;

		if(!isLoaded) {
			return (
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
			);
		}
		return(
			<div>
				Loaded
			</div>
		);
	}
}


