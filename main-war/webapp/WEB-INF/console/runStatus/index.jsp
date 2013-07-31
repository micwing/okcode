<%@page contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div id="breadcrumb">
	<a href="${ctx}/console/home"><i class="icon-home"></i> 首页</a>
	<a href="${ctx}/console/baseConfig"><i class="icon-cog"></i> 系统设置</a>
	<a class="current" href="#">运行状态</a>
</div>
<div class="container-fluid">
	<div class="row-fluid">
		<div class="span12">
			<div class="widget-box">
				<div class="widget-title"><span class="icon"><i class="icon-signal"></i></span><h5>运行状态</h5><div class="buttons"><a href="${ctx}/console/runStatus" class="btn btn-mini"><i class="icon-refresh"></i> 刷新</a></div></div>
				<div class="widget-content">
					<div class="row-fluid">
						<div class="span8">
						
							<form class="form-horizontal" method="get" action="#">
								<div class="control-group">
									<label class="control-label" for="">网站运行状态</label>
									<div class="controls">
										<div class="btn-group">
											<select>
												<option>正常运行</option>
												<option>暂停倒计时</option>
												<option>完全关闭</option>
											</select>
										</div>
									</div>	
								</div>
								<div class="control-group">
									<label class="control-label" for="">恢复时间</label>
									<div class="controls">
										<input class="Wdate" type="text" onFocus="WdatePicker({isShowClear:false,readOnly:true})" placeholder="点击选择时间"/>
										<span class="help-block">“暂停倒计时”状态下的恢复正常运行的时间点</span>
									</div>	
								</div>
								<div class="control-group">
									<label class="control-label" for="">网站通知</label>
									<div class="controls">
										<textarea rows="4" cols="4" placeholder="网站通知"></textarea>
										<span class="help-block">“暂停倒计时”或者“完全关闭”状态下挂出的通知，100字以内</span>
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