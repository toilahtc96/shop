$(document).ready(function() {
	var currentPage = $("#paginatorForm\\:pageCurrent").val();
	goPage = function(a, page) {
		var divNavigation = $(a).parent();
		var aList = $(divNavigation).find("a");
		for (var i = 0; i < $(aList).length; i++) {
			$(aList[i]).attr("class", "");
			if ($(aList[i]).text() == page) {
				$(aList[i]).attr("class", "active");
				$("#paginatorForm\\:pageCurrent").val(i);
			}
		}
		return false;
	};

	goPrev = function(a) {
		var divNavigation = $(a).parent();
		var aList = $(divNavigation).find("a");
		var prevPage = 1;
		for (var i = 0; i < $(aList).length; i++) {
			var attrClass = $(aList[i]).attr("class");
			if ($(aList[i]).attr("class") == 'active') {
				prevPage = i;
			}
		}
		if (prevPage > 1) {
			prevPage = prevPage - 1;
		}
		for (var i = 0; i < $(aList).length; i++) {
			$(aList[i]).attr("class", "");
			if (prevPage == i) {
				$(aList[i]).attr("class", "active");
				$("#paginatorForm\\:pageCurrent").val(i);
			}
		}
		return true;
	}
	goNext = function(a, max) {
		var divNavigation = $(a).parent();
		var aList = $(divNavigation).find("a");
		var nextPage = max;
		for (var i = 0; i < $(aList).length; i++) {
			var attrClass = $(aList[i]).attr("class");
			if ($(aList[i]).attr("class") == 'active') {
				nextPage = aList[i].text;
				console.log(nextPage);
			}
		}
		if (nextPage < max) {
			console.log("+");
			console.log(nextPage);
			nextPage = 1 + parseInt(nextPage);
			console.log("x" + nextPage);
			$("#paginatorForm\\:pageCurrent").val(nextPage);
		}
		for (var i = 0; i < $(aList).length; i++) {
			$(aList[i]).attr("class", "");
		}
		console.log("length: " + $(aList).length);
		console.log("nextPage" + nextPage);
		for (var i = 0; i < $(aList).length; i++) {
			if (nextPage == i) {
				$(aList[i]).attr("class", "active");
			}
		}
		return true;
	}
	
	function handleAjax(data) {
		
		var status = data.status;

		switch (status) {
		case "begin":
			// This is the start of the AJAX request.
			console.log("begin");
			document.getElementsByTagName('body')[0].className = 'loading';
			break;

		case "complete":
			console.log("complete");
			// This is invoked right after AJAX response is
			// returned.
			break;

		case "success":
			console.log("success");
			// This is invoked right after successful processing
			// of AJAX response and update of HTML DOM.
			document.getElementsByTagName('body')[0].className = 'loading';
			break;
		}
	}
	// Setup the statusUpdate function to hear all events on the
	// page
	jsf.ajax.addOnEvent(handleAjax);
	
});