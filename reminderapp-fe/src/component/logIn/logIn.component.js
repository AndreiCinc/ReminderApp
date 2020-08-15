//I should be an layar that contains one form with 2 inputs, a link to a register page and login button

// the layer should have width as list plus create event and should be positioned on top of those;
import React from 'react';
import './logIn.style.css';
import { Formik } from 'formik';
import * as EmailValidator from 'email-validator';
import * as Yup from 'yup';


function LogIn(props) {

	return(
		<Formik
			initialValues={{ email: "", password: ""}}
			onSubmit={(values, {setSubmitting }) => {
				setTimeout(() => {
					console.log("Loggin in", values);
					setSubmitting(false);
				}, 500);
			}}
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
						<button type="submit disable={isSubmitting}">
							LogIn
						</button>

					</form>
				);
			}}
		</Formik>
	);
}

export default LogIn;
