<%-- 
    Document   : newUser
    Created on : 21-abr-2014, 17:55:34
    Author     : infernage
--%>

<%@page import="proyectotaw.ejb.TRolesFacade"%>
<%@page import="proyectotaw.entity.TRoles"%>
<%@page import="proyectotaw.entity.TUsers"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registrar usuario</title>
        <link href="./css/templatemo_style.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <%
            TUsers user = (TUsers) request.getSession().getAttribute("user");
            if (user == null) {
                response.sendRedirect(getServletContext().getContextPath() + "/index");
                return;
            }
            if (user.getRol().getId() == 0) {
        %>
        <form action="register" method="POST">
            Nombre: <input type="text" name="name"><br>
            Apellidos: <input type="text" name="appell"><br>
            DNI: <input type="text" name="dni"><br>
            Dirección: <input type="text" name="address"><br>
            Tipo de usuario: <br>
            <input type="radio" name="type" value="admin">Administrador<br>
            <input type="radio" name="type" value="medic" checked>Médico<br>
            <input type="radio" name="type" value="normalUser">Usuario<br>
            <input type="submit" value="Registrar"> <input type="reset" value="Borrar datos">
        </form>
        <%                } else if (user.getRol().getId() == 1) {
        %>
        <form action="register" method="POST">
            Nombre: <input type="text" name="name"><br>
            Apellidos: <input type="text" name="appell"><br>
            DNI: <input type="text" name="dni"><br>
            Dirección: <input type="text" name="address"><br>
            <input type="submit" value="Registrar"> <input type="reset" value="Borrar datos">
        </form>
        <%
            } else {
                response.sendRedirect(getServletContext().getContextPath() + "/index");
            }
        %>
    </body>
</html>
