<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Connexion</title>
    </head>
    <body>
        <%@page import="java.util.*" %>
        <%@page import="modele.*" %>
        <form action="j_security_check" method="POST">
            <table border=1 cellpadding=10>
                <TR>
                    <td>Login</td>
                    <td><input name=j_username></input></td>
                </TR>
                <TR>
                    <td>Password</td>
                    <td><input type=password name=j_password></input></td>
                </TR>
                <TR>
                    <td colspan=2><input type="submit" value="Connect"/></td>
                </TR>
            </table>
        </form>
    </body>
</html>
