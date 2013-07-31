<%@page contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div id="breadcrumb">
	<a href="${ctx}/console/home"><i class="icon-home"></i> 首页</a>
	<a href="#"><i class="icon-tint"></i> 界面风格</a>
	<a class="current" href="#">前台首页设置</a>
</div>
<div class="container-fluid">
	<div class="row-fluid">
		<div class="span12">
			<div class="widget-box">
				<div class="widget-title">
					<span class="icon">
					<i class="icon-tint"></i>
					</span>
					<h5>前台首页设置</h5>
				</div>
				<div class="widget-content">
					<div class="row-fluid">
						<div class="span8">
							
							<form class="form-horizontal" method="get" action="#">
								<div class="control-group">
									<label class="control-label" for="">设为首页和收藏本站</label>
									<div class="controls">
										<label class="checkbox">
										<input type="checkbox" name="">
										勾选后前台显示“设为首页”和“收藏本站”按钮
										</label>
									</div>	
								</div>
								<div class="control-group">
									<label class="control-label" for="">文章模块显示</label>
									<div class="controls">
										<input type="text" style="width: 80px !important"/> 条
									</div>
								</div>
								<div class="control-group">
									<label class="control-label" for="">产品模块显示</label>
									<div class="controls">
										<input type="text" style="width: 80px !important"/> 条
									</div>
								</div>
								<div class="control-group">
									<label class="control-label" for="">图片模块显示</label>
									<div class="controls">
										<input type="text" style="width: 80px !important"/> 条
									</div>
								</div>
								<div class="control-group">
									<label class="control-label" for="">下载模块显示</label>
									<div class="controls">
										<input type="text" style="width: 80px !important"/> 条
									</div>
								</div>
								<div class="control-group">
									<label class="control-label" for="">招聘模块显示</label>
									<div class="controls">
										<input type="text" style="width: 80px !important"/> 条
									</div>
								</div>
								<div class="control-group">
									<label class="control-label" for="">友情链接</label>
									<div class="controls">
										<label class="checkbox">
										<input type="checkbox" name="">
										勾选后显示友情链接
										</label>
									</div>
								</div>
								<div class="control-group">
									<label class="control-label" for="">首页简介内容</label>
									<div class="controls">
										<textarea rows="" cols="" placeholder="首页简介内容"></textarea>
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