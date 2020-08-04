import React from 'react';
import './createEvent.style.css';
import Name from '../input/title.component.js';
import Calendar from '../input/calendar.component.js';
import Details from '../input/details.component.js';
import CardService from '../../service/CardService.js';


class CreateEvent extends React.Component {
	constructor(props) {
		super(props);
		this.state = {
			name: "",
			startDate: new Date(),
			endDate: new Date(),
			details: ""
		}
	}
	handlerName = e =>{
		this.setState({name: e.target.value});
	}
	handleStartDate = date => {
		this.setState({startDate: date});
	}
	handleEndDate = date => {
		this.setState({endDate: date});
	}
	handleDetails = value => {
		this.setState({details: value})
	}
	handleSubmit = (e) => {
		if (this.state.name === "" ) {
			alert("The name field cannot be emty");
		}else if (
			 this.state.startDate.getTime() >= this.state.endDate.getTime() ) {
				alert("The start date cannot be equal or more than end date");
		}else {
			CardService.postEvent(this.state)
		}
	}	
	render() {
		return(
			<form onSubmit={(e) => {this.handleSubmit(e)}}>
				<div className="Create-event">
					<div>
			        	<Name name={'Insert event name'} handlerName={(e) => this.handlerName(e)} />
		        	</div>
		        	<div className="date">
		         		<Calendar type="submit" handlerDate={this.handleStartDate} date={this.state.startDate}/>
		        	</div>
		        	<div className="date">
		        		<Calendar type="submit" handlerDate={this.handleEndDate} date={this.state.endDate}/>
		        	</div>
		        	<div className="text">
		        		<Details type="submit" handleDetails={this.handleDetails}/>
		        	</div>
		        	<button className="createButton" >
		        		Create   
		        	</button>
		      	</div>
	      	</form>
		);
	}
}
export default CreateEvent;