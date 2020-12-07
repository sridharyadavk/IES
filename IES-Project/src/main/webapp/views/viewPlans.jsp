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

<c:forEach var="plan" items="${plans}">

<tbody>
<tr>
<td>${plan.pid}</td>
<td>${plan.planName}</td>
<td>${plan.planDesc}</td>
<td>${plan.startDate}</td>
<td>${plan.endDate}</td>
<td>${plan.planStatus}</td>
<c:choose>
					<c:when test="${plan.planStatus =='Activate'}">
					<td><a  href="/editPlan?pid=${plan.pid}"><button class="btn btn-primary">Edit</button></a> &nbsp;&nbsp; <a
						href="/deactivatePlan?pid=${plan.pid}"
						onclick="return deactivateConfirm()"><button class="btn btn-danger">DeActivate</button></a></td></c:when>
						<c:otherwise>
						
						<td><a href="/editPlan?pid=${plan.pid}"><button class="btn btn-primary">Edit</button></a>&nbsp;&nbsp;<a
						href="/activePlan?pid=${plan.pid}"
						onclick="return activeConfirm()"><button class="btn btn-success">Activate</button></a></td>
						
						</c:otherwise>
						</c:choose>
</tr>
</tbody>
</c:forEach>
</table>

</body>
</html>