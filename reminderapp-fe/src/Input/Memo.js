import React,  {useState } from 'react';

export default function Memo(props) {

	const [time, setTime] = useState(props.value);

	const handleValue = (event) => {
		setTime(event.target.value);
		props.memo(event);
	}

	return (
		<select id="inputState" value={time} onChange={handleValue} className="form-control">
			<option value="0">When it starts</option>
			<option value="30">30 min before</option>
		    <option value="60">60 min before</option>
		    <option value="120">120 min before</option>
		    <option value="180">180 min before</option>
		</select>
	);
}