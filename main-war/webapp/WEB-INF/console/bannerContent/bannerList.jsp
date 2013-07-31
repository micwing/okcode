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
						<li class="">
						<a href="${ctx}/console/bannerContent">Banner设置</a>
						</li>
						<li class="active">
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
										<th>选择</th>
										<th>类型</th>
										<th>图片标题</th>
										<th>图片地址/Flash地址</th>
										<th width="160px">操作</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td><input type="checkbox"/></td>
										<td>图片</td>
										<td>MetInfo企业网站管理系统</td>
										<td>./upload/201207/1342429839.jpg</td>
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