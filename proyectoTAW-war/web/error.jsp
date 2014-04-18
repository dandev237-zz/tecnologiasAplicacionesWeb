<%-- 
    Document   : error
    Created on : 18-abr-2014, 0:21:37
    Author     : infernage
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><%= request.getAttribute("error")%></title>
    </head>
    <body>
        <h1><font color="red"><%= request.getAttribute("cause")%></font></h1>
    </body>
</html>
