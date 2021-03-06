<%@page contentType="text/html;charset=utf-8" pageEncoding="utf-8" %>
<link href="${ctx}/asset/css/pages/signin.css" rel="stylesheet">
<script src="${ctx}/asset/js/signin.js"></script>
<div class="account-container stacked">
	
	<div class="content clearfix">
		
		<form action="" method="post">
		
			<h1>找回密码</h1>		
			
			<div class="login-fields">
				
				<p>已注册的账号:</p>
				
				<div class="field">
					<label for="username">用户名:</label>
					<input type="text" id="username" name="username" value="" placeholder="用户名" class="login" />
				</div> <!-- /field -->
				
				<div class="field">
					<label for="email">邮箱:</label>
					<input type="text" id="email" name="email" value="" placeholder="邮箱" class="login"/>
				</div> <!-- /password -->
				
				<div class="field">
					<label for="paptcha">验证码:</label>
					<input type="text" id="paptcha" name="paptcha" value="@G)+" placeholder="验证码" class="login" style="width: 80px;float: left;" />
					<img class="paptcha-img" width="108px;" style="margin-left: 9px;cursor: pointer;width: 108px;" src="${ctx}/paptcha" alt="验证码"  onclick="this.src=this.src+'?'+Math.random()">
				</div> <!-- /field -->
				
			</div> <!-- /login-fields -->
			
			<div class="login-actions">
				 
				<button type="button" class="button btn btn-warning btn-large" id="findPassword-btn">确定</button>
				
			</div> <!-- .actions -->
			<!-- 
			<div class="login-social">
				<p>使用社交网络账号登录:</p>
				
				<div class="twitter">
					<a href="#" class="btn_1">腾讯QQ登录</a>				
				</div>
				
				<div class="fb">
					<a href="#" class="btn_2">新浪微博登录</a>				
				</div>
			</div>
			 -->
			
		</form>
		
	</div> <!-- /content -->
	
</div> <!-- /account-container -->


<!-- Text Under Box -->
<div class="login-extra">
	还没有账号？ <a href="${ctx}/signup">立即注册</a><br/>
	已经拥有账号了？<a href="${ctx}/signin">登录</a>
</div> <!-- /login-extra -->


