<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/common/header.jsp">
	<c:param name="title" value="Favorite Parks" />
</c:import>
<c:url value="/survey" var ="survey" />

<c:set var="num" value="1"/>



<section class="main">
	
		<div>
		<p class="voterDescription">Based on user submissions we have compiled a list of the top national parks! 
		<a href="${survey}" class="voteUrl">Click here</a> to vote for your favorite park.</p>
		</div>
		
		
		<c:forEach items="${parks}" var="park" >

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
					<span id="number">#<c:out value="${num}"></c:out></span>
					<c:out value="${park.name}" />
				</h1>
				<h2>
					Total Votes -
					<c:out value="${park.surveyCount}"></c:out>
				</h2>
				<p><a href="${parkDetailUrl}">Click here</a> for more details on <c:out value="${park.name}"/>.</p>

			</div>

		</div>

		<c:set var="num" value="${num +1}" />

		</c:forEach>
</section>

<c:import url="/WEB-INF/jsp/common/footer.jsp"/>