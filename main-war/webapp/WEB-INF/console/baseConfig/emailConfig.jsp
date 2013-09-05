<%@page contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>

<div id="breadcrumb">
	<a href="${ctx}/console/home"><i class="icon-home"></i> 首页</a>
	<a href="${ctx}/console/baseConfig"><i class="icon-cog"></i> 系统设置</a>
	<a href="${ctx}/console/baseConfig">基本设置</a>
	<a class="current" href="${ctx}/console/baseConfig/emailConfig">邮箱配置</a>
</div>
<div class="container-fluid">
	<div class="row-fluid">
		<div class="span12">
			<div class="widget-box">
				<div class="widget-title">
					<ul class="nav nav-tabs">
						<li class="">
						<a href="${ctx}/console/baseConfig">基本信息</a>
						</li>
						<li class="active">
						<a href="${ctx}/console/baseConfig/emailConfig">邮箱配置</a>
						</li>
						<li class="">
						<a href="${ctx}/console/baseConfig/runStatus">运行状态</a>
						</li>
					</ul>
				</div>
				<div class="widget-content">
					<div class="row-fluid">
						<div class="span8">
						
							<form id="fform" class="form-horizontal" method="get" action="#">
								<div class="alert">
									以下信息用于发送系统邮件，请务必正确填写
									<a href="#" data-dismiss="alert" class="close">×</a>
								</div>
								<div class="control-group">
									<label class="control-label" for="stmpServer"><span class="red">*</span> SMTP服务器</label>
									<div class="controls">
										<input type="text" name="stmpServer" value="${dto.stmpServer}">
										<span class="help-block">如163邮箱为smtp.163.com</span>
									</div>	
								</div>
								<div class="control-group">
									<label class="control-label" for="port"><span class="red">*</span> 端口</label>
									<div class="controls">
										<input type="text" name="port" value="${dto.port}">
										<span class="help-block">smtp服务器端口</span>
									</div>	
								</div>
								<div class="control-group">
									<label class="control-label" for="address"><span class="red">*</span> 邮箱账号</label>
									<div class="controls">
										<input type="text" name="address" value="${dto.address}">
										<span class="help-block">用于发送邮件的邮箱账号</span>
									</div>	
								</div>
								<div class="control-group">
									<label class="control-label" for="password"><span class="red">*</span> 邮箱密码</label>
									<div class="controls">
										<input type="password" name="password" value="${dto.password}">
										<span class="help-block">用于发送邮件的邮箱密码</span>
									</div>	
								</div>
								<div class="control-group">
									<label class="control-label" for="testEmailAddress"> 测试邮件的接收邮箱</label>
									<div class="controls">
										<input type="text" id="testEmailAddress" name="testEmailAddress" value="${dto.testEmailAddress}" placeholder="测试邮件接收邮箱">
									</div>	
								</div>
								<div class="form-actions">
									<button class="btn btn-primary" type="button" id="save-btn" onclick="doSave()">保存</button> <button class="btn btn-primary" type="button" id="send-test-btn" onclick="doSendTestEmail()" >保存并发送测试邮件</button>
								</div>
							</form>
						</div>
						<div class="span4">
						</div>
					</div>	
				</div>
			</div>					
		</div>
	</div>
</div>
<script type="text/javascript">
function doSave() {
	if ($('#fform').valid()) {
		$.ajax2({
			url : "${ctx}/console/baseConfig/doSaveEmailConfig",
			data : $("#fform").serialize(),
			btn : '#save-btn'
		});
	}
}
function doSendTestEmail() {
	if ($('#testEmailAddress').val() == '') {
		$.alert('请输入测试邮件的接收邮箱','error');
		$('#testEmailAddress').focus();
		return;
	}
	if ($('#fform').valid()) {
		$.ajax2({
			url : "${ctx}/console/baseConfig/doSendTestEmail",
			data : $("#fform").serialize(),
			btn : '#save-btn,#send-test-btn'
		});
	}
}
$(function() {
	
	$('#fform').validate({
		rules: {
			port: {
				required: true,
				maxlength:1000
			},
			address: {
				required: true,
				maxlength:1000
			},
			stmpServer: {
				required: true,
				maxlength:1000
			},
			password: {
				required: true,
				maxlength:1000
			}
		},
		errorClass: "help-inline",
		errorElement: "span",
		highlight:function(element, errorClass, validClass) {
			$(element).parents('.control-group').removeClass('success');
			$(element).parents('.control-group').addClass('error');
		},
		unhighlight: function(element, errorClass, validClass) {
			$(element).parents('.control-group').removeClass('error');
			$(element).parents('.control-group').addClass('success');
		}
	});
});
</script>