<%-- 
    Document   : showAlertsADates
    Created on : 18-may-2014, 16:56:02
    Author     : Alberto
--%>

<%@page import="proyectotaw.entity.Tcitas"%>
<%@page import="proyectotaw.entity.Talert"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alertas y citas</title>
    </head>
    <body>
        <%
            List<Talert> alerts = (List<Talert>) request.getAttribute("alerts");
            List<Tcitas> dates = (List<Tcitas>) request.getAttribute("dates");
            if (alerts == null || dates == null) {
                response.sendRedirect(getServletContext().getContextPath() + "/index");
                return;
            }
        %>
        <h1>Alertas</h1>
        <div class="cleaner_h10"></div>
        <table border="1">
            <tr>
                <th>Título</th>
                <th>¿Importante?</th>
                <th>Descripción</th>
            </tr>
            <%
                for (Talert alert : alerts) {
            %>
            <tr>
                <td><%=alert.getTitle()%></td>
                <td><%=(alert.getImportant() ? "Importante" : "No importante")%></td>
                <td><%=alert.getDescription()%></td>
            </tr>
            <%
                }
            %>
        </table>
        <div class="cleaner_h10"></div>
        <h1>Citas</h1>
        <div class="cleaner_h10"></div>
        <table border="1">
            <tr>
                <th>Fecha</th>
                <th>¿Importante?</th>
                <th>Descripción</th>
            </tr>
            <%
                for (Tcitas date : dates) {
            %>
            <tr>
                <td><%=date.getDate().toString()%></td>
                <td><%=(date.getImportant() ? "Importante" : "No importante")%></td>
                <td><%=date.getDescription()%></td>
            </tr>
            <%
                }
            %>
        </table>
        <div class="cleaner_h10"></div>
        <form action="menu" method="GET"><input type="submit" value="Back"></form>
    </body>
</html>
