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
	
	var messageList = document.getElementById("heureServer");
    // socket endpoint
    var socket = new SockJS('./stomp');
    var stompClient = Stomp.over(socket);
    stompClient.connect({}, function () {
        ///topic/message endpoint
        stompClient.subscribe("/topic/message", function (data) {
            messageList.innerHTML = data.body;
        });
    });
	



});