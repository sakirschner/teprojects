<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<title>Shopping Cart</title>
<c:url value="/css/site.css" var="cssLink" />
<link rel="stylesheet" href="${cssLink}">
<link
	href="https://fonts.googleapis.com/css?family=Baloo+Chettan+2&display=swap"
	rel="stylesheet">
<script src="https://kit.fontawesome.com/d250ebdefd.js"
	crossorigin="anonymous"></script>

</head>


<body>
<header>
	<c:url value="/" var="home" />
	<h2><a href="${home}">Shopping Cart</a></h2>
	
	<c:url value="/cart" var="cartUrl" />
	<a href="${cartUrl}">
	<span class="cartSpan">
	<c:if test="${order.numOfItems > 0}" >
	<span class="itemCount"><b><c:out value="${order.numOfItems}" /></b></span>
	</c:if>
	<i class="fas fa-shopping-cart"></i>
	</span>
	</a>
</header>

