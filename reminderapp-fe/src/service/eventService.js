import Cookie from '../Service/CookiesService.js';

const host = "https://reminderapp2.herokuapp.com/event/";

const eventService = {


	postEvent(value) {

		let cookie = Cookie.getCookie();
		return fetch(host + "create/" ,
		{
			method: 'post',
			headers: {
				'Content-Type': 'application/json' ,
	 		   	'person' : cookie
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
		return fetch(host + id + "/update" ,
		{
			method: 'PUT',
			headers: {
				'Content-Type': 'application/json' ,
	 		   	'person' : cookie
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

		let cookie = Cookie.getCookie();
       	return fetch(host + "all/", {       		
       		method: 'GET',
			headers: {
				'Content-Type': 'application/json' ,
	 		   	'person' : cookie
	 		},
       })
		.then((response) => response.json())
		.then((response) => {
			return response;
		});
    }, 
    
    getEventsByPersonId() {

    	let cookie = Cookie.getCookie();
      	return fetch(host + "selectByPerson/", {
	       	method: 'GET',
			headers: {
				'Content-Type': 'application/json' ,
	 		   	'person' : cookie
	 		},
	    })
       	.then((response) => response.json())
		.then((response) => {
			return response;
		});
    }, 

    deleteEvent(id) {

    	let cookie = Cookie.getCookie();
        fetch(host + id + "/delete",
		{
			method: "DELETE",
			headers: {
	 		   	'Content-Type': 'application/json' ,
	 		   	"person" : cookie
	 		},
		})
		.catch(err => {
	         console.log('Type send failed', err);
		});
    }
};

export default eventService;