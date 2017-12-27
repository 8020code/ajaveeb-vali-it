	
// 1. This is default post method, in html: method="post" (all filled form values go to Database)
$('form').submit(function(event) {
		event.preventDefault();
		var newBlogJson = $(this).serializeFormJSON();
		var newBlogData = JSON.stringify(modifyPostStateInJson(newBlogJson)); // was modifyTagInJson(newBlogJson)
		console.log(newBlogData);
		
		$.ajax({url: "http://localhost:8080/Ajaveeb/rest/blogs",
			cache: false,
			type: 'POST',
			data:newBlogData,
			success: function (newBlogData){
				location.reload();
			},
			error: function(XMLHttpRequest, textStatus, errorThrown){
				console.log("Status: " + textStatus);
				console.log("Error: " + errorThrown);
			},
			contentType: "application/json; charset=utf-8"
		});
	});
	
	function modifyPostStateInJson(newBlogJson){ // supporting function for upper one!
		var modifiedJson = newBlogJson;
		modifiedJson.postState = {"postStateId": newBlogJson.postState};//? here was id
		return modifiedJson;
	}
	
	
//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>	
			
			
// 2. functions for edit form start 23.02.2017 10:12, not finished yet ( put method isn't working somehow...)
function editFormAjax() {
	var editBlogJson = $("#editFormHtml").serializeFormJSON();
	var editBlogData = JSON.stringify(modifyPostStateInJsonEdit(editBlogJson)); // was modifyTagInJson(newBlogJson)
	console.log(editBlogData);
	
	$.ajax({url: "http://localhost:8080/Ajaveeb/rest/blogs",
		cache: false,
		type: 'PUT',
		data:editBlogData,
		success: function (editBlogData){
			location.reload();
		},
		error: function(XMLHttpRequest, textStatus, errorThrown){
			document.write(editBlogJson.blogId);
			console.log("Status: " + textStatus);
			console.log("Error: " + errorThrown);
		},
		contentType: "application/json; charset=utf-8"
	});
};

function modifyPostStateInJsonEdit(editBlogJson){ // supporting function for upper one!
	var modifiedJsonEdit = editBlogJson;
	modifiedJsonEdit.postState = {"postStateId": editBlogJson.postState};//? here was id
	return modifiedJsonEdit;
}
			
//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>		
			
// 3. After onClick event selected value in drop down menu will be deleted in Database
function deletePostById(){ 
	var deleteBlogJson = $("#deletePostForm").serializeFormJSON();
	console.log(deleteBlogJson);

	$.ajax({
		url: "http://localhost:8080/Ajaveeb/rest/blogs/"+ deleteBlogJson.blogId, //name = "blogId" in form
		cache: false,
		type: 'DELETE',
		success: function (){
			location.reload();//delete blog to add here
		},
		error: function(XMLHttpRequest, textStatus, errorThrown){
			console.log("Status: " + textStatus);
			console.log("Error: " + errorThrown);
		}
	});
};
			
			
			
// 4.  This function is for Login form
function loginAjax(){ 
	var loginValue = $("#username")[0].value + $("#password")[0].value; // check what is important here, name or id, both have the same name btw
	
	$.ajax({
		url: "http://localhost:8080/Ajaveeb/rest/login/" + loginValue, //name = "blogId" in form
		cache: false,
		type: 'GET',
		success: function (loginResponseValueList){
			//console.log(loginResponseValueList);
			if(loginResponseValueList[0].value ="loginValue" ){
				return mainLogin('mainClient','mainPublic');	
			}
		},
		error: function(XMLHttpRequest, textStatus, errorThrown){
			console.log("Status: " + textStatus);
			console.log("Error: " + errorThrown);
		}
	});
};
			
			
//	5. This function activates ajax for Client search button 	
function someIdClient(){
	var searchBlogValue = $("#blogSearchClient")[0].value;
	
	$.ajax({
		url: "http://localhost:8080/Ajaveeb/rest/search/" + searchBlogValue, //name = "blogId" in form
		cache: false,
		type: 'GET',
		success: function (searchResponseValueList){
			console.log(searchResponseValueList);

			var searchResult = "";
			for (var i = searchResponseValueList.length; i > 0; i--) {
				searchResult = searchResult + "<ul><li><h2>"
				+ searchResponseValueList[i-1].blogId + "</h2></li><li>"
				+ searchResponseValueList[i-1].blogContent
				+ "</li></ul>";
			}	
			// clearFields(); not working
		document.getElementById("searchResultsClient").innerHTML = searchResult;
		},
		error: function(XMLHttpRequest, textStatus, errorThrown){
			console.log("Status: " + textStatus);
			console.log("Error: " + errorThrown);
		}
	});
};

//function clearFields() { // added - to clear html forms 
//
//    document.getElementById("blogSearch").value = "";
//}
			
// 6. This function activates ajax for Public search button
function someIdPublic(){ 
	var searchBlogValue = $("#blogSearch")[0].value;
		
	$.ajax({
		url: "http://localhost:8080/Ajaveeb/rest/search/" + searchBlogValue, //name = "blogId" in form
		cache: false,
		type: 'GET',
		success: function (searchResponseValueList){
			console.log(searchResponseValueList);

			var searchResult = "";
			for (var i = searchResponseValueList.length; i > 0; i--) {
				searchResult = searchResult + "<ul><li><h2>"
				+ searchResponseValueList[i-1].blogId + "</h2></li><li>"
				+ searchResponseValueList[i-1].blogContent
				+ "</li></ul>";
			}	
			
		document.getElementById("searchResultsPublic").innerHTML = searchResult;
		},
		error: function(XMLHttpRequest, textStatus, errorThrown){
			console.log("Status: " + textStatus);
			console.log("Error: " + errorThrown);
		}
	});
};
	


// 7. Serialization function to create standard format		
(function($) {
	$.fn.serializeFormJSON = function() {
		var o = {};
		var a = this.serializeArray();
		$.each(a, function() {
			if (o[this.name]) {
				if (!o[this.name].push) {
					o[this.name] = [ o[this.name] ];
				}
				o[this.name].push(this.value || '');
			} else {
				o[this.name] = this.value || '';
			}
		});
		return o;
	};
})(jQuery);