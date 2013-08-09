<%@page contentType="text/html;charset=utf-8" pageEncoding="utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
				<div class="row show-grid">
                    <div class="span12">
                        <div id="breadcrumb">
                        <ul>
                            <li class="home"><a href="${ctx}/">首页</a></li>
                            <li><a href="${ctx}/news">新闻资讯</a></li>
                            <li>公司新闻</li>
                        </ul>
                        </div>
                        <div class="row show-grid">
                            <div id="left-sidebar" class="span3 sidebar">                               
                                <div class="side-nav sidebar-block">
                                    <h2>新闻资讯</h2>
                                    <ul>
                                            <li class="active"><a href="stickies.html">公司新闻</a></li>
                                            <li><a href="columns.html">行业动态</a></li>
                                    </ul>
                                </div>                                
                            </div>
                            <div class="span9 main-column two-columns-left">
                            	<c:if test="${!empty articleList}">
	                            	<c:forEach items="${articleList}" var="article">
	                            	
		                                <div class="row show-grid team-member">
		                                	<c:if test="${!empty article.attr.imageUrl1thumb}">
			                                    <div class="span3 photo">
			                                        <div class="bordered-img"><a href="${ctx}/portal/article/detail/${article.id}" title="${article.title}"><img alt="${article.title}" src="${ctx}${article.attr.imageUrl1thumb}" style="width: 220px;height: 140px;"></a></div>
			                                    </div>
		                                	</c:if>
		                                	<c:if test="${empty article.attr.imageUrl1thumb}">
			                                    <div class="span3 photo">
			                                        <div class="bordered-img"><div style="width: 220px;height: 140px;" ></div></div>
			                                    </div>
		                                	</c:if>
		                                    <div class="span6">
		                                    	<div style="height: 100px;overflow: hidden;">
			                                        <h2><a href="${ctx}/portal/article/detail/${article.id}" title="${article.title}">${article.title}</a></h2>
		                                       		<p>${article.subTitle}</p>
		                                    	</div>
		                                        <div class="post-item-panel">
			                                        <ul>
			                                            <c:if test="${!empty article.attr.price}">
				                                       	<li><p><i class="icon-shopping-cart" title="价格"></i>价格 ￥${article.attr.price}</p></li>
				                                        </c:if>
			                                            <li class="date"><p><i class="icon-calendar" title="更新时间"></i><fmt:formatDate value="${article.updateAt}" pattern="yyyy-MM-dd" /></p></li>
		                                              	<c:if test="${!empty article.author}">
			                                            <li><p><i class="icon-user" title="作者"></i>${article.author}</p></li>
		                                             	</c:if>
			                                            <li><p><i class="icon-tags" title="所属栏目"></i><a href="${ctx}/portal/catalog/${article.catalog.module}/${article.catalog.alias}">${article.catalog.title}</a></p></li>
			                                            <li class="comments"><p><i class="icon-eye-open" title="访问次数"></i><span>${article.clicks}</span></p></li>
			                                        </ul>
			                                    </div>
		                                    </div>
		                                    <div class="member-divider"></div>
		                                </div>
                                
	                            	</c:forEach>
	                                <div class="pagination pull-right">
	                                     <jsp:include page="../../util/paging.jsp">
											<jsp:param name="_paging_base_url" value="${ctx}/portal/article/${catalog.alias}?ctx="/>
											<jsp:param name="_paging_range" value="3"/>
											<jsp:param name="_paging_size" value="10"/>
										</jsp:include>
	                                 </div>
                            	</c:if>
                            </div>
                            
                        </div>
                    </div>
                </div>
                <hr>
