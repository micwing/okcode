<%@page contentType="text/html;charset=utf-8" pageEncoding="utf-8" %>
<link href="${ctx}/asset/css/pages/signin.css" rel="stylesheet">
<script src="${ctx}/asset/js/signin.js"></script>
<div class="account-container register stacked">
	
	<div class="content clearfix">
		
		<form action="" method="post">
		
			<h1>创建您的账号</h1>			
			<!-- 
			<div class="login-social">
				<p>使用社交网络账号:</p>
				
				<div class="twitter">
					<a href="#" class="btn_1">腾讯QQ登录</a>				
				</div>
				
				<div class="fb">
					<a href="#" class="btn_2">新浪微博登录</a>				
				</div>
			</div>
			 -->
			
			<div class="login-fields">
				
				<p>创建你的免费账号:</p>
				
				<div class="field">
					<label for="username">登录名:</label>
					<input type="text" id="username" name="username" value="" placeholder="登录名" class="login" />
				</div> <!-- /field -->
				
				
				<div class="field">
					<label for="password">密码:</label>
					<input type="password" id="password" name="password" value="" placeholder="密码" class="login"/>
				</div> <!-- /field -->
				
				<div class="field">
					<label for="confirm_password">确认密码:</label>
					<input type="password" id="confirm_password" value="" placeholder="确认密码" class="login"/>
				</div> <!-- /field -->
				
				<div class="field">
					<label for="paptcha">验证码:</label>
					<input type="text" id="paptcha" name="paptcha" value="@G)+" placeholder="验证码" class="login" style="width: 80px;float: left;" />
					<img class="paptcha-img" width="108px;" style="margin-left: 9px;cursor: pointer;width: 108px;" src="${ctx}/paptcha" alt="验证码"  onclick="this.src=this.src+'?'+Math.random()">
				</div> <!-- /field -->
				
			</div> <!-- /login-fields -->
			
			<div class="login-actions">
				
				<span class="login-checkbox">
					<input id="Field" name="Field" type="checkbox" class="field login-checkbox" value="First Choice" tabindex="4" />
					<label class="choice" for="Field">我已阅读并同意相关<a href="#">使用条款</a>.</label>
				</span>
									
				<button type="button" class="button btn btn-primary btn-large" id="signup-btn">提交</button>
				
			</div> <!-- .actions -->
			
		</form>
		
	</div> <!-- /content -->
	
</div> <!-- /account-container -->


<!-- Text Under Box -->
<div class="login-extra">
	已经拥有账号了？<a href="${ctx}/signin">登录</a>
</div> <!-- /login-extra -->
	
	

