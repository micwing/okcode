<%@page contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>

<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>   
<div id="sidebar">
	<a href="#" class="visible-phone"><i class="icon icon-home"></i> 控制面板</a>
	<ul>
		<li class="${fn:startsWith(requestServletPath, '/console/home/')?'active':''}"><a href="${ctx}/console/home"><i class="icon icon-home"></i> <span>首页</span></a></li>
		<li class="submenu ${fn:startsWith(requestServletPath, '/console/baseConfig/')
							||fn:startsWith(requestServletPath, '/console/imageConfig/')
							||fn:startsWith(requestServletPath, '/console/safetyConfig/')
							||fn:startsWith(requestServletPath, '/console/dataBackup/')
							||fn:startsWith(requestServletPath, '/console/fileManage/')?'active open':''}">
			<a href="#"><i class="icon icon-cog"></i> <span>系统设置</span> <span class="label"><i class="icon icon-chevron-down"></i></span></a>
			<ul>
				<li class="${fn:startsWith(requestServletPath, '/console/baseConfig/')?'active':''}"><a href="${ctx}/console/baseConfig">基本设置</a></li>
				<li class="${fn:startsWith(requestServletPath, '/console/imageConfig/')?'active':''}"><a href="${ctx}/console/imageConfig">图片设置</a></li>
				<li class="${fn:startsWith(requestServletPath, '/console/safetyConfig/')?'active':''}"><a href="${ctx}/console/safetyConfig">网站安全</a></li>
				<%-- <li class="${fn:startsWith(requestServletPath, '/console/dataBackup/')?'active':''}"><a href="${ctx}/console/dataBackup">数据备份</a></li> --%>
				<li class="${fn:startsWith(requestServletPath, '/console/fileManage/')?'active':''}"><a href="${ctx}/console/fileManage">文件管理</a></li>
			</ul>
		</li>
		<li class="submenu ${fn:startsWith(requestServletPath, '/console/frontHomeConfig/')
							||fn:startsWith(requestServletPath, '/console/bottomInfo/')
							||fn:startsWith(requestServletPath, '/console/listPageStyle/')
							||fn:startsWith(requestServletPath, '/console/articleStyle/')
							||fn:startsWith(requestServletPath, '/console/onlineConfig/')?'active open':''}">
			<a href="#"><i class="icon icon-tint"></i> <span>界面风格</span> <span class="label"><i class="icon icon-chevron-down"></i></span></a>
			<ul>
				<li class="${fn:startsWith(requestServletPath, '/console/frontHomeConfig/')?'active':''}"><a href="${ctx}/console/frontHomeConfig">前台首页设置</a></li>
				<li class="${fn:startsWith(requestServletPath, '/console/bottomInfo/')?'active':''}"><a href="${ctx}/console/bottomInfo">底部信息</a></li>
				<li class="${fn:startsWith(requestServletPath, '/console/listPageStyle/')?'active':''}"><a href="${ctx}/console/listPageStyle">列表页设置</a></li>
				<li class="${fn:startsWith(requestServletPath, '/console/articleStyle/')?'active':''}"><a href="${ctx}/console/articleStyle">内容页设置</a></li>
				<%-- <li class="${fn:startsWith(requestServletPath, '/console/onlineConfig/')?'active':''}"><a href="${ctx}/console/onlineConfig">在线交流设置</a></li> --%>
			</ul>
		</li>
		<li class="submenu ${fn:startsWith(requestServletPath, '/console/columnConfig/')
							||fn:startsWith(requestServletPath, '/console/productFieldConfig/')
							||fn:startsWith(requestServletPath, '/console/downloadFieldConfig/')
							||fn:startsWith(requestServletPath, '/console/imageFieldConfig/')?'active open':''}">
			<a href="#"><i class="icon icon-th-list"></i> <span>栏目规划</span> <span class="label"><i class="icon icon-chevron-down"></i></span></a>
			<ul>
				<li class="${fn:startsWith(requestServletPath, '/console/columnConfig/')?'active':''}"><a href="${ctx}/console/columnConfig">栏目设置</a></li>
				<%-- <li class="${fn:startsWith(requestServletPath, '/console/productFieldConfig/')?'active':''}"><a href="${ctx}/console/productFieldConfig">产品模块字段</a></li>
				<li class="${fn:startsWith(requestServletPath, '/console/downloadFieldConfig/')?'active':''}"><a href="${ctx}/console/downloadFieldConfig">下载模块字段</a></li>
				<li class="${fn:startsWith(requestServletPath, '/console/imageFieldConfig/')?'active':''}"><a href="${ctx}/console/imageFieldConfig">图片模块字段</a></li> --%>
			</ul>
		</li>
		<li class="submenu ${fn:startsWith(requestServletPath, '/console/contentManage/')
							||fn:startsWith(requestServletPath, '/console/sideContent/')
							||fn:startsWith(requestServletPath, '/console/bannerContent/')?'active open':''}">
			<a href="#"><i class="icon icon-list-alt"></i> <span>内容管理</span> <span class="label"><i class="icon icon-chevron-down"></i></span></a>
			<ul>
				<li class="${fn:startsWith(requestServletPath, '/console/contentManage/')?'active':''}"><a href="${ctx}/console/contentManage">模块内容管理</a></li>
				<li class="${fn:startsWith(requestServletPath, '/console/sideContent/')?'active':''}"><a href="${ctx}/console/sideContent">侧边栏管理</a></li>
				<li class="${fn:startsWith(requestServletPath, '/console/bannerContent/')?'active':''}"><a href="${ctx}/console/bannerContent">Banner管理</a></li>
			</ul>
		</li>
		<li class="submenu ${fn:startsWith(requestServletPath, '/console/cacheConfig/')
							||fn:startsWith(requestServletPath, '/console/seoConfig/')
							||fn:startsWith(requestServletPath, '/console/exlinkConfig/')?'active open':''}">
			<a href="#"><i class="icon icon-screenshot"></i> <span>优化推广</span> <span class="label"><i class="icon icon-chevron-down"></i></span></a>
			<ul>
				<%-- <li class="${fn:startsWith(requestServletPath, '/console/cacheConfig/')?'active':''}"><a href="${ctx}/console/cacheConfig">网站缓存</a></li>
				<li class="${fn:startsWith(requestServletPath, '/console/seoConfig/')?'active':''}"><a href="${ctx}/console/seoConfig">SEO优化</a></li> --%>
				<li class="${fn:startsWith(requestServletPath, '/console/exlinkConfig/')?'active':''}"><a href="${ctx}/console/exlinkConfig">友情链接</a></li>
			</ul>
		</li>
		<li class="submenu ${fn:startsWith(requestServletPath, '/console/personalInfo/')?'active open':''}">
			<a href="#"><i class="icon icon-user"></i> <span>用户管理</span> <span class="label"><i class="icon icon-chevron-down"></i></span></a>
			<ul>
				<li class="${fn:startsWith(requestServletPath, '/console/personalInfo/')?'active':''}"><a href="${ctx}/console/personalInfo">个人资料</a></li>
			</ul>
		</li>
	</ul>
</div>