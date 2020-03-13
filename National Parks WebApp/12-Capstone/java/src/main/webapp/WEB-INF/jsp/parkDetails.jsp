<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<c:import url="/WEB-INF/jsp/common/header.jsp">
	<c:param name="title" value="Park Details" />
</c:import>
<section class="main">
<div class="detailHeader">
	<div>
		<c:url value="/img/parks/${park.image}.jpg" var="parkImage" />
		<img src="${parkImage}" />
	</div>
	<div class="parkHeader">
		<h1 class="parkTitle">
			<c:out value="${park.name}" />
		</h1>
		<p class="parkTitle2">
			Location: 
			<c:out value="${park.state}" />
		</p>
		<p class="parkTitle2">
			Climate: 
			<c:out value="${park.climate}" />
		</p>
		<div>
		<p  class="quote"><i>
		"<c:out value="${park.quote}" />"
		</i></p>
		<p class="source">
			~ quote from
			<c:out value="${park.quoteSource}" />
		</p>
		</div>
	</div>
	</div>

	<div>
	<ul class="stats">
		<li>
			<fmt:formatNumber value="${park.acreage}" maxFractionDigits="0" />
			acres!
		</li>
		<li>
			Elevation is <fmt:formatNumber value="${park.elevation}"
							maxFractionDigits="0" /> feet
		</li>
		<li>
			<fmt:formatNumber value="${park.milesOfTrail}" maxFractionDigits="0" /> miles of trail!
		</li>
		<li>
		<c:choose>
		<c:when test="${park.numOfCampsites == 0}">
		<c:out value="Unfortunately...no camping allowed."/>
		</c:when>
		<c:otherwise>
			<c:out value="${park.numOfCampsites}"/> campsites to choose from.
			</c:otherwise>
			</c:choose>
		</li>
		<li>
			Founded in
			<c:out value="${park.yearFounded}" />
		</li>
		<li>
		<fmt:formatNumber value="${park.annualVisitors}" maxFractionDigits="0" /> annual visitors.
		</li>
		<li>
			<c:out value="${park.numOfSpecies}" />
			different species of animals!
		</li>
		<li>
		<c:choose>
		<c:when test="${park.entryFee == 0}">
		<c:out value="Free to enter!"/>
		</c:when>
		<c:otherwise>
			$<c:out value="${park.entryFee}"/> entry fee
			</c:otherwise>
			</c:choose>
		</li>
		</ul>
	</div>
	<div class="detailDescription">
		<c:out value="${park.description}" />
	</div>
	<h2>5 Day Weather Forecast</h2>
	<div class="weatherContainer">
		<c:forEach items="${weather}" var="weather">
			<div>
				<div class="upperWeather">
				<c:choose>
					<c:when test="${weather.forecast == 'thunderstorms'}">
					<c:import url="/WEB-INF/jsp/thunderstorms.jsp"/>
					</c:when>
					<c:when test="${weather.forecast=='sunny'}">
						<c:import url="/WEB-INF/jsp/sunny.jsp"/>
						
					</c:when>
					<c:when test="${weather.forecast=='partly cloudy'}">
						<c:import url="/WEB-INF/jsp/partlyCloudy.jsp"/>
					</c:when>
					<c:when test="${weather.forecast=='rain' }">
						<c:import url="/WEB-INF/jsp/rain.jsp"/>
					</c:when>
					<c:when test="${weather.forecast=='snow'}">
					<c:import url="/WEB-INF/jsp/snow.jsp"/>
					</c:when>
					<c:when test="${weather.forecast=='cloudy'}">
						<c:import url="/WEB-INF/jsp/cloudy.jsp"/>
					</c:when>
				</c:choose>
				
				<h4 id="day">
					<c:choose>
						<c:when test="${weather.forecastValue == 1}">
							<c:out value="Today" />
						</c:when>
						<c:when test="${weather.forecastValue == 2}">
							<c:out value="Tomorrow" />
						</c:when>
						<c:when test="${weather.forecastValue == 3}">
							<c:out value="The day after tomorrow" />
						</c:when>
						<c:when test="${weather.forecastValue == 4}">
							<c:out value="Dawn of the third day" />
						</c:when>
						<c:when test="${weather.forecastValue == 5}">
							<c:out value="Four days from today" />
						</c:when>
					</c:choose>
				</h4>
				<p id="right">
					<c:out value="${weather.forecast}" />
				</p>
				<p id="right">
					High: <b><fmt:formatNumber value="${weather.high}"
							maxFractionDigits="0" />°</b>
				</p>
				<p id="right">
					Low: <b><fmt:formatNumber value="${weather.low}"
							maxFractionDigits="0" />°</b>
				</p>
				</div>
				<div class="responseDiv">
				<c:if test="${empty weather.responseForecast && empty weather.responseTemp}">
				<p class="response" id="italic"><i>Have a great day!</i></p>
				</c:if>
				<c:if test="${not empty weather.responseForecast}">
				<p class="response" id="italic">
					<i><c:out value="${weather.responseForecast}" /></i>
				</p>
				</c:if>
				<c:if test="${not empty weather.responseTemp}">
				<p>
					<i><c:out value="${weather.responseTemp}" /></i>
				</p>
				</c:if>
				</div>
			</div>
		</c:forEach>
	</div>
	<c:url value="/parkDetails" var="detailsUrl">
		<c:param name="code" value="${park.code}"></c:param>
	</c:url>
	<h3>Display the temperature in Metric or Standard</h3>
	<form action="${detailsUrl}" method="POST" >

		<label for="isF">C</label> <input type="radio" name="isF"
			value="false" required> <label for="isF">F</label> <input type="radio"
			name="isF" value="true"> <input type="hidden"
			value="${park.code}" name="code" required> 
			<input type="submit" value="Choose Temp" class="myButton">


	</form>


</section>
<c:import url="/WEB-INF/jsp/common/footer.jsp"/>
