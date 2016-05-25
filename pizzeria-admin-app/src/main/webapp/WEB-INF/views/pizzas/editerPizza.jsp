<%@page import="fr.pizzeria.model.CategoriePizza"%>
<%@page import="fr.pizzeria.model.Pizza"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@page isELIgnored="false"  %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
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
<%
Pizza pizza=(Pizza)request.getAttribute("pizza"); 
%>


<form class="form-inline" method="post">
  <div class="form-group">
    <label for="exampleInputName2">Name</label>
    <input name="nom" type="text" class="form-control" id="exampleInputName2" value="<%=pizza.getNom()%>">
  </div>
  <div class="form-group">
    <label for="exampleInputEmail2">Prix</label>
    <input name=prix type="text" class="form-control" id="exampleInputEmail2" value="<%=pizza.getPrix()%>">
   <div class="form-group">
        <label class="col-xs-3 control-label">Size</label>
        <div class="col-xs-5 selectContainer">
            <select class="form-control" name="categorie">
                <option value="${CategoriePizza.POISSON}">Poisson</option>
                <option value="${CategoriePizza.VIANDE}">Viande</option>
                <option value="${CategoriePizza.SANS_VIANDE}">Sans viande</option>
            </select>
        </div>
    </div>
  <input type="hidden" name="code" value="${pizza.code}" />
  <button  type="submit" class="btn btn-default">Enregistrer</button>
</form>

</body>
</html>