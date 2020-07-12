<%-- 
    Document   : navbar
    Created on : 12 juil. 2020, 18:53:27
    Author     : Romuald
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>  
<html lang="fr">  
<head>  
  <title>Bootstrap Case</title>  
  <meta charset="utf-8">  
  <meta name="viewport" content="width=device-width, initial-scale=1">  
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">  
    
</head>  
<body>  
<%@page import="java.util.*" %>
<%@page import="modele.*" %>
<nav class="navbar navbar-inverse">  
  <div class="container-fluid">  
    <div class="navbar-header">  
      <a class="navbar-brand" href="#">LDLX</a>  
    </div>  
      <!-- elements du menu a basculer en visible une fois loggé -->
    <ul class="nav navbar-nav">  
        <li><a href="#">Afficher</a></li>  
        <li><a href="#">Insérer</a></li>  
        <li><a href="recherche.jsp">Rechercher</a></li>          
    </ul>
<form action="j_security_check" style="margin-top:8px" class="form-inline">
          <!-- formulaire de connexion version inline 
         <input type="text" name=j_username id="login" class="form-control m-0" value="login" placeholder="login" />
         <input type=password name=j_password id="password" class="form-control m-0" value="password" placeholder="password" />
         <button class="btn btn-primary active m-0" type="submit" value="Connect">Se connecter</>
       </form></div>  -->
    <ul class="nav navbar-nav navbar-right"> 
        <!-- bouton a afficher une fois log -->
      <li><a href="login.jsp"></a><span class="glyphicon glyphicon-log-out"></span> Se déconnecter</a></li>  
    </ul>   
</nav>  
  
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>  
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>  
</body>  
</html>  
