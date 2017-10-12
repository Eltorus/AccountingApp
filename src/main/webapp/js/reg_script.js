$("#phone").mask("+375 (99) 999-99-99");

$('#password, #confirm_password').on('keyup', function () {
	if($('#password').val()==null || $('#password').val()==''){
		$('#message').html('').css('color', 'red');
        $('#signup_button').attr("disabled", true);
	}
     else if ($('#password').val() == $('#confirm_password').val()) {
        $('#message').html('Passwords match').css('color', 'green');
        $('#signup_button').attr("disabled", false);
        
    } else {
        $('#message').html('Passwords don\'t match').css('color', 'red');
        $('#signup_button').attr("disabled", true);
        }
});
