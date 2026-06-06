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
                
                 <div class="dropdown">
                     <button class=" btn btn-outline-primary dropdown-toggle" data-bs-toggle="dropdown">Create Account</button>
                        <ul class="dropdown-menu">
                            <li><a class="dropdown-item" href="<%= request.getContextPath()%>/controller/login"><strong>Login as Buyer</strong><p class="text-muted small mb-0">Browse and purchase products</p></a></li>
                            <li><a class="dropdown-item" href="<%= request.getContextPath()%>/controller/sellerlg"><strong>Login as Seller</strong><p class="text-muted small mb-0">Sell products on our platform</p></a></li>
                        </ul>
                </div>
                
                
                <!--
                <div class="navbar-nav ms-auto">
                    <a class="nav-link" href="controller/login"><i class="bi bi-info-circle me-1"></i>Account</a>
                </div>-->
            
        </nav>
        
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
        <script src="/js/bootstrap.js" type="text/javascript"></script>
    </body>
</html>
