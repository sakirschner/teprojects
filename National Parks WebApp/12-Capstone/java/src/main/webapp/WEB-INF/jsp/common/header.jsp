<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<c:url value="/css/site.css" var="cssLink" />
<link rel="stylesheet" href="${cssLink}">
<link href="https://fonts.googleapis.com/css?family=Nunito&display=swap" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/css-toggle-switch/latest/toggle-switch.css" rel="stylesheet" />
<title><c:out value="${param.title}" /></title>
</head>
<header class="navbar">
<c:url value="/img/logo.png" var ="logo" />
<c:url value="/" var ="home" />
<c:url value="/survey" var ="survey" />
<c:url value="/favoriteParks" var ="favoriteParks" />
<a href="${home}"><img src="${logo}" class="logo"/></a>
<div class="headerDiv">
<ul>
<li><a href="${home}">Home</a></li>
<li><a href="${favoriteParks}">Favorite Parks</a></li>
<li><a href="${survey}">Vote</a></li>
</ul>
</div>
</header>
<body>