$('#datepicker').mask("99.99.9999");

$('#address').on('keyup', function() {
	var address = $('#address').val();
	if(address.length != 0) {
		$('#addressinput').attr('class', 'form-group has-feedback');
		$('#purchase').prop('disabled', false);
	} else {
		$('#addressinput').attr('class', 'form-group has-feedback has-error');
		$('#purchase').prop('disabled', true);
	}
});

$("#submit-order-info").click(function(){
	var complitedChecked = $('#order-complited').is(':checked'); 
	if(!complitedChecked) {
		$('#datepicker').prop('required', false);
	}
}); 