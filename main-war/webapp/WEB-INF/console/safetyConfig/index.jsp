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
				<div class="widget-title"><span class="icon"><i class="icon-signal"></i></span><h5>网站安全</h5></div>
				<div class="widget-content">
					<div class="row-fluid">
						<div class="span8">
						
							<form class="form-horizontal" id="fform" method="get" action="#">
								<div class="control-group">
									<label class="control-label" for="adminLoginVerificationCode">管理员登录验证码</label>
									<div class="controls">
										<div class="make-switch switch-small" data-on-label="开" data-off-label="关">
						                    <input type="checkbox" name="adminLoginVerificationCode" value="true" ${dto.adminLoginVerificationCode==true?'checked':''} />
						                </div>
									</div>
								</div>
								<div class="control-group">
									<label class="control-label" for="portalSubmitVerificationCode">前台提交验证码</label>
									<div class="controls">
										<div class="make-switch switch-small" data-on-label="开" data-off-label="关">
						                    <input type="checkbox" name="portalSubmitVerificationCode" value="true" ${dto.portalSubmitVerificationCode==true?'checked':''}/>
						                </div>
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
			url : "${ctx}/console/safetyConfig/doSaveSafetyConfig",
			data : $("#fform").serialize(),
			btn : '#save-btn'
		});
	}
}
$(function() {
	
	$('#fform').validate({
		rules: {
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