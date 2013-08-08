/**
 * Unicorn Admin Template
 * Diablo9983 -> diablo9983@gmail.com
**/
$(document).ready(function(){

	reSetJqueryAlert();
	reWriteJQueryAjax();
	bindSwitchCheckbox();
	
	// === Sidebar navigation === //
	
	$('.submenu > a').click(function(e)
	{
		e.preventDefault();
		var submenu = $(this).siblings('ul');
		var li = $(this).parents('li');
		var submenus = $('#sidebar li.submenu ul');
		var submenus_parents = $('#sidebar li.submenu');
		if(li.hasClass('open'))
		{
			if(($(window).width() > 768) || ($(window).width() < 479)) {
				submenu.slideUp();
			} else {
				submenu.fadeOut(250);
			}
			li.removeClass('open');
		} else 
		{
			if(($(window).width() > 768) || ($(window).width() < 479)) {
				submenus.slideUp();			
				submenu.slideDown();
			} else {
				submenus.fadeOut(250);			
				submenu.fadeIn(250);
			}
			submenus_parents.removeClass('open');		
			li.addClass('open');	
		}
	});
	
	var ul = $('#sidebar > ul');
	
	$('#sidebar > a').click(function(e)
	{
		e.preventDefault();
		var sidebar = $('#sidebar');
		if(sidebar.hasClass('open'))
		{
			sidebar.removeClass('open');
			ul.slideUp(250);
		} else 
		{
			sidebar.addClass('open');
			ul.slideDown(250);
		}
	});
	
	// === Resize window related === //
	$(window).resize(function()
	{
		if($(window).width() > 479)
		{
			ul.css({'display':'block'});	
			$('#content-header .btn-group').css({width:'auto'});		
		}
		if($(window).width() < 479)
		{
			ul.css({'display':'none'});
			fix_position();
		}
		if($(window).width() > 768)
		{
			$('#user-nav > ul').css({width:'auto',margin:'0'});
            $('#content-header .btn-group').css({width:'auto'});
		}
	});
	
	if($(window).width() < 468)
	{
		ul.css({'display':'none'});
		fix_position();
	}
	if($(window).width() > 479)
	{
	   $('#content-header .btn-group').css({width:'auto'});
		ul.css({'display':'block'});
	}
	
	// === Bootstrap Tooltips === //
	$('.tip').tooltip();	
	$('.tip-left').tooltip({ placement: 'left' });	
	$('.tip-right').tooltip({ placement: 'right' });	
	$('.tip-top').tooltip({ placement: 'top' });	
	$('.tip-bottom').tooltip({ placement: 'bottom' });
	
	// === Bootstrap collapse === //
	$(".collapse").collapse();
	
	// === Search input typeahead === //
	$('#search input[type=text]').typeahead({
		source: ['Dashboard','Form elements','Common Elements','Validation','Wizard','Buttons','Icons','Interface elements','Support','Calendar','Gallery','Reports','Charts','Graphs','Widgets'],
		items: 4
	});
	
	// === Fixes the position of buttons group in content header and top user navigation === //
	function fix_position()
	{
		var uwidth = $('#user-nav > ul').width();
		$('#user-nav > ul').css({width:uwidth,'margin-left':'-' + uwidth / 2 + 'px'});
        
        var cwidth = $('#content-header .btn-group').width();
        $('#content-header .btn-group').css({width:cwidth,'margin-left':'-' + uwidth / 2 + 'px'});
	}
	
	
});

function bindSwitchCheckbox() {
	$('.make-switch').on('switch-change', function (e, data) {
		$(this).find('input:checkbox').attr('checked', data.value);
	});
}

function reSetJqueryAlert() {
	$.alert = function(text, type) {
		type = type||'info';
		$.globalMessenger().post({
			  message: text,
			  type: type,//success,info,error
			  showCloseButton: true
			});
	};
	$._messengerDefaults = {
		extraClasses: 'messenger-fixed messenger-theme-future messenger-on-bottom'
	};
}

function reWriteJQueryAjax() {
	//备份jquery的ajax方法  
    var _ajax=$.ajax;  
      
    //重写jquery的ajax方法  
    $.ajax2=function(opt){  
    	//按钮效果
		if (opt.btn) {
			$(opt.btn).addClass('disabled');
		}
		
        //备份opt中error和success方法  
        var fn = {  
            error:function(XMLHttpRequest, textStatus, errorThrown){},  
            success:function(data, textStatus){}  
        }  
        if(opt.error){  
            fn.error=opt.error;  
        }  
        if(opt.success){  
            fn.success=opt.success;  
        }  
        opt.type= 'post';
        opt.dataType= 'json';
		
        //扩展增强处理  
        var _opt = $.extend(opt,{  
        	//错误方法增强处理  
            error:function(XMLHttpRequest, textStatus, errorThrown){  
                fn.error(XMLHttpRequest, textStatus, errorThrown);  
                
                //按钮效果
                if (opt.btn) {
        			$(opt.btn).removeClass('disabled');
        		}
            },  
            success:function(data, textStatus){  
            	//成功回调方法增强处理  
                if (data.code != 0) {
                	$.alert(data.message,data.resultType);
                	if (fn.error) {
                		fn.error(data, textStatus);
                	}
                } else {
                	$.alert(data.message,data.resultType);
                	if (fn.success) {
                		fn.success(data, textStatus);
                	}
                }
                
                //按钮效果
                if (opt.btn) {
        			$(opt.btn).removeClass('disabled');
        		}
            }  
        });  
        _ajax(_opt);  
    }; 
}