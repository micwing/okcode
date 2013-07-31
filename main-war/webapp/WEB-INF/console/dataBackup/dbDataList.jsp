<%@page contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div id="breadcrumb">
	<a href="${ctx}/console/home"><i class="icon-home"></i> 首页</a>
	<a href="#"><i class="icon-cog"></i> 系统设置</a>
	<a href="#">数据备份</a>
	<a class="current" href="#">数据库备份列表</a>	
</div>
<div class="container-fluid">
	<div class="row-fluid">
		<div class="span12">
			<div class="widget-box">
				<div class="widget-title">
					<ul class="nav nav-tabs">
						<li class="">
						<a href="${ctx}/console/dataBackup">备份操作</a>
						</li>
						<li class="active">
						<a href="${ctx}/console/dataBackup/dbDataList">数据库备份列表</a>
						</li>
						<li class="">
						<a href="${ctx}/console/dataBackup/fileDataList">上传文件备份列表</a>
						</li>
					</ul>
				</div>
				<div class="widget-content">
					<div class="row-fluid">
						<div class="span12">
						
							<table class="table table-bordered table-striped table-hover">
								<thead>
									<tr>
										<th width="40px">ID</th>
										<th width="90px">类型</th>
										<th>文件名</th>
										<th>系统版本</th>
										<th>文件大小</th>
										<th>备份时间</th>
										<th width="160px">操作</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td>1</td>
										<td>数据库数据</td>
										<td>sq_csmetinfo_20130620_6234_1</td>
										<td>5.1.7</td>
										<td>1.82 MB</td>
										<td>2013-06-20 01:04:03</td>
										<td>
										    <div class="btn-group">
										    <button class="btn btn-small">导入</button>
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