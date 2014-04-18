<%-- 
    Document   : menu
    Created on : 18-abr-2014, 14:05:17
    Author     : infernage
--%>

<%@page import="proyectotaw.entity.Tusers"%>
<%@page import="proyectotaw.entity.Troles"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Menu principal</title>
    </head>
    <body>
        <%
            Troles rol = ((Tusers) request.getSession().getAttribute("user")).getRol();
        %>
        <h1>TODO</h1>
    </body>
</html>
