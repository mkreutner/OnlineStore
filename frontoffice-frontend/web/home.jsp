<%-- 
    Document   : home
    Created on : Dec 27, 2019, 1:46:38 PM
    Author     : mkreutner
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>OnlineStore - Front Office</title>
        <link rel="stylesheet" 
              href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
        <link rel="stylesheet" 
              href="css/styles.css">
        <!-- Bootstrap 4 scripts -->        
        <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <script src="js/application.js"></script>
    </head>
    <body>
        <div class="container-fluid">
            <nav class="navbar fixed-top navbar-expand-lg navbar-dark bg-dark">
                <a class="navbar-brand" href="home.jsp">OnlineStore, votre boutique multimédia en ligne</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarText" aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarText">
                    <ul class="navbar-nav mr-auto">
                        <li class="nav-item">
                            <a class="nav-link" href="catalogue">Afficher le catalogue des oeuvres</a>
                        </li>
                    </ul>
                    <span class="navbar-text">
                        <a class="nav-link" href="https://www.udemy.com/course/developper-une-application-web-avec-java-ee">Udemy - Développer une application avec Java EE.</a>
                    </span>
                </div>
            </nav>
            <div id="catalogue" class="list-group">

            </div>
        </div>
    </body>
</html>
