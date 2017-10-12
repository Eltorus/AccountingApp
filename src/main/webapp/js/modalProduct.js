$("#pTable").on('click', '#updateProduct', function() {
	var currentRow=$(this).closest("tr");
	var pid = currentRow.find('td:eq(0)').text();
	var pTitle = currentRow.find('td:eq(1)').text();
	var pCategory = $(this).data("cat");
	var pPrice = currentRow.find('td:eq(3)').text();
	var pDesc = currentRow.find('td:eq(4)').text();
	var pAmount = currentRow.find('td:eq(5)').text();
    var pImgPath = currentRow.find('td:eq(6)').text();
	$("#productInfo #product_id").val( pid );
    $("#productInfo #title").val( pTitle );
    $("#productInfo #category").val( pCategory );
    $("#productInfo #price").val( pPrice );
    $("#productInfo #description").val( pDesc );
    $("#productInfo #amount").val( pAmount );
    $("#productInfo #product_img").val(pImgPath);
});

$("#addProduct").click(function() {
	$("#productInfo #title").val("");
    $("#productInfo #category").val("");
    $("#productInfo #price").val("");
    $("#productInfo #description").val("");
    $("#productInfo #amount").val(""); 
});

$("#pTable").on('click', '#deleteProduct', function() {
    var currentRow=$(this).closest("tr");
    var pid = currentRow.find('td:eq(0)').text();
    $("#delete-product-modal #product-id").val( pid );
});