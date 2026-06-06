<%-- 
    Document   : admin_login
    Created on : 16-Dec-2025, 10:25:58 am
    Author     : shadab
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" session="false"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="../css/bootstrap.css" rel="stylesheet" type="text/css" />
        <title>JSP Page</title>
    </head>
    <body>
        <!-- Navigation -->
        <nav class="navbar navbar-white bg-white shadow-sm">
            <div class="container">
                <a class="navbar-brand fw-bold text-success-emphasis" href="#">
                    <i class="bi bi-shop me-2"></i>ecommapp 
                </a>
                <a href="index" class="btn btn-outline-primary">
                    <i class="bi bi-arrow-left me-1"></i> Back to Home
                </a>
            </div>
        </nav>
         <!-- Main Content -->
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
                        
                        <!-- Divider -->
                        <div class="position-relative my-4">
                            <hr>
                            <span class="position-absolute top-50 start-50 translate-middle bg-white px-3 text-muted">
                                OR
                            </span>
                        </div>
                        
                        <!-- Sign Up Section -->
                        <div class="text-center">
                            <p class="text-muted mb-3">Don't have an account?</p>
                            <a href="signUp"><button class="btn btn-outline-primary  w-100" data-bs-toggle="modal" data-bs-target="#signupModal">
                                Create Account
                                </button></a>
                        </div>
                        
                    </div>
                </div>
                <footer class="mt-5 py-4 bg-white border-top">
                    <div class="container text-center text-muted">
                        <p class="mb-0">© 2025 ecommapp Portal. Restricted access.</p>
                    </div>
                </footer>
        
        <script src="../js/bootstrap.js" type="text/javascript"></script>
    </body>
</html>
