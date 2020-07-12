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
        
        <title>Enregistrement</title>
    </head>
    <body>
         <%@page import="java.util.*" %>
        <%@page import="modele.*" %>
        <jsp:include page="navbar.jsp" />
        <form name="inscription" action="Controleur" method="POST">
            <p>
            <label for="code_produit">Code Produit</label>
            <input type="text" name="code_produit" value="" size="10" id="code_produit" />
            </p>
            <p>
            <label for="desc">Description</label>
            <input type="text" name="desc" value="" size="10" id="desc" />
            </p>
            <p>
            <label for="discount">Code discount</label>
            <input type="text" name="discount" value="" size="10" id="discount"/>
            </p>
            <input type="submit" value="Enregistrer le produit" name="Operation_produit" />
        </form>
    </body>
</html>
