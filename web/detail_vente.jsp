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
        
        <title>Détails</title>
    </head>
    <body>
        <jsp:useBean id="resultat" class="beans.resultatrequete" scope="request" />
        <jsp:useBean id="dc" class="beans.resultatrequete" scope="request" />
        <jsp:useBean id="zip" class="beans.resultatrequete" scope="request" />
        <%@page import="modele.*" %>
        <%@page import="java.util.*" %>
        
        <form name="inscription" action="Controleur" method="POST">
           <p>
                <label for="numero">Numero de commande</label>
                <input type="text" name="numero" value="<%=String.valueOf(resultat.getVente().getOrderNum() %>" size="30" id="numero" />
            </p>
            <p>
            <label for="nom">Client</label>
                <input type="text" name="nom" value="<%= resultat.getVente().getCustomer() %>" size="30" id="nom" />
            </p>
            <p>
            <label for="produit">Produit</label>
            <input type="text" name="produit" value="<%= resultat.getVente().getProductId() %>" size="30" id="produit" />
            </p>
            <p>
            <label for="quantité">Quantité</label>
            <input type="text" name="quantité" value="<%= resultat.getVente().getQuantity() %>" size="30" id="quantité" />
            </p>
            <p>
            <label for="livraison">Coût de livraison</label>
            <input type="text" name="livraison" value="<%= resultat.getVente().getShippingCost() %>" size="30" id="livraison"/>
            </p>
            <p>
            <label for="date">Date de livraison</label>
            <input type="text" name="date" value="<%= resultat.getVente().getShippingDate() %>" size="30" id="date"/>
            </p>
            
            <p>
            <label for="date_vente">Date de vente</label>
            <input type="text" name="date_vente" value="<%= resultat.getVente().getSalesDate() %>" size="30" id="date_vente"/>
            </p>
            
            <p>
            <label for="date_vente">Compagnie de livraison</label>
            <input type="text" name="date_vente" value="<%= resultat.getVente().getFreightCompany() %>" size="30" id="date_vente"/>
            </p>
            
            <input type="submit" value="Modifier" name="Operation_vente" />
            <input type="submit" value="Supprimer" name="Operation_vente" />
            <input type="submit" value="Afficher les achats" name="Operation_vente" />
        </form>
    </body>
</html>
