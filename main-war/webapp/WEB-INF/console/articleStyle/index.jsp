<%@page contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>

<div id="breadcrumb">
	<a href="${ctx}/console/home"><i class="icon-home"></i> 首页</a>
	<a href="#"><i class="icon-tint"></i> 界面风格</a>
	<a class="current" href="#">内容页设置</a>
</div>
<div class="container-fluid">
	<div class="row-fluid">
		<div class="span12">
			<div class="widget-box">
				<div class="widget-title">
					<span class="icon">
					<i class="icon-tint"></i>
					</span>
					<h5>内容页设置</h5>
				</div>
				<div class="widget-content">
					<div class="widget-content">
						<div class="row-fluid">
							<div class="span8">
							
								<form class="form-horizontal" method="get" action="#">
									<div class="control-group">
										<label class="control-label" for="">社会化分享按钮</label>
										<div class="controls">
											<label class="checkbox">
												<input type="checkbox" name="">
												勾选后在前台显示社会化分享按钮
											</label>
										</div>	
									</div>
									<div class="control-group">
										<label class="control-label" for="">社会化分享按钮</label>
										<div class="controls">
											<textarea rows="" cols=""></textarea>
											<span class="help-block">社会化分享按钮代码</span>
										</div>	
									</div>
									<div class="control-group">
										<label class="control-label" for="">时间显示格式</label>
										<div class="controls">
											<select></select>
										</div>
									</div>
									<div class="control-group">
										<label class="control-label" for="">产品模块展示图片风格</label>
										<div class="controls">
											<select>
												<option>样式1</option>
												<option>样式2</option>
											</select>
										</div>
									</div>
									<div class="control-group">
										<label class="control-label" for="">产品模块展示图片尺寸</label>
										<div class="controls">
											<input type="text" name="" value="" style="width: 80px !important"> X <input type="text" name="" value="" style="width: 80px !important">
											<span class="help-block">宽 × 高，单位：像素</span>
										</div>
									</div>
									<div class="control-group">
										<label class="control-label" for="">图片模块展示图片风格</label>
										<div class="controls">
											<select>
												<option>样式1</option>
												<option>样式2</option>
											</select>
										</div>
									</div>
									<div class="control-group">
										<label class="control-label" for="">图片模块展示图片尺寸</label>
										<div class="controls">
											<input type="text" name="" value="" style="width: 80px !important"> X <input type="text" name="" value="" style="width: 80px !important">
											<span class="help-block">宽 × 高，单位：像素</span>
										</div>
									</div>
									<div class="control-group">
										<label class="control-label" for="">页脚显示</label>
										<div class="controls">
											<label class="checkbox">
												<input type="checkbox" name="">
												点击次数
											</label>
											<label class="checkbox">
												<input type="checkbox" name="">
												更新时间
											</label>
											<label class="checkbox">
												<input type="checkbox" name="">
												打印此页
											</label>
											<label class="checkbox">
												<input type="checkbox" name="">
												关闭按钮
											</label>
										</div>
									</div>
									<div class="control-group">
										<label class="control-label" for="">上下一条翻页范围</label>
										<div class="controls">
											<label class="radio">
												<input type="radio" name="x" value="option1" checked>
												一级栏目下
											</label>
											<label class="radio">
												<input type="radio" name="x" value="option1">
												当前栏目下
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