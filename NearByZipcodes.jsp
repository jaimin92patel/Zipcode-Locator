<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.*" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>



<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search Nearby Zipcodes</title>
</head>
<body>

<div class="container">
	<div class="row">
		<div class="col-sm-12">
		<form action="ImportZipcode" class="form-horizontal" role="form" action="" method="get">
		  <div class="form-group">
		    <label for="lat" class="col-sm-2 control-label">Latitude</label>
		    <div class="col-sm-10">
		      <input type="text" class="form-control" id="lat" name="lat" placeholder="Enter a Latitude">
		    </div>
		  </div>
		  <div class="form-group">
		    <label for="lon" class="col-sm-2 control-label">Longitude</label>
		    <div class="col-sm-10">
		      <input type="text" class="form-control" id="lon" name="lon" placeholder="Enter a Longitude">
		    </div>
		  </div>
		  
		  <div class="form-group">
		    <label for="radius" class="col-sm-2 control-label">Search Radius (in miles)</label>
		    <div class="col-sm-10">
		      <input type="text" class="form-control" id="radius" name="radius" placeholder="Enter a Search Radius in Miles">
		    </div>
		  </div>
		  
		  <div class="form-group">
		    <div class="col-sm-offset-2 col-sm-10">
		      <button type="submit" class="btn btn-primary">Find Nearby Zipcodes</button>
		    </div>
		  </div>
		</form>
		</div>
	</div>
	
	<div class="row">
		<div class="col-sm-12"></div>
			<h2>Search Results <small>Found nearby zipcodes</small></h2>
			<hr/>
		<%-- 	<%HttpSession ssn=request.getSession(false); 
		      ssn.getAttribute("ImportSession");
		    Integer counter = (Integer)session.getAttribute("ImportSession");
			%> --%>
			<table class="table table-striped table-hover table-bordered">
				<tr>
					<th>Zipcode</th>
					<th>City</th>
					<th>Distance</th>
				</tr>
				
				
				<%--  <c:forEach items="${counter} var="current">
       			 <tr>
          			
         			 <td><c:out value="${current.Latitude}" /><td>
         			 <td><c:out value="${current.Longitude}" /><td>
         			 <td><c:out value="${current.CITY}" /><td>
         			 <td><c:out value="${current.State}" /><td>
       			 </tr>
     			 </c:forEach> --%>  	
     			 
		    	<!-- System.out.println(entries.Latitude); -->
				
			<!-- 	for( zipCodeAdd entry : entries )
        		{
				System.out.println( "<tr><td>" + entry.getZip() + "</td><td>"
                + entry.getLatitude() + "</td><td>" + entry.getLongitude()
                + "</td><td>"+entry.getCity()+"</td><td>"+entry.getState()+"</td></tr>" );
       			 }
		 -->
		 
			
			</table>
		</div>
</div>



</body>
</html>