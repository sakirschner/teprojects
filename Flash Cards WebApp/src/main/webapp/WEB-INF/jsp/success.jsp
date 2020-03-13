<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/common/header.jsp">
	<c:param name="title" value="Java Interview Flash Cards Created" />
</c:import>

<div class="center" id="top">
	<h1>Success!</h1>
	<h2>Your new card will be added to the stack</h2>
</div>
<div class="flip-card" id="fa-card">
	<div class="flip-card-inner">
		<div class="flip-card-front" id="fa-card-front">
			<p>
				<c:out value="${flashcard.question}" />
			</p>
		</div>
		<div class="flip-card-back" id="fa-card-back">
			<p>
				<c:out value="${flashcard.answer}" />
			</p>
		</div>
	</div>
</div>
<div class="center">
	<c:url value="/" var="returnhome" />
	<a href="${returnhome}" class="button2">Return Home</a>
</div>
</body>
</html>