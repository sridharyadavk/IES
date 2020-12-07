<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="css/account.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/themes/smoothness/jquery-ui.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/jquery-ui.min.js"></script>
<script>


$(document).ready(function() { 
	  
    $(function() { 
        $("#my_date_picker1").datepicker({}); 
    }); 

    $(function() { 
        $("#my_date_picker2").datepicker({}); 
    }); 

    $('#my_date_picker1').change(function() { 
        startDate = $(this).datepicker('getDate'); 
        $("#my_date_picker2").datepicker("option", "minDate", startDate); 
    }) 

    $('#my_date_picker2').change(function() { 
        endDate = $(this).datepicker('getDate'); 
        $("#my_date_picker1").datepicker("option", "maxDate", endDate); 
    }) 
}) 
	

</script>
</head>
<body>
<div class="container">

<form:form action="createPlan" method="POST" modelAttribute="plan">
<form:hidden path="pid"/>
<font color="green" align="center"><p align="center">${succMsg}</a></font>
<h1>Create Plan</h1>
<table>
<tr>
<td>Plan Name</td>
<td><form:input path="planName" class="form-control"/></td>
</tr>
<tr>
<td>Plan Description</td>
<td><form:input path="planDesc" class="form-control"/></td>
</tr>
<tr>
<td>Start Date</td>
<td><form:input path="startDate" class="form-control" id="my_date_picker1"/></td>
</tr>
<tr>
<td>End Date</td>
<td><form:input path="endDate" class="form-control" id="my_date_picker2"/></td>
</tr>
<tr>
<td></td>
<td><input type="submit" value="Create" class="btn"></td>
</tr>
</table>
</form:form>
</div>
</body>
</html>