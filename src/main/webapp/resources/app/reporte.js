$(document).ready(function() {
		limpiar();
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

	});

	function vehiculo() {
		$("#rprtV").removeAttr("href");

		var fi = $('#fechaInS').val();
		var ff = $('#fechaFiS').val();

		var msg = '';

		if (!fi.trim()) {
			$('#fechaInS').addClass("has_error_per");
			msg = msg + " - Ingrese una fecha de inicio <br>";
		}
		if (!ff.trim()) {
			$('#fechaFiS').addClass("has_error_per");
			msg = msg + " - Ingrese una fecha final <br>";
		}
		if (msg.trim()) {
			mnsjKo(msg);
		} else {
			$('#fechaInS').removeClass('has_error_per');
			$('#fechaFiS').removeClass('has_error_per');
			var ri = fi.replace("/", "-").replace("/", "-");
			var rf = ff.replace("/", "-").replace("/", "-");

			var urlDel = myContextPath + '/informe/vehiculo/' + ri + '/' + rf;
			$("#rprtV").attr("href", urlDel);
		}

	}

	function conductor() {
		$("#rprtC").removeAttr("href");

		var fi = $('#fechaInS').val();
		var ff = $('#fechaFiS').val();

		var msg = '';

		if (!fi.trim()) {
			$('#fechaInS').addClass("has_error_per");
			msg = msg + " - Ingrese una fecha de inicio <br>";
		}
		if (!ff.trim()) {
			$('#fechaFiS').addClass("has_error_per");
			msg = msg + " - Ingrese una fecha final <br>";
		}

		if (msg.trim()) {
			mnsjKo(msg);

		} else {
			$('#fechaInS').removeClass('has_error_per');
			$('#fechaFiS').removeClass('has_error_per');
			var ri = fi.replace("/", "-").replace("/", "-");
			var rf = ff.replace("/", "-").replace("/", "-");

			var urlDel = myContextPath + '/informe/conductor/' + ri + '/' + rf;

			$("#rprtC").attr("href", urlDel);
		}

	}

	function ticket() {

		$("#rprtT").removeAttr("href");

		var fi = $('#fechaInS').val();
		var ff = $('#fechaFiS').val();

		var msg = '';

		if (!fi.trim()) {
			$('#fechaInS').addClass("has_error_per");
			msg = msg + " - Ingrese una fecha de inicio <br>";
		}
		if (!ff.trim()) {
			$('#fechaFiS').addClass("has_error_per");
			msg = msg + " - Ingrese una fecha final <br>";
		}

		if (msg.trim()) {
			mnsjKo(msg);
		} else {
			$('#fechaInS').removeClass('has_error_per');
			$('#fechaFiS').removeClass('has_error_per');
			var ri = fi.replace("/", "-").replace("/", "-");
			var rf = ff.replace("/", "-").replace("/", "-");

			var urlDel = myContextPath + '/informe/ticket/' + ri + '/' + rf;

			$("#rprtT").attr("href", urlDel);
		}

	}

	function limpiar() {
		$("#fechaInS").val('');
		$("#fechaFiS").val('');
		$('#fechaInS').removeClass('has_error_per');
		$('#fechaFiS').removeClass('has_error_per');
	}