$(document).ready(function(){
	
	$(".load").load("menu.jsp");
	
	$(".imput").each(function(){
		var place = $(this).attr("title");
		var input = $(this);

		input
			.val(place)
			.css('color','#999')
			.focusin(function(){
				input.css("color", "#888888");
				if (input.val() == place){
					input.val('');
				}
			}).focusout(function(){				
				if (input.val() == ''){
					input.css('color', '#999');
					input.val(place);
				}
			});

	});
	
	function verificaCodigo(cp){
		if (cp.which != 8 && cp.which != 0 && (cp.which < 48 || cp.which > 57)) {
			return false;
		}
	}
	$(document).ready(function() {
		$("#txtCodigo").keypress(verificaCodigo);
	});	
	
});