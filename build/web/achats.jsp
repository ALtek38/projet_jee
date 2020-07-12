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
        
        <title>Achats</title>
    </head>
    <body>
        <%@page import="java.util.*" %>
        <%@page import="modele.*" %>
        <jsp:include page="navbar.jsp" />
        <jsp:useBean id="resultat" class="beans.resultatrequete" scope="request" />
        
        <H1>Achats du client n°<%=request.getParameter("numero")%></H1>
        <%            
            out.println("<table border=1 cellpadding=10>");
                        
           // out.println("<TR>");
            List <Object []> res=resultat.getResult();//jointure native
            
            
           for(Object [] ligne : res){
                out.println("<TR>");
                out.println("<TD>"+((PurchaseOrder)ligne[0]).getShippingDate()+"</TD>");
                out.println("<TD>"+((PurchaseOrder)ligne[0]).getProductId()+"</TD>");
                out.println("<TD>"+((PurchaseOrder)ligne[0]).getQuantity()+"</TD>");
                out.println("<TD>"+((PurchaseOrder)ligne[0]).getShippingCost()+"</TD>");
                out.println("</TR>");
           }
           out.println("<TR>");
           out.println("</table>");
                  
            
        %>
        
    </body>
</html>
