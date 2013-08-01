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
									<label class="control-label" for="senderName"><span class="red">*</span> 发件人姓名</label>
									<div class="controls">
										<input type="text" name="senderName" value="${dto.senderName}">
										<span class="help-block">所显示的发件人姓名</span>
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
									<label class="control-label" for="stmpServer"><span class="red">*</span> SMTP服务器</label>
									<div class="controls">
										<input type="text" name="stmpServer" value="${dto.stmpServer}">
										<span class="help-block">如163邮箱为smtp.163.com</span>
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
									<label class="control-label" for=""><span class="red">*</span> 邮件发送测试</label>
									<div class="controls">
										<input class="btn" type="button" name="" value="点击测试">
									</div>	
								</div>
								<div class="form-actions">
									<button class="btn btn-primary" type="button" id="save-btn" onclick="doSave()">保存</button>
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
$(function() {
	
	$('#fform').validate({
		rules: {
			senderName: {
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