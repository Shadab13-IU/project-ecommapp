/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/ClientSide/javascript.js to edit this template
 */


function handleProduct(){
                //alert("shadab");
                let select=document.getElementById("itemcategory");
                console.log("shadab");
                if (select.hasAttribute('data-loaded') && select.getAttribute('data-loaded') === 'true') {
                    return; // Already loaded, don't load again
                }
                let xh=new XMLHttpRequest();
                xh.onreadystatechange=function(){
                    if(xh.readyState==4){
                        if((xh.status>=200 && xh.status<300)||xh.status==304){
                            //alert(xhr.responseText);
                            //field.innerHTML=xhr.responseText;
                            console.log("Categories loaded");
                            let jobj=JSON.parse(xh.responseText);
                            Object.entries(jobj).forEach(([key,value])=>{
                                const option=document.createElement('option');
                                option.value=key;
                                option.textContent=value;
                                select.appendChild(option);
                            });
                            select.setAttribute('data-loaded', 'true');
                        }else{
                            alert("Request is unsuccesfull");
                        }
                    }
                };
                xh.open("get","chandler",true);
                xh.send(null);
                
            }