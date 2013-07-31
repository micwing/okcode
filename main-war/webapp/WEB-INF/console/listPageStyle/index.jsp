<%@page contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div id="breadcrumb">
	<a href="${ctx}/console/home"><i class="icon-home"></i> 首页</a>
	<a href="#"><i class="icon-tint"></i> 界面风格</a>
	<a class="current" href="#">列表页设置</a>
</div>
<div class="container-fluid">
	<div class="row-fluid">
		<div class="span12">
			<div class="widget-box">
				<div class="widget-title">
					<span class="icon">
					<i class="icon-tint"></i>
					</span>
					<h5>列表页设置</h5>
				</div>
				<div class="widget-content">
					<div class="widget-content">
						<div class="row-fluid">
							<div class="span8">
							
								<form class="form-horizontal" method="get" action="#">
									<div class="control-group">
										<label class="control-label" for="">页面链接</label>
										<div class="controls">
											<label class="radio">
											<input type="radio" name="xxx" value="option1" checked>
											当前窗口打开
											</label>
											<label class="radio">
											<input type="radio" name="xxx" value="option1">
											新窗口打开
											</label>
										</div>	
									</div>
									<div class="control-group">
										<label class="control-label" for="">最新信息</label>
										<div class="controls">
											<label>
											最近 <input type="text" value="2" style="width: 40px !important;"/> 天内发表的信息显示 <img alt="" src="${ctx}/asset/console/img/news.gif">
											</label>
										</div>
									</div>
									<div class="control-group">
										<label class="control-label" for="">热门信息</label>
										<div class="controls">
											<label>
											点击次数超过 <input type="text" value="100" style="width: 40px !important;"/> 次的信息显示 <img alt="" src="${ctx}/asset/console/img/hot.gif">
											</label>
										</div>
									</div>
									<div class="control-group">
										<label class="control-label" for="">时间显示格式</label>
										<div class="controls">
											<select></select>
										</div>
									</div>
									<div class="control-group">
										<label class="control-label" for="">产品模块</label>
										<div class="controls">
											<label>
												每页显示 <input type="text" value="10" style="width: 40px !important;"/> 条
											</label>
										</div>
									</div>
									<div class="control-group">
										<label class="control-label" for="">文章模块</label>
										<div class="controls">
											<label>
												每页显示 <input type="text" value="10" style="width: 40px !important;"/> 条
											</label>
										</div>
									</div>
									<div class="control-group">
										<label class="control-label" for="">下载模块</label>
										<div class="controls">
											<label>
												每页显示 <input type="text" value="10" style="width: 40px !important;"/> 条
											</label>
										</div>
									</div>
									<div class="control-group">
										<label class="control-label" for="">图片模块</label>
										<div class="controls">
											<label>
												每页显示 <input type="text" value="10" style="width: 40px !important;"/> 条
											</label>
										</div>
									</div>
									<div class="control-group">
										<label class="control-label" for="">招聘模块</label>
										<div class="controls">
											<label>
												每页显示 <input type="text" value="10" style="width: 40px !important;"/> 条
											</label>
										</div>
									</div>
									<div class="control-group">
										<label class="control-label" for="">留言系统</label>
										<div class="controls">
											<label>
												每页显示 <input type="text" value="10" style="width: 40px !important;"/> 条
											</label>
										</div>
									</div>
									<div class="control-group">
										<label class="control-label" for="">全站搜索</label>
										<div class="controls">
											<label>
												每页显示 <input type="text" value="10" style="width: 40px !important;"/> 条
											</label>
										</div>
									</div>
									<div class="control-group">
										<label class="control-label" for="">翻页样式</label>
										<div class="controls">
											<select></select>
										</div>
									</div>
									<div class="control-group">
										<label class="control-label" for="">产品模块列表页</label>
										<div class="controls">
											<label class="radio">
												<input type="radio" name="xxx" value="" checked>
												显示栏目下所有信息列表
											</label>
											<label class="radio">
												<input type="radio" name="xxx" value="">
												显示当前栏目下级栏目列表
											</label>
										</div>
									</div>
									<div class="control-group">
										<label class="control-label" for="">图片模块列表页</label>
										<div class="controls">
											<label class="radio">
												<input type="radio" name="xx" value="" checked>
												显示栏目下所有信息列表
											</label>
											<label class="radio">
												<input type="radio" name="xx" value="">
												显示当前栏目下级栏目列表
											</label>
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
</div>