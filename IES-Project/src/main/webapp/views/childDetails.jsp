<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script>
	function deactivateConfirm() {
		return confirm("Are You Sure, You Want to Deactivate Account ?");

	}
	function activeConfirm() {
		return confirm("Are You Sure, You Want to Activate Account ?");

	}
</script>
</head>
<body>
<div class="container">

<form:form action="childDtls" method="POST" modelAttribute="cCap">
<font color="green" align="center"><p align="center">${succMsg}</a></font>
<h1>Child Details</h1>
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
<td>Child Name</td>
<td><form:input path="childName" class="form-control"/></td>
</tr>
<tr>
<td>Gender: </td>
<td>
<form:radiobutton path="childGender" value="M" class="radio"/>Male
<form:radiobutton path="childGender" value="F" class="radio"/>Fe-Male
</td>
</tr>
<tr>
<td>DOB: </td>
<td><form:input path="dob" class="form-control" id="datepicker"/></td>
</tr>
<tr>
<td>SSN: </td>
<td><form:input path="childSsn" class="form-control"/></td>
</tr>
<tr>
<td></td>
<td><input type="submit" value="Add" class="btn"></td>
</tr>
</table>
</form:form>
</div>
<
	<div align="center" class="card-body">
		<u><h2>View Plans</h2></u>

<table class="table table-dark table-hover table-bordered">

<tr>
	<th scope="col">S.NO</th>
	<th scope="col">Plan Name</th>
	<th scope="col">Plan Description</th>
	<th scope="col">Plan Start Date</th>
	<th scope="col">Plan End Date</th>
	<th scope="col">Action</th>
</tr>



<tbody>
<tr>
<td>${child.childId}</td>
<td>${child.childName}</td>
<td>${child.childGender}</td>
<td>${child.dob}</td>
<td>${child.childSsn}</td>
<td>${child.childStatus}</td>
<c:choose>
					<c:when test="${child.childStatus =='Activate'}">
					<td><a  href="/editChild?childId=${child.childId}"><button class="btn btn-primary">Edit</button></a> &nbsp;&nbsp; <a
						href="/deactivateChild?childId=${child.childId}"
						onclick="return deactivateConfirm()"><button class="btn btn-danger">DeActivate</button></a></td></c:when>
						<c:otherwise>
						
						<td><a href="/editChild?childId=${child.childId}"><button class="btn btn-primary">Edit</button></a>&nbsp;&nbsp;<a
						href="/deactivePlan?pid=${child.childId}"
						onclick="return activeConfirm()"><button class="btn btn-success">Activate</button></a></td>
						
						</c:otherwise>
						</c:choose>
</tr>
</tbody>

</table>
</body>
</html>