<%@page contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div id="breadcrumb">
	<a href="${ctx}/console/home"><i class="icon-home"></i> 首页</a>
	<a href="${ctx}/console/contentManage/list?module=article"><i class="icon-list-alt"></i> 内容管理</a>
	<a class="current" href="#">模块内容管理</a>	
</div>
<div class="container-fluid">
	<div class="row-fluid">
		<div class="span12">
			<div class="widget-box">
				<div class="widget-title">
					<ul class="nav nav-tabs">
						<li class="${module == 'article'?'active':''}">
						<a href="${ctx}/console/contentManage/list?module=article">文章模块内容</a>
						</li>
						<li class="${module == 'product'?'active':''}">
						<a href="${ctx}/console/contentManage/list?module=product">产品模块内容</a>
						</li>
						<li class="${module == 'image'?'active':''}">
						<a href="${ctx}/console/contentManage/list?module=image">图片模块内容</a>
						</li>
						<li class="${module == 'download'?'active':''}">
						<a href="${ctx}/console/contentManage/list?module=download">下载模块内容</a>
						</li>
						<li class="${module == 'message'?'active':''}">
						<a href="${ctx}/console/contentManage/list?module=message">留言模块内容</a>
						</li>
						<li class="${module == 'job'?'active':''}">
						<a href="${ctx}/console/contentManage/list?module=job">招聘模块内容</a>
						</li>
						<li class="${module == 'exlink'?'active':''}">
						<a href="${ctx}/console/contentManage/list?module=exlink">友链模块内容</a>
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
									<a href="${ctx}/console/contentManage/list?module=${module}">全部栏目</a></c:if>
								</span>
								<c:if test="${!empty catalogs}">
									<c:forEach items="${catalogs}" var="catalog">
										<span class="margin-right-20">
										<c:if test="${catalog.id == cid}">
											<strong style="color: red">${catalog.title}</strong></c:if>
										<c:if test="${catalog.id != cid}">
											<a href="${ctx}/console/contentManage/list?module=${module}&cid=${catalog.id}">${catalog.title}</a></c:if>
										</span>
									</c:forEach>
								</c:if>
							</div>
							
							<c:if test="${module == 'article'}">
								<jsp:include page="article-list-table.jsp" />
							</c:if>
							<c:if test="${module == 'product'}">
								<jsp:include page="product-list-table.jsp" />
							</c:if>
							
							<a class="btn btn-primary btn-small" href="${ctx}/console/contentManage/detail?module=${module}&cid=${cid}&id=">添加${module.label}的内容页面</a>
						</div>
					</div>
				</div>
			</div>					
		</div>
	</div>
</div>
