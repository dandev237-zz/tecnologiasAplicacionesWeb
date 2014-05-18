<%-- 
    Document   : info.jsp
    Created on : 01-may-2014, 18:25:35
    Author     : Fco Javier
--%>

<%@page import="proyectotaw.entity.Tinfoextra"%>
<%@page import="java.util.Collections"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%
            List<Tinfoextra> listaProcesada = (List<Tinfoextra>) request.getAttribute("lista");
            if (listaProcesada == null) {
                response.sendRedirect(getServletContext().getContextPath() + "/index");
                return;
            }
        %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Información general</title>
    </head>
    <body>
        <h1>Información extra personalizada</h1>
        <table> 
            <% for (Tinfoextra t : listaProcesada) {
            %>
            <tr>
                <td> <%=t.getType()%></td>
                <td> <%=t.getDescription()%></td>

            </tr>
            <%}%>
        </table>
    </body>
</html>
