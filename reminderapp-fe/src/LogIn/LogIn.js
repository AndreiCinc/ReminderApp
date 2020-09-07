import React, { useState, useEffect } from 'react';
import './Login.css';
import { Formik } from 'formik';
import * as Yup from 'yup';
import Authentication from '../Service/AuthenticationService.js';
import Cookies from '../Service/CookiesService.js';
import {Route, BrowserRouter as Router, Switch, Link, Redirect, useHistory} from 'react-router-dom';

export default function LogIn(props) {

	const [person, setPerson] = useState({email: "", password: ""});

	const handleSubmit = async (values, {setSubmitting}) => {
		
		setPerson({email: values.email, password: values.password});
		setTimeout(() => {
			setSubmitting(false);
		}, 500);
	}

	let history = useHistory();
	
	useEffect(() => {
		if (person.email !== "" ) {
			const response = Authentication.authenticate(person)
			.then((response) => {
				if (response) {
					Cookies.setCookie("person", response);
					history.push("/")
				}
			})
		}
	})

	return(
		<>
		<div className="Title">
    			<h2>ReminderApp</h2>
    		</div>
			<Formik className="form"
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
						<form className="form" onSubmit={handleSubmit}>
							<label className="loginLable">Email</label>
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
								<div className="input-feedback">*{errors.email}</div>
								)
							}

							<label className="loginLable">Password</label>
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
	  							<div className="input-feedback">*{errors.password}</div>
								)
							}

							<button className="Login" type="submit" submit="submit">
									Login
							</button>
							<button className="Register">
								<Link to="/register">
									Register
								</Link>
							</button>
						</form>
					);
				}}
			</Formik>
		</>
	);
}

