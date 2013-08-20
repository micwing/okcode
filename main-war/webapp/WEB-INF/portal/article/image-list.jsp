<%@page contentType="text/html;charset=utf-8" pageEncoding="utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
	                            <ul id="gallery-main" class="thumbnails gallery">
	                            	<c:forEach items="${articleList}" var="article">
		                            	<li class="span3 small hp-wrapper item" style="text-align: center;">
				                            <a href="${ctx}/portal/article/detail/${article.id}" title="${article.title}" class="thumbnail">
												<img alt="" style="width: 220px; height: 160px;" src="${ctx}${article.attr.imageUrl1thumb}" />
											</a>
											<a href="${ctx}/portal/article/detail/${article.id}" title="${article.title}">
												${article.title}
											</a>
				                        </li>
	                            	
	                            	</c:forEach>
			                    </ul>
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
