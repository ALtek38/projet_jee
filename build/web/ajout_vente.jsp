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
        <jsp:useBean id="client" class="beans.resultatrequete" scope="request" />
        <jsp:useBean id="produit" class="beans.resultatrequete" scope="request" />
        <form name="inscription" action="Controleur" method="POST">
            <p><label for="produit">Produit</label>
          <select name="produit" id="produit" >
                <% List <Object> res=produit.getResult();
                    for(Object enreg1 : res){
                     out.println("<option>"+(Character)enreg1+"</option>");
                 }
                 %>
          </select>
            </p>
            <p>
            <label for="adresse">Adresse</label>
            <input type="text" name="adresse" value="" size="10" id="adresse" />
            </p>
            <p>
            <label for="telephone">Téléphone</label>
            <input type="text" name="telephone" value="" size="10" id="tel" />
            </p>
            <p>
            <label for="email">E-mail</label>
            <input type="text" name="email" value="" size="10" id="email"/>
            </p>
            <p><label for="client">Client</label>
          <select name="client" id="client" >
                <%
                    for(Object enreg2 : client.getResult()){
                     out.println("<option>"+(Character)enreg2+"</option>");
                 }
                 %>
          </select>
            </p>
            <input type="submit" value="Enregistrer la vente" name="Operation" />
        </form>
    </body>
</html>