$("#users-table").on('click', '#discount-modal', function() {
	var currentRow=$(this).closest("tr");
	var userid = currentRow.find('td:eq(0)').text();
	$("#user-discount #user_id").val( userid );
});