<%@page contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div id="breadcrumb">
	<a href="${ctx}/console/home"><i class="icon-home"></i> 首页</a>
	<a href="#"><i class="icon-tint"></i> 用户管理</a>
	<a class="current" href="#">个人资料</a>
</div>
<div class="container-fluid">
	<div class="row-fluid">
		<div class="span12">
			<div class="widget-box">
				<div class="widget-title">
					<span class="icon">
					<i class="icon-tint"></i>
					</span>
					<h5>个人资料</h5>
				</div>
				<div class="widget-content">
					<div class="row-fluid">
						<div class="span8">
						
							<form class="form-horizontal" method="get" action="#">
								<div class="control-group">
									<label class="control-label" for="">用户名</label>
									<div class="controls">
										<input type="text" value="admin" readonly="readonly">
									</div>	
								</div>
								<div class="control-group">
									<label class="control-label" for="">登录密码</label>
									<div class="controls">
										<input type="password" value="admin" >
									</div>	
								</div>
								<div class="control-group">
									<label class="control-label" for="">密码确认</label>
									<div class="controls">
										<input type="password" value="admin" >
									</div>	
								</div>
								<div class="form-actions">
									<button class="btn btn-primary" type="submit">保存</button>
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