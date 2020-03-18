<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<c:import url="/WEB-INF/jsp/common/header.jsp" />

<section class="products">
	<c:forEach items="${products}" var="product">
		<div class="productContainer">
			<a href="#" onclick="toggle_visibility('${product.id}')">
				<div id="center">
					<c:url value="/img/${product.imageName}" var="imageUrl" />
					<img src="${imageUrl}" class="productImg">

				</div>
				<div class="productBottom">
					<h1>
						<c:out value="${product.name}" />
					</h1>
					<p>
						<b> $<fmt:formatNumber type="number" maxFractionDigits="2"
								value="${product.price}" />
						</b>
					</p>
					<c:choose>
						<c:when test="${product.rating < 1.5 && product.rating >= 0.0}">
							<span class="star">&#9733;</span>
							<span class="starGrey">&#9733;</span>
							<span class="starGrey">&#9733;</span>
							<span class="starGrey">&#9733;</span>
							<span class="starGrey">&#9733;</span>
						</c:when>
						<c:when test="${product.rating < 2.5 && product.rating > 1.5}">
							<span class="star">&#9733;</span>
							<span class="star">&#9733;</span>
							<span class="starGrey">&#9733;</span>
							<span class="starGrey">&#9733;</span>
							<span class="starGrey">&#9733;</span>
						</c:when>
						<c:when test="${product.rating < 3.5 && product.rating > 2.5}">
							<span class="star">&#9733;</span>
							<span class="star">&#9733;</span>
							<span class="star">&#9733;</span>
							<span class="starGrey">&#9733;</span>
							<span class="starGrey">&#9733;</span>
						</c:when>
						<c:when test="${product.rating < 4.5 && product.rating > 3.5}">
							<span class="star">&#9733;</span>
							<span class="star">&#9733;</span>
							<span class="star">&#9733;</span>
							<span class="star">&#9733;</span>
							<span class="starGrey">&#9733;</span>
						</c:when>
						<c:otherwise>
							<span class="star">&#9733;</span>
							<span class="star">&#9733;</span>
							<span class="star">&#9733;</span>
							<span class="star">&#9733;</span>
							<span class="star">&#9733;</span>
						</c:otherwise>
					</c:choose>

				</div>
			</a>
		</div>
	</c:forEach>
	<c:forEach items="${products}" var="product">
		<div id="${product.id}" class="detailsContainer">
			<div class="detailsCard">

				<div class="detailsImageContainer">
					<c:url value="/img/${product.imageName}" var="imageUrl2" />
					<img src="${imageUrl2}" class="productImgDetails"> <a
						href="#" onclick="toggle_visibility('${product.id}')"> <span><b>X</b></span>
					</a>
				</div>
				<div class="detailsBottom">
					<div>
						<h3>
							<c:out value="${product.name}" />
						</h3>
					</div>
					<div class="description" id="flex">
						<h2>
							$
							<fmt:formatNumber type="number" maxFractionDigits="2"
								value="${product.price}" />
						</h2>
						<div>
							<c:choose>
								<c:when test="${product.rating < 1.5 && product.rating >= 0.0}">
									<span class="star" id="bigStar">&#9733;</span>
									<span class="starGrey" id="bigStar">&#9733;</span>
									<span class="starGrey" id="bigStar">&#9733;</span>
									<span class="starGrey" id="bigStar">&#9733;</span>
									<span class="starGrey" id="bigStar">&#9733;</span>
								</c:when>
								<c:when test="${product.rating < 2.5 && product.rating > 1.5}">
									<span class="star" id="bigStar">&#9733;</span>
									<span class="star" id="bigStar">&#9733;</span>
									<span class="starGrey" id="bigStar">&#9733;</span>
									<span class="starGrey" id="bigStar">&#9733;</span>
									<span class="starGrey" id="bigStar">&#9733;</span>
								</c:when>
								<c:when test="${product.rating < 3.5 && product.rating > 2.5}">
									<span class="star" id="bigStar">&#9733;</span>
									<span class="star" id="bigStar">&#9733;</span>
									<span class="star" id="bigStar">&#9733;</span>
									<span class="starGrey" id="bigStar">&#9733;</span>
									<span class="starGrey" id="bigStar">&#9733;</span>
								</c:when>
								<c:when test="${product.rating < 4.5 && product.rating > 3.5}">
									<span class="star" id="bigStar">&#9733;</span>
									<span class="star" id="bigStar">&#9733;</span>
									<span class="star" id="bigStar">&#9733;</span>
									<span class="star" id="bigStar">&#9733;</span>
									<span class="starGrey" id="bigStar">&#9733;</span>
								</c:when>
								<c:otherwise>
									<span class="star" id="bigStar">&#9733;</span>
									<span class="star" id="bigStar">&#9733;</span>
									<span class="star" id="bigStar">&#9733;</span>
									<span class="star" id="bigStar">&#9733;</span>
									<span class="star" id="bigStar">&#9733;</span>
								</c:otherwise>
							</c:choose>
						</div>
					</div>
					<div class="description">
						<p>
							<c:out value="${product.description}" />
						</p>
					</div>

					<c:url value="/" var="formUrl" />
					<form method="POST" action="${formUrl}">
						<label for="quantity">Quantity</label> <input type="text"
							name="quantity" value="1" id="right" /> <input type="hidden"
							name="id" value="${product.id}">
				</div>
				<input type="submit" value="Add to cart" class="submitButton" />
				</form>
			</div>
		</div>

		</div>

	</c:forEach>

</section>


<c:import url="/WEB-INF/jsp/common/footer.jsp" />