<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/common/header.jsp">
	<c:param name="title" value="Vote For Your Favorite Park" />
</c:import>
<section class="background">

	<div class="main">
	
	<h1 class="favoriteHeader">Vote for your favorite Park!</h1>

		<c:url value="/survey" var="survey" />
		
		<div class="wholeForm">
		<form action="${survey}" method="POST" class="favoriteForm">


			<div class="formGroup">
				<label for="code">Park:</label> <select name="code" id="park">
					<option value="CVNP">Cuyahoga Valley National Park</option>
					<option value="ENP">Everglades National Park</option>
					<option value="GCNP">Grand Canyon National Park</option>
					<option value="GNP">Glacier National Park</option>
					<option value="GSMNP">Great Smoky Mountains National Park</option>
					<option value="GTNP">Grand Teton National Park</option>
					<option value="MRNP">Mount Rainier National Park</option>
					<option value="RMNP">Rocky Mountain National Park</option>
					<option value="YNP">Yellowstone National Park</option>
					<option value="YNP2">Yosemite National Park</option>
				</select>
			</div>
			<div class="formGroup">
				<label for="state">State of Residence:</label> <select name="state"
					id="residence" >
					<option value="AL">Alabama</option>
					<option value="AK">Alaska</option>
					<option value="AZ">Arizona</option>
					<option value="AR">Arkansas</option>
					<option value="CA">California</option>
					<option value="CO">Colorado</option>
					<option value="CT">Connecticut</option>
					<option value="DE">Delaware</option>
					<option value="DC">District Of Columbia</option>
					<option value="FL">Florida</option>
					<option value="GA">Georgia</option>
					<option value="HI">Hawaii</option>
					<option value="ID">Idaho</option>
					<option value="IL">Illinois</option>
					<option value="IN">Indiana</option>
					<option value="IA">Iowa</option>
					<option value="KS">Kansas</option>
					<option value="KY">Kentucky</option>
					<option value="LA">Louisiana</option>
					<option value="ME">Maine</option>
					<option value="MD">Maryland</option>
					<option value="MA">Massachusetts</option>
					<option value="MI">Michigan</option>
					<option value="MN">Minnesota</option>
					<option value="MS">Mississippi</option>
					<option value="MO">Missouri</option>
					<option value="MT">Montana</option>
					<option value="NE">Nebraska</option>
					<option value="NV">Nevada</option>
					<option value="NH">New Hampshire</option>
					<option value="NJ">New Jersey</option>
					<option value="NM">New Mexico</option>
					<option value="NY">New York</option>
					<option value="NC">North Carolina</option>
					<option value="ND">North Dakota</option>
					<option value="OH">Ohio</option>
					<option value="OK">Oklahoma</option>
					<option value="OR">Oregon</option>
					<option value="PA">Pennsylvania</option>
					<option value="RI">Rhode Island</option>
					<option value="SC">South Carolina</option>
					<option value="SD">South Dakota</option>
					<option value="TN">Tennessee</option>
					<option value="TX">Texas</option>
					<option value="UT">Utah</option>
					<option value="VT">Vermont</option>
					<option value="VA">Virginia</option>
					<option value="WA">Washington</option>
					<option value="WV">West Virginia</option>
					<option value="WI">Wisconsin</option>
					<option value="WY">Wyoming</option>
				</select>
			</div>
			<div class="formGroup">
				<label for="email">Email:</label> 
				<input type="email" name="email" id="email" pattern="(?!(^[.-].*|[^@]*[.-]@|.*\.{2,}.*)|^.{254}.)([a-zA-Z0-9!#$%&'*+\/=?^_`{|}~.-]+@)(?!-.*|.*-\.)([a-zA-Z0-9-]{1,63}\.)+[a-zA-Z]{2,15}" 
				placeholder="example@example.com" required/>
			</div>
			<div class="formGroup">
				<label for="activityLevel">Activity Level:</label> <input
					type="radio" name="activityLevel" value="inactive" required><label
					for="inactive">Inactive</label> <input type="radio"
					name="activityLevel" value="sedentary" required><label
					for="sedentary">Sedentary</label> <input type="radio"
					name="activityLevel" value="active" required><label for="active">Active</label>
				<input type="radio" name="activityLevel" value="extremelyActive" required><label
					for="extremelyActive" >Extremely Active</label>

			</div>
			<div><br></div>
			<div class="formGroup">
				<input type="submit" value="Submit!" class="myButton"/>
			</div>
		</form>
		</div>
	</div>
	

</section>
<c:import url="/WEB-INF/jsp/common/footer.jsp"/>