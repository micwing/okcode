<%@page contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div id="breadcrumb">
	<a href="${ctx}/console/home"><i class="icon-home"></i> 首页</a>
	<a href="#"><i class="icon-th-list"></i> 栏目规划</a>
	<a class="current" href="#">产品模块字段</a>	
</div>
<div class="container-fluid">
	<div class="row-fluid">
		<div class="span12">
			<div class="widget-box">
				<div class="widget-title">
					<span class="icon">
					<i class="icon-th-list"></i>
					</span>
					<h5>产品模块字段</h5>
				</div>
				<div class="widget-content">
					<div class="row-fluid">
						<div class="span12">
						
							<table class="table table-bordered table-striped table-hover">
								<thead>
									<tr>
										<th width="40px">排序</th>
										<th width="90px">字段名称</th>
										<th>所属栏目</th>
										<th>字段类型</th>
										<th width="160px">操作</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td><input type="text" class="ipt-rank" value="1"/></td>
										<td>型号</td>
										<td>产品展示</td>
										<td>单选</td>
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