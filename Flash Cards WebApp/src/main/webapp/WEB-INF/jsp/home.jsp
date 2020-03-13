<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/common/header.jsp">
	<c:param name="title" value="Java Interview Flash Cards" />
</c:import>

	<div class="flip-card">
		<div class="flip-card-inner">
			<div class="flip-card-front">
				<p>
					<c:out value="${flashcard.question}" />
				</p>
			</div>
			<div class="flip-card-back">
				<p>
					<c:out value="${flashcard.answer}" />
				</p>
			</div>
		</div>
	</div>
	<div class="center">
		<c:url value="/" var="nextCard" />
		<a href="${nextCard}" class="button2">Next Card</a>
	</div>
</body>
</html>