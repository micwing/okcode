<%@page contentType="text/html;charset=utf-8" pageEncoding="utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <footer id="footer">
            <div class="footer-top"></div>
            <div class="footer-wrapper">
                <div class="container">
                    <div class="row show-grid">
                        <div class="span12">
                            <div class="row show-grid">

                                <div class="span4">
                                    <img alt="" class="footer-logo" src="${ctx}${baseConfig.siteLogoUrl}" />

                                    <address class="address">
                                        <p><i class="icon-map-marker icon-large"></i>地址: ${bottomInfo.addressInfo}</p>
                                        <p><i class="icon-phone icon-large"></i>电话: ${bottomInfo.contectInfo}</p>
                                        <p><i class="icon-print icon-large"></i>传真: ${bottomInfo.faxInfo}</p>
                                    </address>
                                </div>

                                <div class="span4 footer-center">
                                    ${bottomInfo.otherInfo}
                                </div>
                                
                                <div class="span4 footer-right">
                                    <h4 class="center-title">导航</h4>
                                    <ul class="footer-navigate">
                                        <li>
                                    	<a href="${baseConfig.siteUrl}">首页</a>
	                                    </li>
	                                    <c:if test="${!empty bottomCatalogs}">
	                                    <c:forEach items="${bottomCatalogs}" var="bottomCatalog">
	                                    	
	                                    	<li>
		                                        <a href="${ctx}/portal/catalog/${bottomCatalog.module}/${bottomCatalog.alias}" 
		                                        ${bottomCatalog.newWindowOpen?'target=_blank':''}
		                                        >
		                                        ${bottomCatalog.title}
		                                        </a>
	                                    	</li>
	                                    	
	                                    </c:forEach>
	                                    </c:if>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            
            <div class="footer-bottom">
                <div class="container">
                    <div class="row show-grid">
                        <div class="span12">
                            <p>${bottomInfo.copyrightInfo} ${bottomInfo.moreCode}</p>
                        </div>
                    </div>
                </div>
            </div>
        </footer>