<%@page contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div id="breadcrumb">
	<a href="${ctx}/console/home"><i class="icon-home"></i> 首页</a>
	<a href="#"><i class="icon-tint"></i> 界面风格</a>
	<a class="current" href="#">前台首页设置</a>
</div>
<div class="container-fluid">
	<div class="row-fluid">
		<div class="span12">
			<div class="widget-box">
				<div class="widget-title">
					<span class="icon">
					<i class="icon-tint"></i>
					</span>
					<h5>前台首页设置</h5>
				</div>
				<div class="widget-content">
					<div class="row-fluid">
						<div class="span8">
							
							<form id="fform" class="form-horizontal" method="get" action="#">
								<div class="control-group">
									<label class="control-label" for="articleCatalogId">选择文章栏目</label>
									<div class="controls">
										<select name="articleCatalogId">
										<c:forEach items="${allCatalogs}" var="cata">
											<c:if test="${cata.module == 'article'}">
											<option value="${cata.id}" ${cata.id==dto.articleCatalogId?'selected':''}>${cata.title}</option>
											</c:if>
										</c:forEach>
										</select>
									</div>
								</div>
								<div class="control-group">
									<label class="control-label" for="articleNum">文章模块显示</label>
									<div class="controls">
										<input type="text" name="articleNum" value="${dto.articleNum}" style="width: 80px !important"/> 条
										<span class="help-block">为0则不显示</span>
									</div>
								</div>
								<div class="control-group">
									<label class="control-label" for="productCatalogId">选择产品栏目</label>
									<div class="controls">
										<select name="productCatalogId">
										<c:forEach items="${allCatalogs}" var="cata">
											<c:if test="${cata.module == 'product'}">
											<option value="${cata.id}" ${cata.id==dto.productCatalogId?'selected':''}>${cata.title}</option>
											</c:if>
										</c:forEach>
										</select>
									</div>
								</div>
								<div class="control-group">
									<label class="control-label" for="productNum">产品模块显示</label>
									<div class="controls">
										<input type="text" name="productNum" value="${dto.productNum}" style="width: 80px !important"/> 条
										<span class="help-block">为0则不显示</span>
									</div>
								</div>
								<div class="control-group">
									<label class="control-label" for="imageCatalogId">选择图片栏目</label>
									<div class="controls">
										<select name="imageCatalogId">
										<c:forEach items="${allCatalogs}" var="cata">
											<c:if test="${cata.module == 'image'}">
											<option value="${cata.id}" ${cata.id==dto.imageCatalogId?'selected':''}>${cata.title}</option>
											</c:if>
										</c:forEach>
										</select>
									</div>
								</div>
								<div class="control-group">
									<label class="control-label" for="imageNum">图片模块显示</label>
									<div class="controls">
										<input type="text" name="imageNum" value="${dto.imageNum}" style="width: 80px !important"/> 条
										<span class="help-block">为0则不显示</span>
									</div>
								</div>
								<div class="control-group">
									<label class="control-label" for="downloadCatalogId">选择下载栏目</label>
									<div class="controls">
										<select name="downloadCatalogId">
										<c:forEach items="${allCatalogs}" var="cata">
											<c:if test="${cata.module == 'download'}">
											<option value="${cata.id}" ${cata.id==dto.downloadCatalogId?'selected':''}>${cata.title}</option>
											</c:if>
										</c:forEach>
										</select>
									</div>
								</div>
								<div class="control-group">
									<label class="control-label" for="downloadNum">下载模块显示</label>
									<div class="controls">
										<input type="text" name="downloadNum" value="${dto.downloadNum}" style="width: 80px !important"/> 条
										<span class="help-block">为0则不显示</span>
									</div>
								</div>
								<div class="control-group">
									<label class="control-label" for="jobCatalogId">选择招聘栏目</label>
									<div class="controls">
										<select name="jobCatalogId">
										<c:forEach items="${allCatalogs}" var="cata">
											<c:if test="${cata.module == 'job'}">
											<option value="${cata.id}" ${cata.id==dto.jobCatalogId?'selected':''}>${cata.title}</option>
											</c:if>
										</c:forEach>
										</select>
									</div>
								</div>
								<div class="control-group">
									<label class="control-label" for="jobNum">招聘模块显示</label>
									<div class="controls">
										<input type="text" name="jobNum" value="${dto.jobNum}" style="width: 80px !important"/> 条
										<span class="help-block">为0则不显示</span>
									</div>
								</div>
								<div class="control-group">
									<label class="control-label" for="exlinkShow">友情链接</label>
									<div class="controls">
										<div class="make-switch switch-small" data-on-label="显示" data-off-label="隐藏">
						                    <input type="checkbox" name="exlinkShow" value="true" ${dto.exlinkShow==true?'checked':''} />
						                </div>
									</div>
								</div>
								<div class="control-group">
									<label class="control-label" for="frontContent">首页简介内容</label>
									<div class="controls">
										<textarea name="frontContent" rows="10" cols="10" placeholder="首页简介内容">${dto.frontContent}</textarea>
										<span class="help-block">支持HTML</span>
									</div>
								</div>
								<div class="control-group">
									<label class="control-label" for="specialContent">特别介绍内容</label>
									<div class="controls">
										<textarea name="specialContent" rows="10" cols="10" placeholder="特别介绍内容">${dto.specialContent}</textarea>
										<span class="help-block">支持HTML</span>
									</div>
								</div>
								<div class="form-actions">
									<button class="btn btn-primary" type="button" id="save-btn" onclick="doSave()">保存</button>
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
<script type="text/javascript">
function doSave() {
	if ($('#fform').valid()) {
		$.ajax2({
			url : "${ctx}/console/frontHomeConfig/doSaveFrontHomeConfig",
			data : $("#fform").serialize(),
			btn : '#save-btn'
		});
	}
}
$(function() {
	
	$('#fform').validate({
		rules: {
			copyrightInfo: {
				maxlength:1000
			},
			addressInfo: {
				maxlength:1000
			},
			contectInfo: {
				maxlength:1000
			},
			specialContent: {
				maxlength:1000
			},
			faxInfo: {
				maxlength:1000
			},
			moreCode: {
				maxlength:1000
			},
			otherInfo: {
				maxlength:1000
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