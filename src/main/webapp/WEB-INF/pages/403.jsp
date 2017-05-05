<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- Meta, title, CSS, favicons, etc. -->
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Siges</title>

<%-- <link href="<c:url value="/resources/css/bootstrap.css"/>" rel="stylesheet" type="text/css" /> --%>
<%-- <link href="<c:url value="/resources/css/custom.css"/>" rel="stylesheet" type="text/css" /> --%>
<%-- <link href="<c:url value="/resources/css/font-awesome.css"/>" rel="stylesheet" type="text/css" /> --%>
</head>
<body class="login">
	<c:url value="/j_spring_security_logout" var="logoutUrl" />

	Recurso no permitido

	<a href="${logoutUrl}"> <span class="glyphicon glyphicon-log-out" />
		Regresar al Inicio
	</a>

</body>
</html>
