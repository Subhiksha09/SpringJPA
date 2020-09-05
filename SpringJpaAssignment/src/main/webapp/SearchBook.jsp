<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<p style="color:yellow ;" > Search Book </p>

       <form action="searchbook">
	   Library Id: 
	   <input type="text" name="searchByLibraryId">
	   <br>
	   Book Id: 
	   <input type="text" name="searchByBookId">
	   <br>
	   <input type="submit" value="Search Book">
			
		</form>
</body>
</html>