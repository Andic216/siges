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
								<label class="control-label col-md-2 col-sm-2 col-xs-12">Nombre:</label>
								<div class=" col-md-4 col-sm-4 col-xs-12">
									<input class="form-control text-uppercase" type="text" id="nombreS" name="nombreS">
								</div>
								<div class="visible-xs ">
									<div class="clearfix"></div>
									<br>
								</div>
								<div class="col-md-2 col-sm-2 col-xs-12">
									<button type="button" id="btnToolB" data-toggle="tooltip" title="Buscar"
										class="btn btn-primary btn-sm" onclick="filtrar()">
										<span class="glyphicon glyphicon-search"/>
									</button>
									&nbsp;&nbsp;
									<button type="button" id="btnToolL" data-toggle="tooltip" title="Limpiar"
										class="btn btn-primary btn-sm" onclick="limpiarFormS()">
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
						<div class=" col-md-2 col-sm-2 col-xs-12">
							<button type="button" class="btn btn-success btn-sm" onclick="nuevo()">
							<i class="glyphicon glyphicon-erase"></i> Nuevo
							</button>
						</div>											
					</div>
				</div>
				<div class="clearfix"></div>				
				<div class="x_panel">
					<div class="x_content">
						<div class="table-responsive tbl_res" >
							<table id="example" class="table table-hover table-bordered dt-responsive nowrap" 
								cellspacing="0" width="100%">
								<thead>
									<tr>
										<th>DNI</th>
										<th>Nombre</th>										
										<th>Acci&oacute;n</th>
									</tr>
								</thead>
							</table>
						</div>
					</div>
				</div>
				
			</div>
		</div>
	</div>

<div id="nuevo" class="modal fade">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<h4 class="modal-title" id="gridSystemModalLabel">Nuevo</h4>
			</div>
			<div class="modal-body">
				<form id="frmConductor" name ="frmItem" method="post" data-parsley-validate
									class="form-horizontal form-label-left">
					<div class="row">
						<div class="col-md-12 col-sm-12 col-xs-12">
							<input type="hidden" id="id" name="id">						
							<div class="form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12">DNI:</label>
								<div class=" col-md-4 col-sm-4 col-xs-12">
									<input class="form-control text-uppercase" type="text" id="dni" name="dni">
								</div>								
							</div>
							<div class="form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12">Nombre:</label>
								<div class=" col-md-7 col-sm-7 col-xs-12">
									<input class="form-control text-uppercase" type="text" id="nombre" name="nombre">
								</div>
							</div>
						</div>
					</div>
				</form>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-danger btn-sm" data-dismiss="modal">Cancelar</button>
				<button id="btnSub" type="button" class="btn btn-success btn-sm btn_modal_success" onclick="grabar()">Aceptar</button>
			</div>
		</div>
	</div>
</div>

</body>
<jsp:include page="util/libjs.jsp" />
<script src="<c:url value="/resources/app/conductor.js" />" type="text/javascript"></script>
</html>