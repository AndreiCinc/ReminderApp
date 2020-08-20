import React from 'react';
import './CreateEvent.css';
import Name from '../Input/Name.js';
import Calendar from '../Input/Calendar.js';
import Details from '../Input/Details.js';
import EventService from '../Service/EventService.js';
import Memo from '../Input/Memo.js';
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
		console.log(e.target.value);
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
		}else {
			EventService.postEvent(this.state)
		}
		e.preventDefault();
	}

	render() {
		return(
			<form className="Create-event" onSubmit={(e) => {this.handleSubmit(e)}}>
			
					<div>
			        	<Name name={'Insert event name'} handlerName={this.handlerName} />
		        	</div>

		        	<div className="date">
		         		<Calendar 
		         			type="submit" 
		         			handlerDate={this.handleStartDate} 
		         			date={this.state.startDate}
		         			labelDate={"Start date"}
		         			labelTime={"Start time"}
		         		/>
		        	</div>

		        	<div className="date">
		        		<Calendar 
		        			type="submit"
		        			handlerDate={this.handleEndDate} 
		        			date={this.state.endDate}
		        			labelDate={"End date"}
		         			labelTime={"End time"}
		         		/>
		        	</div>

		        	<div className="text">
		        		<Details type="submit" handleDetails={this.handleDetails}/>
		        	</div>

			        <div className="bottom" >
			        	<div className="bell">
			        		<BellIcon width='15' active={false} animate={false} opacity={0.6}/>
			        	</div>
			        	<div className="memo">
			        		<Memo memo={this.handleMemo}/>
			        	</div>
			        	<div>
				        <button className="createButton" onClick={(e) => {this.handleSubmit(e)}}>
				        	Create  
				        </button>
				        </div>
		        	</div>
		        	
	      	</form>
		);
	}
}
export default CreateEvent;