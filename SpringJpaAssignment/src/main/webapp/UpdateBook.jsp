<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<p style="color:green ;" > Update Book </p>

<form action = "updatebook" method = "post">

      Library Id: 
      <input type = "text" name = "LibraryId" >
      <br>
      Library Name:
      <input type = "text" name = "LibraryName">
      <br>
      Book Id:
      <input type = "text" name = "BookId">
      <br>
      Book Name:
      <input type = "text" name = "BookName">
      <br>
      Publisher:
      <input type = "text" name = "Publisher">
      <br>
      Author:
      <input type = "text" name = "Author">
      <br>
      
      <input type = "submit" name = "Update Book">
      
      </form>

</body>
</html>