<%@page contentType="text/html;charset=utf-8" pageEncoding="utf-8" isErrorPage="true"%>
<%@page import="okcode.biz.trading.util.GlobalConstants" %>
<%@include file="includes.jsp" %>
<!DOCTYPE html> 
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>出错了！</title>
	<link href="${ctx}/static/console/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
	<link href="${ctx}/static/console/css/font-awesome.min.css" rel="stylesheet">
    <link href="${ctx}/static/console/css/base-admin-2.css" rel="stylesheet">
    <link href="${ctx}/static/console/css/custom.css" rel="stylesheet">

</head>

<body>
	
<div class="container">
	
	<div class="row">
		
		<div class="span12">
			
			<div class="error-container">
				<h1><i class="icon-remove-sign"></i> 出错了！</h1>
				
				<h2>对不起，<%= exception.getMessage()  %></h2>
				
				<div class="error-details"><br/>
				</div>
				
				<div class="error-actions">
					<a href="${ctx}/" class="btn btn-large btn-primary">
						<i class="icon-chevron-left"></i>
						&nbsp;
						返回首页
					</a>
					
					<a href="mailto:<%-- <%=GlobalConstants.HELP_EMAIL %> --%>" class="btn btn-large">
						<i class="icon-envelope"></i>
						&nbsp;
						联系我们
					</a>
					
				</div> <!-- /error-actions -->
							
			</div> <!-- /error-container -->			
			
		</div> <!-- /span12 -->
		
	</div> <!-- /row -->
	
</div> <!-- /container -->

</body>
</html>
