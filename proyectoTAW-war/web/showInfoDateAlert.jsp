<%-- 
    Document   : showInfoDateAlert
    Created on : 19-may-2014, 18:38:16
    Author     : Alberto
--%>

<%@page import="proyectotaw.entity.Tcitas"%>
<%@page import="proyectotaw.entity.Talert"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Información detallada</title>
    </head>
    <body>
        <%
            Talert alert = (Talert) request.getAttribute("alert");
            Tcitas date = (Tcitas) request.getAttribute("date");
            if (alert == null && date == null) {
                response.sendRedirect(getServletContext().getContextPath() + "/index");
                return;
            }
            if (date == null) {
        %>
        <h1>Alerta <%=alert.getTitle()%></h1>
        <div class="cleaner_h10"></div>
        <h1>Descripción:</h1>
        <p><%=alert.getDescription()%></p>
        <h1>¿Importante?</h1> <%= (alert.getImportant() ? "Sí" : "No")%>
        <%
        } else if (alert == null) {
        %>
        <h1>Cita fecha <%= date.getDate().toString()%></h1>
        <div class="cleaner_h10"></div>
        <h1>Descripción:</h1>
        <p><%=date.getDescription()%></p>
        <h1>¿Importante?</h1> <%= (date.getImportant() ? "Sí" : "No")%>
        <%
            }
        %>
    </body>
</html>
