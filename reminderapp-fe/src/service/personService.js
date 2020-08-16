
const personService = {

	postPerson(value){
		console.log(value);
		fetch("http://localhost:8080/person/" ,
		{
			method: 'POST',
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

	putPerson(value, id) {
		fetch("https://localhost:8080/person/" + id ,
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
       return fetch("https://localhost:8080/person/getAll/")
		.then((response) => response.json())
		.then((response) => {
			return response;
		});
    }, 
    
    deletePerson(value) {
        fetch("https://localhost:8080/person/" + value,
		{
			method: 'DELETE',
		})
		.catch(err => {
	         console.log('Type send failed', err);
		});
    }
};

export default personService;