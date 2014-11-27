<%@ taglib prefix="portal" uri="/WEB-INF/tld/tagliberary.tld"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"   prefix="c" %>

<c:set var="pageID" scope="request" value="profile"/>
<jsp:include page="../pagesections/header.jsp" />
<div class="container">
	<div class="row">
		<div class="col-md-12">
			<h1 class="page-header">My Profile</h1>
		</div>
	</div>
	<div class="row">

		<div class="col-md-3">
			<jsp:include page="../pagesections/sidebar.jsp" />
		</div>
		<div class="col-md-9">
			<div class="row">
				<div class="col-md-3">
					<img src="#" class="img-rounded profileImage"></img>
				</div>
				<div class="col-md-9">
					<h1 class="profileName">Mohit Kanwar</h1>
					<h3>Sr. Consultant</h3>
					<h5>8588832476</h5>
					<h5>MKanwar@Xebia.com</h5>
				</div>
			</div>
			<div class="row">
				I have been working for Team beachbody for around 7 months now. Its been a great journey so far, Enjoying a lot in Xebia!
				Good Stuff to learn about.
				Burrraaaaaaaaaaaaaaaaaaaaaaaaaaaa!!!
				</div>
			</div>
		</div>
	</div>
</div>
<jsp:include page="../pagesections/footer.jsp" />