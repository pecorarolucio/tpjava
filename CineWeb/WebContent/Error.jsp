<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
    <title>Error</title>
</head>
<body>
<%String error = request.getParameter("error"); %>
    <h2>Error</h2>
    <p><%=error %></p>
</body>
</html>