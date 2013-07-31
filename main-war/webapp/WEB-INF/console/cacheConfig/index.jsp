<%@page contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>

<div id="breadcrumb">
	<a href="${ctx}/console/home"><i class="icon-home"></i> 首页</a>
	<a href="#"><i class="icon-screenshot"></i> 优化推广</a>
	<a href="#">网站缓存</a>
	<a class="current" href="#">缓存状态</a>	
</div>
<div class="container-fluid">
	<div class="row-fluid">
		<div class="span12">
			<div class="widget-box">
				<div class="widget-title">
					<ul class="nav nav-tabs">
						<li class="active">
						<a href="${ctx}/console/cacheConfig">缓存状态</a>
						</li>
						<li class="">
						<a href="${ctx}/console/cacheConfig/config">缓存设置</a>
						</li>
					</ul>
				</div>
				<div class="widget-content">
					<div class="row-fluid">
						<div class="span12">
						
							<table class="table table-bordered table-striped table-hover">
								<thead>
									<tr>
										<th>缓存描述</th>
										<th width="90px">缓存数量</th>
										<th width="160px">操作</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td>商品模块缓存</td>
										<td>153</td>
										<td>
										    <div class="btn-group">
										    <button class="btn btn-small">清空</button>
										    </div>
										</td>
									</tr>
									<tr>
										<td>下载模块缓存</td>
										<td>153</td>
										<td>
										    <div class="btn-group">
										    <button class="btn btn-small">清空</button>
										    </div>
										</td>
									</tr>
								</tbody>
							</table>
							<div class="pull-right" style="">
								<button class="btn btn-danger" type="submit">清空全部缓存</button>
							</div>
						</div>
					</div>
				</div>
			</div>					
		</div>
	</div>
</div>