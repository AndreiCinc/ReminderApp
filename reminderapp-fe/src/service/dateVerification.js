

 const DateVerification = (date) => {
	let actualDate = new Date().toString();
	let memoDate = new Date(date).toString();
	if (memoDate === actualDate ) {
		return true;
	}
	return false;
}

export default DateVerification;
