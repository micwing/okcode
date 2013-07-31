<%@page contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div id="breadcrumb">
	<a href="${ctx}/console/home"><i class="icon-home"></i> 首页</a>
	<a href="#"><i class="icon-screenshot"></i> 优化推广</a>
	<a class="current" href="#">SEO优化</a>	
</div>
<div class="container-fluid">
	<div class="row-fluid">
		<div class="span12">
			<div class="widget-box">
				<div class="widget-title">
					<span class="icon">
					<i class="icon-screenshot"></i>
					</span>
					<h5>SEO优化</h5>
				</div>
				<div class="widget-content">
					<div class="row-fluid">
						<div class="span8">
							<form class="form-horizontal" method="get" action="#">
								<div class="control-group">
									<label class="control-label" for="">首页标题(title)</label>
									<div class="controls">
										<div class="radio">
											<input type="radio" name="a"/>
											网站名称+网站关键字
										</div>
										<div class="radio">
											<input type="radio" name="a"/>
											网站名称+网站描述
										</div>
										<div class="radio">
											<input type="radio" name="a"/>
											自定义内容：<br/>
											<input type="text" />
										</div>
									</div>	
								</div>
								<div class="control-group">
									<label class="control-label" for="">列表页标题(title)</label>
									<div class="controls">
										<div class="radio">
											<input type="radio" name="b"/>
											栏目名称+网站关键字
										</div>
										<div class="radio">
											<input type="radio" name="b"/>
											栏目名称+网站描述
										</div>
										<div class="radio">
											<input type="radio" name="b"/>
											栏目名称+自定义内容：<br/>
											<input type="text" />
										</div>
									</div>	
								</div>
								<div class="control-group">
									<label class="control-label" for="">内容页标题(title)</label>
									<div class="controls">
										<div class="radio">
											<input type="radio" name="c"/>
											内容标题+网站关键字
										</div>
										<div class="radio">
											<input type="radio" name="c"/>
											内容标题+网站描述
										</div>
										<div class="radio">
											<input type="radio" name="c"/>
											内容标题+自定义内容：<br/>
											<input type="text" />
										</div>
									</div>	
								</div>
								<div class="control-group">
									<label class="control-label" for="">图片alt默认内容</label>
									<div class="controls">
										<div class="radio">
											<input type="radio" name="d"/>
											只显示图片本身的alt，从不显示默认内容
										</div>
										<div class="radio">
											<input type="radio" name="d" checked="checked"/>
											当图片的alt为空时才显示默认内容：<br/>
											<input type="text" />
										</div>
										<div class="radio">
											<input type="radio" name="d"/>
											为所有图片alt值追加默认内容：<br/>
											<input type="text" />
										</div>
									</div>	
								</div>
								<div class="control-group">
									<label class="control-label" for="">超链接title默认内容</label>
									<div class="controls">
										<div class="radio">
											<input type="radio" name="e"/>
											只显示超链接本身的title，从不显示默认内容
										</div>
										<div class="radio">
											<input type="radio" name="e" checked="checked"/>
											当超链接的title为空时才显示默认内容：<br/>
											<input type="text" />
										</div>
										<div class="radio">
											<input type="radio" name="d"/>
											为所有超链接title值追加默认内容：<br/>
											<input type="text" />
										</div>
									</div>	
								</div>
								<div class="control-group">
									<label class="control-label" for="">网站头部优化字</label>
									<div class="controls">
										<textarea rows="" cols=""></textarea>
									</div>	
								</div>
								<div class="control-group">
									<label class="control-label" for="">网站底部优化字</label>
									<div class="controls">
										<textarea rows="" cols=""></textarea>
									</div>	
								</div>
								<div class="form-actions">
									<button class="btn btn-primary" type="submit">保存</button>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>					
		</div>
	</div>
</div>