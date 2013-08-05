<%@page contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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