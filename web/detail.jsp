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
                <label for="numero">Numero</label>
                <input type="text" name="numero" value="<%=String.valueOf(resultat.getClient().getCustomerId()) %>" size="30" id="numero" />
            </p>
            <p>
            <label for="nom">Nom</label>
                <input type="text" name="nom" value="<%=resultat.getClient().getName()%>" size="30" id="nom" />
            </p>
            <p>
            <label for="adresse">Adresse</label>
            <input type="text" name="adresse" value="<%=resultat.getClient().getAddressline1()%>" size="30" id="adresse" />
            </p>
            <p>
            <label for="telephone">Téléphone</label>
            <input type="text" name="telephone" value="<%=resultat.getClient().getPhone()%>" size="30" id="tel" />
            </p>
            <p>
            <label for="email">E-mail</label>
            <input type="text" name="email" value="<%=resultat.getClient().getEmail()%>" size="30" id="email"/>
            </p>
            <p>
            <label for="Remise">Remise</label>
           <select name="Remise" id="dc" >
                <% List <Character> res=dc.getResult();
                    for(Character enreg1 : res){
                        if ( enreg1==resultat.getClient().getDiscountCode())
                    {
                        out.println("<option selected=\"selected\">"+enreg1+"</option>");
                    }
                    else { out.println("<option>"+enreg1+"</option>"); }
                 }
                 %>
          </select>
            </p>
            
            <p>
          <label for="Code_Postal">Code Postal</label>
          <select name="Code_Postal" id="cp">
                <% List<MicroMarket> liste=zip.getResult();
                    for(MicroMarket enreg2 : liste){
                     if ( enreg2.getZipCode().equals(resultat.getClient().getZip()))
                    {
                        out.println("<option selected=\"selected\">"+enreg2.getZipCode()+"</option>");
                    }
                    else { out.println("<option>"+enreg2.getZipCode()+"</option>"); }
                 }
                 %>
            </select>
            </p>
            
            <input type="submit" value="Modifier" name="Operation_client" />
            <input type="submit" value="Supprimer" name="Operation_client" />
            <input type="submit" value="Afficher les achats" name="Operation_client" />
        </form>
    </body>
</html>
