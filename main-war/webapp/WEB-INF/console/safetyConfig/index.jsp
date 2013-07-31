<%@page contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div id="breadcrumb">
	<a href="${ctx}/console/home"><i class="icon-home"></i> 首页</a>
	<a href="#"><i class="icon-cog"></i> 系统设置</a>
	<a class="current" href="#">网站安全</a>	
</div>
<div class="container-fluid">
	<div class="row-fluid">
		<div class="span12">
			<div class="widget-box">
				<div class="widget-title"><span class="icon"><i class="icon-signal"></i></span><h5>网站安全</h5><div class="buttons"><a href="#" class="btn btn-mini"><i class="icon-refresh"></i> Update stats</a></div></div>
				<div class="widget-content">
					<div class="row-fluid">
						<div class="span8">
						
							<form class="form-horizontal" method="get" action="#">
								<div class="control-group">
									<label class="control-label" for=""><span class="red">*</span> 后台文件夹名称</label>
									<div class="controls">
										<input type="text" name="" value="" placeholder="后台文件夹名称">
									</div>	
								</div>
								<div class="control-group">
									<label class="control-label" for="">管理员登录验证码</label>
									<div class="controls">
										<div class="make-switch switch-small" data-on-label="开" data-off-label="关">
						                    <input type="checkbox" id="admin_verification_ckb" checked />
						                </div>
									</div>
								</div>
								<div class="control-group">
									<label class="control-label" for="">前台登录验证码</label>
									<div class="controls">
										<label class="checkbox">
										<input type="checkbox" name="">
										开启后普通用户登录需要输入验证码
										</label>
									</div>	
								</div>
								<div class="control-group">
									<label class="control-label" for="">前台提交验证码</label>
									<div class="controls">
										<label class="checkbox">
										<input type="checkbox" name="">
										开启后前台用户的提交操作需要输入验证码
										</label>
									</div>	
								</div>
								<div class="control-group">
									<label class="control-label" for="">内容管理回收站</label>
									<div class="controls">
										<label class="checkbox">
										<input type="checkbox" name="">
										开启后被删除的内容先删除到回收站
										</label>
									</div>
								</div>
								<div class="control-group">
									<label class="control-label" for=""><span class="red">*</span> 文件上传最大值</label>
									<div class="controls">
										<input type="text" name="" placeholder="文件上传最大值">
										<span class="help-block">单位：M</span>
									</div>	
								</div>
								<div class="control-group">
									<label class="control-label" for=""><span class="red">*</span> 允许上传的文件格式</label>
									<div class="controls">
										<textarea rows="4" cols="4" placeholder="允许上传的文件格式"></textarea>
										<span class="help-block">多种格式请用“|”隔开</span>
									</div>	
								</div>
								<div class="form-actions">
									<button class="btn btn-primary" type="button" onclick="alert($('#admin_verification_ckb').attr('checked'))">保存</button>
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
