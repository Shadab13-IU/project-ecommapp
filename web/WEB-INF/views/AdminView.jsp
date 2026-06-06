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
        <link href="${pageContext.request.contextPath}/css/bootstrap.css" rel="stylesheet" type="text/css" />
        <title>JSP Page</title>
    </head>
    <body>
        <script src="../js/category.js" type="text/javascript"></script>
        
         
         <div class="container-fluid">
        <div class="row">
            <!-- Left Side - Seller Section -->
            <div class="col-md-4 col-lg-3 bg-light p-4">
                
                        <h5>Seller Section</h5>
                       
            </div>
            
            <!-- Right Side - Lists Section -->
            <div class="col-md-8 col-lg-9 p-4">
                <h1 class="mb-4">Lists</h1>
                <div class="mb-4">
                    <button type="button" class="btn btn-outline-primary" data-bs-toggle="modal" data-bs-target="#uploadModal">
                        Upload a new item
                    </button>
                </div>
            </div>
        </div>
    </div>

    <!-- Upload Modal -->
    <div class="modal fade" id="uploadModal" tabindex="-1" aria-labelledby="uploadModalLabel" aria-hidden="true">
        <div class="modal-dialog modal-xls">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="uploadModalLabel">Upload New Item</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <form method="POST" action="uploaditem" enctype="multipart/form-data">
                        <div class="mb-3">
                            <label for="itemName" class="form-label">Product_Name</label>
                            <input type="text" class="form-control"  name="prdid" id="itemName" placeholder="Enter product name">
                        </div>
                        
                        <div class="mb-3">
                            <label for="itemPrice" class="form-label">Product_CostPrice</label>
                            <input type="text" class="form-control"  name="prc" placeholder="Enter product price">
                        </div>
                        
                        <div class="mb-3">
                            <label for="itemDescription" class="form-label">Product_Description</label>
                            <textarea name="description" class="form-control" id="itemDescription" rows="3" placeholder="Enter product description"></textarea>
                        </div>
                        
                        <div class="mb-3">
                            <label for="itemCategory" class="form-label">Category</label>
                            <select class="form-select" id="itemcategory" name="itemct" onfocus="handleProduct();" onchange="subCat('subcategory',this.value);">
                                <option selected>Select category</option><!--
                                <option value="1">Electronics</option>
                                <option value="2">Clothing</option>
                                <option value="3">Home & Garden</option>
                                <option value="4">Books</option>
                                <option value="5">Other</option>-->
                            </select>
                        </div>
                        
                        <div class="mb-3">
                            <label for="itemCategory" class="form-label">SubCategory</label>
                            <select name="subct" class="form-select" id="subcategory" disabled>
                                <option selected>Select Subcategory</option>
<!--                            <option value="1">Electronics</option>
                                <option value="2">Clothing</option>
                                <option value="3">Home & Garden</option>
                                <option value="4">Books</option>
                                <option value="5">Other</option>-->
                            </select>
                        </div>
                        
                         <div class="mb-3">
                            <label for="itemPrice" class="form-label">Product_Brand</label>
                            <input type="text" class="form-control"  name="brnd" placeholder="Enter product brand">
                        </div>
                        
                         <div class="mb-3">
                            <label for="itemPrice" class="form-label">Product_Warranty</label>
                            <input type="text" class="form-control"  name="wrnty" placeholder="Enter product warranty">
                        </div>
                        
                        <div class="mb-3">
                            <label for="itemPrice" class="form-label">Product_Quantity</label>
                            <input type="text" class="form-control"  name="qant" placeholder="Enter product quantity">
                        </div>
                        
                        <div class="mb-3">
                            <label for="itemPrice" class="form-label">Product_SellingPrice</label>
                            <input type="text" class="form-control"  name="scp" placeholder="Enter product discount">
                        </div>
                        
                        <div class="mb-3">
                            <label for="itemPrice" class="form-label">Product_Dimension</label>
                            <input type="text" class="form-control"  name="dmns" placeholder="Enter product dimension">
                        </div>
                        
                        <div class="mb-3">
                            <label for="itemPrice" class="form-label">Product_Weight</label>
                            <input type="text" class="form-control"  name="wght" placeholder="Enter product weight">
                        </div>
                        
                        
<!--                        <div class="mb-3">
                            <label for="itemPrice" class="form-label">Price</label>
                            <div class="input-group">
                                <span class="input-group-text">Rs</span>
                                <input type="number" class="form-control" id="itemPrice" placeholder="0.00">
                            </div>
                        </div>-->
                        
                        <div class="mb-3">
                            <label for="itemImage" class="form-label">Upload Image</label>
                            <input class="form-control" name="img" type="file" id="itemImage">
                        </div>
                        
                        <div class="form-check mb-3">
                            <input class="form-check-input" type="checkbox" id="termsCheck">
                            <label class="form-check-label" for="termsCheck">
                                I agree to the terms and conditions
                            </label>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancel</button>
                            <button type="submit" class="btn btn-primary">Upload Item</button>
                        </div>
                    </form>
                </div>
                
            </div>
        </div>
    </div>
        <script src="${pageContext.request.contextPath}/js/bootstrap.js" type="text/javascript"></script>
        <script>
            function subCat(id,value){
                //alert(id);
                let scategory=document.getElementById(id);
                console.log(value);
                scategory.innerHTML = '';
                scategory.disabled = true;
                let xhr=new XMLHttpRequest();
                xhr.onreadystatechange=function(){
                    if(xhr.readyState==4){
                        if((xhr.status>=200 && xhr.status<300)||xhr.status==304){
                            //alert(xhr.responseText);
                            //field.innerHTML=xhr.responseText;
                            scategory.innerHTML = '';
                            scategory.disabled = false;
                            let jobj=JSON.parse(xhr.responseText);
                            Object.entries(jobj).forEach(([key,value])=>{
                                const option=document.createElement('option');
                                option.value=key;
                                option.textContent=value;
                                scategory.appendChild(option);
                            });
                           // scategory.setAttribute('data-fetched', 'true');
                        }else{
                            alert("Request is unsuccesfull")
                        }
                    }
                };
                xhr.open("get","schandler?cid="+value,true);
                xhr.send(null);
                //
               
            };
        </script>
    </body>
</html>
