<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- <%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%> --%>

<jsp:include page="util/head.jsp" />

<body class="nav-md">
	<div id="preloader">
    	<div id="loader">&nbsp;</div>
	</div>
	<div class="container body">
		<div class="main_container">
			<jsp:include page="util/menu.jsp" />
			<div class="right_col" role="main"  style="height: 95.5% !important;">
				<div class="">
					<div class="page-title">
						<div class="title_left">
							<h3>Item</h3>
						</div>
					</div>
				</div>
				
				<div class="clearfix"></div>
				<div class="ln_solid"></div>
				
				<div class="row">
					<div class="col-md-12 col-sm-12 col-xs-12">
						<form id="frmSearch" class="form-horizontal ">
							
							<div class="form-group">
								<label class="control-label col-md-2 col-sm-2 col-xs-12">Fecha Inicio:</label>
								<div class=" col-md-2 col-sm-2 col-xs-12">
									<div id="fechaIS" class="input-group date ">
	                                    <input type="text" class="form-control" id="fechaInS" name="fechaInS" />
	                                    <span class="input-group-addon">
	                                    	<span class="glyphicon glyphicon-calendar"/>
	                                    </span>
	                                </div>
								</div>
								<div class="visible-xs ">
									<div class="clearfix"></div>
									<br>
								</div>
								<label class="control-label col-md-2 col-sm-2 col-xs-12">Fecha Fin:</label>
								<div class=" col-md-2 col-sm-2 col-xs-12">
									<div id="fechaFS" class="input-group date ">
	                                    <input type="text" class="form-control" id="fechaFiS" name="fechaFiS" />
	                                    <span class="input-group-addon">
	                                    	<span class="glyphicon glyphicon-calendar"/>
	                                    </span>
	                                </div>
								</div>
								<div class="visible-xs ">
									<div class="clearfix"></div>
									<br>
								</div>
								<div class="col-md-2 col-sm-2 col-xs-12">
									<button type="button" id="btnToolL" data-toggle="tooltip" title="Limpiar"
										class="btn btn-primary btn-sm" onclick="limpiar()">
										<span class="glyphicon glyphicon-erase"/>
									</button>
								</div>						
							</div>
						</form>
					</div>
				</div>
				<div class="clearfix"></div>
				<div class="ln_solid"></div>
				<div class="row">
				
					<div class="col-md-12 col-sm-12 col-xs-12">
						<div class=" col-md-2 col-sm-2 col-xs-4 col-md-offset-3 col-sm-offset-3">
							<a class="btn btn-success btn-sm" id="rprtV"  href="#"  onclick="vehiculo(); ">
								<i class="glyphicon glyphicon-road"></i> Vehiculo
							</a>
						</div>
						<div class=" col-md-2 col-sm-2 col-xs-4 ">
							<a class="btn btn-success btn-sm" id="rprtC"  href="#"  onclick="conductor(); ">
								<i class="glyphicon glyphicon-user"></i> Conductor
							</a>
						</div>
						<div class=" col-md-2 col-sm-2 col-xs-4 ">
							<a class="btn btn-success btn-sm" id="rprtT"  href="#"  onclick="ticket(); ">
								<i class="glyphicon glyphicon-th-list"></i> Ticket
							</a>
						</div>						
					</div>					
				</div>
			</div>
		</div>
	</div>

</body>
<jsp:include page="util/libjs.jsp" />
<script src="<c:url value="/resources/app/reporte.js" />" type="text/javascript"></script>
</html>