<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
    <%@ page isErrorPage="true" %>   
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<meta charset="utf-8">
<title>New Ninja</title>
</head>
<body>
	<div class="container-fluid"  style="margin:20px;">
		<a href="/home">Go Back</a>
		<h1> New Ninja </h1>
		<form:form action="/ninjas/new/" method="post" modelAttribute="ninja" style="width:15%;">
			<p class="form-group">
				<form:label path="dojo">Dojo: </form:label>
				<form:select path="dojo" required="required" class="form-control">
					<form:options items="${dojos}" itemValue="id" itemLabel="name"/>
				</form:select>
				<form:errors path="dojo"/>
			</p>
			<p class="form-group">
				<form:label path="firstName">First Name: </form:label>
				<form:input class="form-control" path="firstName" required="required"/>
				<form:errors path="firstName"/>
			</p>
			<p class="form-group">
				<form:label path="lastName">Last Name: </form:label>
				<form:input class="form-control" path="lastName" required="required"/>
				<form:errors path="lastName"/>
			</p>
			<p class="form-group">
				<form:label path="age">Age: </form:label>
				<form:input class="form-control" path="age" type="number" min="1" step="1" value="1" required="required"/>
				<form:errors path="age"/>
			</p>
			<input type="submit" value="Create" class="form-control btn btn-outline-primary"/>
		</form:form>		
	</div>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html>