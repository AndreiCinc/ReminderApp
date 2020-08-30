import Cookie from '../Service/CookiesService.js';

const eventService = {

	postEvent(value){

		fetch("https://reminderapp5.herokuapp.com/event/ReminderApp/api/v1/event/" ,
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
		fetch("https://reminderapp5.herokuapp.com/event/ReminderApp/api/v1/event/" ,
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
    
    getEventsByPersonId() {

    	let cookie = Cookie.getCookie();
      	return fetch("http://localhost:8080/event/selectByPerson/", {
	       	method: 'get',
	       	headers: { 
	       		'person' : cookie
	       	},
	    })
       	.then((response) => response.json())
		.then((response) => {
			return response;
		});
    }, 

    deleteEvent(id) {
        fetch("https://reminderapp5.herokuapp.com/event/ReminderApp/api/v1/event/" + id,
		{
			method: 'DELETE',
		})
		.catch(err => {
	         console.log('Type send failed', err);
		});
    }
};

export default eventService;