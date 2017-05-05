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
							<h3>Usuarios</h3>
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
									<input class="form-control text-uppercase" type="text" id="nombS" name="nombS">
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
				<button type="button" class="btn btn-success btn-sm" onclick="nuevo()">
					<i class="glyphicon glyphicon-erase"></i> Nuevo
				</button>
				
				<div class="clearfix"></div>
				
				<div class="x_panel">
					<div class="x_content">
						<div class="table-responsive tbl_res" >
							<table id="example" class="table table-hover table-bordered dt-responsive nowrap" 
								cellspacing="0" width="100%">
								<thead>
									<tr>
										<th>Usuario</th>
										<th>Nombre</th>
										<th>Rol</th>
										<th>Estado</th>										
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
				<form id="frmCliente" name ="frmItem" method="post" data-parsley-validate
									class="form-horizontal form-label-left">
					<div class="row">
						<div class="col-md-12 col-sm-12 col-xs-12">
							<input type="hidden" id="id" name="id">						
							<div class="form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12" id="lblusuario">Usuario:</label>
								<div class=" col-md-5 col-sm-9 col-xs-12">
									<input class="form-control text-uppercase" type="text" id="usuario" name="usuario">
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12">Nombre:</label>
								<div class=" col-md-5 col-sm-9 col-xs-12">
									<input class="form-control text-uppercase" type="text" id="nombre" name="nombre">
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12">Rol:</label>
									<select class="selectpicker col-md-5 col-sm-9 col-xs-12" id="rol" name="rol" >
									  <option>CONSULTOR</option>
									  <option>ADMINISTRADOR</option>
									</select>	
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

<div id="reiniciarPassModal" class="modal fade" >
		<div class="modal-dialog" style="width: 280px !important;">
			<div class="modal-content">
				<div class="modal-header" style="font-size: 13px !important; padding: 5px !important;">
					<label for="myalue"/>
				</div>
				<input type="hidden" id="idReset" name="idReset">
				<div class="modal-footer" style="text-align: center; padding: 5px !important;">
					<button id="nombre1" type="button" class="btn btn-success btn-sm btn_modal_success" 
						onclick="reiniciarPassOk()">Si
					</button>
					<button id="nombre2" type="button" class="btn btn-success btn-sm btn_modal_success">No
					</button>
				</div>
			</div>
		</div> 
</div>
	
</body>
<jsp:include page="util/libjs.jsp" />
<script type="text/javascript">

$(document).ready(function() {
	tablaForm();
});

function tablaForm(){

	var urlLoad = '${pageContext.request.contextPath}/usuario/lst';
	
	$("#example").dataTable({        
		"sAjaxSource" : urlLoad,
		"fnServerParams" : function(aoData) {
			aoData.push(
					{ "name" : "nombre", "value" : $('#nombS').val() });  
		},
		"aoColumns" : [
			{ "mData" : "usuario" },
			{ "mData" : "nombre" },
			{ "mData" : function(obj){
				if(obj.rol=="ROLE_ADMIN"){
					return "ADMINISTRADOR";
				}else{
					return "CONSULTOR";
				}
			} },
			{ "mData" : function(obj){
				if(obj.estado=="1"){
					return "ACTIVO";
				}else{
					return "BAJA";
				}
			} },
			{ "mData": null, "sClass": "buttonCol", "mRender":
            function (obj) {
			return '<button type="button" id="btnToolE" data-toggle="tooltip" title="Editar"'+
					'class="btn btn-success btn-xs margin_button" onclick="editar(\''+obj.id+'\')">'
            		+'<i class="glyphicon glyphicon-edit"></i>'+
            	'</button>&nbsp;&nbsp;'+
            	'<button type="button" id="btnToolD" data-toggle="tooltip" title="Eliminar"'+
					'class="btn btn-success btn-xs margin_button" '
            		+'onclick="eliminar(\''+obj.id+'\',\'el Usuario\')">' 
            		+'<i class="glyphicon glyphicon-remove-circle"></i>'+
            	'</button>&nbsp;&nbsp;'+
            	'<button type="button" id="btnToolR" data-toggle="tooltip" title="Reiniciar password"'+
					'class="btn btn-success btn-xs margin_button" onclick="reiniciarPass(\''+obj.id+'\',\'el Usuario\')">' 
        			+'<i class="glyphicon glyphicon-repeat"></i>'+
        		'</button>';
            	}
            }
		]
	});
}

function nuevo(){
	limpiarForm();
	$("#usuario").removeAttr('disabled');
	$("#rol").removeAttr('disabled');
	$("#btnSub").removeAttr('disabled');
	$('#nuevo').modal({
		show : true,
		backdrop : 'static',
		keyboard : false
	});
}

function limpiarFormS(){
	 $('#nombS').val('');
	 var oTable = $('#example').DataTable();
		oTable.ajax.reload();
}

function limpiarForm(){
	$('#id').val('');
	$('#nombre').val('');
	$('#usuario').val('');
	$('#rol').val('');
}



function grabar(){

	$("#btnSub").attr('disabled', 'disabled');
	
	var mom = $('#nombre').val();
	var usr = $('#usuario').val();
	var sts = '1';
	var rol = $('#rol').val();
	var clv = '123456';
	var msg = '';
	if(rol=='Administrador'){
		rol='ROLE_ADMIN';
	}else{
		rol='ROLE_USER';
	}
	if(!mom.trim() ){
		$('#nombre').addClass("has_error_per");
		msg=msg+" - Ingrese un nombre <br>";	
	}
	if(!usr.trim() ){
		$('#usuario').addClass("has_error_per");
		msg=msg+" - Ingrese un usuario <br>";	
	}

	if(!msg.trim()){

		var urlSave = '${pageContext.request.contextPath}/usuario/saveOrUpdate';

		var formData = {   
			"id" : $("#id").val(),
			"nombre" : mom,
			"usuario" : usr,
			"estado" : sts,
			"rol" : rol,
			"clave" : clv
		};
		$.ajax({
			type : "POST",
			contentType : 'application/json; charset=utf-8',
			dataType : 'json',
			url : urlSave,
			data : JSON.stringify(formData),					
			success : function(response) {
				if(response.estado=='3'){
					mnsjOk(response.mensaje);
					$('#nuevo').modal('hide');							
					var oTable = $('#example').DataTable();
					oTable.ajax.reload();
				}
				else{
					mnsjWa(response.mensaje);
					$("#btnSub").removeAttr('disabled');
				}
			},
			error : function() {
				alert('Error while request..');
			}
		});
	}else{
		$("#btnSub").removeAttr('disabled');
		mnsjKo(msg);
	}
}

function editar(id){
	$("#usuario").attr('disabled', 'disabled');
	$("#rol").attr('disabled', 'disabled');
	$("#btnSub").removeAttr('disabled');
	var urlEdit = '${pageContext.request.contextPath}/usuario/edit';

	var formData = {
		"id" : id
	};

	$.ajax({
		type : "POST",
		contentType : 'application/json; charset=utf-8',
		dataType : 'json',
		url : urlEdit,
		data : JSON.stringify(formData),
		success : function(response) {
			limpiarForm();

			$("#id").val(response.id),
			$("#usuario").val(response.usuario),
			$("#nombre").val(response.nombre),
			$("#rol").val(response.rol),
			$("#estado").val(response.estado),
			$("#clave").val(response.clave);
			$('#nuevo').modal({
				show : true,
				backdrop : 'static',
				keyboard : false
			});

		},
		error : function() {
			alert('Error while request..');
		}
	});	
	
}

function eliminarOk(){

	var urlDel = '${pageContext.request.contextPath}/usuario/eliminar';

	var formData = {
		"id" : $('#idElim').val()
	};

	$.ajax({
		type : "POST",
		contentType : 'application/json; charset=utf-8',
		dataType : 'json',
		url : urlDel,
		data : JSON.stringify(formData),
		success : function(response) {
			$('#eliminarObjetc').modal('hide');
			if(response.estado=='3'){
				mnsjOk('Se ha cambiado el estado correctamente');
				var oTable = $('#example').DataTable();
				oTable.ajax.reload();
			}
			else{
				mnsjWa(response.mensaje);
			}
		},
		error : function() {
			alert('Error while request..');
		}
	});
}

function filtrar() {
	var oTable = $('#example').DataTable();
	oTable.ajax.reload();
}


function reiniciarPass(obj2, obj3){
	$('#reiniciarPassModal').modal({
			show : true,
			backdrop : 'static',
			keyboard : false
	});
	$("label[for='myalue']").html("¿Desea reiniciar el password de "+obj3+"?");
	$('#idReset').val(obj2);
	$('button#nombre2').click(function() { 
		   $('#reiniciarPassModal').modal('hide');
	});
}

function reiniciarPassOk(){

	var urlDel = '${pageContext.request.contextPath}/usuario/updatePass';

	var formData = {
		"id" : $('#idReset').val(),
		"clave":"123456"
	};

	$.ajax({
		type : "POST",
		contentType : 'application/json; charset=utf-8',
		dataType : 'json',
		url : urlDel,
		data : JSON.stringify(formData),
		success : function(response) {
			$('#reiniciarPassModal').modal('hide');
			if(response.estado=='3'){
				mnsjOk('Se ha reiniciado la clave de usuario');
				var oTable = $('#example').DataTable();
				oTable.ajax.reload();
			}
			else{
				mnsjWa(response.mensaje);
			}
		},
		error : function() {
			alert('Error while request..');
		}
	});
}
</script>
</html>