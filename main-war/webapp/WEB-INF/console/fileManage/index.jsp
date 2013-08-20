<%@page contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div id="breadcrumb">
	<a href="${ctx}/console/home"><i class="icon-home"></i> 首页</a>
	<a href="#"><i class="icon-cog"></i> 系统设置</a>
	<a class="current" href="#">文件管理</a>
</div>
<div class="container-fluid">
	<div class="row-fluid">
		<div class="span12">
			<div class="widget-box">
				<div class="widget-title"><span class="icon"><i class="icon-signal"></i></span><h5>文件管理</h5><div class="buttons"><a href="${ctx}/console/runStatus" class="btn btn-mini"><i class="icon-refresh"></i> 刷新</a></div></div>
				<div class="widget-content">
					<div class="row-fluid">
						<div class="span12" id="fileManagerMain" role="region">

						</div>
					</div>
				</div>
			</div>					
		</div>
	</div>
</div>
<script type="text/javascript">
$(function() {
	var ckf = new CKFinder();
	ckf.basePath = '/asset/console/js/ckfinder/';
	ckf.appendTo($('#fileManagerMain').get(0));
});
</script>