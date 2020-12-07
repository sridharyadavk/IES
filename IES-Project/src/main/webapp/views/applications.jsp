<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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
<div class="jumbotron">
<div class="card">
<div class="card-header">
IES
</div>
	<div align="center" class="card-body">
		<u><h2>View Applications</h2></u>

<table class="table table-dark table-hover table-bordered">

<tr>
	<th scope="col">Application Id</th>
	<th scope="col">First Name</th>
	<th scope="col">Last Name</th>
	<th scope="col">DOB</th>
	<th scope="col">Gender</th>
	<th scope="col">SSN</th>
	<th scope="col">Mobile</th>
	<th scope="col">Action</th>
</tr>

<c:forEach var="application" items="${appList}">

<tbody>
<tr>
<td>${application.applicationId}</td>
<td>${application.firstName}</td>
<td>${application.lastName}</td>
<td>${application.dob}</td>
<td>${application.gender}</td>
<td>${application.ssn}</td>
<td>${application.mobile}</td>
<c:choose>
					<c:when test="${application.status =='Active'}">
					<td><a  href="/editApplication?applicationId=${application.applicationId}"><button class="btn btn-primary">Edit</button></a> &nbsp;&nbsp; <a
						href="/deactivateApplication?applicationId=${application.applicationId}"
						onclick="return deactivateConfirm()"><button class="btn btn-danger">DeActivate</button></a></td></c:when>
						<c:otherwise>
						
						<td><a href="/editApplication?applicationId=${application.applicationId}"><button class="btn btn-primary">Edit</button></a>&nbsp;&nbsp;<a
						href="/activateApplication?applicationId=${application.applicationId}"
						onclick="return activeConfirm()"><button class="btn btn-success">Activate</button></a></td>
						
						</c:otherwise>
						</c:choose>
</tr>
</tbody>
</c:forEach>
</table>

</body>
</html>