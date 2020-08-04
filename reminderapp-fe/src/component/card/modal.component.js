import React from 'react';
import ReactDOM from 'react-dom';
import Modal from 'react-modal';
 
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
      !props.onClose && props.onClose(e);
    }
   
      return (
        <div>
          <Modal
            isOpen={false}
            onRequestClose={onClose}
            style={customStyles}
          >
            <h2>Hello, {props.title}</h2>
            <button className={"closeButton"} onClick={onClose}>close</button>
            <div>I am a modal</div>
          </Modal>
        </div>
      );
  }