import axios from 'axios';

const api_url_user = "http://localhost:8080/user/";

const api_url_authentication = "http://localHost:8080/authentication/authenticate/";

const personService = {

	postPerson(person){
		
		return axios.post(api_url_user + "create/", person
		)
		.then(response => { return response})
		.catch(err => {
	        alert("Email already exists!");
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