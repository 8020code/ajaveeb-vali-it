
// Available JSON -->[{"postStateId":1,"postStateName":"published"},{"postStateId":2,"postStateName":"draft"},{"postStateId":3,"postStateName":"deleted"}]
// This function fills 2 drop down menus (published, draft and  published, draft, deleted)

var allPostStates;
var allPostStatesEdit;
function getallPostStates(){
	$.getJSON("http://localhost:8080/Ajaveeb/rest/states",
		function(states) {//[{"postStateId":1,"postStateName":"published"},{"postStateId":2,"postStateName":"draft"}]
			allPostStates = states;
			allPostStatesEdit = states;
			addPostStatesToFormSelect();
			addPostStatesToFormSelectEdit();
		});
}
function addPostStatesToFormSelect(){ // for new post
	var options = $("#postStateSelect");
	options.prepend('<option disabled="disabled">Choose post status!</option>'); // added
	options.append($("<option />").val(allPostStates[0].postStateId).text(allPostStates[0].postStateName));
	options.append($("<option />").val(allPostStates[1].postStateId).text(allPostStates[1].postStateName));
	
}

function addPostStatesToFormSelectEdit(){ //for edit post 
	var options = $("#postStateSelectEdit");
	options.prepend('<option disabled="disabled">Choose post status!</option>'); // added
	$.each(allPostStatesEdit, function(index) {
	options.append($("<option />").val(allPostStatesEdit[index].postStateId).text(allPostStatesEdit[index].postStateName));
	});
}

getallPostStates();