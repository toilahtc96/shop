$(document).ready(function() {
	console.log("1");
	$(".datepicker").datepicker({
		dateFormat : 'dd/mm/yy',
		changeMonth : true,
		changeYear : true,
		yearRange : "1965:2030"
	});
});