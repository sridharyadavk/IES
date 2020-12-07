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


	<div class="container" align="center" class="card-body">
	
		<font color="red">${failMsg}</font>
		<form:form action="search" method="GET" modelAttribute="application">
       <form:input type="text" path="applicationId"  name="text" class="form-control" placeholder="Search Here"/>
       <input type="submit"  name="submit" class="btn" value="Search">
        </form:form>
       
       </div> 
<div class="container">
<form:form action="createCase" method="POST" modelAttribute="application">
<form:hidden path="applicationId"/>
<font color="green" align="center"><p align="center">${succMsg}</a></font>
<h1>Select Plan</h1>
<table>

<tr >
<td>First Name :</td>
<td><form:input path="firstName" class="form-control" readonly="true"/></td>
</tr>
<tr>
<td>Last Name :</td>
<td><form:input path="lastName" class="form-control" readonly="true"/></td>
</tr>
<tr>
<td>Gender :</td>
<td><form:input path="gender" class="form-control" readonly="true"/></td>
</tr>
<tr>
<td>DOB :</td>
<td><form:input path="dob" class="form-control" readonly="true"/></td>
</tr>
<tr>
<td>SSN :</td>
<td><form:input path="ssn" class="form-control" readonly="true"/></td>
</tr>
<tr>
<td>Mobile :</td>
<td><form:input path="mobile" class="form-control" readonly="true"/></td>
</tr>
<tr>
<td>Email :</td>
<td><form:input path="email" class="form-control" readonly="true"/></td>
</tr>
<%-- <tr>
<td>Role: </td>
<td>
<form:select path="planList" id="acctype" class="selectbox">
<form:option value="">-select-</form:option>
<form:option value="">${plans.planList}</form:option>

</form:select>
</td>
</tr> --%>
<tr>
<td></td>
<td><input type="submit" value="CreateCase" class="btn"></td>
</tr>
</table>
</form:form>
</div>
</body>
</html>