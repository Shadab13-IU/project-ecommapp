<%-- 
    Document   : SignUp
    Created on : 16-Dec-2025, 2:31:51 pm
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
        <div class="container mt-5">
            <div class="row justify-content-center">
                <div class="col-md-6 col-lg-5">
                
                <!-- Login Card -->
                <div class="card border-0 shadow">
                    <div class="card-body p-5">
                        
                        <!-- Header -->
                        <div class="text-center mb-4">
                            <h2 class="fw-bold">Sign Up</h2>                            
                        </div>
                        
                        <!-- Login Form -->
                        <form action="register" method="POST">
                            <!-- Email -->
                            <div class="mb-3">
                                <label class="form-label">Email Address</label>
                                <div class="input-group">
                                    <span class="input-group-text">
                                        <i class="bi bi-envelope"></i>
                                    </span>
                                    <input type="email" name="email" class="form-control" placeholder="user@example.com">
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
                                </div>
                            </div>
                            
                            <div class="mb-3">
                                <label class="form-label">First Name</label>
                                <div class="input-group">
                                    <span class="input-group-text">
                                        <i class="bi bi-envelope"></i>
                                    </span>
                                    <input type="text" name="fname" class="form-control" placeholder="Enter first name">
                                </div>
                            </div>
                            
                            <div class="mb-3">
                                <label class="form-label">Last Name</label>
                                <div class="input-group">
                                    <span class="input-group-text">
                                        <i class="bi bi-envelope"></i>
                                    </span>
                                    <input type="text" name="lname" class="form-control" placeholder="Enter Last name">
                                </div>
                            </div>
                            
                            <div class="mb-3">
                                <span class="fs-10"><label class="col-form-label col-sm-2">Gender</label></span>
                                <div class="form-check-inline">
                                    <input type="radio" name="gender" value="1"/><label>Male</label>
                                </div>
                                <div class="form-check-inline">  
                                   <input type="radio" name="gender" value="2"/><label>Female</label>
                                </div>
                                
                            </div>
                            
                            <!-- <div class="mb-4">
                                <label class="col-form-label col-sm-2">Gender</label>
                                <div class="form-check form-check-inline">
                                    <input class="form-check-input" type="radio" name="gender" id="genderMale" value="male">
                                    <label class="form-check-label" for="genderMale">Male</label>
                                </div>
                                <div class="form-check form-check-inline">
                                    <input class="form-check-input" type="radio" name="gender" id="genderMale" value="male">
                                    <label class="form-check-label" for="genderMale">Female</label>
                                </div>
                            </div>
                             -->
                            
                            <!--<div class="mb-4">
                                <label class="col-form-label col-sm-2">Gender</label>
                                <div class="form-check form-check-inline">
                                    <input class="form-check-input" type="radio" name="gender" id="genderMale" value="male">
                                    <label class="form-check-label" for="genderMale">Male</label>
                                </div>
                                <div class="form-check form-check-inline">
                                    <input class="form-check-input" type="radio" name="gender" id="genderMale" value="male">
                                    <label class="form-check-label" for="genderMale">Female</label>
                                </div>
                            </div>-->
                            
                            
                            
                            <!-- Submit Button -->
                            <button type="submit" class="btn btn-outline-primary  btn-lg w-100  mb-3">
                                <i class="bi bi-box-arrow-in-right me-2"></i> Sign Up
                            </button>
                        </form>
        <script src="../js/bootstrap.js" type="text/javascript"></script>
    </body>
</html>
