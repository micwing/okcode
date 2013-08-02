<%@page contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<div class="control-group">
	<label class="control-label" for="price">价格</label>
	<div class="controls">
		<div class="input-prepend">
		  <span class="add-on">￥</span>
		  <input class="span2" type="text" name="price" value="${article.attr.price}" placeholder="价格">
		</div>
	</div>	
</div>
<div class="control-group" id="showImageUrl">
	<label class="control-label" for=""></label>
	<div class="controls">
		<a href="javascript:;" onclick="showImageUrl()"><i class="icon-arrow-down"></i> 显示产品展示图片</a>
	</div>	
</div>
<c:forEach begin="1" end="10" step="1" var="i">
	<div class="control-group control-group-imageUrl" style="display:none">
		<label class="control-label" for="updateAt">展示图片${i}</label>
		<div class="controls">
			<span class="p-image${i}"></span><input type="text" name="imageUrl${i}" value="${article.attr.imageUrl['imageUrl'+i]}" placeholder="展示图片${i}"/> <input type="button" class="btn imageUrlBtn" idx="${i}" value="浏览图片" />
			<c:if test="${i==10}">
				<span class="help-block">您至多添加10张图片</span>
			</c:if>
		</div>
	</div>
</c:forEach>
<div class="control-group" id="hideImageUrl" style="display:none">
	<label class="control-label" for=""></label>
	<div class="controls">
		<a href="javascript:;" onclick="hideImageUrl()"><i class="icon-arrow-up"></i> 收起产品展示图片</a>
	</div>	
</div>
<script type="text/javascript">
function showImageUrl() {
	$('#showImageUrl').hide();
	$('.control-group-imageUrl').show(500);
	$('#hideImageUrl').show();
}
function hideImageUrl() {
	$('#hideImageUrl').hide();
	$('.control-group-imageUrl').hide(500);
	$('#showImageUrl').show();
}
$(function() {
	$('.imageUrlBtn').on("click", function(){
		var i = $(this).attr('idx');
		var finder = new CKFinder();
		//finder.basePath = Drupal.settings.basePath + Drupal.settings.ckfinderPath + '/';
		finder.selectActionFunction = function(fileUrl) {
			$('.p-image'+i).html('<img src="'+fileUrl+'"/><br/>');
			$('input:text[name=imageUrl'+i+']').val(fileUrl);
		};
		finder.popup();
	});
});
</script>