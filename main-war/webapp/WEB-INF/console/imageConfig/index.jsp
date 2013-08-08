<%@page contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div id="breadcrumb">
	<a href="${ctx}/console/home"><i class="icon-home"></i> 首页</a>
	<a href="#"><i class="icon-cog"></i> 系统设置</a>
	<a href="#">图片设置</a>
	<a class="current" href="#">图片设置</a>
</div>
<div class="container-fluid">
	<div class="row-fluid">
		<div class="span12">
			<div class="widget-box">
				<div class="widget-title">
					<span class="icon">
					<i class="icon icon-cog"></i>
					</span>
					<h5>图片设置</h5>
				</div>
				<div class="widget-content">
					<div class="row-fluid">
						<div class="span8">
						
							<form id="fform" class="form-horizontal" method="get" action="#">
								<div class="control-group">
									<label class="control-label" for=""><span class="red">*</span> 产品模块图片展示</label>
									<div class="controls">
										<input type="text" name="productImageWidth" value="${dto.productImageWidth}" style="width: 80px !important"> X <input type="text" name="productImageHeight" value="${dto.productImageHeight}" style="width: 80px !important">
										<span class="help-block">宽 × 高，单位：像素</span>
									</div>
								</div>
								<div class="control-group">
									<label class="control-label" for=""><span class="red">*</span> 图片模块图片展示</label>
									<div class="controls">
										<input type="text" name="imageImageWidth" value="${dto.imageImageWidth}" style="width: 80px !important"> X <input type="text" name="imageImageHeight" value="${dto.imageImageHeight}" style="width: 80px !important">
										<span class="help-block">宽 × 高，单位：像素</span>
									</div>
								</div>
								<div class="control-group">
									<label class="control-label" for=""><span class="red">*</span> 下载模块图片展示</label>
									<div class="controls">
										<input type="text" name="downloadImageHeight" value="${dto.downloadImageHeight}" style="width: 80px !important"> X <input type="text" name="downloadImageWidth" value="${dto.downloadImageWidth}" style="width: 80px !important">
										<span class="help-block">宽 × 高，单位：像素</span>
									</div>
								</div>
								<div class="form-actions">
									<button class="btn btn-primary" id="save-btn" type="button" onclick="doSave()">保存</button>
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
			url : "${ctx}/console/imageConfig/doSaveImageConfig",
			data : $("#fform").serialize(),
			btn : '#save-btn'
		});
	}
}
$(function() {
	
	$('#fform').validate({
		rules: {
			productImageWidth: {
				required: true,
				number: true
			},
			productImageHeight: {
				required: true,
				number: true
			},
			imageImageWidth: {
				required: true,
				number: true
			},
			imageImageHeight: {
				required: true,
				number: true
			},
			downloadImageWidth: {
				required: true,
				number: true
			},
			downloadImageHeight: {
				required: true,
				number: true
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