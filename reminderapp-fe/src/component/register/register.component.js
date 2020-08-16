import React, { useState, useEffect } from 'react';
import './register.style.css';
import PersonService from '../../service/personService.js';
import bcrypt from 'bcryptjs';
import { Formik } from 'formik';
import * as Yup from 'yup';



function Register(props) {

	const [person, setPerson] = useState({
									name: "",
									email: "",
									password: "",
									observations: "",
									role: ""
								});

	const saltRounds = 10;
	const handleSubmit = (values, {setSubmitting}) => {
		bcrypt.genSalt(saltRounds, function(err, salt) {
   			bcrypt.hash(values.password, salt, function(err, hash) {
   				setPerson({name: values.name, email: values.email, password: hash});
		    });
		});
		setTimeout(() => {
					setSubmitting(false);
				}, 500);
	}
	useEffect(() => {
		PersonService.postPerson(person);
	});
	return(
		<Formik
			initialValues={{passwordConfirmation: "" }, { name: "", email: "", password: ""}}
			onSubmit={(values, {setSubmitting }) => handleSubmit(values, {setSubmitting})}
			validationSchema={Yup.object().shape({
				name: Yup.string()
					.required("Required"),
		    	email: Yup.string()
		        	.email()
		        	.required("Required"),
		      	password: Yup.string()
		        	.required("No password provided.")
		        	.min(8, "Password is too short - should be 8 chars minimum.")
		        	.matches(/(?=.*[0-9])/, "Password must contain a number."),
		        passwordConfirmation: Yup.string()
     				.oneOf([Yup.ref('password'), null], 'Passwords must match')
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

						<label htmlFor="name">Name</label>
						<input
							id="name"
							name="name"
							type="text"
							placeholder="Enter your name"
							value={values.name}
							onChange={handleChange}
							onBlur={handleBlur}
							className={errors.name && touched.name & "errors"}
						/>
						{errors.name && touched.name && (
							<div className="input-feedback">{errors.name}</div>
							)
						}

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

						<input 
							id="passwordConfirmation"
							name="passwordConfirmation"
							type="password"
							placeholder="Enter your password"
							value={values.passwordConfirmation}
							onChange={handleChange}
							onBlur={handleBlur}
							className={errors.passwordConfirmation && touched.passwordConfirmation & "errors"}
						/>
						{errors.passwordConfirmation && touched.passwordConfirmation && (
  							<div className="input-feedback">{errors.passwordConfirmation}</div>
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

export default Register;

