<%-- 
    Document   : test
    Created on : 15-abr-2014, 19:09:56
    Author     : Alberto
--%>

<%@page import="proyectotaw.entity.Tusers"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        sdasdd
        <%
            List<Tusers> list = (List<Tusers>) request.getAttribute("list");
            if (list != null){
                for(int i = 0; i < list.size(); i++){
                    Tusers t = list.get(i);
                    %>
                    <h1>
                        <%=t.getUsername()%>
                    </h1>
                    <%
                }
            }
            %>
    </body>
</html>
