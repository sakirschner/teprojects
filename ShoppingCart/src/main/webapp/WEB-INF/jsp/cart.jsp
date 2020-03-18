<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<c:import url="/WEB-INF/jsp/common/header.jsp"/>
<c:url value="/" var="home" />
<c:url value="/clear" var="clear" />
<c:url value="/checkout" var="checkout" />

<section>
	<c:choose>
		<c:when test="${order == null}">
			<div class="emptyContainer">
				<h2>Cart Empty</h2>
				<a href="${home}"><div class="button">Keep Shopping</div></a>
			</div>
		</c:when>
		<c:otherwise>
			<div class="cartHeader">
				<div></div>
				<div>
					<p>Product</p>
				</div>
				<div>
					<p>Description</p>
				</div>
				<div>
					<p>Price</p>
				</div>
				<div>
					<p>Quantity</p>
				</div>
				<div>
					<p>Total</p>
				</div>
			</div>
			<c:forEach items="${order.cartItems}" var="item">
				<div class="cartItemContainer">
					<div class="cartPic">
						<c:url value="/img/${item.imageName}" var="imageUrl" />
						<img src="${imageUrl}" class="cartImage">
					</div>
					<div class="cartName">
						<p>
							<c:out value="${item.name}" />
						<p>
					</div>

					<div class="cartDescription">
						<p>
							<c:out value="${item.description}" />
						</p>
					</div>
					<div class="cartPrice">
						<span class="mobileInfo">Price: </span>
						<p>
							$
							<fmt:formatNumber type="number" maxFractionDigits="2"
								value="${item.price}" />
						</p>
					</div>
					<div class="cartQuantity">
						<span class="mobileInfo">Quantity: </span>
						<p>
							<c:out value="${item.quantity}" />
						</p>
					</div>
					<div class="cartTotal">
						<span class="mobileInfo">Total: </span>

						<p>
							$
							<fmt:formatNumber type="number" maxFractionDigits="2"
								value="${item.total}" />
						</p>
					</div>
				</div>
			</c:forEach>
			<div class="cartFooter">
				<div></div>
				<div></div>
				<div></div>
				<div></div>
				<div></div>
				<div>
					<h3><span class="mobileInfo">Total:  </span>
						 $
						<fmt:formatNumber type="number" maxFractionDigits="2"
							value="${order.total}" />
					</h3>
					<c:url value="/" var="home" />
					<c:url value="/clear" var="clear" />
					<c:url value="/checkout" var="checkout" />
					<a href="${checkout}"><div class="button">Check Out</div></a> <a
						href="${home}"><div class="button">Keep Shopping</div></a> <a
						href="${clear}"><div class="button">Clear Cart</div></a>
				</div>
			</div>
		</c:otherwise>
	</c:choose>
</section>
<c:import url="/WEB-INF/jsp/common/footer.jsp" />