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
        <title>OnlineStore - Back Office</title>
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
                <a class="navbar-brand" href="home.jsp">OnlineStore - Gestion de la boutique</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarText" aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarText">
                    <ul class="navbar-nav mr-auto">
                        <li class="nav-item">
                            <a class="nav-link" href="catalogue">Afficher le catalogue des oeuvres</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="addworkform">Ajouter une oeuvre au catalogue</a>
                        </li>
                    </ul>
                    <span class="navbar-text">
                        <a class="nav-link" href="https://www.udemy.com/course/developper-une-application-web-avec-java-ee">Udemy - Développer une application avec Java EE.</a>
                    </span>
                </div>
            </nav>
            <div id="catalogue" class="list-group">

            </div>
            <div id="addworkform-container" class="row justify-content-center align-items-center h-100">
                <div class="col col-6">
                    <form id="addworkform" method="POST">
                        <fieldset>
                            <legend>Work</legend>
                            <div class="form-group row">
                                <label class="col-sm-2 col-form-label" for="title">Titre : </label>
                                <div class="col-sm-10">
                                    <input class="form-control" id="title" name="title" type="text" />
                                </div>
                            </div>
                            <div class="form-group row">
                                <label class="col-sm-2 col-form-label" for="release">Année de sortie : </label>
                                <div class="col-sm-10">
                                    <input class="form-control" id="release" name="release" type="number" />
                                </div>
                            </div>
                            <div class="form-group row">
                                <label class="col-sm-2 col-form-label" for="genre">Genre : </label>
                                <div class="col-sm-10">    
                                    <input class="form-control" id="genre" name="genre" type="text" />
                                </div>
                            </div>
                            <div class="form-group row">
                                <label class="col-sm-2 col-form-label" for="summary">Résumé : </label>
                                <div class="col-sm-10">
                                    <input class="form-control" id="summary" name="summary" type="text" />
                                </div>
                            </div>
                            <div class="form-group row">
                                <label class="col-sm-2 col-form-label" for="main_artist">Artiste principal : </label>
                                <div class="col-sm-10">
                                    <input class="form-control" id="main_artist" name="main_artist" type="text" />
                                </div>
                            </div>
                        </fieldset>
                        <fieldset class="container">
                            <div class="row">
                                <button class="col-6 btn btn-secondary float-leftt" type="reset">Réinitialiser</button>
                                <button class="col-6 btn btn-primary float-right" type="submit">Créer</button>
                            </div>
                        </fieldset>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
