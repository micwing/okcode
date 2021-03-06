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
                                <h1>${article.title}</h1>
                                <h4 style="margin-bottom: 10px">${article.subTitle}</h4>
                            	<div class="flexslider thumbnails-flexslider" style="width:${imageConfig.imageImageWidth};">
								<ul class="slides">
                           			<c:forEach begin="1" end="10" step="1" var="i">
	                           			<c:set var="key" value="${fn:replace('imageUrlx','x',i)}"></c:set>
										<c:if test="${article.attr[key] != null && article.attr[key] != ''}">
									    <li data-thumb="${article.attr[key]}">
											<img alt="" src="${article.attr[key]}" style="width:${imageConfig.imageImageWidth}; height:${imageConfig.imageImageHeight};"/>
									    </li>
	                           			</c:if>
                           			</c:forEach>
								</ul>
								</div>

                                <div>${article.content}</div>
                                <div class="post-item-panel">
                                    <ul>
                                        <li class="date"><p><i class="icon-calendar" title="更新时间"></i><fmt:formatDate value="${article.updateAt}" pattern="yyyy-MM-dd" /></p></li>
                                        <c:if test="${!empty article.author}">
                                        	<li><p><i class="icon-user" title="作者"></i>${article.author}</p></li>
                                        </c:if>
                                        <li><p><i class="icon-tags" title="所属栏目"></i><a href="${ctx}/portal/catalog/${article.catalog.module}/${article.catalog.alias}">${article.catalog.title}</a></p></li>
                                        <li class="comments"><p><i class="icon-eye-open" title="访问次数"></i><span>${article.clicks}</span></p></li>
                                    </ul>
                                </div>
                                <!-- <ul class="pager">
                                    <li class="previous"><a href="#">&larr; 上一篇</a></li>
                                    <li class="next"><a href="#">下一篇 &rarr;</a></li>
                                </ul> -->
                                <hr>
                                
                                <div class="post-socials">
                                	<h2>分享</h2>
                                    <!-- Baidu Button BEGIN -->
									<div id="bdshare" class="bdshare_t bds_tools get-codes-bdshare">
									<a class="bds_qzone"></a>
									<a class="bds_tsina"></a>
									<a class="bds_tqq"></a>
									<a class="bds_renren"></a>
									<a class="bds_t163"></a>
									<span class="bds_more">更多</span>
									<a class="shareCount"></a>
									</div>
									<script type="text/javascript" id="bdshare_js" data="type=tools&amp;uid=0" ></script>
									<script type="text/javascript" id="bdshell_js"></script>
									<script type="text/javascript">
									document.getElementById("bdshell_js").src = "http://bdimg.share.baidu.com/static/js/shell_v2.js?cdnversion=" + Math.ceil(new Date()/3600000)
									</script>
									<!-- Baidu Button END -->
                                </div>
                                <hr>
                                
                                <!-- <div class="comments">
                                    <h2>评论</h2>                                                                        
                                    <div class="comment-object">
                                        <div class="row show-grid comment-details">
                                            <div class="span5">
                                                <a class="name" href="#">飞翔的迈克</a>
                                            </div>
                                            <div class="span3">
                                                <p class="comment-date">July 11, 2012 at 10:51 am</p>
                                            </div>
                                            <div class="span1">
                                                <a class="reply" href="#">Reply</a>
                                            </div>
                                        </div>
                                        <div class="row show-grid comment-item">
                                            <table class="comment-table span9">
                                                <tr>
                                                    <td>
                                                        <a href="default.htm"><img alt="" src="img/comment_thumb.jpg" /></a>
                                                    </td>
                                                    <td class="baloon"></td>
                                                    <td class="comment-body">                                                
                                                        <p>This is a comment! Donec ullamcorper nulla non metus auctor fringilla. Integer posuere erat
                                                            a ante venenatis dapibus posuere velit.</p>
                                                    </td>
                                                </tr>
                                            </table>
                                        </div>
                                    </div>                                                                                                                                              
                                </div> -->
                                
                                <!-- <div class="reply-form">                                    
                                <div class="row show-grid">
                                    <h2 class="offset1">提交评论</h2>
                                    <form id="validForm">
                                        <div class="control-group span4 offset1">
                                            <label for="inputName" class="control-label">NAME<sup>*</sup></label>
                                            <div class="controls">
                                                <input type="text" placeholder="Name" id="inputName" class="span4">
												<span class="help-inline">Please fill your name</span>
                                            </div>
                                        </div>                                         
                                        <div class="control-group span4">
                                            <label for="inputEmail" class="control-label">EMAIL<sup>*</sup></label>
                                            <div class="controls">
                                                <input type="text" class="span4" id="inputEmail" placeholder="Email">
                                                <span class="help-inline">Please correct the error</span>
                                            </div>
                                        </div>
                                        <div class="control-group span8 offset1">
                                            <label class="control-label" for="inputWebsite">WEBSITE</label>
                                            <div class="controls">
                                                <input type="text" class="span8" id="inputWebsite">
                                            </div>
                                        </div>
                                        <div class="control-group span8 offset1">
                                            <label class="control-label" for="textarea">COMMENT<sup>*</sup></label>
                                            <div class="controls">
                                                <textarea class="span8" rows="4" id="textarea"></textarea>
												<span class="help-inline">Please write a comment</span>
                                            </div>
                                        </div>
                                        <div class="control-group offset1 form-button-offset">
                                            <input style="margin-left: 0;" type="submit" class="btn" value="Post Comment" />
                                        </div>
                                    </form>
                                </div>
                                </div> -->
                               
                            </div>
                        </div>
                    </div>
                </div>
                <hr>
