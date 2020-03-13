<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:import url="/WEB-INF/jsp/common/header.jsp">
	<c:param name="title" value="Add Java Interview Card" />
</c:import>

<c:url var="addUrl" value="/add" />

<div>
	<form method="POST" action="${addUrl}">
		<div>
			<label for="question">Question</label> 
			<br>
			<textarea name="question" required required placeholder="enter question"></textarea>

		</div>
		<div>
			<label for="answer">Answer</label>
			<br>
			 <textarea name="answer" required placeholder="enter answer"></textarea>

		</div>

		<div>
			<input type="submit" value="Add Card" class="button3"/>
		</div>

	</form>
</div>


</body>
</html>