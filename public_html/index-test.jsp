<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<!--
Design by Free CSS Templates
http://www.freecsstemplates.org
Released for free under a Creative Commons Attribution 2.5 License

Name       : Wood Working   
Description: A two-column, fixed-width design with dark color scheme.
Version    : 1.0
Released   : 20110708
-->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="jsp/head-tag.jsp" />

<body>
<div id="wrapper">
	<div id="wrapper-bgbtm">
        <c:import url="jsp/header-div.jsp" />
		<c:import url="jsp/menu-div.jsp" />
		
		<div id="page">
		
            <!-- begin #content -->
            <div id="content">
                <c:import url="jsp/post1.jsp" />
            </div>
            <!-- end #content -->
            
            <!-- #sidebar -->
            <c:import url="jsp/sidebar-div.jsp" />  
            
            <div style="clear: both;">&nbsp;</div>
        </div>
		<!-- end #page -->
		
		<!-- #footer -->
		<c:import url="jsp/footer-div.jsp" />    		
	</div>
</div>
</body>
</html>
