<%@page contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div id="breadcrumb">
	<a href="${ctx}/console/home"><i class="icon-home"></i> 首页</a>
	<a href="#"><i class="icon-list-alt"></i> 内容管理</a>
	<a href="#">模块内容</a>
	<a class="current" href="#">招聘模块内容</a>	
</div>
<div class="container-fluid">
	<div class="row-fluid">
		<div class="span12">
			<div class="widget-box">
				<div class="widget-title">
					<ul class="nav nav-tabs">
						<li class="">
						<a href="${ctx}/console/contentManage/articleModule">文章模块内容</a>
						</li>
						<li class="">
						<a href="${ctx}/console/contentManage/productModule">产品模块内容</a>
						</li>
						<li class="">
						<a href="${ctx}/console/contentManage/imageModule">图片模块内容</a>
						</li>
						<li class="">
						<a href="${ctx}/console/contentManage/downloadModule">下载模块内容</a>
						</li>
						<li class="">
						<a href="${ctx}/console/contentManage/messageModule">留言模块内容</a>
						</li>
						<li class="active">
						<a href="${ctx}/console/contentManage/jobModule">招聘模块内容</a>
						</li>
						<li class="">
						<a href="${ctx}/console/contentManage/exlinkModule">友链模块内容</a>
						</li>
					</ul>
				</div>
				<div class="widget-content">
					<div class="row-fluid">
						<div class="span12">
							<div class="alert alert-info">
								<label class="radio inline">
									栏目：
								</label>
								<label class="radio inline">
									<input type="radio" name="x" />
									全部
								</label>
								<label class="radio inline">
									<input type="radio" name="x" />
									留言咨询
								</label>
							</div>
							<table class="table table-bordered table-striped table-hover">
								<thead>
									<tr>
										<th width="40px">ID</th>
										<th width="140px">提交时间</th>
										<th>所属栏目</th>
										<th>标题</th>
										<th width="40px">是否已读</th>
										<th width="160px">操作</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td>1</td>
										<td>2013-06-20 01:04:03</td>
										<td>留言咨询</td>
										<td>想购买你们的一个产品</td>
										<td><span class="red">未读</span></td>
										<td>
										    <div class="btn-group">
										    <button class="btn btn-small">查看</button>
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