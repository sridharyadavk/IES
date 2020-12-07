<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Accounts Page</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript">
	function deactivateConfirm() {
		return confirm("Are You Sure, You Want to Deactivate Account ?");

	}
	function activeConfirm() {
		return confirm("Are You Sure, You Want to Activate Account ?");

	}
	 //using Jquery
	$(document).ready(function()
	{
	    $('#userType').change(function(){		   
	       window.location.href = '/getAllAcc?role=' + $(this).val();
	    });
	}); 

	//using Javascript
	/*function ListTables()
	{
		var val=document.getElementById("userType").value;
		 window.location.href = '/accounts?role=' + val;
	}*/
</script>
</head>
<body>
<div class="container">
<div class="jumbotron">
<div class="card">
<div class="card-header">
Boot Strap Card
</div>
	<div align="center" class="card-body">
		<u><h2>VIEW ACCOUNTS</h2></u>
		<select id="userType" name="role">
		   <option >-Selest- </option>
			<option value="Admin"  >Admin</option>
			<option value="CaseWorker" >Caseworker</option>
		</select>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<a href="/accReg">   + Add New Account</a><br/>
		<font color="green">${succMsg}</font> <font color="red">${updateSucc}</font>
		<br><br/>
		<table class="table table-dark table-hover table-bordered">
			<tr>
				<th scope="col">S.No</th>
				<th scope="col">FirstName</th>
				<th scope="col">LastName</th>
				<th scope="col">Email</th>
				<th scope="col">Role</th>
				<th scope="col">Action</th>
			</tr>
			<c:forEach items="${accounts}" var="account">
				<tr>
					<td>${account.accountId}</td>
					<td>${account.firstName}</td>
					<td>${account.lastName}</td>
					<td>${account.email}</td>
					<td>${account.role}</td>
					<c:choose>
					<c:when test="${account.accStatus =='Active'}">
					<td><a  href="/editAccount?accountId=${account.accountId}"><button class="btn btn-primary">Edit</button></a> &nbsp;&nbsp; <a
						href="/deactivateAccount?accountId=${account.accountId}"
						onclick="return deactivateConfirm()"><button class="btn btn-danger">DeActivate</button></a></td></c:when>
						<c:otherwise>
						
						<td><a href="/editAccount?accountId=${account.accountId}"><button class="btn btn-primary">Edit</button></a>&nbsp;&nbsp;<a
						href="/activateAccount?accountId=${account.accountId}"
						onclick="return activeConfirm()"><button class="btn btn-success">Activate</button></a></td>
						
						</c:otherwise>
						</c:choose>
				</tr>

			</c:forEach>
		</table><br><br>
		<a href="home" >back to Home</a>

	
</div>
</div>
</div>
</div>
</body>
</html>