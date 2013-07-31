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
							<form class="form-horizontal" method="get" action="#">
								<div class="control-group">
									<label class="control-label" for="">版权信息</label>
									<div class="controls">
										<input type="text" placeholder="版权信息"/>
										<span class="help-block">支持HTML</span>
									</div>	
								</div>
								<div class="control-group">
									<label class="control-label" for="">联系方式</label>
									<div class="controls">
										<input type="text" placeholder="联系方式"/>
										<span class="help-block">支持HTML</span>
									</div>	
								</div>
								<div class="control-group">
									<label class="control-label" for="">第三方代码</label>
									<div class="controls">
										<textarea rows="4" cols="4" placeholder="第三方代码"></textarea>
										<span class="help-block">第三方代码，例如第三方的访问统计代码，支持HTML</span>
									</div>	
								</div>
								<div class="control-group">
									<label class="control-label" for="">其他底部信息</label>
									<div class="controls">
										<textarea rows="4" cols="4" placeholder="其他底部信息"></textarea>
										<span class="help-block">支持HTML</span>
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