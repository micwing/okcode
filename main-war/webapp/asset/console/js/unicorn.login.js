/**
 * Unicorn Admin Template
 * Diablo9983 -> diablo9983@gmail.com
**/
$(document).ready(function(){
	$.extend({
		browser: {
			mozilla : /firefox/.test(navigator.userAgent.toLowerCase()),
			webkit : /webkit/.test(navigator.userAgent.toLowerCase()),
			opera : /opera/.test(navigator.userAgent.toLowerCase()),
			msie : /msie/.test(navigator.userAgent.toLowerCase())
		}
	});
	
	
    if($.browser.msie == true) {
        $('input[placeholder]').each(function(){
       
	        var input = $(this);       
	       
	        $(input).val(input.attr('placeholder'));
	               
	        $(input).focus(function(){
	             if (input.val() == input.attr('placeholder')) {
	                 input.val('');
	             }
	        });
	       
	        $(input).blur(function(){
	            if (input.val() == '' || input.val() == input.attr('placeholder')) {
	                input.val(input.attr('placeholder'));
	            }
	        });
	    });
        
    }
});