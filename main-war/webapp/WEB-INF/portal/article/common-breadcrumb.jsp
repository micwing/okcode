<%@page contentType="text/html;charset=utf-8" pageEncoding="utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
						<ul>
                            <li class="home"><a href="${ctx}/">首页</a></li>
                            <c:forEach items="${breadCatalogs}" var="breadCatalog">
	                            <li><a href="${ctx}/portal/catalog/${breadCatalog.module}/${breadCatalog.alias}" 
                                          	${breadCatalog.newWindowOpen?'target=_blank':''}
                                          	>${breadCatalog.title}</a></li>
                            </c:forEach>
                            <c:if test="${!empty article}">
                            	<li>${article.title}</li>
                            </c:if>
                        </ul>