<%@page contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>

<div id="breadcrumb">
	<a href="${ctx}/console/home"><i class="icon-home"></i> 首页</a>
	<a href="#"><i class="icon-list-alt"></i> 内容管理</a>
	<a href="#">Banner管理</a>
	<a class="current" href="#">Banner设置</a>
</div>
<div class="container-fluid">
	<div class="row-fluid">
		<div class="span12">
			<div class="widget-box">
				<div class="widget-title">
					<ul class="nav nav-tabs">
						<li class="active">
						<a href="${ctx}/console/bannerContent">Banner设置</a>
						</li>
						<li class="">
						<a href="${ctx}/console/bannerContent/bannerList">Banner列表</a>
						</li>
					</ul>
				</div>
				<div class="widget-content">
					<div class="row-fluid">
						<div class="span12">
						
							<table class="table table-bordered table-striped table-hover">
								<thead>
									<tr>
										<th>应用栏目</th>
										<th>显示模式</th>
										<th>图片预览</th>
										<th>宽(像素)</th>
										<th>高(像素)</th>
										<th width="160px">操作</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td>网站首页</td>
										<td><select></select></td>
										<td><img src="http://www.baidu.com/img/bdlogo.gif"/>
										<img src="http://www.baidu.com/img/bdlogo.gif"/>
										<img src="http://www.baidu.com/img/bdlogo.gif"/>
										<img src="http://www.baidu.com/img/bdlogo.gif"/>
										</td>
										<td>800px</td>
										<td>100px</td>
										<td>
										    <div class="btn-group">
										    <button class="btn btn-small">修改</button>
										    <button class="btn btn-small">删除</button>
										    </div>
										</td>
									</tr>
									<tr>
										<td>网站首页</td>
										<td><select></select></td>
										<td><img src="http://www.baidu.com/img/bdlogo.gif"/>
										<img src="http://www.baidu.com/img/bdlogo.gif"/>
										<img src="http://www.baidu.com/img/bdlogo.gif"/>
										<img src="http://www.baidu.com/img/bdlogo.gif"/>
										</td>
										<td>800px</td>
										<td>100px</td>
										<td>
										    <div class="btn-group">
										    <button class="btn btn-small">修改</button>
										    <button class="btn btn-small">删除</button>
										    </div>
										</td>
									</tr>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>					
		</div>
	</div>
</div>