$(document).ready(function() {
	tablaForm();
});

function eliminarOk() {

	var urlDel = myContextPath + '/vehiculo/delete';

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
			if (response.estado == '3') {
				mnsjOk(response.mensaje);
				var oTable = $('#example').DataTable();
				oTable.ajax.reload();
			} else {
				mnsjWa(response.mensaje);
			}
		},
		error : function() {
			alert('Error while request..');
		}
	});
}

function editar(id) {
	$("#btnSub").removeAttr('disabled');
	var urlEdit = myContextPath + '/vehiculo/edit';

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

			$("#id").val(response.id), $("#placa").val(response.placa);
			$("#marca").val(response.marca);

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

function nuevo() {
	limpiarForm();
	$("#btnSub").removeAttr('disabled');
	$('#nuevo').modal({
		show : true,
		backdrop : 'static',
		keyboard : false
	});
}

function grabar() {

	$("#btnSub").attr('disabled', 'disabled');

	var id = $('#id').val();
	var plac = $("#placa").val();
	var marc = $("#marca").val();

	var msg = '';

	if (!plac.trim()) {
		$('#placa').addClass("has_error_per");
		msg = msg + " - Ingrese una placa <br>";
	}

	if (!msg.trim()) {

		var urlSave = myContextPath+'/vehiculo/saveOrUpdate';

		var formData = {
			"id" : id,
			"placa" : plac,
			"marca" : marc
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

	$('#frmVehiculo').find('input, label, select, textarea').removeClass(
			'has_error_per');
	$('#id').val('');
	$("#placa").val('');
	$("#marca").val('');
}

function tablaForm() {

	var urlLoad = myContextPath + '/vehiculo/lst';

	$("#example")
			.dataTable(
					{
						"sAjaxSource" : urlLoad,
						"fnServerParams" : function(aoData) {
							aoData.push({
								"name" : "placa",
								"value" : $('#placaS').val()
							});
						},
						"aoColumns" : [
								{
									"mData" : "placa"
								},
								{
									"mData" : "marca"
								},
								{
									"mData" : null,
									"sClass" : "buttonCol",
									"mRender" : function(obj) {
										return '<button type="button" id="btnToolE" data-toggle="tooltip" title="Editar"'
												+ 'class="btn btn-success btn-xs margin_button" onclick="editar(\''
												+ obj.id
												+ '\')">'
												+ '<i class="glyphicon glyphicon-edit"></i>'
												+ '</button>&nbsp;&nbsp;'
												+ '<button type="button" id="btnToolD" data-toggle="tooltip" title="Eliminar"'
												+ 'class="btn btn-success btn-xs margin_button" '
												+ 'onclick="eliminar(\''
												+ obj.id
												+ '\',\'el Registro\')">'
												+ '<i class="glyphicon glyphicon-remove-circle"></i>'
												+ '</button>';
									}
								} ]
					});
}

function limpiarFormS() {
	$('#placaS').val('');
	var oTable = $('#example').DataTable();
	oTable.ajax.reload();
}
function filtrar() {
	var oTable = $('#example').DataTable();
	oTable.ajax.reload();
}