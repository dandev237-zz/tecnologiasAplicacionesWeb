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
        <%  TUsers usuario = (TUsers) request.getSession().getAttribute("user");
            int id = usuario.getId();

            List<TInfo> listaInfo = (List<TInfo>) request.getAttribute("lista");
            List<TInfo> listaProcesada = new ArrayList<TInfo>();
            if (listaInfo != null) {
                for (TInfo t : listaInfo) {
                    if (t.getTPatientInfo().getId() == id) {
                        listaProcesada.add(t);
                    }
                }

                List<Integer> tipos = new ArrayList<Integer>();
                for (TInfo t : listaProcesada) {
                    if (!tipos.contains(t.getType())) {
                        tipos.add(t.getType());
                    }
                }
                Collections.sort(tipos);

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
                <td> <%=t.getDate().toString()%></td>
                <td> <%=t.getDescription()%></td>

            </tr>
            <%}
                }%>
        </table>
        <%}
            }%>
    </body>
</html>
