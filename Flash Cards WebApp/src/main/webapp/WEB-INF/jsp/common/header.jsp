<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<link href="https://fonts.googleapis.com/css2?family=Nunito&display=swap" rel="stylesheet">
<c:url value="/css/site.css" var="cssLink" />
<link rel="stylesheet" href="${cssLink}">
<title><c:out value="${param.title}" /></title>
</head>
<body>
<header>
<c:url value="/" var="home"/>
<p><a href="${home}" class="home">Java Flash Cards</a></p>
<c:url value="/add" var="addUrl"/>
<a href="${addUrl}" class="button">Add New Card</a>
</header>