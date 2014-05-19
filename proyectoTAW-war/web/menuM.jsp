<%-- 
    Document   : menuM
    Created on : 21-abr-2014, 17:46:25
    Author     : infernage
--%>

<%@page import="proyectotaw.entity.Tusers"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Menu médico</title>
    </head>
    <body>
        <%
            Tusers user = (Tusers) request.getSession().getAttribute("user");
            if (user == null){
                response.sendRedirect(getServletContext().getContextPath() + "/index");
                return;
            }
            if (user.getRol().getId() != 1){
                response.sendRedirect(getServletContext().getContextPath() + "/index");
                return;
            }
        %>
        <table>
            <tr>
                <td><form action="newUser.jsp"><button>Registrar usuario</button></form></td>
                <td><form action="sendAlert.jsp"><button>Enviar alertas</button></form></td>
                <td><form action="modifyAlert.jsf"><button>Modificar alertas</button></form></td>
            </tr>
            <tr>
                <td><form action="date"><button>Crear aviso de cita</button></form></td>
                <td><form action="deletedate"><button>Borrar aviso de cita</button></form></td>
            </tr>
        </table>
        <br>
        <form action="logout.jsp" method="GET">
            <input type="submit" value="Logout">
        </form>
    </body>
</html>
