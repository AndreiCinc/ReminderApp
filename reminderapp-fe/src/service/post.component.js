import React, { Component } from 'react';
import PostService from './CardService.js';

export default class postRequest extends React.Component {
	constructor(props) {
		super(props)

		this.state = {
			name: "",
    		startDate: "",
		    endDate: "",
		    details: "",
		}
	}

	changeHandler = e => {
		this.setState({[e.target.name]: e.target.value});
	}

	submitHandler = e => {
		PostService.postEvent(this.state);
		e.preventDefault();
	}

	render() {

		return(<div></div>)
	}
	}