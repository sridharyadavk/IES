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

</head>
<body>

<div class="container">
<form:form action="incomeDtls" method="POST" modelAttribute="snap">

<h5 class="successMsg">${successMsg}</h5>
<h5 class="failMsg">${failureMsg}</h5>
<h1>InCome Details</h1>
<table>
<tr>
<td>Case Number: </td>
<td><form:input path="caseNo" class="form-control" readonly="true"/></td>
</tr>

<tr>
<td>First Name: </td>
<td><form:input path="firstName" class="form-control" readonly="true"/></td>
</tr>

<tr>
<td>Last Name </td>
<td><form:input path="lastName" class="form-control" readonly="true"/>
</td>
</tr>
<tr>
<td>Is Working Employee: </td>
<td>
<form:radiobutton path="empStatus" value="Yes" class="radio"/>Yes
<form:radiobutton path="empStatus" value="No" class="radio"/>No
</td>
</tr>
<tr>
<td>Income: </td>
<td><form:input path="income" class="form-control"/></td>
</tr>
<tr>
<td></td>
<td><input type="submit" value="Submit" id="submitBtn" class="btn"></td>
</tr>
</table>
</form:form>
</div>
</body>
</html>