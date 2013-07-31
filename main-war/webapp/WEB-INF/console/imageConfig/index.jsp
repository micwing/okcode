<%@page contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div id="breadcrumb">
	<a href="${ctx}/console/home"><i class="icon-home"></i> 首页</a>
	<a href="#"><i class="icon-cog"></i> 系统设置</a>
	<a href="#">图片设置</a>
	<a class="current" href="#">图片通用设置</a>
</div>
<div class="container-fluid">
	<div class="row-fluid">
		<div class="span12">
			<div class="widget-box">
				<div class="widget-title">
					<ul class="nav nav-tabs">
						<li class="active">
						<a href="${ctx}/console/imageConfig">图片通用设置</a>
						</li>
						<li class="">
						<a href="${ctx}/console/imageConfig/watermarkConfig">图片水印设置</a>
						</li>
					</ul>
				</div>
				<div class="widget-content">
					<div class="row-fluid">
						<div class="span8">
						
							<form class="form-horizontal" method="get" action="#">
								<div class="control-group">
									<label class="control-label" for="">自动删除图片</label>
									<div class="controls">
										<label class="checkbox">
										<input type="checkbox" name="">
										开启后删除信息时将自动删除相应图片
										</label>
									</div>	
								</div>
								<div class="control-group">
									<label class="control-label" for="">自动生成缩略图</label>
									<div class="controls">
										<label class="checkbox">
										<input type="checkbox" name="">
										开启后添加大图时将自动生成缩略图
										</label>
									</div>
								</div>
								<div class="control-group">
									<label class="control-label" for="">自动重命名</label>
									<div class="controls">
										<label class="checkbox">
										<input type="checkbox" name="" checked="checked">
										对上传的文件名自动进行重名名
										</label>
										<span class="help-block">建议勾选</span>
									</div>	
								</div>
								<div class="control-group">
									<label class="control-label" for="">缩略图生成方式</label>
									<div class="controls">
										<label class="radio">
										<input type="radio" checked="checked" value="" name="xxx">
										自动拉伸
										</label>
										<label class="radio">
										<input type="radio" value="" name="xxx">
										自动留白
										</label>
										<label class="radio">
										<input type="radio" value="" name="xxx">
										自动裁减
										</label>
									</div>
								</div>
								<div class="control-group">
									<label class="control-label" for=""><span class="red">*</span> 产品模块</label>
									<div class="controls">
										<input type="text" name="" value="" style="width: 80px !important"> X <input type="text" name="" value="" style="width: 80px !important">
										<span class="help-block">宽 × 高，单位：像素</span>
									</div>
								</div>
								<div class="control-group">
									<label class="control-label" for=""><span class="red">*</span> 图片模块</label>
									<div class="controls">
										<input type="text" name="" value="" style="width: 80px !important"> X <input type="text" name="" value="" style="width: 80px !important">
										<span class="help-block">宽 × 高，单位：像素</span>
									</div>
								</div>
								<div class="control-group">
									<label class="control-label" for=""><span class="red">*</span> 文章模块</label>
									<div class="controls">
										<input type="text" name="" value="" style="width: 80px !important"> X <input type="text" name="" value="" style="width: 80px !important">
										<span class="help-block">宽 × 高，单位：像素</span>
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