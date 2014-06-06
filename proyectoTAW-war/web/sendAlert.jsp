<%-- 
    Document   : sendAlert
    Created on : 17-may-2014, 17:43:03
    Author     : Fco Javier
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Enviar Alerta</title>
    </head>
    <body>
        <form action="send" method="POST">
            <label for="nuhsa">Nuhsa del paciente:</label>
            <input type="text" name="nuhsa"/>
            <label for="title">Título:</label>
            <input type="text" name="title"/>
            <label for="description">Descripción:</label>
            <br>
            <textarea name="description" rows="10" cols="30"></textarea>
            <input type="submit" value="Enviar">
            <input type="reset" value="Borrar">
            <input type="checkbox" name="important" value="Importante">Importante
        </form>
        <form action="menu" method="GET"><input type="submit" value="Volver"/></form>
    </body>
</html>
