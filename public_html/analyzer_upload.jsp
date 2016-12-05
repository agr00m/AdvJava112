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

<c:import url="/jsp/head-tag.jsp" />

<body>
<div id="wrapper">

	<div id="wrapper-bgbtm">
		
        <c:import url="/jsp/header-div.jsp" />
		<!-- end #header -->
		
		<c:import url="/jsp/menu-div.jsp" />
		<!-- end #menu -->
		
		<div id="page">
		
            <!-- begin #content -->
            <div id="content">
                
                <h2>Filelyzer - Upload File to Analyze</h2><br>
                <fieldset>
                    <legend>Upload File</legend>
                    <form method="POST" action="upload" enctype="multipart/form-data">
                        File:
                        <input type="file" name="file" id="file" /> <br><br>
                        <input type="submit" value="Upload" name="upload" id="upload" />
                    </form>
                </fieldset><br>
                
                <h3>${message}</h3>
                <p>Select a report on the right to view results.</p>
                <% session.setAttribute("message",""); %>
                
            </div>
            <!-- end #content -->
            
            <c:import url="/jsp/sidebar-div.jsp" />
            <!-- end #sidebar -->
            
            <div style="clear: both;">&nbsp;</div>
		</div>
		<!-- end #page -->
		
		<c:import url="/jsp/footer-div.jsp" />
		<!-- end #footer -->
		
	</div>
</div>
</body>
</html>
