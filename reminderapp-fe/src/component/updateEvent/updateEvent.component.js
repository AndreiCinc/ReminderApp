import React from 'react';
import Name from '../input/title.component.js';
import Calendar from '../input/calendar.component.js';
import Details from '../input/details.component.js';
import EventService from '../../service/eventService.js';
import Memo from '../input/memo.component.js';
import BellIcon from 'react-bell-icon';
import Modal from 'react-modal';

Modal.setAppElement('#root')

  export const updateModal = {
    content : {
      top                   : '50%',
      left                  : '50%',
      right                 : '',
      bottom                : '',
      marginRight           : '-50%',
      transform             : 'translate(-50%, -50%)',
      height                : '400px'
    }
  };

class updateEvent extends React.Component{
	constructor(props) {
		super(props);
		this.state = {
			name: props.name,
			startDate: new Date(props.startDate),
			endDate: new Date(props.endDate),
			details: props.details,
			reminderDate: props.reminderDate,
			openModal: false,
		}
	}

	onClose = (e) => {
      this.props.onClose && this.props.onClose(e);
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
		this.setState({details: value});
	}
	handleMemo = e => {
		let date = e.target.value;
		let memoDate = new Date(this.state.startDate.getTime()) - (date * 60000);
		let newDate = new Date(memoDate);
		this.setState({reminderDate: newDate});
	}
	handleSubmit = (e) => {
		console.log(this.state);
		this.setState({openModal: !this.state.openModal});
		EventService.putEvent(this.state, this.props.id);
		e.preventDefault();
	}
	handlerModal = (e) => {
		this.setState({openModal: !this.state.openModal});
	}
	render() {
		return(
			<>
			<button className="update-button" onClick={(e) => this.handlerModal(e)}>
						<i className="fa fa-cog">
						</i>
			</button>
			<Modal
			key={this.props.id}
            isOpen={this.state.openModal}
            onRequestClose={this.handlerModal}
            style={updateModal}
          	>
				<form onSubmit={(e) => {this.handleSubmit(e)}}>
					<div className="Create-event">
						<div>
				        	<Name name={this.state.name} handlerName={this.handlerName} />
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
			        		<Details type="submit" handleDetails={this.handleDetails} value={this.state.details}/>
			        	</div>
				        <div className="bottom" >
				        	<div className="bell">
				        		<BellIcon width='15' active={false} animate={false} opacity={0.6}/>
				        	</div>
				        	<div>
				        		<Memo memo={this.handleMemo} value={this.state.reminderDate}/>
				        	</div>
				        	<div>
					        <button className="createButton" onClick={(e) => {this.handleSubmit(e)}}>
					        	Update 
					        </button>
					        </div>
			        	</div>
			      	</div>
		      	</form>
	      	</Modal>
	      	</>
		);
	}
}

export default updateEvent;