<%-- 
    Document   : newjsp
    Created on : 31-Dec-2025, 2:18:56 pm
    Author     : shadab
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="../css/bootstrap.css" rel="stylesheet" type="text/css" />
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container mt-5">
        <div class="row justify-content-center">
            <div class="col-md-6 col-lg-5">
                
                <!-- Login Card -->
                <div class="card border-0 shadow">
                    <div class="card-body p-5">
                        
                        <!-- Header -->
                        <div class="text-center mb-4">
                            
                            <h2 class="fw-bold">Sign In</h2>
                            
                        </div>
                        
                        <!-- Login Form -->
                        <form action="lmodel" method="POST">
                            <!-- Email -->
                            <div class="mb-3">
                                <label class="form-label">Email Address</label>
                                <div class="input-group">
                                    <span class="input-group-text">
                                        <i class="bi bi-envelope"></i>
                                    </span>
                                    <input type="text" name="email" class="form-control" placeholder="user@ecomm.com" required>
                                    <input type="hidden" name="category" value="2">
                                </div>
                            </div>
                            
                            <!-- Password -->
                            <div class="mb-4">
                                <label class="form-label">Password</label>
                                <div class="input-group">
                                    <span class="input-group-text">
                                        <i class="bi bi-lock"></i>
                                    </span>
                                    <input type="password" name="pwd" class="form-control" placeholder="Enter password" required>
                                    <!--<button class="btn btn-outline-secondary" type="button">
                                        <i class="bi bi-eye"></i>
                                    </button>-->
                                </div>
                            </div>
                            <!-- Submit Button -->
                            <button type="submit" class="btn btn-outline-primary  w-100  mb-3">
                                <i class="bi bi-box-arrow-in-right me-2"></i> Sign In
                            </button>
                        </form>
                        
                        
                        
                    </div>
                </div>
    <script src="../js/bootstrap.js" type="text/javascript"></script>                  
    </body>
</html>
