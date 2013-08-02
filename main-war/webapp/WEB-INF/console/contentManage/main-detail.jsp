<%@page contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<div id="breadcrumb">
	<a href="${ctx}/console/home"><i class="icon-home"></i> 首页</a>
	<a href="${ctx}/console/contentManage/list?module=article"><i class="icon-list-alt"></i> 内容管理</a>
	<a href="${ctx}/console/contentManage/list?module=${module}">模块内容管理</a>
	<a class="current" href="#">${fn:replace(module.label, '模块', '')}内容详情</a>	
</div>
<div class="container-fluid">
	<div class="row-fluid">
		<div class="span12">
			<div class="widget-box">
				<div class="widget-title">
					<span class="icon">
					<i class="icon-list-alt"></i>
					</span>
					<h5>${fn:replace(module.label, '模块', '')}内容详情</h5>
				</div>
				<div class="widget-content">
					<div class="row-fluid">
						<div class="span12">
						
							<form class="form-horizontal" id="ffrom" method="post" action="">
								<div class="control-group">
									<label class="control-label" for="">所属栏目</label>
									<div class="controls">
										<select name="catalogId">
										<c:if test="${!empty catalogs}"></c:if>
										<c:forEach items="${catalogs}" var="catalog">
											<option value="${catalog.id}" ${catalog.id==cid||catalog.id==article.catalog.id?'selected=selected':''}>${catalog.title}</option>
										</c:forEach>
										</select>
									</div>
								</div>
								<div class="control-group">
									<label class="control-label" for="title">标题</label>
									<div class="controls">
										<input type="text" name="title" value="${article.title}" />
										<input type="hidden" name="id" value="${article.id}" />
									</div>	
								</div>
								<div class="control-group">
									<label class="control-label" for="subTitle">小标题</label>
									<div class="controls">
										<input type="text" name="subTitle" value="${article.subTitle}" />
									</div>	
								</div>
								<div class="control-group">
									<label class="control-label" for="topFlag">置顶</label>
									<div class="controls">
										<label class="checkbox">
											<input type="checkbox" name="topFlag" value="true" ${article.topFlag?'checked=checked':''}/>
											勾选后列表页显示在最顶部
										</label>
									</div>	
								</div>
								<div class="control-group">
									<label class="control-label" for="clicks">点击次数</label>
									<div class="controls">
										<input type="text" name="clicks" value="${article.clicks}" />
									</div>	
								</div>
								<div class="control-group">
									<label class="control-label" for="author">作者</label>
									<div class="controls">
										<input type="text" name="author" value="${article.author}" />
									</div>	
								</div>
								<div class="control-group">
									<label class="control-label" for="updateAt">更新时间</label>
									<div class="controls">
										<input type="text" class="Wdate"  name="updateAt"
										 onfocus="WdatePicker({isShowClear:false,readOnly:true})" readonly="readonly"
										 placeholder="点击选择更新时间"
										 value="<fmt:formatDate value="${article.updateAt}" pattern="yyyy-MM-dd" />" />
									</div>	
								</div>
								
								<c:if test="${module == 'product'}">
									<jsp:include page="product-detail-form-inc.jsp"></jsp:include>
								</c:if>
								
								<div class="control-group">
									<label class="control-label" for="content">详细内容</label>
									<div class="controls">
										<textarea id="cke-content" name="content">${article.content}</textarea>
									</div>
								</div>
								<div class="form-actions">
									<button class="btn btn-primary" type="button" id="save-btn" onclick="doSave()">保存</button>
									<a class="btn btn-warning" href="${ctx}/console/contentManage/list?module=${module}&cid=${cid}">返回列表</a>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>					
		</div>
	</div>
</div>
<script type="text/javascript">
var cke;
function doSave() {
	if ($('#ffrom').valid()) {
		$('#cke-content').val(cke.getData());
		$.ajax2({
			url : "${ctx}/console/contentManage/doSave",
			data : $("#ffrom").serialize(),
			btn : '#save-btn',
			success : function(result) {
				if (result.code == 0) {
					$('#id').val(result.value);
				}
			}
		});
	}
}
$(function () {
	cke = CKEDITOR.replace('cke-content');
	
	$('#ffrom').validate({
		rules: {
			catalogId: {
				required: true
			},
			title: {
				maxlength:100
			},
			subTitle: {
				maxlength:100
			},
			updateAt: {
				required: true
			},
			clicks: {
				number:true
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