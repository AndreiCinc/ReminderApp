import Cookie from '../Service/CookiesService.js';

const cookie = Cookie.getCookie();

const eventService = {


	postEvent(value) {

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

		fetch("http://localhost:8080/event/" + id + "/update" ,
		{
			method: 'PUT',
			headers: {
	 		   'Content-Type': 'application/json' ,
	 		   "person" : cookie
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

       	return fetch("http://localhost:8080/event/all/", {
       		method: 'GET',
			headers: {
	 		   'Content-Type': 'application/json' ,
	 		   "person" : cookie
	 		},
       })
		.then((response) => response.json())
		.then((response) => {
			return response;
		});
    }, 
    
    getEventsByPersonId() {

      	return fetch("http://localhost:8080/event/selectByPerson/", {
	       	method: 'GET',
			headers: {
	 		   'Content-Type': 'application/json' ,
	 		   "person" : cookie
	 		},
	    })
       	.then((response) => response.json())
		.then((response) => {
			return response;
		});
    }, 

    deleteEvent(id) {

        fetch("http://localhost:8080/event/" + id + "/delete",
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