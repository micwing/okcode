<%@page contentType="text/html;charset=utf-8" pageEncoding="utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
		                                <div class="post-item">
		                                    <h2>${article.title}</h2>
		                                    <img alt="" src="img/blog05.jpg" />
		                                    <p class="post-description">${article.subTitle}</p>
		                                    <a class="post-more" href="${ctx}/news/detail/1">阅读全文&nbsp;&raquo;</a>
		                                    <div class="post-item-panel">
		                                        <ul>
		                                            <li class="date">
		                                              <p><i class="icon-calendar"></i><fmt:formatDate value="${article.updateAt}" pattern="yyyy-MM-dd" /></p></li>
		                                              <c:if test="${!empty article.author}">
			                                            <li><p><i class="icon-user"></i>by ${article.author}</p></li>
		                                              </c:if>
		                                            <li><p><i class="icon-tags"></i><a href="default.htm">photos</a>, <a href="default.htm">design</a></p></li>
		                                            <li class="comments"><p><i class="icon-comments-alt"></i><span>2 comments</span></p></li>
		                                        </ul>
		                                    </div>
		                                </div>
	                            	</c:forEach>
	                                <div class="pagination pull-right">
	                                     <jsp:include page="../../util/paging.jsp">
											<jsp:param name="_paging_base_url" value="${ctx}/portal/article/${catalog.alias}?a=a"/>
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
