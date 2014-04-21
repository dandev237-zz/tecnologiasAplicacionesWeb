<%-- 
    Document   : menu
    Created on : 18-abr-2014, 14:05:17
    Author     : infernage
--%>

<%@page import="proyectotaw.entity.TUsers"%>
<%@page import="proyectotaw.entity.TRoles"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Menu principal</title>
    </head>
    <body>
        <%
            TUsers user = (TUsers) request.getSession().getAttribute("user");
            if (user == null){
                response.sendRedirect(getServletContext().getContextPath() + "/index");
                return;
            }
            TRoles rol = user.getRol();
            if (rol.getId() == 0){
                getServletContext().getRequestDispatcher("/menuA.jsp").forward(request, response);
                return;
            } else if (rol.getId() == 1){
                getServletContext().getRequestDispatcher("/menuM.jsp").forward(request, response);
                return;
            }
        %><br>Nombre:
        <%=user.getName()%><br>NUHSA:<%=user.getNuhsa()%>
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
                <td><form>
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
                <td><form>
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
        <form action="logout.jsp" method="GET">
            <input type="submit" value="Logout">
        </form>
    </body>
</html>
