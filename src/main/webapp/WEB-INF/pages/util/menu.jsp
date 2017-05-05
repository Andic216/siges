<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<c:url value="/j_spring_security_logout" var="logoutUrl" />
<c:set var="context" value="${pageContext.request.contextPath}" />

<div class="col-md-3 left_col">
	<div class="left_col scroll-view">
		<div class="navbar nav_title" style="border: 0;">
			<a href="${context}/inicio" class="site_title">
				<div class="text-center"><span>Siges</span></div>
			</a>
		</div>
		<div class="clearfix"></div>
<!-- 		<br /> -->
		<!-- sidebar menu -->
		<div id="sidebar-menu" class="main_menu_side hidden-print main_menu">
			<div class="menu_section">
<%-- 			<div class="text-center" style="color:#FFFFFF"><h2>${PROYECTO.nombre}</h2></div> --%>
<!--  				<br> -->
				<ul class="nav side-menu">					
					<sec:authorize access="hasRole('ROLE_ADMIN')">
						<li>
							<a>
								<span class="glyphicon glyphicon-folder-close"/> Configuraci&oacute;n 
								<span class="fa fa-chevron-down"></span>
							</a>
							<ul class="nav child_menu">
								<li><a href="${context}/conductor/page">Conductor</a></li>
								<li><a href="${context}/vehiculo/page">Vehiculo</a></li>								
								<li><a href="${context}/destino/page">Destino</a></li>
							</ul>
						</li>
					</sec:authorize>
					<sec:authorize access="hasAnyRole('ROLE_ADMIN','ROLE_USER')">
						<li>
							<a>
								<span class="glyphicon glyphicon-copy"/> Proceso 
								<span class="fa fa-chevron-down"></span>
							</a>
							<ul class="nav child_menu">
								<li><a href="${context}/entrega/page">Registro</a></li>							
							</ul>
						</li>
					</sec:authorize>
						<li>
							<a>
								<span class="glyphicon glyphicon-copy"/> Informe 
								<span class="fa fa-chevron-down"></span>
							</a>
							<ul class="nav child_menu">
								<li><a href="${context}/informe/page">General</a></li>							
							</ul>
						</li>
				</ul>
			</div>
		</div>
	</div>
</div>

<div class="top_nav">
	<div class="nav_menu">		
		<nav class="" role="navigation">		
			<div class="nav toggle">
				<a id="menu_toggle">
					<span class="glyphicon glyphicon-th-list"></span>
				</a>
			</div>			
			<ul class="head_menu nav navbar-nav navbar-right">
				
				<li class="head_menu">					
					<a href="javascript:;" class="user-profile dropdown-toggle" 
						data-toggle="dropdown" aria-expanded="false">
						&nbsp;&nbsp;${USUA.nombre}&nbsp;
						<span class="glyphicon glyphicon-user"></span>
					</a>
					<ul class="dropdown-menu dropdown-usermenu pull-right">
						<li>
							<a href="${logoutUrl}">							
								<span class="glyphicon glyphicon-log-out"/> Salir
							</a>
						</li>
					</ul>
				</li>
			</ul>
		</nav>
	</div>
</div>
