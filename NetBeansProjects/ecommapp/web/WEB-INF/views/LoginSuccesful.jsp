<%-- 
    Document   : LoginSuccesful
    Created on : 18-Dec-2025, 2:41:25 pm
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
        <h1>Login Success!</h1>
        <a href="login"><h6>LogOut</h6></a>
        <%
            HttpSession s1=request.getSession(false);
            if(s1==null){
                request.getRequestDispatcher("/index.jsp").forward(request,response);
            }  
        %>
    </body>
</html>
