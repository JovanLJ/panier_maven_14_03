<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset='utf-8'>
		<title>Formulaire</title>
	</head>
	<body>

		<h1>Identifiez-vous </h1>

<!--   la méthode est post, envoi infos vers Controlleur_Servlet  -->

		<form method='post' action="FrontControleur?cmd=LoginCommande">
		<label for='id'>Identifiant : </label>
		<input name='identifiant' type='text' /><br><br>
		<label for='mdp'> Mot de passe : </label>
		<input name='password' type='password' /><br><br>
		<input name='boutonValider' type='submit'/>
		</form>
	</body>
</html>