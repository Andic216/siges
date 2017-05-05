<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div id="eliminarObjetc" class="modal fade" >
		<div class="modal-dialog" style="width: 280px !important;">
			<div class="modal-content">
				<div class="modal-header" style="font-size: 13px !important; padding: 5px !important;">
					<label for="myalue"/>
				</div>
				<input type="hidden" id="idElim" name="idElim">
				<div class="modal-footer" style="text-align: center; padding: 5px !important;">
					<button id="nombre1" type="button" class="btn btn-success btn-sm btn_modal_success" 
						onclick="eliminarOk()">Si
					</button>
					<button id="nombre2" type="button" class="btn btn-success btn-sm btn_modal_success">No
					</button>
				</div>
			</div>
		</div> 
</div>

<script src="<c:url value="/resources/js/jquery-1.12.4.js" />" type="text/javascript"></script>
<script src="<c:url value="/resources/js/moment.js" />" type="text/javascript"></script>
<script src="<c:url value="/resources/js/bootstrap.js" />" type="text/javascript"></script>
<script src="<c:url value="/resources/js/bootstrap-datetimepicker.js" />" type="text/javascript"></script>
<script src="<c:url value="/resources/js/custom.js" />" type="text/javascript"></script>
<script src="<c:url value="/resources/js/jquery.dataTables.js" />" type="text/javascript"></script>
<script src="<c:url value="/resources/js/jquery.bootstrap-growl.js" />" type="text/javascript"></script>
<script src="<c:url value="/resources/js/bootstrap-select.min.js" />" type="text/javascript"></script>

<script type="text/javascript">
var myContextPath = '${pageContext.request.contextPath}';
</script>

<script type="text/javascript">

	$(window).load(function() {
		$('#preloader').fadeOut('slow');
		 $('body').css({'overflow':'visible'});
	})


$(document).ready(function() {
		
    $("#btnToolD").tooltip();	
	$('#btnToolE').tooltip();
	$('#btnToolB').tooltip();
	$('#btnToolL').tooltip();

	$(".numb").on("keypress keyup blur",function (event) {    
         $(this).val($(this).val().replace(/[^\d].+/, ""));
		//$(this).val($(this).val().replace(/[^0-9.].+/, ""));
         if ((event.which < 48 || event.which > 57)&&
      	     (event.which != 0 && event.which != 8)) {
             event.preventDefault();
         }
     });
	

	$('.decim').keypress(function(event) {
	    var $this = $(this);
	    if ((event.which != 46 || $this.val().indexOf('.') != -1) &&
	       ((event.which < 48 || event.which > 57) &&
	       (event.which != 0 && event.which != 8))) {
	           event.preventDefault();
	    }

	    var text = $(this).val();
	    if ((event.which == 46) && (text.indexOf('.') == -1)) {
	        setTimeout(function() {
	            if ($this.val().substring($this.val().indexOf('.')).length > 3) {
	                $this.val($this.val().substring(0, $this.val().indexOf('.') + 3));
	            }
	        }, 1);
	    }

	    if ((text.indexOf('.') != -1) &&
	        (text.substring(text.indexOf('.')).length > 2) &&
	        (event.which != 0 && event.which != 8) &&
	        ($(this)[0].selectionStart >= text.length - 2)) {
	            event.preventDefault();
	    }      
	});
});

function eliminar(obj2, obj3){
	$('#eliminarObjetc').modal({
			show : true,
			backdrop : 'static',
			keyboard : false
	});
	$("label[for='myalue']").html("¿Desea eliminar  "+obj3+"?");
	$('#idElim').val(obj2);
	$('button#nombre2').click(function() { 
		   $('#eliminarObjetc').modal('hide');
	});
}


function mnsjOk(msnj){
	$.bootstrapGrowl(msnj, {
		type : 'success', align : 'right', stackup_spacing : 30,
		offset : { from : 'bottom', amount : 150 }
	});
}
function mnsjWa(msnj){
	$.bootstrapGrowl(msnj, {
		type : 'warning', align : 'right', stackup_spacing : 30,
		offset : { from : 'bottom', amount : 150 }
	});
}
function mnsjKo(msnj){
	$.bootstrapGrowl(msnj, {
		type : 'danger', align : 'right', stackup_spacing : 30,
		offset : { from : 'bottom', amount : 150 }
	});
}



// Plug-in to fetch page data 

jQuery.fn.DataTable.ext.pager.numbers_length = 3;

jQuery.fn.dataTableExt.oApi.fnPagingInfo = function(oSettings) {
	return {
		"iStart" : oSettings._iDisplayStart,
		"iEnd" : oSettings.fnDisplayEnd(),
		"iLength" : oSettings._iDisplayLength,
		"iTotal" : oSettings.fnRecordsTotal(),
		"iFilteredTotal" : oSettings.fnRecordsDisplay(),
		"iPage" : oSettings._iDisplayLength === -1 ? 0 : Math
				.ceil(oSettings._iDisplayStart / oSettings._iDisplayLength),
		"iTotalPages" : oSettings._iDisplayLength === -1 ? 0 : Math
				.ceil(oSettings.fnRecordsDisplay()
						/ oSettings._iDisplayLength)
	};
};

$.extend( true, $.fn.dataTable.defaults, {	
	"bSort":false,
	
    "bPaginate":true,
    "sPaginationType":"full_numbers",
   	"bJQueryUI": true,
   	
	"bStateSave" : false,
	"bFilter" : false,
	"bProcessing" : true,
	"iDisplayStart" : 0,
	"iDisplayLength" : 10,
	"dom": "rt<'bottom'ip><'clear'>",
	"scrollCollapse": true,
	
	"oLanguage": {
		"sProcessing":     "Procesando...",
	    "sLengthMenu":     "Mostrar _MENU_ registros",
	    "sZeroRecords":    "No se encontraron resultados",
	    "sEmptyTable":     "Ningún dato disponible en esta tabla",
		"sInfo":           "Registros del _START_ al _END_ de _TOTAL_ registros",
	    "sInfoEmpty":      "Mostrando registros del 0 al 0 de un total de 0 registros",
	    "sInfoFiltered":   "(filtrado de un total de _MAX_ registros)",
	    "sInfoPostFix":    "",
	    "sSearch":         "Buscar:",
	    "sUrl":            "",
	    "sInfoThousands":  ",",
	    "sLoadingRecords": "Cargando...",
	    "oPaginate": {
	        "sFirst":    "Primero",
	        "sLast":     "Último",
	        "sNext":     "Siguiente",
	        "sPrevious": "Anterior"
	    },
	    "oAria": {
	        "sSortAscending":  ": Activar para ordenar la columna de manera ascendente",
	        "sSortDescending": ": Activar para ordenar la columna de manera descendente"
	    }
	}
} );

</script>