
const eventService = {

	postEvent(value){

		fetch("http://localhost:8080/event/create/" ,
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

	putEvent(value, id) {

		fetch("http://localhost:8080/event/" + id + "/update" ,
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

	getEvents() {
       return fetch("http://localhost:8080/event/all/")
		.then((response) => response.json())
		.then((response) => {
			return response;
		});
    }, 
    
    getEventsByPersonId(personId) {
       return fetch("http://localhost:8080/event/" + personId + "/selectByPerson" )
		.then((response) => response.json())
		.then((response) => {
			return response;
		});
    }, 

    deleteEvent(id) {
        fetch("http://localhost:8080/event/" + id + "/delete",
		{
			method: 'DELETE',
		})
		.catch(err => {
	         console.log('Type send failed', err);
		});
    }
};

export default eventService;