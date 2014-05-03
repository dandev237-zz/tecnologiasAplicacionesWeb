<%-- 
    Document   : menuA
    Created on : 21-abr-2014, 17:51:34
    Author     : infernage
--%>

<%@page import="proyectotaw.entity.TUsers"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Administración</title>
    </head>
    <body>
        <%
            TUsers user = (TUsers) session.getAttribute("user");
            if (user == null){
                response.sendRedirect(getServletContext().getContextPath() + "/index");
                return;
            }
            if (user.getRol().getId() != 0){
                response.sendRedirect(getServletContext().getContextPath() + "/index");
                return;
            }
        %>
        <table>
            <tr>
                <th>Consultar</th>
                <th>Acciones</th>
            </tr>
            <tr>
                <td><form action="location?action=map" method="GET">
                        <input type="submit" value="Mapa del hospital"
                               style="width: 240px;">
                    </form></td>
                <td><form action="https://ws003.juntadeandalucia.es/pls/intersas/servicios.carpeta_salud.tramite_enlinea_cs" >
                        <input type="submit" value="Acceder a ClicSalud"
                               style="width: 240px;">
                    </form></td>
            </tr>
            <tr>
                <td style="height: 28px;"><form action="location?action=hospital" method="GET">
                        <input type="submit" value="Ubicación del hospital"
                               style="width: 240px;">
                    </form></td>
                <td><form>
                        <input type="submit" value="Enviar formulario de contacto"
                               style="width: 240px;">
                    </form></td>
            </tr>
            <tr>
                <td><form action="GeneralInfoServlet">
                        <input type="submit" value="Información personalizada"
                               style="width: 240px;">
                    </form></td>
                <td><form>
                        <input type="submit" value="Personalizar código QR"
                               style="width: 240px;">
                    </form></td>
            </tr>
            <tr>
                <td><form>
                        <input type="submit" value="Equipo médico" style="width: 240px;">
                    </form></td>
                <td><form>
                        <input type="submit" value="Configurar avisos o recordatorios"
                               style="width: 240px;">
                    </form></td>
            </tr>
            <tr>
                <td><form action="location?action=location" method="GET">
                        <input type="submit" value="Localización personal"
                               style="width: 240px;">
                    </form></td>
            </tr>
        </table>
        <br>
        <form action="newUser.jsp" method="GET">
            <button>Registrar usuario</button>
        </form>
        <br>
        <form action="logout.jsp" method="GET">
            <input type="submit" value="Logout">
        </form>
    </body>
</html>
