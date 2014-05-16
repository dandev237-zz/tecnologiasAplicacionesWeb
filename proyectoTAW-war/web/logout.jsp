<%-- 
    Document   : logout
    Created on : 21-abr-2014, 17:39:12
    Author     : infernage
--%>

<%@page import="proyectotaw.entity.Tusers"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
    </head>
    <%
        Tusers user = (Tusers) session.getAttribute("user");
        if (user != null) {
            session.invalidate();
        }
        response.sendRedirect(getServletContext().getContextPath() + "/index");
    %>
</html>
