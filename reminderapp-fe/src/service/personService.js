
const api_url_user = "https://reminderapp2.herokuapp.com/";

const personService = {

	postPerson(person){
		
		return fetch(api_url_user + "create/", {
			
			method: 'post',
			headers: {
				'Content-Type': 'application/json' ,
	 		},
	 		dataType: "json",
			body: JSON.stringify(person),
		})
		.then(response => { return response})
		.catch(err => {
	        alert("Email already exists!");
		});
	},

	putPerson(value, id) {

		return fetch(api_url_user + id + "/update" ,
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

       return fetch(api_url_user + "all/")
		.then((response) => response.json())
		.then((response) => {
			return response;
		});
    },

    getPersonByEmail(email) {

       return fetch(api_url_user + email + "/select")
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
    	
        fetch(api_url_user + value + "/delete" ,
		{
			method: 'DELETE',
		})
		.catch(err => {
	         console.log('Type send failed', err);
		});
    },
};

export default personService;