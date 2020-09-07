import axios from 'axios';

const api_url_authentication = "https://reminderapp2.herokuapp.com/authentication/authenticate/";

const authentication = { 

	authenticate(user) {
		
       return axios.post(api_url_authentication, user)
		.then(response => {return response.data})
		.catch(error => alert('Email or password incorrect!'));
    }, 
}

export default authentication;