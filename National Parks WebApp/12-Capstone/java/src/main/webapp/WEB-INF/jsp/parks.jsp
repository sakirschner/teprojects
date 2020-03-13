<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/common/header.jsp">
	<c:param name="title" value="Park Home Page" />
</c:import>
<section class="main">
	<c:forEach items="${parks}" var="park">
		<div class="parkContainer">
			<div>
			<div>
				<c:url value="/img/parks/${park.image}.jpg" var="parkImage" />
				<c:url value="/parkDetails" var="parkDetailUrl">
					<c:param name="code" value="${park.code}"></c:param>
				</c:url>
			
				<a href="${parkDetailUrl}"><img src="${parkImage}" /></a>
			</div>
			</div>
			<div>
				<h1>
					<c:out value="${park.name}" />
				</h1>
				<h2>
			Located in the great state of <c:out value="${park.state}" />!
		</h2>
				<c:out value="${park.description}" />
				<p><a href="${parkDetailUrl}">Click here</a> or on the photo for more details on <c:out value="${park.name}"/>.</p>
			</div>
		</div>
	</c:forEach>

</section>

<c:import url="/WEB-INF/jsp/common/footer.jsp"/>