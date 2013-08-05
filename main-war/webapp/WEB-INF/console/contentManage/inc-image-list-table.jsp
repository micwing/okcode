<%@page contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:if test="${!empty articleList}">
<table class="table table-bordered table-striped table-hover">
	<tr>
		<th width="40px">ID</th>
		<th width="140px">更新时间</th>
		<th width="80px">所属栏目</th>
		<th>标题</th>
		<th width="60px">是否置顶</th>
		<th width="160px">操作</th>
	</tr>
	<c:forEach items="${articleList}" var="article">
	<tr>
		<td>${article.id}</td>
		<td><fmt:formatDate value="${article.updateAt}" pattern="yyyy-MM-dd" /></td>
		<td>
			<c:forEach items="${catalogs}" var="catalog">
			<c:if test="${catalog.id == article.catalog.id}">${catalog.title}</c:if>
			</c:forEach>
		</td>
		<td>${empty article.title?'(空)':article.title}</td>
		<td>${article.topFlag==true?'<span class=red>是</span>':'否'}</td>
		<td>
		    <div class="btn-group">
		    <a class="btn btn-small" href="${ctx}/console/contentManage/detail?module=${module}&cid=${cid}&id=${article.id}">编辑</a>
		    <a class="btn btn-small" href="#">查看</a>
		    <button class="btn btn-danger btn-small" id="del-btn-${article.id}" onclick="doDelete(${article.id})">删除</button>
		    </div>
		</td>
	</tr>
	</c:forEach>
</table>

<div class="span6 pull-right">
	<div class="pagination pagination-right">
		<jsp:include page="../../util/paging.jsp">
			<jsp:param name="_paging_base_url" value="${ctx}/console/contentManage/list?module=${module}&cid=${cid}"/>
			<jsp:param name="_paging_range" value="3"/>
			<jsp:param name="_paging_size" value="10"/>
		</jsp:include>
	</div>
</div>
</c:if>
<c:if test="${empty articleList}">
	暂无数据，
</c:if>

<script type="text/javascript">
function doDelete(aid) {
	if (!window.confirm("您确定要删除吗？")) {
		return;
	}
	$.ajax2({
		url : "${ctx}/console/contentManage/doDelete",
		data : {aid:aid},
		btn : '#del-btn-'+aid,
		success : function(result) {
			if (result.code == 0) {
				setTimeout(function() {
					window.location.href='${ctx}/console/contentManage/list?module=${module}&cid=${cid}';
				},1000);
			}
		}
	});
}
</script>