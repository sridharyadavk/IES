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
		$("#ssnId").blur(function() {
			$("#errMsg").text("");
			$.ajax({
				type : "GET",
				url : "validateSsn?ssn="+$("#ssnId").val(),
				success : function(data) {
					if(data=="INVALID"){
						$("#errMsg").text("Invalid SSN");
						$("#submitBtn").prop("disabled", true);
					}else{
						$("#submitBtn").prop("disabled", false);
					}
				}
			});

		});

	});
		
		$(function() {
	  $("#datepicker").datepicker({
	  changeMonth:true,
	  changeYear:true,
	  yearRange : "1960:"+ new Date(),
	  maxDate : new Date(),
	  dateFormat : 'dd/mm/yy'
	  });
	});
	
</script>
</head>
<body>

<div class="container">
<form:form action="appRegistration" method="POST" modelAttribute="appReg">
<form:hidden path="applicationId"/>
<h5 class="successMsg">${apId}</h5>
<h5 class="successMsg">${updateMsg}</h5>
<h1>Application Registration</h1>
<table>
<tr>
<td>First Name: </td>
<td><form:input path="firstName" class="form-control"/></td>
</tr>

<tr>
<td>Last Name: </td>
<td><form:input path="lastName" class="form-control"/></td>
</tr>

<tr>
<td>DOB: </td>
<td><form:input path="dob" class="form-control" id="datepicker"/></td>
</tr>

<tr>
<td>Gender: </td>
<td>
<form:radiobutton path="gender" value="M" class="radio"/>Male
<form:radiobutton path="gender" value="F" class="radio"/>Fe-Male
</td>
</tr>

<tr>
<td>SSN: </td>
<td>
<form:input path="ssn" class="form-control" maxlength="9" id="ssnId"/>
<span id="errMsg" style="color: red;"></span>
</td>
</tr>

<tr>
<td>Phone Number: </td>
<td><form:input path="mobile" class="form-control"/></td>
</tr>

<tr>
<td>Email: </td>
<td><form:input path="email" id="userEmail" class="form-control"/>

</td>
</tr>

<tr>
<td></td>
<td><input type="submit" value="Create" id="submitBtn" class="btn"></td>
</tr>
</table>
</form:form>
</div>
</body>
</html>