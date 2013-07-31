<%@page contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>

<div id="breadcrumb">
	<a href="${ctx}/console/home"><i class="icon-home"></i> 首页</a>
	<a href="#"><i class="icon-cog"></i> 系统设置</a>
	<a href="#">基本设置</a>
	<a class="current" href="#">系统邮箱配置</a>
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
						<a href="${ctx}/console/baseConfig/emailConfig">系统邮箱配置</a>
						</li>
					</ul>
				</div>
				<div class="widget-content">
					<div class="row-fluid">
						<div class="span8">
						
							<form class="form-horizontal" method="get" action="#">
								<div class="alert">
									以下信息用于发送系统邮件，请务必正确填写
									<a href="#" data-dismiss="alert" class="close">×</a>
								</div>
								<div class="control-group">
									<label class="control-label" for=""><span class="red">*</span> 发件人姓名</label>
									<div class="controls">
										<input type="text" name="" value="">
										<span class="help-block">所显示的发件人姓名</span>
									</div>	
								</div>
								<div class="control-group">
									<label class="control-label" for=""><span class="red">*</span> 邮箱账号</label>
									<div class="controls">
										<input type="text" name="" value="">
										<span class="help-block">用于发送邮件的邮箱账号</span>
									</div>	
								</div>
								<div class="control-group">
									<label class="control-label" for=""><span class="red">*</span> SMTP服务器</label>
									<div class="controls">
										<input type="text" name="" value="">
										<span class="help-block">如163邮箱为smtp.163.com</span>
									</div>	
								</div>
								<div class="control-group">
									<label class="control-label" for=""><span class="red">*</span> 邮箱密码</label>
									<div class="controls">
										<input type="text" name="" value="">
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
									<button class="btn btn-primary" type="submit">保存</button>
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