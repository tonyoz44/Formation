<%@page import="fr.pizzeria.model.Pizza"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html ">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>listePizzas</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
	integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7"
	crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css"
	integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r"
	crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"
	integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS"
	crossorigin="anonymous"></script>
<meta charset="utf-8">

<link rel="icon" href="../../favicon.ico">


</head>
<body>
<div class="panel panel-default">
  <!-- Default panel contents -->
  <div class="panel-heading">Liste Pizzas</div>
  <div class="panel-body">
    <p>...</p>
  </div>

	<table class="table table-striped">
		<%
			List<Pizza> listPizzas = (List<Pizza>) request.getAttribute("ListePizzas");
			for (Pizza pizza : listPizzas) {
		%>
		<tr>
			<td><%=pizza.getCode()%>
			<td><%=pizza.getCategorie()%>
			<td><%=pizza.getId()%>
			<td><%=pizza.getNom()%>
			<td><%=pizza.getPrix()%>
			<a  class="btn btn-primary" formaction=<%=request.getContextPath()%>"/pizzas/edit?code='<%=pizza.getCode() %>'">Default</button>
		</tr>
		<%
			}
		%>
</table>
</body>
</html>