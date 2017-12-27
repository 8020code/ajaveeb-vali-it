
	
// 1. This function filter out 5 last posts from available Json, results can print out in html, using names inside  " " marks
function getAllBlogsNonTabClient() {
	$.getJSON("http://localhost:8080/Ajaveeb/rest/blogs",
		function(blogs) {
			var tableContent = "";
			var pickColor = "";
			//[{"blogId":1,"blogName":"fff","blogContent":"ddd","postState":{"postStateId":1,"postStateName":"published"},"tagsFromPost":"ffd"}					
			if(blogs.length <= 5) {
				for (var i = blogs.length; i > 0; i--) {
					
					pickColor = (blogs[i-1].postState.postStateName === "draft") ? "blue":"anotherColor" // if not draft then activates if loop where are 2 color options
						if(pickColor === "anotherColor"){
							pickColor = (blogs[i-1].postState.postStateName === "published") ? "green":"red"// 
						}
					tableContent = tableContent
					+ "<ul><li>"
					+ blogs[i-1].blogName.fontsize(6)														 // Blog Header
					+ "</li><br><li>" 			   	
					+ blogs[i-1].blogContent			   			  										 // Blog Content
					+ "</li><li><i>"
					+ blogs[i-1].tagsFromPost.fontcolor("black").link("https://en.wikipedia.org	")		     // Blog Tags (separated by commas)
					+ "</i></li><li>"
					+ blogs[i-1].postState.postStateName.fontcolor(pickColor).bold()    					 // Blog State ( draft or published) str1.localeCompare(str2);
					+ "</i></li><li>"
					+ "<br><br>" + " *** " + "<br><br>"
					+ "</li></ul>";
				}
			}											
			else{
				for (var i = blogs.length; i > blogs.length-5; i--) {
							
					pickColor = (blogs[i-1].postState.postStateName === "draft") ? "blue":"anotherColor" // if not draft then activates if loop where are 2 color options
						if(pickColor === "anotherColor"){
							pickColor = (blogs[i-1].postState.postStateName === "published") ? "green":"red"// 
						}	
					tableContent = tableContent
					+ "<ul><li>"
					+ blogs[i-1].blogName.fontsize(6)
					+ "</li><br><li>" 
					+ blogs[i-1].blogContent
					+ "</li><li>"
					+ blogs[i-1].tagsFromPost.fontcolor("black").link("https://en.wikipedia.org")
					+ "</li><li><i>"										
					+ blogs[i-1].postState.postStateName.fontcolor(pickColor).bold()
					+ "</i></li><li>"
					+ "<br><br>" + " *** " + "<br><br>"
					+ "</li></ul>";
				}	
			}					
			document.getElementById("blogTableBodyNonTabClient").innerHTML = tableContent; // to client view
		});
}
		
// 2. This function filter out all posts from available Json, results can print out in html, using names inside  " " marks
		function getAllBlogsNonTabAllClient() {
			$.getJSON("http://localhost:8080/Ajaveeb/rest/blogs",
				function(blogs) {
					var tableContent = "";
					var pickColor = "";
						for (var i = blogs.length; i > 0; i--) {
							pickColor = (blogs[i-1].postState.postStateName === "draft") ? "red":"green" //added
							tableContent = tableContent
							+ "<ul><li><h2>"
							+ blogs[i-1].blogId + ": " + blogs[i-1].blogName
							+ "</h2></li><li>"
							+ blogs[i-1].blogContent
							+ "</li><li>"
							+ blogs[i-1].tagsFromPost.fontcolor("black").link("https://en.wikipedia.org")
							+ "</li><li><i>"										
							+ blogs[i-1].postState.postStateName.fontcolor(pickColor).bold() 
							+ "</i></li><li>"
							+ "<br><br>" + " *** "+ "<br><br>"
							+ "</li></ul>";
						}										
					document.getElementById("blogTableBodyNonTabAllClient").innerHTML = tableContent; // to client view
				});
		}
		
		

	
		// 1.1. For public view we don't print out post states, later optimize this code
		function getAllBlogsNonTab() {
			$.getJSON("http://localhost:8080/Ajaveeb/rest/blogs",
				function(blogs) {
					var tableContent = "";
					//[{"blogId":1,"blogName":"fff","blogContent":"ddd","postState":{"postStateId":1,"postStateName":"published"},"tagsFromPost":"ffd"}					
					if(blogs.length <= 5) {
						for (var i = blogs.length; i > 0; i--) {
							test = "blogs[i-1].tagsFromPost";
							test = test.valueOf();
							tableContent = tableContent
							+ "<ul><li>"
							+ blogs[i-1].blogName.fontsize(6)						  			    		    	// Blog Header
							+ "</li><br><li>" 			   
							+ blogs[i-1].blogContent			   			 						   			    // Blog Content
							+ "</li><li><i>"
							+ blogs[i-1].tagsFromPost.fontcolor("black").link("https://en.wikipedia.org")	        // Blog Tags (separated by commas)
							+ "</i></li><li>"
							+ "<br><br>" + " *** " + "<br><br>"
							+ "</li></ul>";
						}
					}											
					else{
						for (var i = blogs.length; i > blogs.length-5; i--) {
							pickColor = (blogs[i-1].postState.postStateName === "draft") ? "red":"green" //added		
							tableContent = tableContent
							+ "<ul><li>"
							+ blogs[i-1].blogName.fontsize(6)			// Blog Header
							+ "</li><br><li>" 
							+ blogs[i-1].blogContent
							+ "</li><li>"
							+ blogs[i-1].tagsFromPost.fontcolor("black").link("https://en.wikipedia.org")
							+ "</li><li><li>"
							+ "<br><br>" + " *** " + "<br><br>"
							+ "</li></ul>";
						}	
					}					
					document.getElementById("blogTableBodyNonTab").innerHTML = tableContent;  // last five posts printout
				});
		}
				
		// 2.1 This function filter out all posts from available Json, results can print out in html, using names inside  " " marks
				function getAllBlogsNonTabAll() {
					$.getJSON("http://localhost:8080/Ajaveeb/rest/blogs",
						function(blogs) {
							var tableContent = "";
							var pickColor = "";
								for (var i = blogs.length; i > 0; i--) {
									pickColor = (blogs[i-1].postState.postStateName === "draft") ? "red":"green" //added
									tableContent = tableContent
									+ "<ul><li><h2>"
									+ blogs[i-1].blogId + ": " + blogs[i-1].blogName
									+ "</h2></li><li>"
									+ blogs[i-1].blogContent
									+ "</li><li>"
									+ blogs[i-1].tagsFromPost.fontcolor("black").link("https://en.wikipedia.org")
									+ "</li><li><li>"
									+ "<br><br>" + " *** "+ "<br><br>"
									+ "</li></ul>";
								}	
											
							document.getElementById("blogTableBodyNonTabAll").innerHTML = tableContent;  // 
						});
				}	
	
				
				// 3. TODO Getting values for edit form from JSON Blog Entry, testing...
				
//		 		function getFieldsToEditForm() {
//		 			$.getJSON("http://localhost:8080/ajaveeb/rest/blogs" + blogId,
//		 				function(blogs) {
//		 					var blogName = blogs[index].blogName;
//		 					var blogContent = blogs[index].blogContent;
//		 					var tagsFromPost = blogs[index].tagsFromPost;
//		 					var postStateName = blogs[index].postState.postStateName;
									 
//		 					document.getElementById("blogName").innerHTML = blogName;
//		 					document.getElementById("blogContent").innerHTML = blogContent;
//		 					document.getElementById("tagsFromPost").innerHTML = tagsFromPost;
//		 					document.getElementById("postStateName").innerHTML = postStateName;
//		 				});
//		 		}
		
	getAllBlogsNonTabClient();
	getAllBlogsNonTabAllClient();// added
	getAllBlogsNonTab();
	getAllBlogsNonTabAll();// added
	//getFieldsToEditForm();
	

		
		
		
		
	