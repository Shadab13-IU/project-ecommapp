<%-- 
    Document   : productDetails
    Created on : 28-May-2026, 8:32:04 pm
    Author     : shadab
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div id="root"></div>
        <script src="https://unpkg.com/react@16/umd/react.production.min.js"></script>
        <script src="https://unpkg.com/react-dom@16/umd/react-dom.production.min.js"></script>
        <script src="https://unpkg.com/@babel/standalone/babel.min.js"></script>

        <script
            type="text/babel"
            src="${pageContext.request.contextPath}/js/single-product.js">
        </script>
    </body>
</html>
