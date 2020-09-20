$(document).ready(function() {
	
	// DO GET
	$.ajax({
		type : "GET",
		url : "api/customer/allnew",
		success: function(result){
			$.each(result, function(i, item){
				
				var itemRow = '<tr>' +
				'<td>' + item.id + '</td>' +
				'<td>' + item.itemId + '</td>' +
				'<td>' + item.description + '</td>' +
				'<td>' + item.lastSold + '</td>' +
				'<td>' + item.shelfLife + '</td>' +
				'<td>' + item.department + '</td>' +
				'<td>' + item.price + '</td>' +
				'<td>' + item.unit + '</td>' +
				'<td>' + item.xFor + '</td>' +
				'<td>' + item.cost + '</td>' +
						  '</tr>';
				
				$('#itemTable tbody').append(itemRow);
				
	        });
			
			$( "#itemTable tbody tr:odd" ).addClass("info");
			$( "#itemTable tbody tr:even" ).addClass("success");
		},
		error : function(e) {
			alert("ERROR: ", e);
			console.log("ERROR: ", e);
		}
	});
	
	// do Filter on View
	$("#inputFilter").on("keyup", function() {
	    var inputValue = $(this).val().toLowerCase();
	    $("#itemTable tr").filter(function() {
	    	$(this).toggle($(this).text().toLowerCase().indexOf(inputValue) > -1)
	    });
	});
})