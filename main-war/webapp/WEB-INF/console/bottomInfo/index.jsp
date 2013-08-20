<%@page contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>

<div id="breadcrumb">
	<a href="${ctx}/console/home"><i class="icon-home"></i> 首页</a>
	<a href="#"><i class="icon-tint"></i> 界面风格</a>
	<a class="current" href="#">底部信息</a>	
</div>
<div class="container-fluid">
	<div class="row-fluid">
		<div class="span12">
			<div class="widget-box">
				<div class="widget-title">
					<span class="icon">
					<i class="icon-tint"></i>
					</span>
					<h5>底部信息</h5>
				</div>
				<div class="widget-content">
					<div class="row-fluid">
						<div class="span8">
							<form id="fform" class="form-horizontal" method="get" action="#">
								<div class="control-group">
									<label class="control-label" for="addressInfo">地址信息</label>
									<div class="controls">
										<input type="text" name="addressInfo" value="${dto.addressInfo}" placeholder="地址信息"/>
									</div>	
								</div>
								<div class="control-group">
									<label class="control-label" for="contectInfo">电话</label>
									<div class="controls">
										<input type="text" name="contectInfo" value="${dto.contectInfo}" placeholder="电话"/>
									</div>	
								</div>
								<div class="control-group">
									<label class="control-label" for="faxInfo">传真</label>
									<div class="controls">
										<input type="text" name="faxInfo" value="${dto.faxInfo}" placeholder="传真"/>
									</div>	
								</div>
								<div class="control-group">
									<label class="control-label" for="otherInfo">其他底部信息</label>
									<div class="controls">
										<textarea name="otherInfo" rows="4" cols="4" placeholder="其他底部信息">${dto.otherInfo}</textarea>
										<span class="help-block">支持HTML</span>
									</div>	
								</div>
								<div class="control-group">
									<label class="control-label" for="moreCode">第三方代码</label>
									<div class="controls">
										<textarea name="moreCode" rows="4" cols="4" placeholder="第三方代码">${dto.moreCode}</textarea>
										<span class="help-block">第三方代码，例如第三方的访问统计代码，支持HTML</span>
									</div>	
								</div>
								<div class="control-group">
									<label class="control-label" for="copyrightInfo">版权信息</label>
									<div class="controls">
										<input type="text" name="copyrightInfo" value="${dto.copyrightInfo}" placeholder="版权信息"/>
										<span class="help-block">支持HTML</span>
									</div>	
								</div>
								<div class="form-actions">
									<button class="btn btn-primary" type="button" id="save-btn" onclick="doSave()">保存</button>
								</div>
							</form>
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
			url : "${ctx}/console/bottomInfo/doSaveBottomInfo",
			data : $("#fform").serialize(),
			btn : '#save-btn'
		});
	}
}
$(function() {
	
	$('#fform').validate({
		rules: {
			copyrightInfo: {
				required: true,
				maxlength:1000
			},
			addressInfo: {
				required: true,
				maxlength:1000
			},
			contectInfo: {
				required: true,
				maxlength:1000
			},
			faxInfo: {
				required: true,
				maxlength:1000
			},
			moreCode: {
				required: true,
				maxlength:1000
			},
			otherInfo: {
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