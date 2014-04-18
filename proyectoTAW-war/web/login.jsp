<%-- 
    Document   : login
    Created on : 17-abr-2014, 23:29:58
    Author     : infernage
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Acceso</title>
    </head>
    <body>
        <form name="login" action="auth" method="POST">
            <center>
                <table bgcolor="gray">
                    <tr><td>Username:</td><td><input type="text" name="user"/></td></tr>
                    <tr><td>Password:</td><td><input type="password" name="pass"/></td></tr>
                    <tr><td></td><td align="center"><input type="submit" value="Login" name="logbutton"/>
                        </td></tr>
                </table>
            </center>
        </form>
    </body>
</html>
