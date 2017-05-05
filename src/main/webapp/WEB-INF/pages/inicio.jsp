<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- <%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%> --%>

<jsp:include page="util/head.jsp" />

<body class="nav-md">
	<div class="container body">
		<div class="main_container">
			<jsp:include page="util/menu.jsp" />
			<div class="right_col" role="main"  style="height: 95.5% !important;">

<!-- 				<sec:authorize access="hasRole('ROLE_ADMIN')"> -->
<!-- 					<sec:authentication property="principal.username"/> -->
<!-- 	        	</sec:authorize>								 -->

			</div>
		</div>
	</div>
</body>
<jsp:include page="util/libjs.jsp" />
<script type="text/javascript">
</script>
</html>