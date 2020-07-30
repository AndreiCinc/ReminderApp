
const CardService = {

	postEvent: function(value) {
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

	getEvents: function() {
       return fetch('http://localhost:8080/event/ReminderApp/api/v1/event')
		.then((response) => response.json())
		.then((response) => {
			return response;
		});
    }, 
    deleteEvent: function(value) {
        fetch("http://localhost:8080/event/ReminderApp/api/v1/event/" + value,
		{
			method: 'DELETE',
		})
		.catch(err => {
	         console.log('Type send failed', err);
		});
    },
};

export default CardService;