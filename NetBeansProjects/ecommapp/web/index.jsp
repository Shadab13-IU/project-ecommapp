<%-- 
    Document   : index.jsp
    Created on : 16-Dec-2025, 2:22:40 pm
    Author     : shadab
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" session="false"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="${pageContext.request.contextPath}/css/bootstrap.css" rel="stylesheet" type="text/css" />
        <title>ecommapp</title>
        
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-white bg-white shadow-sm">
            <div class="container">
                <a class="navbar-brand fw-bold text-primary" href="#">
                    <i class="bi bi-shop me-2"></i>ecommapp
                </a>
                <div class="navbar-nav ms-auto">
                    <a class="nav-link" href="login"><i class="bi bi-info-circle me-1"></i>Account</a>
                </div>
            </div>
        </nav>
        <script src="/js/bootstrap.js" type="text/javascript"></script>
    </body>
</html>
