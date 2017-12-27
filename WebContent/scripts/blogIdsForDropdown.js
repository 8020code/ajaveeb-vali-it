// {"blogId":82,"blogName":"Viies","blogContent":"Riis","postState":{"postStateId":1,"postStateName":"published"},"tagsFromPost":"mais"}, etc.
var allBlogsIdsList

function getallBlogsIdsList() {
	$.getJSON("http://localhost:8080/Ajaveeb/rest/blogs",
		function(blogsIds) {
		allBlogsIdsList = blogsIds
		addBlogIdtoFormSelect();
		addBlogIdtoDeleteFormSelect();
		addBlogIdtoFormSelectEdit();
		});
}

// Comment: this adds blog id's to dropdown list, where we use it???
function addBlogIdtoFormSelect(){  
	var options = $("#blogIdDropDown");
	$.each(allBlogsIdsList, function(index) {
	    options.append($("<option />").val(allBlogsIdsList[index].blogId).text(allBlogsIdsList[index].blogId)); 
	});
}		

// Comment: this adds blog id's to dropdown list to Edit form
function addBlogIdtoFormSelectEdit(){  
	var options = $("#blogIdDropDownEdit");
	options.prepend('<option disabled="disabled">Choose Post ID for edit</option>'); // added
	$.each(allBlogsIdsList, function(index) {
	    options.append($("<option />").val(allBlogsIdsList[index].blogId).text(allBlogsIdsList[index].blogId)); 
	});
}	


//Comment: this adds blog id's to dropdown to delete selected post from Database
function addBlogIdtoDeleteFormSelect(){  
	var options = $("#blogIdDropDownDelete");
	options.prepend('<option disabled="disabled">Choose Post ID for delete</option>');// added
	$.each(allBlogsIdsList, function(index) {
	    options.append($("<option />").val(allBlogsIdsList[index].blogId).text(allBlogsIdsList[index].blogId)); 
	});
}

getallBlogsIdsList();