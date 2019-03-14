<%@page import="filtres.Filtre"%>
<%@page import="classes_metier.Client"%>
<%@page import="filtres.ContaineurFiltre"%>
<%@page import="filtres.CollectionFiltres"%>
<%@page import="beans_fonctionnalite.CatalogueBrowser"%>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 <%
 		CatalogueBrowser cb =  (CatalogueBrowser) request.getSession().getAttribute ("monCatalogue");
 
     	Client clientBean =  cb.getClient();
     	
     %>   <!--   // mon objet clientBean répuère le client envoyé depuis le controleur-->
    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Félicitations</title>
	</head>
	<body>
	
		<h1> Connection réussie! Bienvenue <%=clientBean.getName() %> !</h1>
	<% System.out.println("entrée dans login-succès");%>
	
		<form method="post" action="FrontControleur?cmd=SelectionCommande" >
				<% 
				CollectionFiltres coll = cb.getcollection(); %>   
				<%for (ContaineurFiltre cf: coll.getCf()){%>
				<aside> 
				<h3> <%=cf.getNom() %> </h3>
						<% for(Filtre filtre : cf.getListeFiltre()) {
						%><input type="checkbox" name="selection" value="<%=filtre.getId()%>" label="<%=filtre.getIntitule()%>"  <%=filtre.getChecked()%>> <%=filtre.getIntitule()%>
						</br>
						<% };%> 
				</aside>
				<% }; %>
				<input type="submit" value="Filtrer">
		</form>	
		<main>
			<div> <%@ include file="/WEB-INF/panier.jsp" %>	</div> 
			<div> <%@ include file="/WEB-INF/catalogue.jsp" %>	</div>
		</main>
	</body>
</html>
