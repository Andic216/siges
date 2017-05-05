<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- Meta, title, CSS, favicons, etc. -->
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Siges</title>

<link href="<c:url value="/resources/css/bootstrap.css"/>" rel="stylesheet" type="text/css" />
<link href="<c:url value="/resources/css/app.css"/>" rel="stylesheet" type="text/css" />
<link href="<c:url value="/resources/css/bootstrap-select.css"/>" rel="stylesheet" type="text/css" />
</head>
<body >

	<div id="mainWrapper">
			<div class="login-container">
				<div class="login-card">
					<h1 class="classH1">SICEX</h1>
					<div class="login-form">
						<form name="loginForm" action="<c:url value="login" />" method="POST" class="form-horizontal">						
							<c:if test="${error != null}">
								<div class="alert alert-danger">
									<p>Usuario y clave inv&aacute;lida</p>									
								</div>
							</c:if>
							<div class="input-group input-sm">
								<label class="input-group-addon" for="username"><i class="glyphicon glyphicon-user"></i></label>
								<input type="text" class="form-control" id="username" name="username" placeholder="Usuario" required>
							</div>
							<div class="input-group input-sm">
								<label class="input-group-addon" for="password"><i class="glyphicon glyphicon-lock"></i></label> 
								<input type="password" class="form-control" id="password" name="password" placeholder="Clave" required>
							</div>
							<div class="form-actions">
								<input type="submit"   
									class="btn btn-block btn-primary btn-default" value="Log in">
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
</body>
</html>
