
const personService = {

	postPerson(value){
		
		console.log(value);
		fetch("http://localhost:8080/user/create/" ,
		{
			method: 'POST',
			headers: {
	 		   "Content-Type" : "application/JSON" ,
	 		},
	 		dataType: "json",
			body: JSON.stringify(value),
		})
		.then(response => response.json())
		.then(response => {
			if (response.message) {
				alert(response.message);
			}
		})
		.catch(function(error) {
  			console.error('Error:', error);
		});
	},

	putPerson(value, id) {
		fetch("http://localhost:8080/user/" + id + "/update" ,
		{
			method: 'PUT',
			headers: {
	 		   "Content-Type" : "application/JSON" ,
	 		},
	 		dataType: "json",
			body: JSON.stringify(value),
		})
		.then(response => response.json())
		.then(json => {console.log(json)
		})
		.catch(err => {
	         console.log('Type send failed', err);
		});
	},

	getPerson() {
       return fetch("http://localhost:8080/user/all/")
		.then((response) => response.json())
		.then((response) => {
			return response;
		});
    },

    getPersonByEmail(email) {
       return fetch("http://localhost:8080/user/" + email + "/select")
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
        fetch("http://localhost:8080/user/" + value + "/delete" ,
		{
			method: 'DELETE',
		})
		.catch(err => {
	         console.log('Type send failed', err);
		});
    }
};

export default personService;