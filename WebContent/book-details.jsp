<%@ page import="com.bridgelabz.modal.BookDetails" language="java"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<style>
	.container {
		width: 600px
	}

	.text {
		text-align: left
	}
	.editform{
		width:560;
	}
</style>
<body>
	<%
		BookDetails objBookDetails = (BookDetails) request.getAttribute("bookDetails");
		boolean isEditFlow = "Y".equalsIgnoreCase(request.getAttribute("isEditFlow").toString());
	%>
		<%
			if (isEditFlow) {
		%>
		<form class="form" action="editBook" method="post">
			<div class="form-group">

				<div class="row">
					<div class="col-md-4">Author-Name:</div>
					<div class="col-md-8 text">
						<input type="text" name="bookAuthor" value="<%=objBookDetails.getBookAuthor()%>" />
					</div>
				</div>
				<div class="row">
					<div class=" col-md-4">Book-Title:</div>
					<div class="col-md-8">
						<input type="text" name="bookTitle" value="<%=objBookDetails.getBookTitle()%>" />
					</div>
				</div>
				<div class="row">
					<div class="col-md-4">Book-Price:</div>
					<div class="col-md-8">
						<input type="text" name="bookPrice" value="<%=objBookDetails.getBookPrice()%>" />
					</div>
				</div>
				<input type="hidden" value="<%=objBookDetails.getBookId()%>" name="bookId"> 
				<input type="hidden" name="ACTION_MODE" value="EDIT_BOOK_DETAILS">
				<input type="submit" value="Save">
			</div>
		</form>
	<%
		} else {
	%>
	<form class="form"  action="editBook" method="post">
		<div class="form-group">
			<div class="row">
				<div class="col-md-4">Author-Name:</div>
				<div class="col-md-8 text">
					<input type="text" name="bookAuthor" value="<%=objBookDetails.getBookAuthor()%>" readonly="readonly" />
				</div>
			</div>
		
		<div class="row">
			<div class=" col-md-4">Book-Title:</div>
			<div class="col-md-8">
				<input type="text" name="bookTitle" value="<%=objBookDetails.getBookTitle()%>" readonly="readonly" />
			</div>
		</div>
		<div class="row">
			<div class="col-md-4">Book-Price:</div>
				<div class="col-md-8">
					<input type="text" name="bookPrice"value="<%=objBookDetails.getBookPrice()%>" readonly="readonly" />
				</div>
		</div>
	 </div>
	</form>
	<%
		}
	%>
</body>
</html>