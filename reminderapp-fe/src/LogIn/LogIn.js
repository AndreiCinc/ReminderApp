import React, { useState, useEffect } from 'react';
import './LogIn.css';
import { Formik } from 'formik';
import * as Yup from 'yup';
import bcrypt from 'bcryptjs';
import PersonService from '../Service/PersonService.js';
import {Route, BrowserRouter as Router, Switch, Link, Redirect} from 'react-router-dom';

export default function LogIn(props) {

	const [person, setPerson] = useState({email: "", password: ""});
	const [personDetails, setPersonDetails] = useState({email: "", password: ""});
	const [personExists, setPersonExists] = useState(false);

	const saltRounds = 10;

	const handleSubmit = async (values, {setSubmitting}) => {
		const personService = await PersonService.getPersonByEmail(values.email);
		console.log(personService);
		const setDetails = await setPersonDetails({email: personService.email, password: personService.password});
		console.log(setDetails);
		const person = await setPerson({email: values.email, password: values.password});
		const redirect = () => {
			console.log(personDetails.email);
			if (personDetails.email != undefined) {
				return(
					<Redirect to="/mainPage" />
				)
			}
		};
		

		setTimeout(() => {
			setSubmitting(false);
		}, 500);
		console.log(personDetails.personPassword);
	}

	useEffect(() => {
		if (personDetails != undefined){
			bcrypt.compare(person.password, personDetails.personPassword, function(err, result) {
		   		if (!result) {
	    			alert("Wrong password");
		   		}
		   	});
		}
	})

	return(
		<>
		<div className="Title">
    			<h2>ReminderApp</h2>
    		</div>
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

					return(
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

							<button type="submit" submit="submit">
									LogIn
							</button>
							
							<div className="Register" type="submit">
								<Link to="/register" type="submit">
									<h5>Register</h5>
								</Link>
							</div>
						</form>
					);
				}}
			</Formik>
		</>
	);
}

