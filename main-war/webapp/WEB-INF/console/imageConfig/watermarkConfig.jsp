<%@page contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div id="breadcrumb">
	<a href="${ctx}/console/home"><i class="icon-home"></i> 首页</a>
	<a href="#"><i class="icon-cog"></i> 系统设置</a>
	<a href="#">图片设置</a>
	<a class="current" href="#">图片水印设置</a>
</div>
<div class="container-fluid">
	<div class="row-fluid">
		<div class="span12">
			<div class="widget-box">
				<div class="widget-title">
					<ul class="nav nav-tabs">
						<li class="">
						<a href="${ctx}/console/imageConfig">图片通用设置</a>
						</li>
						<li class="active">
						<a href="${ctx}/console/imageConfig/watermarkConfig">图片水印设置</a>
						</li>
					</ul>
				</div>
				<div class="widget-content">
					<div class="row-fluid">
						<div class="span8">
						
							<form class="form-horizontal" method="get" action="#">
								<div class="control-group">
									<label class="control-label" for="">水印类型</label>
									<div class="controls">
										<label class="radio">
										<input type="radio" checked="checked" value="" name="xxx">
										文字水印
										</label>
										<label class="radio">
										<input type="radio" value="" name="xxx">
										图片水印
										</label>
									</div>	
								</div>
								<div class="control-group">
									<label class="control-label" for="">选择水印图片</label>
									<div class="controls">
										<input type="file"/>
										<span class="help-block">仅支持.gif|.png格式</span>
									</div>
								</div>
								<div class="control-group">
									<label class="control-label" for="">水印文字</label>
									<div class="controls">
										<input type="text" name="" placeholder="水印文字"/>
										<span class="help-block">不支持中文</span>
									</div>	
								</div>
								<div class="control-group">
									<label class="control-label" for="">图片水印文字大小</label>
									<div class="controls">
										<input type="text" name="" placeholder="像素"/>
										<span class="help-block">单位：像素</span>
									</div>	
								</div>
								<div class="control-group">
									<label class="control-label" for="">水印文字角度</label>
									<div class="controls">
										<input type="text" name="" placeholder="角度"/>
										<span class="help-block">水平为0</span>
									</div>	
								</div>
								<div class="control-group">
									<label class="control-label" for="">水印文字颜色</label>
									<div class="controls">
										<input class="colorpicker" type="text" value="#000000" data-color="#000000" />
										<span class="help-block">点击选择颜色</span>
									</div>	
								</div>
								<div class="control-group">
									<label class="control-label" for="">水印位置</label>
									<div class="controls">
										<table class="table span6" >
											<tr>
												<td><label class="radio">
												<input type="radio" value="" name="watermark-location">
												左上角
												</label></td>
												<td><label class="radio">
												<input type="radio" value="" name="watermark-location">
												顶中部
												</label></td>
												<td><label class="radio">
												<input type="radio" value="" name="watermark-location">
												右上角
												</label></td>
											</tr>
											<tr>
												<td><label class="radio">
												<input type="radio" value="" name="watermark-location">
												左中部
												</label></td>
												<td><label class="radio">
												<input type="radio" value="" name="watermark-location">
												中间部
												</label></td>
												<td><label class="radio">
												<input type="radio" value="" name="watermark-location">
												右中部
												</label></td>
											</tr>
											<tr>
												<td><label class="radio">
												<input type="radio" value="" name="watermark-location">
												左下角
												</label></td>
												<td><label class="radio">
												<input type="radio" value="" name="watermark-location">
												底中部
												</label></td>
												<td><label class="radio">
												<input type="radio" value="" name="watermark-location">
												右下角
												</label></td>
											</tr>
										</table>
											     
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
<script type="text/javascript">
$(document).ready(function(){
    $('.colorpicker').colorpicker();
});
</script>