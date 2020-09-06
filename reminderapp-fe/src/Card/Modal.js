import React from 'react';
import './Modal.css';
import Name from '../Input/Name.js';
import Calendar from '../Input/Calendar.js';
import Details from '../Input/Details.js';
import EventService from '../Service/EventService.js';
import Memo from '../Input/Memo.js';
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
      height                : '380px',
      width                 : '280px'

    }
  };

class updateEvent extends React.Component{
  constructor(props) {
    super(props);
    this.state = {
      eventName: props.name,
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
    this.setState({eventName: e.target.value});
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
          <Name name={this.state.eventName} handlerName={this.handlerName} />
          
          <Calendar 
            type="submit" 
            handlerDate={this.handleStartDate} 
            date={this.state.startDate}
            labelDate={"Start date"}
            labelTime={"Start time"}
          />
          
          <Calendar 
            type="submit"
            handlerDate={this.handleEndDate} 
            date={this.state.endDate}
            labelDate={"End date"}
            labelTime={"End time"}
          />
          
          <Details name="details" style={{'margin-top': '25px'}} value={this.state.details} handleDetails={this.handleDetails}/>
         
          <Memo memo={this.handleMemo}/>

          <button className="updateButton" onClick={(e) => {this.handleSubmit(e)}}>
            Update
          </button>
              
        </Modal>
      </>
    );
  }
}

export default updateEvent;