<%@page contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<style type="text/css">
table input[type="text"] {
	font-size: 12px;
	height: 13px;
	width: 120px;
}
.ipt-name,.ipt-qq {
	width: 80px !important;
}
</style>
<div id="breadcrumb">
	<a href="${ctx}/console/home"><i class="icon-home"></i> 首页</a>
	<a href="#"><i class="icon-tint"></i> 界面风格</a>
	<a href="#">在线交流设置</a>
	<a class="current" href="#">客服账号管理</a>
</div>
<div class="container-fluid">
	<div class="row-fluid">
		<div class="span12">
			<div class="widget-box">
				<div class="widget-title">
					<ul class="nav nav-tabs">
						<li class="active">
						<a href="${ctx}/console/onlineConfig">客服账号管理</a>
						</li>
						<li class="">
						<a href="${ctx}/console/onlineConfig/styleConfig">展示风格</a>
						</li>
					</ul>
				</div>
				<div class="widget-content">
					<div class="row-fluid">
						<div class="span12">
							<table class="table table-bordered table-striped table-hover">
								<thead>
									<tr>
										<th>排序</th>
										<th>客服名称</th>
										<th>QQ</th>
										<th>淘宝旺旺</th>
										<th>阿里旺旺</th>
										<th>SKYPE</th>
										<th>操作</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td><input type="text" class="ipt-rank" value="1" /></td>
										<td><input type="text" class="ipt-name" value="咨询销售" /></td>
										<td><input type="text" class="ipt-qq" value="348468810" /></td>
										<td><input type="text" class="ipt-tbww" value="metinfo@metinfo.cn" /></td>
										<td><input type="text" class="ipt-alww" value="metinfo" /></td>
										<td><input type="text" class="ipt-skype" value="metinfo@metinfo.cn" /></td>
										<td>
										    <div class="btn-group">
										    <button class="btn btn-small">保存</button>
										    <button class="btn btn-small">删除</button>
										    </div>
										</td>
									</tr>
								</tbody>
							</table>
						</div>
						<div class="span12">
							<input type="button" class="btn" value="添加客服" />
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>