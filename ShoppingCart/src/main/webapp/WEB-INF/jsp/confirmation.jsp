<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<c:import url="/WEB-INF/jsp/common/header.jsp" />
<c:url value="/" var="home" />
<section class="confirmationContainer">
<div class="emptyContainer">
	<h2>Order Successful!</h2>
	<a href="${home}"><div class="button">Keep Shopping</div></a>
</div>
</section>
<c:import url="/WEB-INF/jsp/common/footer.jsp" />