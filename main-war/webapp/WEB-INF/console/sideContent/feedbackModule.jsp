<%@page contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div id="breadcrumb">
	<a href="${ctx}/console/home"><i class="icon-home"></i> 首页</a>
	<a href="#"><i class="icon-list-alt"></i> 内容管理</a>
	<a href="#">侧边栏管理</a>
	<a class="current" href="#">反馈模块</a>	
</div>
<div class="container-fluid">
	<div class="row-fluid">
		<div class="span12">
			<div class="widget-box">
				<div class="widget-title">
					<ul class="nav nav-tabs">
						<li class="active">
						<a href="${ctx}/console/sideContent/feedbackModule">反馈模块</a>
						</li>
						<li class="">
						<a href="${ctx}/console/sideContent/articleModule">文章模块</a>
						</li>
						<li class="">
						<a href="${ctx}/console/sideContent/productModule">产品模块</a>
						</li>
						<li class="">
						<a href="${ctx}/console/sideContent/downloadModule">下载模块</a>
						</li>
						<li class="">
						<a href="${ctx}/console/sideContent/imageModule">图片模块</a>
						</li>
						<li class="">
						<a href="${ctx}/console/sideContent/jobModule">招聘模块</a>
						</li>
					</ul>
				</div>
				<div class="widget-content">
					<div class="row-fluid">
						<div class="span12">
							
							<div class="tabbable">
							    <ul class="nav nav-tabs">
								    <li class="active"><a href="#1" data-toggle="tab">在线留言</a></li>
								    <li><a href="#2" data-toggle="tab">章节 2</a></li>
							    </ul>
							    <div class="tab-content">
								    <div class="tab-pane active" id="1">
								    	<form class="form-horizontal span8" method="get" action="#">
											<div class="control-group">
												<label class="control-label" for="">当前栏目列表</label>
												<div class="controls">
													<label class="checkbox">
														<input type="checkbox" name="" checked="checked">
														勾选后显示当前栏目下的子栏目列表
													</label>
												</div>	
											</div>
											<div class="control-group">
												<label class="control-label" for="">当前栏目列表</label>
												<div class="controls">
													<label class="checkbox">
														<input type="checkbox" name="" checked="checked">
														勾选后显示当前栏目下的子栏目列表
													</label>
												</div>	
											</div>
											
											<div class="form-actions">
												<button class="btn btn-primary" type="submit">保存</button>
											</div>
										</form>	
								    </div>
								    <div class="tab-pane" id="2">
								    	<p>这里是章节 2.</p>
								    </div>
							    </div>
						    </div>
						
						</div>
					</div>
				</div>
			</div>					
		</div>
	</div>
</div>