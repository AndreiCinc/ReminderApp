import Cookie from '../Service/CookiesService.js';

const eventService = {

	postEvent(value) {

		let cookie = Cookie.getCookie();
		fetch("http://localhost:8080/event/create/" ,
		{
			method: 'post',
			headers: {
				"content-type": "application/json",
	 		   	"person" : cookie
	 		},
	 		dataType: "json",
			body: JSON.stringify(value),
		})
		.then(response => response.json())
		.catch(err => {
	         console.log('Type send failed', err);
		});
	},

	putEvent(value, id) {
		let cookie = Cookie.getCookie();
		fetch("https://reminderapp5.herokuapp.com/event/ReminderApp/api/v1/event/" ,
		{
			method: 'PUT',
			headers: {
	 		   "Content-Type" : cookie ,
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