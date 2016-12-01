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
                
                <h2>Employee Search</h2>
                <form method="GET" action="search-results">
                    <fieldset>
                      <legend>Employee Search</legend>
                      Search criteria:<br>
                      <input type="text" name="searchTerm"> <br><br>
                      <input id="100" type="radio" name="searchType" value="emp_id" checked> 
                      <label for="100">Employee ID </label><br>
                      <input id="101" type="radio" name="searchType" value="last_name" > 
                      <label for="101"> Last Name </label><br>
                      <br>
                      <input type="submit" value="Search">
                    </fieldset>
                </form>
                
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
