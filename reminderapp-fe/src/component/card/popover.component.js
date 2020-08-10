import React, { useState } from 'react';
import './card.style.css';
import Popover, { ArrowContainer } from 'react-tiny-popover';
import Moment from 'react-moment';
import 'moment-timezone';


export default function CustomComponent (props) {

	const [isPopoverOpen, setIsPopoverOpen] = useState(false);
	let name = props.title;
	let start = props.startDate;
	let end = props.endDate;
	let reminder = props.reminder;
	let details = props.details;
	
	const container = ({ position, targetRect, popoverRect})=> ( 
	    <ArrowContainer 
	    	position={position}
	    	targetRect={targetRect}
	    	popoverRect={popoverRect}
	    	arrowColor={'#d9e6f2'}
	    	padding={60}
	    	arrowSize={10}
	    	arrowStyle={{ opacity: 0.8}}
	    >
		    <div className="popoverStyle" >
		    	<div className="header">
					{name}
				</div>
				<div className="body">
					<div>
						Event starts: 
						<Moment format=" MM-DD-YYYY HH:mm" locale="ro">
               				{start}
               			</Moment>
					</div>
					<div>
						Event ends:   
						<Moment format=" MM-DD-YYYY HH:mm">
               				{end}
               			</Moment>
					</div>
					<div>
						Reminde at:   
						<Moment format=" MM-DD-YYYY HH:mm">
               				{reminder} 
               			</Moment>
					</div>
					<div>
						Details: {details}
					</div>
				</div>
		    </div>
	    </ArrowContainer>
	);

	return(
		<Popover
			isOpen={isPopoverOpen}
			position={['right']}
			onClickOutside={() => setIsPopoverOpen(!isPopoverOpen)}
			content={container}
		>
			<button 
				type="button"
				className="details-button"
				onClick={() => setIsPopoverOpen(!isPopoverOpen)}
			>
				<i className="fa fa-angle-double-right" aria-hidden="true">
				</i>
			</button>
		</Popover>
	);
}
		