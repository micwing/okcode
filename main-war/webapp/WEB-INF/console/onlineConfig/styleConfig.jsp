<%@page contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div id="breadcrumb">
	<a href="${ctx}/console/home"><i class="icon-home"></i> 首页</a>
	<a href="#"><i class="icon-tint"></i> 界面风格</a>
	<a href="#">在线交流设置</a>
	<a class="current" href="#">展示风格</a>
</div>
<div class="container-fluid">
	<div class="row-fluid">
		<div class="span12">
			<div class="widget-box">
				<div class="widget-title">
					<ul class="nav nav-tabs">
						<li class="">
						<a href="${ctx}/console/onlineConfig">客服账号管理</a>
						</li>
						<li class="active">
						<a href="${ctx}/console/onlineConfig/styleConfig">展示风格</a>
						</li>
					</ul>
				</div>
				<div class="widget-content">
					<div class="row-fluid">
						<div class="span8">
						
							<form class="form-horizontal" method="get" action="#">
								<div class="control-group">
									<label class="control-label" for="">在线交流显示</label>
									<div class="controls">
										<label class="radio">
										<input type="radio" checked="checked" value="" name="xxx">
										固定于页面左边
										</label>
										<label class="radio">
										<input type="radio"  value="" name="x">
										固定于页面右边
										</label>
										<label class="radio">
										<input type="radio"  value="" name="x">
										居左随屏幕滚动
										</label>
										<label class="radio">
										<input type="radio"  value="" name="x">
										居右随屏幕滚动
										</label>
										<label class="radio">
										<input type="radio"  value="" name="x">
										关闭
										</label>
									</div>	
								</div>
								<div class="control-group">
									<label class="control-label" for="">位置</label>
									<div class="controls">
										<label>
										距离浏览器侧边 <input type="text" style="width:30px !important;"/> 像素，距离浏览器顶部 <input type="text" style="width:30px !important;"/> 像素
										</label>
									</div>	
								</div>
								<div class="control-group">
									<label class="control-label" for="">漂浮风格</label>
									<div class="controls">
										<select></select> <select></select>
									</div>	
								</div>
								<div class="control-group">
									<label class="control-label" for="">QQ图标</label>
									<div class="controls">
										<label class="radio inline">
										<input type="radio" checked="checked" value="" name="qq">
										<img alt="" src="${ctx}/asset/console/img/online/qq_1.jpg">
										</label>
										<label class="radio inline">
										<input type="radio"  value="" name="qq">
										<img alt="" src="${ctx}/asset/console/img/online/qq_10.jpg">
										</label>
										<label class="radio inline">
										<input type="radio"  value="" name="qq">
										<img alt="" src="${ctx}/asset/console/img/online/qq_2.jpg">
										</label>
										<label class="radio inline">
										<input type="radio"  value="" name="qq">
										<img alt="" src="${ctx}/asset/console/img/online/qq_3.jpg">
										</label>
										<label class="radio inline">
										<input type="radio"  value="" name="qq">
										<img alt="" src="${ctx}/asset/console/img/online/qq_4.jpg">
										</label>
										<label class="radio inline">
										<input type="radio"  value="" name="qq">
										<img alt="" src="${ctx}/asset/console/img/online/qq_41.jpg">
										</label>
										<label class="radio inline">
										<input type="radio"  value="" name="qq">
										<img alt="" src="${ctx}/asset/console/img/online/qq_42.jpg">
										</label>
										<label class="radio inline">
										<input type="radio"  value="" name="qq">
										<img alt="" src="${ctx}/asset/console/img/online/qq_44.jpg">
										</label>
										<label class="radio inline">
										<input type="radio"  value="" name="qq">
										<img alt="" src="${ctx}/asset/console/img/online/qq_45.jpg">
										</label>
										<label class="radio inline">
										<input type="radio"  value="" name="qq">
										<img alt="" src="${ctx}/asset/console/img/online/qq_46.jpg">
										</label>
										<label class="radio inline">
										<input type="radio"  value="" name="qq">
										<img alt="" src="${ctx}/asset/console/img/online/qq_47.jpg">
										</label>
										<label class="radio inline">
										<input type="radio"  value="" name="qq">
										<img alt="" src="${ctx}/asset/console/img/online/qq_5.jpg">
										</label>
										<label class="radio inline">
										<input type="radio"  value="" name="qq">
										<img alt="" src="${ctx}/asset/console/img/online/qq_6.jpg">
										</label>
										<label class="radio inline">
										<input type="radio"  value="" name="qq">
										<img alt="" src="${ctx}/asset/console/img/online/qq_7.jpg">
										</label>
										<label class="radio inline">
										<input type="radio"  value="" name="qq">
										<img alt="" src="${ctx}/asset/console/img/online/qq_8.jpg">
										</label>
										<label class="radio inline">
										<input type="radio"  value="" name="qq">
										<img alt="" src="${ctx}/asset/console/img/online/qq_9.jpg">
										</label>
									</div>
								</div>
								<div class="control-group">
									<label class="control-label" for="">淘宝旺旺图标</label>
									<div class="controls">
										<label class="radio inline">
										<input type="radio" checked="checked" value="" name="tb">
										<img alt="" src="${ctx}/asset/console/img/online/taobao_1.jpg">
										</label>
										<label class="radio inline">
										<input type="radio" value="" name="tb">
										<img alt="" src="${ctx}/asset/console/img/online/taobao_2.jpg">
										</label>
									</div>
								</div>
								<div class="control-group">
									<label class="control-label" for="">阿里旺旺图标</label>
									<div class="controls">
										<label class="radio inline">
										<input type="radio" checked="checked" value="" name="al">
										<img alt="" src="${ctx}/asset/console/img/online/alibaba_1.jpg">
										</label>
										<label class="radio inline">
										<input type="radio" value="" name="al">
										<img alt="" src="${ctx}/asset/console/img/online/alibaba_2.jpg">
										</label>
										<label class="radio inline">
										<input type="radio" value="" name="al">
										<img alt="" src="${ctx}/asset/console/img/online/alibaba_101.jpg">
										</label>
									</div>
								</div>
								<div class="control-group">
									<label class="control-label" for="">SKYPE图标</label>
									<div class="controls">
										<label class="radio inline">
										<input type="radio" checked="checked" value="" name="s">
										<img alt="" src="${ctx}/asset/console/img/online/skype_11.gif">
										</label>
										<label class="radio inline">
										<input type="radio" value="" name="s">
										<img alt="" src="${ctx}/asset/console/img/online/skype_12.gif">
										</label>
									</div>
								</div>
								<div class="control-group">
									<label class="control-label" for="">显示客服名称</label>
									<div class="controls">
										<label class="checkbox">
										<input type="checkbox" checked="checked" value="" name="s">
										勾选则显示客服名称
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