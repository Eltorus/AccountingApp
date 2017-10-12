$(document).ready(function(){
    $("#pTable").on('click', '#cancelProduct', function() {
	var currentRow=$(this).closest("tr");
	var oid = currentRow.find('td:eq(0)').text();
	$(".modal-body #order-id").val( oid );
});
});