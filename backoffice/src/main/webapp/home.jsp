<%-- 
    Document   : home
    Created on : Dec 27, 2019, 2:08:56 PM
    Author     : mkreutner
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>OnlineStrore - BackOffice - Home</title>
        <link rel="stylesheet" 
              href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" 
              integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" 
              crossorigin="anonymous">
        <!-- Bootstrap 4 scripts -->        
        <script src="https://code.jquery.com/jquery-3.4.1.min.js" integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo=" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        <script src="js/application.js"></script>
    </head>
    <body>
        <div class="container-fluid">
            <h1>OnlineStore - Gestion de la boutique</h1>
            <p>
                Bonjour ${ not empty sessionScope.identifiant ? sessionScope.identifiant : "Guest"},
                ${ not empty sessionScope.identifiant ? "(<a href=\"logout\">Déconnexion</a>)" : "(<a href=\"login.html\">Se connecter</a>)"}
            </p>
            <ul>
                <li><a href="catalogue">Afficher le catalogue des oeuvres</a></li>
                <li><a href="add-work-form.html">Ajouter une oeuvre au catalogue</a></li>
            </ul>
        </div>
        <div id="catalogue" class="list-group">
            
        </div>
    </body>
</html>
