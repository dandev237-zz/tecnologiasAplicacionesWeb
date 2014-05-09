<%-- 
    Document   : info.jsp
    Created on : 01-may-2014, 18:25:35
    Author     : Fco Javier
--%>

<%@page import="java.util.Collections"%>
<%@page import="java.util.ArrayList"%>
<%@page import="proyectotaw.entity.TInfo"%>
<%@page import="java.util.List"%>
<%@page import="proyectotaw.entity.TUsers"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%
            List<Integer> tipos = (List<Integer>) request.getAttribute("tipos");
            List<TInfo> listaProcesada = (List<TInfo>) request.getAttribute("lista");
            if (tipos == null || listaProcesada == null){
                response.sendRedirect(getServletContext().getContextPath() + "/index");
                return;
            }
        %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Información extra personalizada</h1>
        <% for (int i : tipos) { %>
        <table> 
            <% for (TInfo t : listaProcesada) {
                    if (t.getType() == i) {
            %>
            <tr>
                <td> <%=t.getDate()%></td>
                <td> <%=t.getDescription()%></td>

            </tr>
            <%}
                }%>
        </table>
        <%}%>
    </body>
</html>
