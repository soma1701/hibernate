var currentcatagory="";
	function loadDoc(bookCatagory) {
		console.log("Inside the science");
		currentcatagory=bookCatagory;
	  var xhttp = new XMLHttpRequest();
	  xhttp.open("POST", "fetchBookTitle?ACTION_MODE=FETCH_BOOK_TITLE&bookCatagory="+bookCatagory, true);
	  xhttp.send();
	  xhttp.onreadystatechange = function() {
	    if (this.readyState == 4 && this.status == 200) {
	      document.getElementById("demo-"+bookCatagory).innerHTML = this.responseText;
	    }
	  };
	}
	function fetchDetails(bookId,isEditFlow){
		var xhttp = new XMLHttpRequest();
		  xhttp.open("POST", "fetchData?ACTION_MODE=FETCH_BOOK_DETAILS&bookId="+bookId+"&isEditFlow="+isEditFlow, true);
		  xhttp.send();
		  xhttp.onreadystatechange = function() {
		    if (this.readyState == 4 && this.status == 200) {
		      document.getElementById("book-details").innerHTML = this.responseText;
		    }
		  };
	}
	function deleteBook(bookId){
		var xhttp = new XMLHttpRequest();
		  xhttp.open("POST", "deleteData?ACTION_MODE=DELETE_BOOK&bookId="+bookId, true);
		  xhttp.send();
		  xhttp.onreadystatechange = function() {
		    if (this.readyState == 4 && this.status == 200) {
		    	
		    loadDoc(currentcatagory);
		    
		    }
		  };
		
	}
	function validateBook(){
		var bookTitle =document.getElementById("bookTitle").value;
		var bookAuthor = document.getElementById("bookAuthor").value;
		var bookPrice = document.getElementById("bookPrice").value;
		 
		if(bookTitle==""||bookTitle==null){
			alert("bookTitle can't be null");
			return false;
		} else if(bookAuthor==""||bookAuthor==null){
				alert("bookAuthor can't be null");
			    return false;
		}
		 else if(bookPrice==""||bookPrice==null){
			alert("bookAuthor can't be null");
			return false;
		}
		return true;
	}
	
