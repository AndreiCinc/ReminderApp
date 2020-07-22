import React, { Component } from 'react';
import './details.style.css';

export default function details() {

	return (
		<div class="form-group blue-border inline">
		  <label for="exampleFormControlTextarea4">Details: </label>
		  <textarea class="form-control" id="exampleFormControlTextarea4" rows="3"></textarea>
		</div>
	);
}