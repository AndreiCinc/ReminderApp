//I should be an layar that contains one form with 2 inputs, a link to a register page and login button

// the layer should have width as list plus create event and should be positioned on top of those;
import React, { useState, useEffect } from 'react';
import './logIn.style.css';
import { Formik } from 'formik';
import * as Yup from 'yup';
import bcrypt from 'bcryptjs';
import PersonService from '../../service/personService.js';
import {Route, BrowserRouter as Router, Switch, Link, Redirect} from 'react-router-dom';



function LogIn(props) {

	const [person, setPerson] = useState({email: "", password: ""});
	const [personDetails, setPersonDetails] = useState();

	const saltRounds = 10;

	const handleSubmit = async (values, {setSubmitting}) => {
		const person = await PersonService.getPersonByEmail(values.email)
		const set = await setPersonDetails(person);
		const personSet = await setPerson({email: values.email, password: values.password})

		setTimeout(() => {
					setSubmitting(false);
				}, 500);
	}

	useEffect(() => {
		if (personDetails != undefined){
			bcrypt.compare(person.password, personDetails.personPassword, function(err, result) {
		   		if (!result) {
	    			alert("Wrong password");
		   		}else {
		   			return(
		   				<Redirect to="/mainPage" />
		   			)
		   		}
		   	});
		}
	})

	return(
		<Formik
			initialValues={{ email: "", password: ""}}
			onSubmit={(values, {setSubmitting }) => handleSubmit(values, {setSubmitting})}
			validationSchema={Yup.object().shape({
		    	email: Yup.string()
		        	.email()
		        	.required("Required"),
		      	password: Yup.string()
		        	.required("No password provided.")
		        	.min(8, "Password is too short - should be 8 chars minimum.")
		        	.matches(/(?=.*[0-9])/, "Password must contain a number.")
		    })}
		>
			{props => {
				const {
					values,
					touched,
					errors,
					isSubmitting,
					handleChange,
					handleBlur,
					handleSubmit
				} = props;

				return (
					<form onSubmit={handleSubmit}>

						<label htmlFor="email">Email</label>
						<input
							id="email"
							name="email"
							type="text"
							placeholder="Enter your email"
							value={values.email}
							onChange={handleChange}
							onBlur={handleBlur}
							className={errors.email && touched.email & "errors"}
						/>
						{errors.email && touched.email && (
							<div className="input-feedback">{errors.email}</div>
							)
						}
						<label htmlFor="password">Password</label>
						<input 
							id="password"
							name="password"
							type="password"
							placeholder="Enter your password"
							value={values.password}
							onChange={handleChange}
							onBlur={handleBlur}
							className={errors.password && touched.password & "errors"}
						/>
						{errors.password && touched.password && (
  							<div className="input-feedback">{errors.password}</div>
							)
						}

							<button type="submit">
								<Link to="/mainPage">
									LogIn
								</Link>
							</button>
						
						<button type="submit">
							<Link to="/register" type="submit">
								Register
							</Link>
						</button>
					</form>
				);
			}}
		</Formik>
	);
}

export default LogIn;
