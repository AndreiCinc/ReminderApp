import React from 'react';
import Modal from 'react-modal';
import UpdateEvent from '../updateEvent/updateEvent.component.js';
   
Modal.setAppElement('#root')

export default function DetailsModal(props) {

    
   
      return (
        <div>
          <Modal
            isOpen={props.isOpen}
            onRequestClose={onClose}
            style={props.style}
          >
            <UpdateEvent 
              id={props.id}
              onClose={onClose}
              name={props.name}
              startDate={props.startDate}
              endDate={props.endDate}
              details={props.details}
              reminderDate={props.reminderDate}
            />
          </Modal>
        </div>
      );
  }