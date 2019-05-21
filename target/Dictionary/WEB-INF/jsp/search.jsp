<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
	<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
	<script src="//code.jquery.com/jquery-1.10.2.js"></script>
	<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>

	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	
	<script src="${pageContext.request.contextPath}/resources/js/searchautocomplete.js"></script>
	<title>Dictionary web application</title>

</head>

<body>

	<h2>Dictionary</h2>

	<form method="POST" action="search">

				<label for="word">Word: </label>
				<input id="word" name="word" value="${word}"/>
				<input type="submit" value="Search" />
				<br><br>
				<label for="explanation">Explanation: </label>
				<br>
				<textarea style="resize:none" rows="4" cols="70"  
					readonly name="explanation">${explanation}</textarea>

	</form>

</body>
</html>