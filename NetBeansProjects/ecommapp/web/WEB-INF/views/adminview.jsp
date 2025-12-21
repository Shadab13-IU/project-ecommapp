<%-- 
    Document   : adminview
    Created on : 18-Dec-2025, 2:40:43 pm
    Author     : shadab
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" session="false"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Admin view!</h1>
         <%
            HttpSession s1=request.getSession(false);
            if(s1==null){
                request.getRequestDispatcher("/index.jsp").forward(request,response);
            }  
        %>
    </body>
</html>
