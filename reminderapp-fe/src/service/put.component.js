import React, { Component } from 'react';

export default class postRequest extends React.Component {
	constructor(props) {
		super(props)

		this.state = {
			url: this.props,
			name: "",
    		startDate: "",
		    endDate: "",
		    details: "",
		}
	}

	putData() {
		console.log(this.state)
		fetch("http://localhost:8080/event/ReminderApp/api/v1/event/" + this.state.url,
		{
			method: 'PUT',
			headers: {
	 		   "Content-Type" : "application/JSON" ,
	 		},
	 		dataType: "json",
			body: JSON.stringify(this.state),
		})
		.then(response => response.json())
		.then(json => {console.log(json)
		})
		.catch(err => {
	         console.log('Type send failed', err);
		});
	}

	changeHandler = e => {
		this.setState({[e.target.name]: e.target.value});
	}

	submitHandler = e => {
		this.putData()
		e.preventDefault();
	}
	
	render() {
 		
 		const {name, startDate, endDate, details} = this.state;
		return(
			<div>
				<form onSubmit={this.submitHandler}>
					<div>
						<input 
							type="text" 
							name="name" 
							values={name} 
							onChange={this.changeHandler}
						/>
					</div>
					<div>
						<input 
							type="text" 
							name="startDate" 
							values={startDate} 
							onChange={this.changeHandler} 
						/>
					</div>
					<div>
						<input 
							type="text" 
							name="endDate" 
							values={endDate}
							onChange={this.changeHandler} 
						/>
					</div>
					<div>
						<input
							type="text" 
							name="details" 
							values={details}
							onChange={this.changeHandler}
						/>
					</div>
					<button type="submit">Submit</button>
				</form>
			</div>
		);
	}
}