$("#users-table").on('click', '#userUpdate-modal', function() {
	var currentRow=$(this).closest("tr");
	var userEmail = currentRow.find('td:eq(2)').text();
	var userPosition = currentRow.find('td:eq(4)').text();
	var userIsAdmin = currentRow.find('td:eq(7)').text();
	if(userIsAdmin == "true") {
		userIsAdmin = 1;
	} else {
		userIsAdmin = 2;
	}
	$("#userUpdate #userEmail").val( userEmail );
	$("#userUpdate #userPosition").val( userPosition );
	$("#userUpdate #userIsAdmin").val( userIsAdmin );
});