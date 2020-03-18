<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<section>

	<c:url var="formAction" value="/checkout" />
	<form method="POST" action="${formAction}" class="checkoutForm">
		<div class="checkOutContianer">
			<div>
				<label for="customerName">Customer Name</label> 
				<br>
				<input type="text" name="customerName" class="checkOutInput" required
				placeholder="Enter name"/>
			</div>

			<div>
				<label for="streetAddress1">Street Address 1</label>
				<br>
				 <input
					type="text" name="streetAddress1" class="checkOutInput" required
					placeholder="Enter Street Address 1"/>

			</div>

			<div>
				<label for="streetAddress2">Street Address 2</label> 
				<br>
				<input
					type="text" name="streetAddress2" class="checkOutInput" 
					placeholder="Enter Street Address 2"/>

			</div>

			<div>
				<label for="city">City</label>
				<br>
				 <input type="text" name="city" class="checkOutInput" required
				placeholder="Enter City" />

			</div>

			<div>
				<label for="state">State</label>
				<br>
				 <input type="text" name="state" class="checkOutInput" required
				 placeholder="Enter State (MI)" pattern="[A-Za-z]{2}"/>

			</div>

			<div>
				<label for="zipCode">Zipcode</label>
				<br>
				 <input type="text"
					name="zipCode" class="checkOutInput" required
					placeholder="Enter Zipcode"/>

			</div>
		</div>
			<div>
				<input class="checkoutButton" type="submit" value="Place Order" />
			</div>
	</form>

</section>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />