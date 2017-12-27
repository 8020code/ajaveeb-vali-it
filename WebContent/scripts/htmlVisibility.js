// Functions to show or hide html page content !!!

function mainLogin (shown, hidden) {
  document.getElementById(shown).style.display='block';
  document.getElementById(hidden).style.display='none'; 
  return false;
}
	
// Public view  functions:

<!-- showAllBlogs -->
function showAllBlogsPublic (shown, hidden) {
	  document.getElementById(shown).style.display='block';
	  document.getElementById(hidden).style.display='none';
	  return false;
	}		
	
// Client view  functions:

function showAllBlogsClient (shown, hidden) {
	  document.getElementById(shown).style.display='block';
	  document.getElementById(hidden).style.display='none';
	  return false;
	}	

function newPostView (shown, hidden) {
	  document.getElementById(shown).style.display='block';
	  document.getElementById(hidden).style.display='none';
	  return false;
	}

function editPostView (shown, hidden) {
	  document.getElementById(shown).style.display='block';
	  document.getElementById(hidden).style.display='none';
	  return false;
	}
		
		