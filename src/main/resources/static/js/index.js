$(document).ready(function(){

	$("#print").click(function(){
		
		$.ajax({
		    url: "book.htm",
		    success: function(data){		    	
		    	$('#book').html(data);
		    	$('#myModal').modal('show');
		    }   
		});
	});
	



});