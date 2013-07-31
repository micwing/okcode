<%@page contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div id="breadcrumb">
	<a href="${ctx}/console/home"><i class="icon-home"></i> 首页</a>
	<a href="#"><i class="icon-cog"></i> 系统设置</a>
	<a href="#">数据备份</a>
	<a class="current" href="#">备份操作</a>	
</div>
<div class="container-fluid">
	<div class="row-fluid">
		<div class="span12">
			<div class="widget-box">
				<div class="widget-title">
					<ul class="nav nav-tabs">
						<li class="active">
						<a href="${ctx}/console/dataBackup">备份操作</a>
						</li>
						<li class="">
						<a href="${ctx}/console/dataBackup/dbDataList">数据库备份列表</a>
						</li>
						<li class="">
						<a href="${ctx}/console/dataBackup/fileDataList">上传文件备份列表</a>
						</li>
					</ul>
				</div>
				<div class="widget-content">
					<div class="row-fluid">
						<div class="span8">
						
							<div class="alert">
								建议每月至少备份一次数据库，一年至少下载两次备份数据（数据库备份数据和上传文件备份数据）到本地
								<a href="#" data-dismiss="alert" class="close">×</a>
							</div>
							<form class="form-horizontal" method="get" action="#">
								<div class="control-group">
									<label class="control-label" for="">数据库备份</label>
									<div class="controls">
										<input type="button" class="btn btn-primary" name="" value="备份">
										<span class="help-block">备份网站文字内容和后台设置</span>
									</div>	
								</div>
								<div class="control-group">
									<label class="control-label" for="">上传文件备份</label>
									<div class="controls">
										<input type="button" class="btn btn-primary" name="" value="备份">
										<span class="help-block">备份所有从后台上传的图片和文件</span>
									</div>	
								</div>
							</form>	
						</div>
						<div class="span4">
						</div>
					</div>				
				</div>
			</div>					
		</div>
	</div>
</div>