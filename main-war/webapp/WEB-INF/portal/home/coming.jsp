<%@page contentType="text/html;charset=utf-8" pageEncoding="utf-8" %>
<%@include file="../../common/includes.jsp" %>
<!DOCTYPE html>
<html>
  <head>
  	<meta http-equiv="content-language" content="zh-cn" >
  	<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
  	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
      
      <!--  SEO STUFF START HERE -->
  	<link rel="Shortcut Icon" href="${ctx}/asset/portal/img/favicon.ico" type="image/ico" >
    <title>网站建设中</title>
    <meta name="keywords" content="" />
    <meta name="description" content="" />
    <meta name="author" content="" />
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
    <link rel="stylesheet" href="${ctx}/asset/portal/css/flexslider.css" />
    <link rel="stylesheet" href="${ctx}/asset/portal/css/jquery.fancybox.css" type="text/css" media="screen" />
    <link rel="stylesheet" href="${ctx}/asset/portal/css/jquery.countdown.css">
    <!--[if lte IE 8]>
        <link rel="stylesheet" type="text/css" href="${ctx}/asset/portal/css/IE-fix.css" />
    <![endif]-->
</head>
<body>
		<div id="out_container">
        <!-- THE LINE AT THE VERY TOP OF THE PAGE -->
        <div class="top_cs_line"></div>
        <!-- HEADER AREA -->
        <header>
            <div class="container">
                <div class="row">
                    <!-- HEADER LOGO -->
                    <div class="span12 logo center-logo">
                        <a class="cs-logo" href="${ctx}/"> </a>
                    </div>
                </div>
            </div>
        </header>
        <!-- MAIN CONTENT AREA -->
        <div class="main-content">

            <!-- BEGIN ARTICLE CONTENT AREA -->

            <div class="coming-soon-content">
                <div class="coming-soon-topline"></div>
                <h1>网站建设中，请稍后访问...</h1>


                <div id="countdown"></div>
                <p id="note"></p>

            </div>

            <!-- END ARTICLE CONTENT AREA -->

        </div>
        <!-- FOOTER STARTS HERE -->
        <footer id="footer" class="coming-soon-footer">
            <div class="footer-wrapper footer-cs">
                <div class="container">
                    <div class="row show-grid">
                        <div class="span12">
                            <ul class="footer-socials">
                                <li><a class="fb" href="#"></a></li>
                                <li><a class="tw" href="#"></a></li>
                                <li><a class="in" href="#"></a></li>
                                <li><a class="wf" href="#"></a></li>
                                <li><a class="fl" href="#"></a></li>
                                <li><a class="b" href="#"></a></li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
            <div class="footer-bottom footer-bottom-cs">
                <div class="container">
                    <div class="row show-grid">
                        <div class="span12">
                            <p class="bottom-p">© <a href="../www.themeleaf.com/default.htm">ThemeLeaf</a> 2013. All rights reserved.</p>
                        </div>
                    </div>
                </div>
            </div>
        </footer>
		
		</div>
        	<!-- END FOOTER -->

    <script type="text/javascript" src="${ctx}/asset/portal/js/jquery.min.js"></script>
     
    <script type="text/javascript" src="${ctx}/asset/portal/js/jquery-ui.min.js"></script>
    <script type="text/javascript" src="${ctx}/asset/portal/js/bootstrap.js"></script>
    <script type="text/javascript" src="${ctx}/asset/portal/js/jquery.flexslider-min.js"></script>
    <script type="text/javascript" src="${ctx}/asset/portal/js/jquery.isotope.js"></script>
    <script type="text/javascript" src="${ctx}/asset/portal/js/jquery.fancybox.pack.js"></script>
    <script type="text/javascript" src="${ctx}/asset/portal/rs-plugin/js/jquery.themepunch.plugins.min.js"></script>
    <script type="text/javascript" src="${ctx}/asset/portal/rs-plugin/js/jquery.themepunch.revolution.min.js"></script>
    <script type="text/javascript" src="${ctx}/asset/portal/js/revolution.custom.js"></script>
    <script type="text/javascript" src="${ctx}/asset/portal/js/custom.js"></script>
    
    <script src="${ctx}/asset/portal/js/jquery.countdown.js"></script>
    <script type="text/javascript">
    jQuery(function(){

    	var note = jQuery('#note'),
    		ts = new Date(2014, 0, 19, 10,10,0);

    	jQuery('#countdown').countdown({
    		timestamp	: ts,
    		callback	: function(days, hours, minutes, seconds){

    			var message = "";

    			message += days + " 天" + ", ";
    			message += hours + " 小时" + ", ";
    			message += minutes + " 分" + ", ";
    			message += seconds + " 秒" + " <br />";

    			note.html(message);
    		}
    	});

    });
    </script>
</body>
</html>