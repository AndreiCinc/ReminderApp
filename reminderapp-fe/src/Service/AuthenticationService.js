import axios from 'axios';

const api_url_authentication = "http://localHost:8080/authentication/authenticate/";

const authentication = { 

	authenticate(user) {
		
       return axios.post(api_url_authentication, user)
		.then(response => {return response.data})
		.catch(error => alert('Email or password incorrect!'));
    }, 
}

export default authentication;