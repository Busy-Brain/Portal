<%@ taglib prefix="portal" uri="../../WEB-INF/tld/tagliberary.tld"%>
<!DOCTYPE html>
<html>
<head>
<portal:Style/>
<portal:Script/>
<portal:Title pageIdentifier="${pageIdentifier}"/>
<portal:Meta pageIdentifier="${pageIdentifier}"/>
</head>
<body>

<jsp:include page="pagesections/header.jsp"/>
${pageContent}
<jsp:include page="pagesections/footer.jsp"/>
</body>
</html> 