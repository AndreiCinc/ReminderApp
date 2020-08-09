import React from 'react';
import Modal from 'react-modal';
import CreateEvent from '../createEvent/createEvent.component.js';
   
Modal.setAppElement('#root')
   
export default function DetailsModal(props) {

    function onClose(e) {
      props.onClose && props.onClose(e);
    }
   
      return (
        <div>
          <Modal
            isOpen={props.isOpen}
            onRequestClose={onClose}
            style={props.style}
          >
            <CreateEvent buttonFunction={"Update"} id={props.id} onClose={onClose}/>
          </Modal>
        </div>
      );
  }