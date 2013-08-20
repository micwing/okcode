<%@page contentType="text/html;charset=utf-8" pageEncoding="utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
				<div class="row show-grid">
                    <div class="span12">
                        <div id="breadcrumb">
                        	<jsp:include page="common-breadcrumb.jsp" />
                        </div>
                        <div class="row show-grid">
                            <div id="left-sidebar" class="span3 sidebar">                               
                                <jsp:include page="common-sideCatalogItems.jsp" />
                            </div>
                            <div class="span9 main-column two-columns-left">
                            	<c:if test="${!empty articleList}">
	                            	<c:forEach items="${articleList}" var="article">
		                                <div class="post-item">
		                                    <h2>${article.title}</h2>
		                                    <p class="post-description">${article.subTitle}</p>
		                                    <a class="post-more" href="${ctx}/portal/article/detail/${article.id}">阅读全文&nbsp;&raquo;</a>
		                                    <div class="post-item-panel">
		                                        <ul>
		                                            <li class="date">
		                                              <p><i class="icon-calendar"></i><fmt:formatDate value="${article.updateAt}" pattern="yyyy-MM-dd" /></p></li>
		                                              <c:if test="${!empty article.author}">
			                                            <li><p><i class="icon-user"></i>by ${article.author}</p></li>
		                                              </c:if>
		                                            <li><p><i class="icon-tags"></i><a href="${ctx}/portal/catalog/${article.catalog.module}/${article.catalog.alias}">${article.catalog.title}</a></p></li>
		                                        </ul>
		                                    </div>
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
