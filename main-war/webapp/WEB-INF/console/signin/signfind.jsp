<%@page contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>找回密码</title>
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
            <form id="loginform" action="#" class="form-vertical">
				<p>请输入E-mail</p>
				<div class="control-group">
                    <div class="controls">
                        <div class="input-prepend">
                            <span class="add-on"><i class="icon-envelope"></i></span><input type="text" placeholder="E-mail" />
                        </div>
                    </div>
                </div>
                <div class="control-group">
                    <div class="controls">
                        <div class="input-prepend">
                            <span class="add-on"><i class="icon-hand-right"></i></span><input type="text" id="password" placeholder="验证码" style="width: 117px;"/>
                            <img class="paptcha-img" style="margin-left: 9px;cursor: pointer;height: 30px" src="${ctx}/paptcha" alt="验证码"  onclick="this.src=this.src+'?'+Math.random()">
                        </div>
                    </div>
                </div>
                <div class="form-actions">
                    <span class="pull-left"><a href="${ctx}/console/signin" class="flip-link" id="to-login">&lt; 返回登录</a></span>
                    <span class="pull-right"><input type="button" class="btn btn-inverse" value="确定" onclick="alert('功能未实现')"/></span>
                </div>
            </form>
        </div>
        
        <script src="${ctx}/asset/console/js/unicorn.login.js"></script> 
    </body>
</html>
