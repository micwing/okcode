<%@page contentType="text/html;charset=utf-8" pageEncoding="utf-8" %>
<%@page import="okcode.biz.trading.model.Article" %>
<%@page import="okcode.framework.utils.HtmlUtil" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
								<div class="side-nav sidebar-block">
                                    <h2>${navCatalog.title}</h2>
                                    <ul>
                                           <c:if test="${!empty sideCatalogItems}">
		                                   <c:forEach items="${sideCatalogItems}" var="secondCatalogItem">
		                                   
		                                    	<li class="${catalog.id == secondCatalogItem.catalog.id?'active':''}">
			                                        <a href="${ctx}/portal/catalog/${secondCatalogItem.catalog.module}/${secondCatalogItem.catalog.alias}" 
			                                        ${secondCatalogItem.catalog.newWindowOpen?'target=_blank':''}
			                                        >
			                                        ${secondCatalogItem.catalog.title}<i>${secondCatalogItem.catalog.subTitle}</i>
			                                        </a>
		                                    	</li>
		                                    	
		                                        <c:if test="${!empty secondCatalogItem.subCatalog}">
	                                        	<c:forEach items="${secondCatalogItem.subCatalog}" var="thirdCatalogItem">
	                                            	<li class="${catalog.id == thirdCatalogItem.catalog.id?'active':''}" style="padding-left: 10px;">
		                                            	<a href="${ctx}/portal/catalog/${thirdCatalogItem.catalog.module}/${thirdCatalogItem.catalog.alias}" 
		                                            	${thirdCatalogItem.catalog.newWindowOpen?'target=_blank':''}
		                                            	>
		                                            	${thirdCatalogItem.catalog.title}
	                                            	</a></li>
	                                            </c:forEach>
		                                        </c:if>
		                                    	
		                                    </c:forEach>
		                                    </c:if>
                                    </ul>
                                </div>