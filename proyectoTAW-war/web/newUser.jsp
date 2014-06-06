<%-- 
    Document   : newUser
    Created on : 21-abr-2014, 17:55:34
    Author     : infernage
--%>

<%@page import="proyectotaw.entity.Tusers"%>
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
            Tusers user = (Tusers) request.getSession().getAttribute("user");
            if (user == null) {
                response.sendRedirect(getServletContext().getContextPath() + "/index");
                return;
            }
            if (user.getRol().getId() == 0) {
        %>
        <div class="col_w450" style="margin-left: 40%; margin-right: 0px;">
            <div id="register_user_form">
                <form action="register" method="POST">
                    <label for="name">Nombre:</label>
                    <input type="text" name="name" class="required input_field" id="name"/>
                    <div class="cleaner_h10"></div>
                    <label for="appell">Apellidos:</label>
                    <input type="text" name="appell" class="required input_field" id="appell"/>
                    <div class="cleaner_h10"></div>
                    <label for="dni">DNI:</label>
                    <input type="text" name="dni" class="required input_field" id="dni"/>
                    <div class="cleaner_h10"></div>
                    <label for="address">Dirección:</label>
                    <input type="text" name="address" class="required input_field" id="address"/>
                    <div class="cleaner_h10"></div>
                    Tipo de usuario:<div class="cleaner_h10"></div>
                    <input type="radio" name="type" value="admin">Administrador
                    <div class="cleaner_h10"></div>
                    <input type="radio" name="type" value="medic" checked>Médico
                    <div class="cleaner_h10"></div>
                    <input type="radio" name="type" value="normalUser">Usuario
                    <div class="cleaner_h10"></div>
                    <input type="submit" value="Registrar" class="submit_btn float_l">
                    <input type="reset" value="Borrar datos" class="submit_btn float_l">
                </form>
                <form action="menu" method="GET"><input type="submit" value="Volver"/></form>
            </div>
        </div>
        <%                } else if (user.getRol().getId() == 1) {
        %>
        <div class="col_w450" style="margin-left: 40%; margin-right: 0px;">
            <div id="register_user_form">
                <form action="register" method="POST">
                    <label for="name">Nombre:</label>
                    <input type="text" name="name" class="required input_field" id="name"/>
                    <div class="cleaner_h10"></div>
                    <label for="appell">Apellidos:</label>
                    <input type="text" name="appell" class="required input_field" id="appell"/>
                    <div class="cleaner_h10"></div>
                    <label for="dni">DNI:</label>
                    <input type="text" name="dni" class="required input_field" id="dni"/>
                    <div class="cleaner_h10"></div>
                    <label for="address">Dirección:</label>
                    <input type="text" name="address" class="required input_field" id="address"/>
                    <div class="cleaner_h10"></div>
                    <input type="submit" value="Registrar" class="submit_btn float_l">
                    <input type="reset" value="Borrar datos" class="submit_btn float_l">
                </form>
                <form action="menu" method="GET"><input type="submit" value="Volver"/></form>
            </div>
        </div>
        <%
            } else {
                response.sendRedirect(getServletContext().getContextPath() + "/index");
            }
        %>
    </body>
</html>
