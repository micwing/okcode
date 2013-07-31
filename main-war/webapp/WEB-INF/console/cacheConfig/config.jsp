<%@page contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>

<div id="breadcrumb">
	<a href="${ctx}/console/home"><i class="icon-home"></i> 首页</a>
	<a href="#"><i class="icon-screenshot"></i> 优化推广</a>
	<a href="#">网站缓存</a>
	<a class="current" href="#">缓存设置</a>	
</div>
<div class="container-fluid">
	<div class="row-fluid">
		<div class="span12">
			<div class="widget-box">
				<div class="widget-title">
					<ul class="nav nav-tabs">
						<li class="">
						<a href="${ctx}/console/cacheConfig">缓存状态</a>
						</li>
						<li class="active">
						<a href="${ctx}/console/cacheConfig/config">缓存设置</a>
						</li>
					</ul>
				</div>
				<div class="widget-content">
					<div class="row-fluid">
						<div class="span8">
						
							<form class="form-horizontal" method="get" action="#">
								<div class="control-group">
									<label class="control-label" for="">产品模块缓存</label>
									<div class="controls">
										<label class="checkbox">
											<input type="checkbox" />
											启用针对产品模块的缓存功能
										</label>
									</div>
								</div>
								<div class="control-group">
									<label class="control-label" for="">下载模块缓存</label>
									<div class="controls">
										<label class="checkbox">
											<input type="checkbox" />
											启用针对下载模块的缓存功能
										</label>
									</div>
								</div>
								<div class="control-group">
									<label class="control-label" for="">图片模块缓存</label>
									<div class="controls">
										<label class="checkbox">
											<input type="checkbox" />
											启用针对图片模块的缓存功能
										</label>
									</div>
								</div>
								<div class="form-actions">
									<button class="btn btn-primary" type="submit">保存</button>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>					
		</div>
	</div>
</div>