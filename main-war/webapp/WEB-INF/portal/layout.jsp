<%@page contentType="text/html;charset=utf-8" pageEncoding="utf-8" %>
<%@include file="../common/includes.jsp" %>
<!DOCTYPE html>
<html>
  <head>
  	<meta http-equiv="content-language" content="zh-cn" >
  	<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
  	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
      
      <!--  SEO STUFF START HERE -->
  	<link rel="shortcut icon" href="${ctx}/asset/portal/img/favicon.ico">
    <title>${baseConfig.systemName} - ${baseConfig.siteKeyword}</title>
    <meta name="keywords" content="${baseConfig.siteKeyword}" />
    <meta name="description" content="${baseConfig.siteDescription}" />
    <meta name="author" content="一刻建站|onekr.com" />
    <meta name="robots" content="follow, index" />
    <!--  SEO STUFF END -->
      
	<link href="${ctx}/asset/portal/${ctx}/asset/portal/img/favicon.ico" rel="shortcut icon">

    <link rel="stylesheet" type="text/css" href="${ctx}/asset/portal/rs-plugin/css/settings.css" media="screen" />
    <link rel="stylesheet" type="text/css" href="${ctx}/asset/portal/css/rs-responsive.css" media="screen" />
    
    <link rel="stylesheet" href="${ctx}/asset/portal/css/bootstrap.css" />
    <link rel="stylesheet" href="${ctx}/asset/portal/css/custom.css" />
    <link rel="stylesheet" href="${ctx}/asset/portal/css/isotope.css" />
    <link rel="stylesheet" href="${ctx}/asset/portal/css/color_scheme.css" />
    <link rel="stylesheet" href="${ctx}/asset/portal/css/font-awesome.css" />
    <link rel="stylesheet" href="${ctx}/asset/portal/css/font-awesome-ie7.css" />
    <link rel="stylesheet" href="${ctx}/asset/portal/js/flexslider/flexslider.css" />
    <link rel="stylesheet" href="${ctx}/asset/portal/css/jquery.fancybox.css" type="text/css" media="screen" />
    <!--[if lte IE 8]>
        <link rel="stylesheet" type="text/css" href="${ctx}/asset/portal/css/IE-fix.css" />
    <![endif]-->
</head>
<body>
	<div id="out_container">
        <div class="top_line"></div>

		<tiles:insertAttribute name="header" />

        <div class="main-content">
            <div class="container">
                <tiles:insertAttribute name="content" />
            </div>
        </div>

		<tiles:insertAttribute name="footer" />
	
	</div>

    <script type="text/javascript" src="${ctx}/asset/portal/js/jquery.min.js"></script>
     
    <script type="text/javascript" src="${ctx}/asset/portal/js/jquery-ui.min.js"></script>
    <script type="text/javascript" src="${ctx}/asset/portal/js/bootstrap.js"></script>
    <script type="text/javascript" src="${ctx}/asset/portal/js/flexslider/jquery.flexslider.js"></script>
    <script type="text/javascript" src="${ctx}/asset/portal/js/jquery.isotope.js"></script>
    <script type="text/javascript" src="${ctx}/asset/portal/js/jquery.fancybox.pack.js"></script>
    <script type="text/javascript" src="${ctx}/asset/portal/rs-plugin/js/jquery.themepunch.plugins.min.js"></script>
    <script type="text/javascript" src="${ctx}/asset/portal/rs-plugin/js/jquery.themepunch.revolution.min.js"></script>
    <script type="text/javascript" src="${ctx}/asset/portal/js/revolution.custom.js"></script>
    <script type="text/javascript" src="${ctx}/asset/portal/js/custom.js"></script>
</body>
</html>