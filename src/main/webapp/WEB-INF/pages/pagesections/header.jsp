<%@ taglib prefix="portal" uri="/WEB-INF/tld/tagliberary.tld"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
<portal:Style />
<portal:Script />
<portal:Title pageIdentifier="${pageIdentifier}" />
<portal:Meta pageIdentifier="${pageIdentifier}" />

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
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
	<input type="hidden" name="pageId" value="<c:out value='${pageID}'/>"/>
	<nav class="navbar navbar-inverse navbar-fixed-top header" role="navigation">
		<div class="container-fluid header">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar" aria-expanded="false"
					aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">Me!</a>
			</div>
			<sec:authorize access="isAuthenticated()">
				<div id="navbar" class="navbar-collapse collapse ">
					<ul class="nav navbar-nav navbar-right">
						<li><a href="/qbank/me/dashboard">Dashboard</a></li>
						<li><a href="/qbank/me/profile">Profile</a></li>
						<li><a href="/qbank/me/attendance">Attendance & Vacations</a></li>
						<li><a href="/qbank/me/network">Network</a></li>
						<li><a href="/qbank/logout">Logout</a></li>
					</ul>
				<%--	<form class="navbar-form navbar-right">
						<input type="text" class="form-control" placeholder="Search...">
					</form>
					 --%>
				</div>
			</sec:authorize>
		</div>
	</nav>