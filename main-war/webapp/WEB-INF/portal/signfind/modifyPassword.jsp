<%@page contentType="text/html;charset=utf-8" pageEncoding="utf-8" %>
<link href="${ctx}/asset/css/pages/signin.css" rel="stylesheet">
<script src="${ctx}/asset/js/signin.js"></script>
<div class="account-container register stacked">
	
	<div class="content clearfix">
		
		<form action="" method="post">
		
			<h1>重置密码</h1>		
			
			<div class="login-fields">
				
				<p>您正在重置 [ ${user.userName} ] 的密码:</p>
				
				<div class="field">
					<label for="password">新密码:</label>
					<input type="password" id="password" name="password" value="" placeholder="新密码" class="login"/>
					<input type="hidden" id="userId" name="userId" value="${user.id}" />
					<input type="hidden" id="passwordUrl" name="passwordUrl" value="${user.attributes.passwordUrl}"/>
				</div> <!-- /field -->
				
				<div class="field">
					<label for="confirm_password">确认密码:</label>
					<input type="password" id="confirm_password" value="" placeholder="确认密码" class="login"/>
				</div> <!-- /field -->
				
			</div> <!-- /login-fields -->
			
			<div class="login-actions">
				 
				<button type="button" class="button btn btn-warning btn-large" id="doModifyPassword-btn">确定</button>
				
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






