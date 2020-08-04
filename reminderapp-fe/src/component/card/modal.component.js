import React from 'react';
import Modal from 'react-modal';
import CreateEvent from '../createEvent/createEvent.component.js';
 
  const customStyles = {
    content : {
      top                   : '50%',
      left                  : '50%',
      right                 : 'auto',
      bottom                : 'auto',
      marginRight           : '-50%',
      transform             : 'translate(-50%, -50%)'
    }
  };
   
Modal.setAppElement('#root')
   
export default function DetailsModal(props){

    function onClose(e) {
      props.onClose && props.onClose(e);
    }
   
      return (
        <div>
          <Modal
            isOpen={props.isOpen}
            onRequestClose={onClose}
            style={customStyles}
          >
            <CreateEvent buttonFunction={"Update"} id={props.id} onClose={onClose}/>
          </Modal>
        </div>
      );
  }