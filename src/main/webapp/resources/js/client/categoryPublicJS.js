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
		return false;
	}
	goNext = function(a, max) {
		var divNavigation = $(a).parent();
		var aList = $(divNavigation).find("a");
		var nextPage = max;
		for (var i = 0; i < $(aList).length; i++) {
			var attrClass = $(aList[i]).attr("class");
			if ($(aList[i]).attr("class") == 'active') {
				nextPage = i;
			}
		}
		if (nextPage < max) {
			nextPage = nextPage + 1;
		}
		for (var i = 0; i < $(aList).length; i++) {
			$(aList[i]).attr("class", "");
			if (nextPage == i) {
				if (i == $(aList).length - 1) {
					$(aList[i - 1]).attr("class", "active");
					$("#paginatorForm\\:pageCurrent").val(i-1);
				} else {
					$(aList[i]).attr("class", "active");
					$("#paginatorForm\\:pageCurrent").val(i);
				}
			}
		}
		return true;
	}
});