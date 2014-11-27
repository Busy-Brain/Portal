<%@ taglib prefix="portal" uri="../../WEB-INF/tld/tagliberary.tld"%>
<jsp:include page="pagesections/header.jsp"/>
	<%-- BODY START --%>
	<div class="container-fluid loginFormContainer centerSection">

		<form class="form-signin" role="form" name='loginForm'
		    action="/qbank/j_spring_security_check" method='POST'>
			<h3 class="form-signin-heading">Enter the world of Awesomeness</h3>
			<input type="email" class="form-control" placeholder="Email address" name="username"
				required autofocus> <input type="password"
				class="form-control" placeholder="Password" required name="password">
		<%--	<div class="checkbox">
				<label> <input type="checkbox" value="remember-me">
					Remember me
				</label>
			</div> --%>
			<button class="btn btn-lg btn-primary btn-block" type="submit">Sign
				in</button>
				<input type="hidden" 
                     name="${_csrf.parameterName}" value="${_csrf.token}" />
		</form>

	</div>
	
	<%-- BODY END --%>
<jsp:include page="pagesections/footer.jsp"/>
