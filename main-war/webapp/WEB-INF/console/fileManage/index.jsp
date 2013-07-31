<%@page contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div id="breadcrumb">
	<a href="${ctx}/console/home"><i class="icon-home"></i> 首页</a>
	<a href="#"><i class="icon-cog"></i> 系统设置</a>
	<a class="current" href="#">文件管理</a>
</div>
<div class="container-fluid">
	<div class="row-fluid">
		<div class="span12">
			<div class="widget-box">
				<div class="widget-title"><span class="icon"><i class="icon-signal"></i></span><h5>文件管理</h5><div class="buttons"><a href="${ctx}/console/runStatus" class="btn btn-mini"><i class="icon-refresh"></i> 刷新</a></div></div>
				<div class="widget-content">
					<div class="row-fluid">
						<div class="span12">
						
							<table class="table table-bordered table-striped table-hover">
								<thead>
									<tr>
										<th width="20px">选择</th>
										<th width="90px">类型</th>
										<th>文件夹名称</th>
										<th>文件名称</th>
										<th>文件大小</th>
										<th>上传时间</th>
										<th width="160px">操作</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td><input type="checkbox"/></td>
										<td>上传文件数据</td>
										<td>2013</td>
										<td>sq_csmetinfo</td>
										<td>1.82 MB</td>
										<td>2013-06-20 01:04:03</td>
										<td>
										    <div class="btn-group">
										    <button class="btn btn-small">下载</button>
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