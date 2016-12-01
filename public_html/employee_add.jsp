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
                
                <h2>Add Employee</h2>  <br>  
                <div class="container">
                    <form method="POST" action="add-employee">
                        <fieldset>
                          <legend>New Employee Information</legend>
                          First Name: 
                          <input type="text" name="first_name"> <br>
                          Last Name:
                          <input type="text" name="last_name"> <br>
                          SSN: 
                          <input type="text" name="ssn"> <br>
                          Department:
                          <input type="text" name="dept"> <br>
                          Room #: 
                          <input type="text" name="room"> <br>
                          Phone #: 
                          <input type="text" name="phone"> <br>
                          <br>
                          <input type="submit" value="Submit">
                        </fieldset>
                    </form>
                </div>
                <br>
                <h3>${message}</h3>
                <%
                    session.removeAttribute("message");
                %>
                
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
