<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Me!</title>

<!-- Bootstrap -->
<link href="/qbank/static/css/default/bootstrap.min.css"
	rel="stylesheet">
<link href="/qbank/static/css/default/style.css" rel="stylesheet">
<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
	<nav class="navbar navbar-inverse navbar-fixed-top header" role="navigation">
      <div class="container-fluid">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">Me!</a>
        </div>
      
      </div>
    </nav>
	<%-- BODY START --%>
	<div class="container-fluid loginFormContainer centerSection">

		<form class="form-signin" role="form" name='loginForm'
		    action="/qbank/j_spring_security_check" method='POST'>
			<h2 class="form-signin-heading">Please sign in</h2>
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
	<!-- /container -->





	<%-- BODY END --%>
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="/qbank/static/js/default/jquery.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="/qbank/static/js/default/bootstrap.min.js"></script>
</body>
</html>