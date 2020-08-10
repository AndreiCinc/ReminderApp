import React from 'react';
import './createEvent.style.css';
import Name from '../input/title.component.js';
import Calendar from '../input/calendar.component.js';
import Details from '../input/details.component.js';
import CardService from '../../service/cardService.js';
import Memo from '../input/memo.component.js';
import BellIcon from 'react-bell-icon';


class CreateEvent extends React.Component {
	constructor(props) {
		super(props);
		this.state = {
			name: "",
			startDate: new Date(),
			endDate: new Date(),
			details: "",
			reminderDate: new Date()
		}
	}
	handlerName = e =>{
		this.setState({name: e.target.value});
	}
	handleStartDate = date => {
		this.setState({startDate: date, reminderDate: date});
	}
	handleEndDate = date => {
		this.setState({endDate: date});
	}
	handleDetails = value => {
		this.setState({details: value});
	}
	handleMemo = e => {
		let date = e.target.value;
		let memoDate = this.state.startDate.getTime() - (date * 60000);
		let newDate = new Date(memoDate);
		this.setState({reminderDate: newDate});
	}
	handleSubmit = (e) => {
		if (this.state.name === "" ) {
			alert("The name field cannot be emty");
		}else if (
			 this.state.startDate.getTime() >= this.state.endDate.getTime() ) {
				alert("The start date cannot be equal or more than end date");
		}else if (this.props.buttonFunction === "Create") {
			CardService.postEvent(this.state)
		}else if (this.props.buttonFunction === "Update") {
			this.props.onClose(e.target.value);
			CardService.putEvent(this.state, this.props.id);
		}
		e.preventDefault();
	}

	render() {
		return(
			<form onSubmit={(e) => {this.handleSubmit(e)}}>
				<div className="Create-event">
					<div>
			        	<Name name={'Insert event name'} handlerName={this.handlerName} />
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
			        <div className="bottom" >
			        	<div className="bell">
			        		<BellIcon width='15' active={false} animate={false} opacity={0.6}/>
			        	</div>
			        	<div>
			        		<Memo memo={this.handleMemo}/>
			        	</div>
			        	<div>
				        <button className="createButton" onClick={(e) => {this.handleSubmit(e)}}>
				        	{this.props.buttonFunction}  
				        </button>
				        </div>
		        	</div>
		      	</div>
	      	</form>
		);
	}
}
export default CreateEvent;