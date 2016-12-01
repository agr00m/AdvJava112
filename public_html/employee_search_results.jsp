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
                
                <h2>Search Results</h2>
                <table rules="cols">
                    <col width="50">
                    <col width="140">
                    <col width="140">
                    <col width="110">
                    <col width="50">
                    <col width="70">
                    <col width="100">
                    <tr>   
                        <th>ID</th>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>SSN</th>
                        <th>Dept</th>
                        <th>Room #</th>
                        <th>Phone #</th>
                    </tr>
                    <c:forEach var="employee" items="${searchResults.getSearchResults()}">
                        <tr>
                            <td>${employee.getEmployeeID()}</td>
                            <td>${employee.getFirstName()}</td>
                            <td>${employee.getLastName()}</td>
                            <td>${employee.getSSN()}</td>
                            <td>${employee.getDepartment()}</td>
                            <td>${employee.getRoomNumber()}</td>
                            <td>${employee.getPhoneNumber()}</td>
                        </tr>
                    </c:forEach>
                </table>
                
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
