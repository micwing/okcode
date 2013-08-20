<%@page contentType="text/html;charset=utf-8" pageEncoding="utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <header>
            <div class="container">
                <div class="row">
                    <div class="span4 logo">
                        <a class="logo" href="${baseConfig.siteUrl}">
                            <img alt="logo" title="${baseConfig.systemName}" src="${ctx}${baseConfig.siteLogoUrl}">
                        </a>
                    </div>
                    <div class="span4 offset4">
                        <p class="head_phone">${baseConfig.siteDescription}</p>
                    </div>
                    <ul class="socials unstyled">
                        <li><a class="flickr" href="#"></a></li>
                    </ul>
                </div>
            </div>
            
            <div class="container">
                <div class="navbar">
                    <div class="navbar-inner">
                        <div class="container">
                            <div class="buttons-container">
                            </div>
                            <div class="nav-collapse">
                                <ul class="nav nav-pills">
                                    <li class="single ${navCatalog == null?'active':''}">
                                    	<a href="${baseConfig.siteUrl}">首页<i>Home</i></a>
                                    </li>
                                    <c:if test="${!empty navCatalogItems}">
                                    <c:forEach items="${navCatalogItems}" var="firstCatalogItem">
                                    	
                                    	<li class="${(empty firstCatalogItem.subCatalog) ? 'single':'dropdown'} ${navCatalog.id == firstCatalogItem.catalog.id?'active':''}">
	                                        <a href="${ctx}/portal/catalog/${firstCatalogItem.catalog.module}/${firstCatalogItem.catalog.alias}" 
	                                        ${firstCatalogItem.catalog.newWindowOpen?'target=_blank':''}
	                                        >
	                                        ${firstCatalogItem.catalog.title}<i>${firstCatalogItem.catalog.subTitle}</i>
	                                        </a>
	                                        <c:if test="${!empty firstCatalogItem.subCatalog}">
	                                        <ul class="dropdown-menu">
	                                        	<c:forEach items="${firstCatalogItem.subCatalog}" var="secondCatalogItem">
                                            	<li><a href="${ctx}/portal/catalog/${secondCatalogItem.catalog.module}/${secondCatalogItem.catalog.alias}" 
                                            	${firstCatalogItem.catalog.newWindowOpen?'target=_blank':''}
                                            	>
                                            	${secondCatalogItem.catalog.title}
                                            	</a></li>
	                                            </c:forEach>
	                                        </ul>
	                                        </c:if>
                                    	</li>
                                    	
                                    </c:forEach>
                                    </c:if>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </header>