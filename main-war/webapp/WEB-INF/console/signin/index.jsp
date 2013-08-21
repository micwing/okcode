<%@page contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>登录</title>
		<meta charset="UTF-8" />
		<meta http-equiv="content-language" content="zh-CN">
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<link rel="stylesheet" href="${ctx}/asset/console/css/bootstrap.min.css" />
		<link rel="stylesheet" href="${ctx}/asset/console/css/bootstrap-responsive.min.css" />
        <link rel="stylesheet" href="${ctx}/asset/console/css/unicorn.login.css" />
        
        <script src="${ctx}/asset/console/js/jquery-1.9.1.min.js"></script>
    </head>
    <body>
        <div id="logo">
            <img src="${ctx}/asset/console/img/logo.png" alt="" />
        </div>
        <div id="loginbox" style="height: 227px;">            
            <form id="loginform" class="form-vertical" action="index.html">
				<p id="msg">请输入用户名与密码</p>
                <div class="control-group">
                    <div class="controls">
                        <div class="input-prepend">
                            <span class="add-on"><i class="icon-user"></i></span><input type="text" id="username" placeholder="用户名" />
                        </div>
                    </div>
                </div>
                <div class="control-group">
                    <div class="controls">
                        <div class="input-prepend">
                            <span class="add-on"><i class="icon-lock"></i></span><input type="password" id="password" placeholder="密码" />
                        </div>
                    </div>
                </div>
                <c:if test="${safetyConfigDto.adminLoginVerificationCode == true}">
                <div class="control-group">
                    <div class="controls">
                        <div class="input-prepend">
                            <span class="add-on"><i class="icon-hand-right"></i></span><input type="text" id="paptcha" placeholder="验证码" style="width: 117px;"/>
                            <img class="paptcha-img" style="margin-left: 9px;cursor: pointer;height: 30px" src="${ctx}/paptcha" alt="验证码"  onclick="this.src=this.src+'?'+Math.random()">
                        </div>
                    </div>
                </div>
                <script type="text/javascript">
                $('#loginbox').css('height', '277px');
                </script>
                </c:if>
                <div class="form-actions">
                    <span class="pull-left"><a href="${ctx}/console/signin/signfind" class="flip-link" id="to-recover">忘记密码?</a></span>
                    <span class="pull-right"><input type="button" class="btn btn-inverse" value="登录" onclick="doSignin()"/></span>
                </div>
            </form>
        </div>
        
        <script src="${ctx}/asset/console/js/unicorn.login.js"></script> 
        <script type="text/javascript">
        function doSignin() {
        	if ($('#username').val() == '') {
        		$('#msg').html('<span style="color:red">请输入用户名！</span>');
        		$('#username').focus();
        		return;
        	}
        	if ($('#password').val() == '') {
        		$('#msg').html('<span style="color:red">请输入密码！</span>');
        		$('#password').focus();
        		return;
        	}
        	<c:if test="${safetyConfigDto.adminLoginVerificationCode == true}">
        	if ($('#paptcha').val() == '') {
        		$('#msg').html('<span style="color:red">请输入验证码！</span>');
        		$('#paptcha').focus();
        		return;
        	}
        	</c:if>
        	
        	$.ajax({
    			url : "${ctx}/console/signin/doSignin",
    			type : 'post',
    	        dataType : 'json',
    			data : {username:$('#username').val(), password:$('#password').val(), paptcha:$('#paptcha').val()},
    			success : function(data) {
    				if (data.code != 0) {
	    				$('#msg').html('<span style="color:red">'+data.message+'</span>');
	    				$('#password').focus();
    				} else {
    					location.href = '/console/signin/redirect';
    				}
    			}
    		});
        }
        $("input").keyup(function(e){
            if (13 == e.which) {
        		doSignin();
            }
       	});
        </script>
    </body>
</html>
