<%@page contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div id="breadcrumb">
	<a href="${ctx}/console/home"><i class="icon-home"></i> 首页</a>
	<a href="#"><i class="icon-screenshot"></i> 优化推广</a>
	<a class="current" href="#">友情链接</a>	
</div>
<div class="container-fluid">
	<div class="row-fluid">
		<div class="span12">
			<div class="widget-box">
				<div class="widget-title">
					<span class="icon">
					<i class="icon-screenshot"></i>
					</span>
					<h5>友情链接</h5>
				</div>
				<div class="widget-content">
					<div class="row-fluid">
						<div class="span12">
						
							<table class="table table-bordered table-striped table-hover">
								<thead>
									<tr>
										<th width="20px">排序</th>
										<th width="90px">类型</th>
										<th>网站标题</th>
										<th>网站地址</th>
										<th>网站关键词</th>
										<th width="160px">操作</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td><input type="text" class="ipt-rank"/></td>
										<td>文字连接</td>
										<td>百度搜索</td>
										<td>http://www.baidu.com</td>
										<td>权威中文搜索引擎</td>
										<td>
										    <div class="btn-group">
										    <button class="btn btn-small">详细</button>
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