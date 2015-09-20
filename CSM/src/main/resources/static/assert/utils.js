function convertDateToShow(date){
	var split = date.split('-');
	return split[2] + '/' + split[1] + '/' + (parseInt(split[0])+543).toString();
}