import axios from 'axios';

const api_url_user = "http://localhost:8080/user/";

const personService = {

	postPerson(name, email, password){
		
		return axios.post(api_url_user + "create/", {
			name,
			email,
			password
		})
		.then(response => response.json())
		.then(json => {console.log(json)
		})
		.catch(err => {
	         console.log('Type send failed', err);
		});
	},

	putPerson(value, id) {
		return axios.put(api_url_user + id + "/update" ,
		{
			value
		})
		.then(response => response.json())
		.then(json => {console.log(json)
		})
		.catch(err => {
	         console.log('Type send failed', err);
		});
	},

	getPerson() {
       return axios.get(api_url_user + "all/")
		.then((response) => response.json())
		.then((response) => {
			return response;
		});
    },

    getPersonByEmail(email) {
       return axios.get(api_url_user + email + "/select")
		.then(response => response.json())
		.then(response => {
			console.log(response);
			if (response.name === undefined) {
					alert(response.message);
			}else {
				return response;
			}
		})
		.catch(error => console.log(error));
    }, 
    
    deletePerson(value) {
        fetch("http://localhost:8080/user/delete/" + value + "/delete" ,
		{
			method: 'DELETE',
		})
		.catch(err => {
	         console.log('Type send failed', err);
		});
    },
};

export default personService;