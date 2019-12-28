<%-- 
    Document   : work-details
    Created on : Dec 28, 2019, 5:46:52 AM
    Author     : mkreutner
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>OnlineStore - Front Office - Détails de l'oeuvre</title>
        <link rel="stylesheet" 
              href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" 
              integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" 
              crossorigin="anonymous">
    </head>
    <body>
        <div class="container-fluid">
            <h3>
                Détail de l'oeuvre ${requestScope.work.title} (#${requestScope.work.id})
            </h3>
            <ul>
                <li><span>Titre</span><span>${requestScope.work.title}</span></li>
                <li><span>Année</span><span>${requestScope.work.release}</span></li>
                <li><span>Résumé</span><span>${requestScope.work.summary}</span></li>
                <li><span>Act(eur/rice) principal(e)</span><span>${requestScope.work.mainArtist.name}</span></li>
            </ul>
            <hr/>
            <a href="catalogue" class="btn btn-link btn-secondary-out">Retour au catalogue des oeuvres</a>
        </div>
        <!-- Bootstrap 4 scripts -->        
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    </body>
</html>
