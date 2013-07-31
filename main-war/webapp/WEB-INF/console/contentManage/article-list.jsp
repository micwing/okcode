<%@page contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div id="breadcrumb">
	<a href="${ctx}/console/home"><i class="icon-home"></i> 首页</a>
	<a href="${ctx}/console/contentManage/articleList?module=article"><i class="icon-list-alt"></i> 内容管理</a>
	<a class="current" href="#">模块内容管理</a>	
</div>
<div class="container-fluid">
	<div class="row-fluid">
		<div class="span12">
			<div class="widget-box">
				<div class="widget-title">
					<ul class="nav nav-tabs">
						<li class="${module == 'article'?'active':''}">
						<a href="${ctx}/console/contentManage/articleList?module=article">文章模块内容</a>
						</li>
						<li class="${module == 'product'?'active':''}">
						<a href="${ctx}/console/contentManage/articleList?module=product">产品模块内容</a>
						</li>
						<li class="${module == 'image'?'active':''}">
						<a href="${ctx}/console/contentManage/articleList?module=image">图片模块内容</a>
						</li>
						<li class="${module == 'download'?'active':''}">
						<a href="${ctx}/console/contentManage/articleList?module=download">下载模块内容</a>
						</li>
						<li class="${module == 'message'?'active':''}">
						<a href="${ctx}/console/contentManage/articleList?module=message">留言模块内容</a>
						</li>
						<li class="${module == 'job'?'active':''}">
						<a href="${ctx}/console/contentManage/articleList?module=job">招聘模块内容</a>
						</li>
						<li class="${module == 'exlink'?'active':''}">
						<a href="${ctx}/console/contentManage/articleList?module=exlink">友链模块内容</a>
						</li>
					</ul>
				</div>
				<div class="widget-content">
					<div class="row-fluid">
						<div class="span12">
							<div class="alert alert-info">
								<span class="margin-right-20">
								<c:if test="${empty cid}">
									<strong style="color: red">全部栏目</strong></c:if>
								<c:if test="${!empty cid}">
									<a href="${ctx}/console/contentManage/articleList?module=${module}">全部栏目</a></c:if>
								</span>
								<c:if test="${!empty catalogs}">
									<c:forEach items="${catalogs}" var="catalog">
										<span class="margin-right-20">
										<c:if test="${catalog.id == cid}">
											<strong style="color: red">${catalog.title}</strong></c:if>
										<c:if test="${catalog.id != cid}">
											<a href="${ctx}/console/contentManage/articleList?module=${module}&cid=${catalog.id}">${catalog.title}</a></c:if>
										</span>
									</c:forEach>
								</c:if>
							</div>
							
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
									    <a class="btn btn-small" href="${ctx}/console/contentManage/articleDetail?module=${module}&cid=${cid}&id=${article.id}">编辑</a>
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
										<jsp:param name="_paging_base_url" value="${ctx}/console/contentManage/articleList?module=${module}&cid=${cid}"/>
										<jsp:param name="_paging_range" value="3"/>
										<jsp:param name="_paging_size" value="10"/>
									</jsp:include>
								</div>
							</div>
							</c:if>
							<c:if test="${empty articleList}">
								暂无数据，
							</c:if>
							<a class="btn btn-primary btn-small" href="${ctx}/console/contentManage/articleDetail?module=${module}&cid=${cid}&id=">添加${module.label}的内容页面</a>
						</div>
					</div>
				</div>
			</div>					
		</div>
	</div>
</div>
<script type="text/javascript">
function doDelete(aid) {
	if (!window.confirm("您确定要删除吗？")) {
		return;
	}
	$.ajax2({
		url : "${ctx}/console/contentManage/doDeleteArticle",
		data : {aid:aid},
		btn : '#del-btn-'+aid,
		success : function(result) {
			if (result.code == 0) {
				setTimeout(function() {
					window.location.href='${ctx}/console/contentManage/articleList?module=${module}&cid=${cid}';
				},1000);
			}
		}
	});
}
</script>