<%@page contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@page import="okcode.biz.trading.enums.CatalogLevel"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<div id="breadcrumb">
	<a href="${ctx}/console/home"><i class="icon-home"></i> 首页</a>
	<a href="#"><i class="icon-th-list"></i> 栏目规划</a>
	<a href="${ctx}/console/columnConfig">栏目设置</a>	
	<a class="current" href="#">栏目详情</a>	
</div>
<div class="container-fluid">
	<div class="row-fluid">
		<div class="span12">
			<div class="widget-box">
				<div class="widget-title">
					<span class="icon">
					<i class="icon-th-list"></i>
					</span>
					<h5>栏目详情<c:if test="${!empty catalog.title}"> (${catalog.title})</c:if></h5>
				</div>
				<div class="widget-content">
					<div class="row-fluid">
						<div class="span8">
						
							<form class="form-horizontal" id="ffrom" method="post" action="">
								<div class="control-group">
									<label class="control-label" for="">栏目类型</label>
									<div class="controls">
										<span>${catalog.module.label}</span>
										<input type="hidden" id="id" name="id" value="${catalog.id}">
										<input type="hidden" name="module" value="${catalog.module}">
									</div>
								</div>
								<c:if test="${(firstItem.catalog.module != 'sitemap')&&(firstItem.catalog.module != 'search')&&(firstItem.catalog.module != 'outlink')}">
								<div class="control-group">
									<label class="control-label" for="pid">上级栏目</label>
									<div class="controls">
										<select name="pid">
											<option value="0">无</option>
											<c:forEach items="${catalogItems}" var="firstItem">
												<c:if test="${firstItem.catalog.id != catalog.id}">
												<c:if test="${firstItem.catalog.module != 'sitemap'&&firstItem.catalog.module != 'search'&&firstItem.catalog.module != 'outlink'}">
												<option value="${firstItem.catalog.id}" ${firstItem.catalog.id==catalog.pid?'selected':''}>${firstItem.catalog.title}</option>
												</c:if>
												</c:if>
												<c:if test="${!empty firstItem.subCatalog}">
													<c:forEach items="${firstItem.subCatalog}" var="secondItem">
														<c:if test="${secondItem.catalog.id != catalog.id}">
														<c:if test="${secondItem.catalog.module != 'sitemap'&&secondItem.catalog.module != 'search'&&secondItem.catalog.module != 'outlink'}">
														<option value="${secondItem.catalog.id}" ${secondItem.catalog.id==catalog.pid?'selected':''}>└ ${secondItem.catalog.title}</option>
														</c:if>
														</c:if>
													</c:forEach>
												</c:if>
											</c:forEach>
										</select>
									</div>	
								</div>
								</c:if>
								<div class="control-group">
									<label class="control-label" for="title">栏目标题</label>
									<div class="controls">
										<input type="text" name="title" value="${catalog.title}" />
									</div>	
								</div>
								<div class="control-group">
									<label class="control-label" for="subTitle">栏目小标题</label>
									<div class="controls">
										<input type="text" name="subTitle" value="${catalog.subTitle}" />
									</div>	
								</div>
								<div class="control-group">
									<label class="control-label" for="alias">访问别名</label>
									<div class="controls">
										<input type="text" name="alias" value="${catalog.alias}" />
									</div>	
								</div>
								<c:if test="${catalog.module=='outlink'}">
								<div class="control-group">
									<label class="control-label" for="outlinkUrl">链接地址</label>
									<div class="controls">
										<input type="text" name="outlinkUrl" value="${catalog.attributes.outlinkUrl}" />
									</div>	
								</div>
									
								</c:if>
								<div class="control-group">
									<label class="control-label" for="rank">排序值</label>
									<div class="controls">
										<input type="text" name="rank" value="${catalog.rank}" />
									</div>
								</div>
								<div class="control-group">
									<label class="control-label" for="navDisplay">导航栏显示</label>
									<div class="controls">
										<label class="radio inline">
											<input type="radio" name="navDisplay" value="NONE" 
												${catalog.navDisplay == 'NONE'?'checked=checked':''}
												/>
											不显示
										</label>
										<label class="radio inline">
											<input type="radio" name="navDisplay" value="MAIN"
												${catalog.navDisplay == null?'checked=checked':''}
												${catalog.navDisplay == 'MAIN'?'checked=checked':''}
												/>
											主导航栏
										</label>
										<label class="radio inline">
											<input type="radio" name="navDisplay" value="BOTTOM"
												${catalog.navDisplay == 'BOTTOM'?'checked=checked':''}
												/>
											底部导航栏
										</label>
										<label class="radio inline">
											<input type="radio" name="navDisplay" value="BOTH"
												${catalog.navDisplay == 'BOTH'?'checked=checked':''}
												/>
											都显示
										</label>
									</div>
								</div>
								<div class="control-group">
									<label class="control-label" for="newWindowOpen">新窗口打开</label>
									<div class="controls">
										<label class="checkbox">
											<input type="checkbox" name="newWindowOpen" 
												${catalog.newWindowOpen == true ? 'checked=checked':''}
												/>
											勾选后在新窗口打开本栏目的链接页面
										</label>
									</div>
								</div>
								<%--以下四种模块才可以指定显示内容 --%>
								<c:if test="${catalog.module == 'article'||catalog.module == 'product'||catalog.module == 'image'||catalog.module == 'download'}">
								<div class="control-group">
									<label class="control-label" for="clickDisplay">点击后的显示</label>
									<div class="controls">
										<label class="radio">
											<input type="radio" name="clickDisplay" value="FIRST_CONTENT"
												${catalog.clickDisplay == 'FIRST_CONTENT' ? 'checked=checked':''}
												/>
											本栏目第一个内容
										</label>
										<label class="radio">
											<input type="radio" name="clickDisplay" value="FIRST_SUB_PAGE"
												${catalog.clickDisplay == null ? 'checked=checked':''}
												${catalog.clickDisplay == 'FIRST_SUB_PAGE' ? 'checked=checked':''}
												/>
											显示第一个子栏目点击后的显示
										</label>
										<label class="radio">
											<input type="radio" name="clickDisplay" value="CONTENT_LIST"
												${catalog.clickDisplay == null ? 'checked=checked':''}
												${catalog.clickDisplay == 'CONTENT_LIST' ? 'checked=checked':''}
												/>
											栏目内容列表
										</label>
										<span class="help-block">选择当栏目被点击后显示内容页或者列表页</span>
									</div>
								</div>
								</c:if>
								<div class="form-actions">
									<button class="btn btn-primary" type="button" id="save-btn" onclick="doSave()">保存</button>
									<a class="btn btn-warning" href="${ctx}/console/columnConfig">返回列表</a>
								</div>
							</form>
						</div>
						<div class="span4"></div>
					</div>
				</div>
			</div>					
		</div>
	</div>
</div>
<script type="text/javascript">
function doSave() {
	if ($('#ffrom').valid()) {
		$.ajax2({
			url : "${ctx}/console/columnConfig/doSave",
			data : $("#ffrom").serialize(),
			btn : '#save-btn',
			success : function(result) {
				if (result.code == 0) {
					$('#id').val(result.value.id);
				}
			}
		});
	}
}

$(function () {
	
	$('#ffrom').validate({
		rules: {
    		module: {
				required: true
			},
			alias: {
				required: true,
				chrnum_: true
			},
			title: {
				maxlength:100,
				required: true
			},
			subTitle: {
				maxlength:100
			},
			rank: {
				number: true
			},
			templateId: {
				required: true
			},
			navDisplay: {
				required: true
			},
			clickDisplay: {
				required: true
			},
			outlinkUrl: {
				required: true
			}
		},
		errorClass: "help-inline",
		errorElement: "span",
		highlight:function(element, errorClass, validClass) {
			$(element).parents('.control-group').removeClass('success');
			$(element).parents('.control-group').addClass('error');
		},
		unhighlight: function(element, errorClass, validClass) {
			$(element).parents('.control-group').removeClass('error');
			$(element).parents('.control-group').addClass('success');
		}
	});
		
});
</script>