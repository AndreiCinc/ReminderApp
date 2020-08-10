

 const DateVerification = (date) => {
	let actualDate = new Date().toString();
	let memoDate = new Date(date).toString();
	console.log(actualDate);
	console.log(memoDate);
	if (memoDate === actualDate ) {
		return true;
	}
	return false;
}

export default DateVerification;
