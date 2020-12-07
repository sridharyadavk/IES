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

<form:form action="planSelection" method="POST" modelAttribute="caseDtls">
<font color="green" align="center"><p align="center">${succMsg}</a></font>
<h1>Create Plan</h1>
<table>
<tr>
<td>Case Number</td>
<td><form:input path="caseNo" class="form-control"/></td>
</tr>
<tr>
<td>First Name</td>
<td><form:input path="firstName" class="form-control"/></td>
</tr>
<tr>
<td>Last Name</td>
<td><form:input path="lastName" class="form-control"/></td>
</tr>
<tr>
<td>Plan: </td>
<td>
<form:select path="planName" id="acctype" class="selectbox">
<form:option value="">-select-</form:option>
<form:options items="${plans}"/>


</form:select>
</td>
</tr>
<tr>
<td></td>
<td><input type="submit" value="Next" class="btn"></td>
</tr>
</table>
</form:form>
</div>
</body>
</html>