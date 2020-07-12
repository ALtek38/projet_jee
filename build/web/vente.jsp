<%-- 
    Document   : customer
    Created on : 23 juin 2020, 09:27:34
    Author     : dhond
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://cdn.jsdelivr.net/jquery.validation/1.15.1/jquery.validate.min.js"></script>
        <link href="https://fonts.googleapis.com/css?family=Kaushan+Script" rel="stylesheet">
        <link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">

        <title>Gérer les ventes</title>
    </head>
    <body>
        <h1>Gérer les ventes</h1>
        <form action="Controleur" method="POST">
            <div class="form-group col-md-6">
                <p>Choisissez dans la liste ci-dessous, quel action vous voulez effectuer.</p>
                <select name="Operation_vente" class="form-control">
                    <option>Afficher toutes les ventes</option>
                    <option>Ajouter une nouvelle vente</option>
                </select>
                <input type="submit" class="btn btn-primary" value="Valider">
            </div>
        </form>
    </body>
</html>

