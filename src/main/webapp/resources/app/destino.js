$(document).ready(function() {
	tablaForm();
});

function eliminarOk() {

	var urlDel = myContextPath + '/destino/delete';

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
	var urlEdit = myContextPath + '/destino/edit';

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

			$("#id").val(response.id), $("#codigo").val(response.codigo);
			$("#nombre").val(response.nombre);

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
	var cod = $("#codigo").val();
	var nomb = $("#nombre").val();

	var msg = '';

	if (!nomb.trim()) {
		$('#nombre').addClass("has_error_per");
		msg = msg + " - Ingrese un nombre <br>";
	}

	if (!msg.trim()) {

		var urlSave = myContextPath + '/destino/saveOrUpdate';

		var formData = {
			"id" : id,
			"codigo" : cod,
			"nombre" : nomb
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

	$('#frmDestino').find('input, label, select, textarea').removeClass(
			'has_error_per');
	$('#id').val('');
	$("#codigo").val('');
	$("#nombre").val('');
}

function tablaForm() {

	var urlLoad = myContextPath + '/destino/lst';

	$("#example")
			.dataTable(
					{
						"sAjaxSource" : urlLoad,
						"fnServerParams" : function(aoData) {
							aoData.push({
								"name" : "nombre",
								"value" : $('#nombreS').val()
							});
						},
						"aoColumns" : [
								{
									"mData" : "codigo"
								},
								{
									"mData" : "nombre"
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
	$('#nombreS').val('');
	var oTable = $('#example').DataTable();
	oTable.ajax.reload();
}
function filtrar() {
	var oTable = $('#example').DataTable();
	oTable.ajax.reload();
}