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
        
        <title>Resultat</title>
    </head>
    <body>
        <jsp:include page="navbar.jsp" />
        <%@page import="java.util.*" %>
        <%@page import="modele.*" %>
        <jsp:useBean id="resultat" class="beans.resultatrequete" scope="request" />
        <form name="Result" action="Controleur" method="POST">
        
            <%            
            out.println("<table border=1 cellpadding=10>") ;
          // resultat.getResult().stream();nouveauté java 8 à creurser 
          List <Object> res=resultat.getResult();//jointure native
            
            for(Object  ligne : res){
                out.println("<TR>");           
                out.println("<TD> <input type=submit value="+String.valueOf(((Customer)ligne).getCustomerId())+" name=Operation_client /></TD>");
                out.println("<TD>"+((Customer)ligne).getName()+"</TD>");
                out.println("<TD>"+((Customer)ligne).getZip()+"</TD>");
                out.println("<TD>"+((Customer)ligne).getAddressline1()+"</TD>");
                out.println("<TD>"+((Customer)ligne).getDiscountCode()+"</TD>");
                out.println("<TD>"+((Customer)ligne).getEmail()+"</TD>");
                /*jointure réalisée par mappng xml
                out.println("<TD>"+((Customer)resultat.getResult().get(i)).getName()+"</TD>");
                out.println("<TD>"+((Customer)resultat.getResult().get(i)).getDiscountCode().getRate()+"</TD>");*/
                 out.println("</TR>");
                
                
            }
            out.println("</table>");
          
        %>
        </form>
    </body>
</html>
