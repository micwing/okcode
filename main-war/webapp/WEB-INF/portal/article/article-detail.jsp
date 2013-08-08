<%@page contentType="text/html;charset=utf-8" pageEncoding="utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
				<div class="row show-grid">
                    <div class="span12">
                        <div id="breadcrumb">
                        <ul>
                            <li class="home"><a href="${ctx}/">首页</a></li>
                            <li><a href="${ctx}/news">新闻资讯</a></li>
                            <li><a href="${ctx}/news/list/1">公司新闻</a></li>
                            <li>一刻企业建站系统研发开始，互联网迎来新格局</li>
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
                                <h1>${article.title}</h1>
                                <div>${article.content}</div>
                                <div class="post-item-panel">
                                    <ul>
                                        <li class="date">
                                          <p><i class="icon-calendar"></i><fmt:formatDate value="${article.updateAt}" pattern="yyyy-MM-dd" /></p></li>
                                          <c:if test="${!empty article.author}">
                                        	<li><p><i class="icon-user"></i>by ${article.author}</p></li>
                                          </c:if>
                                        <li><p><i class="icon-tags"></i><a href="default.htm">silicon valley</a>, <a href="default.htm">business</a></p></li>
                                        <li class="comments"><p><i class="icon-comments-alt"></i><span>2 comments</span></p></li>
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
