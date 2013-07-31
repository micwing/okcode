<%@page contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@include file="../common/includes.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<title>${_title == null ? '控制台' : _title}</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<meta http-equiv="content-language" content="zh-cn" >
	<link href="${ctx}/asset/console/img/favicon.ico" rel="shortcut icon">
	
	<link rel="stylesheet" href="${ctx}/asset/console/css/bootstrap.min.css" />
	<%-- 
	<link rel="stylesheet" href="http://lib.sinaapp.com/js/bootstrap/2.3.1/css/bootstrap.min.css" />
	--%>
	
	<link rel="stylesheet" href="${ctx}/asset/console/css/bootstrap-responsive.min.css" /> 
	<%-- 
	<link rel="stylesheet" href="http://lib.sinaapp.com/js/bootstrap/2.3.1/css/bootstrap-responsive.min.css" />
	--%>
	<link rel="stylesheet" href="${ctx}/asset/console/css/colorpicker.css" />
	<link rel="stylesheet" href="${ctx}/asset/console/css/fullcalendar.css" />	
	<link rel="stylesheet" href="${ctx}/asset/console/css/unicorn.main.css" />
	<link rel="stylesheet" href="${ctx}/asset/console/css/unicorn.grey.css" />
	
	<script type="text/javascript">
	var ctx = '${ctx}';
	</script>
	<script src="${ctx}/asset/console/js/jquery-1.9.1.min.js"></script> 
	<%-- 
	<script src="http://lib.sinaapp.com/js/jquery/1.9.1/jquery-1.9.1.min.js"></script>
	--%>
	<!-- <script type="text/javascript">
	if (window.jQuery) {
		document.write('<script type="text/javascript" src="${ctx}/asset/libs/jquery/jquery-1.9.1.min.js">\x3C/script>');
	} else {
		
	}
	</script> -->
</head>
<body>
	<div id="header">
		<h1><a href="dashboard.html"></a></h1>		
	</div>
	
	<div id="search">
		<input type="text" placeholder="搜索..."/><button type="submit" class="tip-right" title="Search"><i class="icon-search icon-white"></i></button>
	</div>
	
	<tiles:insertAttribute name="user-nav" />

	<tiles:insertAttribute name="sidebar" />
	
	<div id="content">
		<tiles:insertAttribute name="content-header" />
		
		<tiles:insertAttribute name="content" />
	</div>
	
	
	<script src="${ctx}/asset/console/js/jquery.ui.custom.js"></script> 
	<%-- 
	<script src="http://lib.sinaapp.com/js/jquery-ui/1.8.2/jquery-ui.min.js"></script>
	--%>
	
	<script src="${ctx}/asset/console/js/bootstrap.min.js"></script> 
	<%-- 
	<script src="http://lib.sinaapp.com/js/bootstrap/2.3.1/js/bootstrap.min.js"></script>
	--%>
	
	<script src="${ctx}/asset/console/js/excanvas.min.js"></script>
	<script src="${ctx}/asset/console/js/bootstrap-colorpicker.js"></script>
	<script src="${ctx}/asset/console/js/ieplaceholder.js"></script>
	<script src="${ctx}/asset/console/js/jquery.flot.min.js"></script>
	<script src="${ctx}/asset/console/js/jquery.flot.resize.min.js"></script>
	<script src="${ctx}/asset/console/js/jquery.peity.min.js"></script>
	<script src="${ctx}/asset/console/js/fullcalendar.min.js"></script>
	<script src="${ctx}/asset/console/js/My97DatePicker/WdatePicker.js" type="text/javascript"></script>
	
	<script src="${ctx}/asset/console/js/validate/jquery.validate.js" type="text/javascript"></script>
	<script src="${ctx}/asset/console/js/validate/more_rules.js" type="text/javascript"></script>
	<script src="${ctx}/asset/console/js/validate/message_cn.js" type="text/javascript"></script>
	
	<script src="${ctx}/asset/console/js/noty/jquery.noty.js" type="text/javascript"></script>
	<script src="${ctx}/asset/console/js/noty/bottom.js" type="text/javascript"></script>
	<script src="${ctx}/asset/console/js/noty/default.js" type="text/javascript"></script>
	
	<script src="${ctx}/asset/console/js/unicorn.js"></script>
	<script src="${ctx}/asset/console/js/unicorn.dashboard.js"></script>
</body>
</html>
