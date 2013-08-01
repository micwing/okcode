<%@page contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div id="breadcrumb">
	<a href="${ctx}/console/home"><i class="icon-home"></i> 首页</a>
	<a href="#"><i class="icon-cog"></i> 系统设置</a>
	<a href="#">基本设置</a>
	<a class="current" href="${ctx}/console/baseConfig/runStatus">运行状态</a>
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
						<li class="">
						<a href="${ctx}/console/baseConfig/emailConfig">邮箱配置</a>
						</li>
						<li class="active">
						<a href="${ctx}/console/baseConfig/runStatus">运行状态</a>
						</li>
					</ul>
				</div>
				<div class="widget-content">
					<div class="row-fluid">
						<div class="span8">
						
							<form id="fform" class="form-horizontal" method="get" action="#">
								<div class="control-group">
									<label class="control-label" for="runStatus">网站运行状态</label>
									<div class="controls">
										<div class="btn-group">
											<select name="runStatus">
												<option value="NORMAL" ${dto.runStatus == 'NORMAL' ? 'selected':''}>正常运行</option>
												<option value="PAUSED" ${dto.runStatus == 'PAUSED' ? 'selected':''}>暂停倒计时</option>
												<option value="DELETED" ${dto.runStatus == 'DELETED' ? 'selected':''}>完全关闭</option>
											</select>
										</div>
									</div>	
								</div>
								<div class="control-group">
									<label class="control-label" for="recoverTime">恢复时间</label>
									<div class="controls">
										<input class="Wdate" type="text" name="recoverTime" value="${dto.recoverTime}" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" readonly="readonly" placeholder="点击选择时间"/>
										<span class="help-block">“暂停倒计时”状态下的恢复正常运行的时间点</span>
									</div>	
								</div>
								<div class="control-group">
									<label class="control-label" for="siteNotice">网站通知</label>
									<div class="controls">
										<textarea name="siteNotice" rows="4" cols="4" placeholder="网站通知">${dto.siteNotice}</textarea>
										<span class="help-block">“暂停倒计时”或者“完全关闭”状态下挂出的通知，1000字以内</span>
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
			url : "${ctx}/console/baseConfig/doSaveRunStatus",
			data : $("#fform").serialize(),
			btn : '#save-btn'
		});
	}
}
$(function() {
	
	$('#fform').validate({
		rules: {
			runStatus: {
				required: true
			},
			recoverTime: {
				maxlength:1000
			},
			siteNotice: {
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