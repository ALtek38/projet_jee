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
        <jsp:useBean id="client" class="beans.resultatrequete" scope="request" />
        <jsp:useBean id="produit" class="beans.resultatrequete" scope="request" />
        <form name="inscription" action="Controleur" method="POST">
            <p><label for="produit">Produit</label>
          <select name="produit" id="produit" >
                <% List <Object> res=produit.getResult();
                    for(Object enreg1 : res){
                     out.println("<option>"+((Product)enreg1).getDescription()+"</option>");
                 }
                 %>
          </select>
            </p>
            <p>
            <label for="quantité">Quantité</label>
            <input type="text" name="quantité" value="" size="10" id="quantité" />
            </p>
            <p>
            <label for="livraison">Coût de livraison</label>
            <input type="text" name="livraison" value="" size="10" id="livraison" />
            </p>
            <p>
            <label for="date_livr">Date de livraison</label>
            <input type="text" name="date_livr" value="" size="10" id="date_livr"/>
            </p>
            <p>
            <label for="vente">Date de vente</label>
            <input type="text" name="vente" value="" size="10" id="vente"/>
            </p>
            <p>
            <label for="compagnie">Compagnie de livraison</label>
            <input type="text" name="compagnie" value="" size="10" id="compagnie"/>
            </p>
            <p><label for="client">Client</label>
          <select name="client" id="client" >
                <%
                    for(Object enreg2 : client.getResult()){
                     out.println("<option>"+((Customer)enreg2).getName()+"</option>");
                 }
                 %>
          </select>
            </p>
            <input type="submit" value="Enregistrer la vente" name="Operation_vente" />
        </form>
    </body>
</html>
