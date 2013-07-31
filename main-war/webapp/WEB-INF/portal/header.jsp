<%@page contentType="text/html;charset=utf-8" pageEncoding="utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <header>
            <div class="container">
                <div class="row">
                    <div class="span4 logo">
                        <a class="logo" href="index.html">
                            <img alt="logo" title="bizstrap" src="${ctx}/asset/portal/img/logo.png">
                        </a>
                    </div>
                    <div class="span4 offset4">
                        <p class="head_phone"><a href="tel_3A555-555-5555">(800) 655-7800</a></p>
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
                                    <li class="active single">
                                    	<a href="http://www.onekr.com">首页<i>Home</i></a>
                                    </li>
                                    <c:if test="${!empty catalogItems}">
                                    <c:forEach items="${catalogItems}" var="firstCatalogItem">
                                    	
                                    	<li class="${(empty firstCatalogItem.subCatalog) ? 'single':'dropdown'} ">
	                                        <a href="${ctx}/portal/${firstCatalogItem.catalog.module}/${firstCatalogItem.catalog.alias}" 
	                                        ${firstCatalogItem.catalog.newWindowOpen?'target=_blank':''}
	                                        >
	                                        ${firstCatalogItem.catalog.title}<i>${firstCatalogItem.catalog.subTitle}</i>
	                                        </a>
	                                        <c:if test="${!empty firstCatalogItem.subCatalog}">
	                                        <ul class="dropdown-menu">
	                                        	<c:forEach items="${firstCatalogItem.subCatalog}" var="secondCatalogItem">
                                            	<li><a href="${ctx}/portal/${secondCatalogItem.catalog.module}/${secondCatalogItem.catalog.alias}" 
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