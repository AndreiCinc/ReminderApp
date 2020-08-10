
const cardService = {

	postEvent(value){
		console.log(value);
		fetch("http://localhost:8080/event/ReminderApp/api/v1/event/" ,
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
		fetch("http://localhost:8080/event/ReminderApp/api/v1/event/" + id ,
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
       return fetch('http://localhost:8080/event/ReminderApp/api/v1/event')
		.then((response) => response.json())
		.then((response) => {
			return response;
		});
    }, 
    
    deleteEvent(value) {
        fetch("http://localhost:8080/event/ReminderApp/api/v1/event/" + value,
		{
			method: 'DELETE',
		})
		.catch(err => {
	         console.log('Type send failed', err);
		});
    }
};

export default cardService;