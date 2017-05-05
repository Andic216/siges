
$(document).ready(function() {
	tablaForm();
	
	$('#fechaIS').datetimepicker({ 
		locale : 'es',
		format : 'DD/MM/YYYY',
		showClose : true
	});

	$('#fechaFS').datetimepicker({
		locale : 'es',
		format : 'DD/MM/YYYY',
		showClose : true
	});

	$('#fecha').datetimepicker({
		locale : 'es',
		format : 'DD/MM/YYYY',
		showClose : true
	});

	$('#horaR').datetimepicker({
        format: 'LT',
        showClose : true
    });

	loadConductor();
	loadDestino();
	loadVehiculo();
});

function loadConductor() {
	var urlLoad = myContextPath +'/common/conductor';
	$.ajax({
		type : "POST",
		contentType : 'application/json; charset=utf-8',
		dataType : 'json',
		url : urlLoad,
		success : function(data) {
			$.each(data, function(key, value) {
				$('#conduc').append(
						'<option value="'+value.id+'">'+value.nombre+'</option>');
			});
			$('#conduc').selectpicker();
		}		
	});	
}
function loadDestino() {
	var urlLoad = myContextPath +'/common/destino';
	$.ajax({
		type : "POST",
		contentType : 'application/json; charset=utf-8',
		dataType : 'json',
		url : urlLoad,
		success : function(data) {
			$.each(data, function(key, value) {
				$('#dest').append(
						'<option value="'+value.id+'">'+value.nombre+'</option>');
			});
			$('#dest').selectpicker();
		}		
	});	
}
function loadVehiculo() {
	var urlLoad = myContextPath +'/common/vehiculo';
	$.ajax({
		type : "POST",
		contentType : 'application/json; charset=utf-8',
		dataType : 'json',
		url : urlLoad,
		success : function(data) {
			$.each(data, function(key, value) {
				$('#placa').append(
						'<option value="'+value.id+'">'+value.placa+'</option>');
			});
			$('#placa').selectpicker();
		}		
	});	
}

function eliminarOk(){

	var urlDel = myContextPath +'/entrega/delete';

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
				mnsjOk(response.mensaje);
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

function editar(id){
	$("#btnSub").removeAttr('disabled');
	var urlEdit = myContextPath +'/entrega/edit';

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
			$("#ticket").val(response.ticket);
			
			$("#fechaR").val(response.fecha);
			
			$("#hora").val(response.hora);
			$("#conduc").val(response.conductor.id);
			$('#conduc').selectpicker('refresh');			
			$("#dest").val(response.destino.id);
			$('#dest').selectpicker('refresh');
			$("#placa").val(response.vehiculo.id);
			$('#placa').selectpicker('refresh');
			$("#d2").val(response.diesel);
			$("#capac").val(response.capacidad);
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

function nuevo(){
		
	limpiarForm();
	
	$('#fecha').data("DateTimePicker").date(new Date());
	
	$("#btnSub").removeAttr('disabled');
	$('#nuevo').modal({
		show : true,
		backdrop : 'static',
		keyboard : false
	});
}

function grabar() {

	$("#btnSub").attr('disabled', 'disabled');

	var id =	$('#id').val();
	var tic = $('#ticket').val();
	var fec = $('#fechaR').val();
	var hor = $('#hora').val();
	var con = $('#conduc').val();
	var des = $('#dest').val();
	var pla = $('#placa').val();
	var die = $('#d2').val();
	var cap = $('#capac').val();

	var msg = '';

	if (!tic.trim()) {
		$('#ticket').addClass("has_error_per");
		msg = msg + " - Ingrese un ticket <br>";
	}
	if (!fec.trim()) {
		$('#fechaR').addClass("has_error_per");
		msg = msg + " - Ingrese una fecha <br>";
	}
	if (!hor.trim()) {
		$('#hora').addClass("has_error_per");
		msg = msg + " - Ingrese una hora <br>";
	}
	if (!con.trim()) {
		$('button[data-id="conduc"]').addClass('has_error_per');
		msg = msg + " - Seleccione un conductor <br>";
	}
	if (!des.trim()) {
		$('button[data-id="dest"]').addClass('has_error_per');
		msg = msg + " - Ingrese un nombre <br>";
	}
	if (!pla.trim()) {
		$('button[data-id="placa"]').addClass('has_error_per');
		msg = msg + " - Ingrese un nombre <br>";
	}
	if (!cap.trim()) {
		$('#capac').addClass("has_error_per");
		msg = msg + " - Ingrese la capacidad <br>";
	}

	if (!msg.trim()) {

		var urlSave = myContextPath +'/entrega/saveOrUpdate';

		var formData = {
			"id" :id,
			"ticket" :tic,
			"fecha" :fec,
			"hora" :hor,
			"conductor" : {"id": con} ,
			"destino" : {"id": des} ,
			"vehiculo" : {"id": pla} ,
			"diesel" :die,
			"capacidad" :cap
		};
		$.ajax({
			type : "POST",
			contentType : 'application/json; charset=utf-8',
			dataType : 'json',
			url : urlSave,
			data : JSON.stringify(formData),
			success : function(response) {
				if (response.estado == '3') {
					mnsjOk(response.mensaje);
					$('#nuevo').modal('hide');
					var oTable = $('#example').DataTable();
					oTable.ajax.reload();
				} else {
					mnsjWa(response.mensaje);
					$("#btnSub").removeAttr('disabled');
				}
			},
			error : function() {
				mnsjKo('Error procesando');
			}
		});
	} else {
		$("#btnSub").removeAttr('disabled');
		mnsjKo(msg);
	}
}


function limpiarForm() {
	$('#frmEntrega').find('input, label, select, textarea').removeClass('has_error_per');
	$('#id').val('');
	$("#ticket").val('');
	$("#fechaR").val('');
	$("#hora").val('');
	$("#conduc").val('');
	$("#dest").val('');
	$("#placa").val('');
	$("#d2").val('');
	$("#capac").val('');
    $('#conduc').selectpicker('refresh');
    $('#dest').selectpicker('refresh');
    $('#placa').selectpicker('refresh');
    $('button[data-id="conduc"]').removeClass('has_error_per');
    $('button[data-id="dest"]').removeClass('has_error_per');
    $('button[data-id="placa"]').removeClass('has_error_per');
}

function tablaForm(){

	var urlLoad = myContextPath +'/entrega/lst';
	
	$("#example").dataTable({        
		"sAjaxSource" : urlLoad,
		"fnServerParams" : function(aoData) {
 			aoData.push(
 					{ "name" : "fecAuxI", "value" : $('#fechaInS').val() },
					{ "name" : "fecAuxF", "value" : $('#fechaFiS').val() });  
 		},
		"aoColumns" : [
			{ "mData" : "ticket"},
			{ "mData" : "fecha"},
			{ "mData" : "hora"},
			{ "mData" : "conductor.nombre"},
			{ "mData" : "destino.nombre"},
			{ "mData" : "vehiculo.placa"},
			{ "mData" : "capacidad"},
			{ "mData" : "diesel"},
			{ "mData": null, "sClass": "buttonCol", "mRender":
			function (obj) {
				return '<button type="button" id="btnToolE" data-toggle="tooltip" title="Editar"'+
						'class="btn btn-success btn-xs margin_button" onclick="editar(\''+obj.id+'\')">'
	            		+'<i class="glyphicon glyphicon-edit"></i>'+
	            	'</button>&nbsp;&nbsp;'+
	            	'<button type="button" id="btnToolD" data-toggle="tooltip" title="Eliminar"'+
						'class="btn btn-success btn-xs margin_button" '
	            		+'onclick="eliminar(\''+obj.id+'\',\'el Registro\')">' 
	            		+'<i class="glyphicon glyphicon-remove-circle"></i>'+
	            	'</button>';
	            	}
            }
		]
	});
}

	function limpiarFormS() {
		$("#fechaInS").val('');
		$("#fechaFiS").val('');
		var oTable = $('#example').DataTable();
		oTable.ajax.reload();
	}
	function filtrar() {
		var oTable = $('#example').DataTable();
		oTable.ajax.reload();
	}