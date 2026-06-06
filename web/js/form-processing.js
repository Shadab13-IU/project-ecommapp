/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/ClientSide/javascript.js to edit this template
 */

/*document.addEventListener('DOMContentLoaded', function(){
   let dv=document.getElementById("pid");
   dv.innerHTML="";
   let xhr=new XMLHttpRequest();
    xhr.onreadystatechange=function(){
        if(xhr.readyState==4){
            if((xhr.status>=200 && xhr.status<300)||xhr.status==304){
                //alert(xhr.responseText);
                //field.innerHTML=xhr.responseText;
                let formData=JSON.parse(xhr.responseText);
                
                //alert(jobj);
                //console.log(jobj);
                //let fm=jobj.components;
                //let fm=document.createElement(jobj.components);
//                console.log(fm);
                    const form = document.createElement('form');
                    form.method = formData.method;
                    form.action = formData.action;
                    form.id = 'dynamic-form';
                    formData.fields.forEach((field) => {
                        let element;
                
                        // Determine element type
                        if (field.type === 'submit') {
                            element = document.createElement('button');
                            element.type = 'submit';
                            //element.textContent = field.value || 'Submit';
                        } else {
                            element = document.createElement('input');
                            element.type = field.type || 'text';

                            // Set properties if they exist
                            if (field.name) element.name = field.name;
                            //if (field.id) element.id = field.id || field.name;
                            if (field.placeholder) element.placeholder = field.placeholder;
                            //if (field.value) element.value = field.value;

                            // Add required attribute if specified
                            //if (field.required) element.required = true;
                        }
                        form.appendChild(element);
                    });
                    console.log(form);
                    dv.appendChild(form);
                }  
                //         console.log(form);
            }else{
                alert("Request is unsuccesfull")
            }
        }
    };
    xhr.open("get","frmpro",true);
    xhr.send(null);
}*/
document.addEventListener('DOMContentLoaded', function(){
    let dv = document.getElementById("pid");
    if (!dv) {
        console.error("Element with id 'pid' not found!");
        return;
    }
    
    dv.innerHTML = "";
    let xhr = new XMLHttpRequest();
    
    xhr.onreadystatechange = function() {
        if (xhr.readyState == 4) {
            if ((xhr.status >= 200 && xhr.status < 300) || xhr.status == 304) {
                try {
                    let formData = JSON.parse(xhr.responseText);
                    
                    
                    console.log(formData);
                    const form = document.createElement('form');
                    form.method = formData.method;
                    form.action = formData.action;
                    console.log(formData.action);
                    form.id = 'dynamic-form';
                    
                    
                    form.style.cssText = `
                        display: flex;
                        flex-direction: column;
                        gap: 15px;
                        max-width: 400px;
                        margin: 0 auto;
                        padding: 20px;
                        border: 1px solid #ddd;
                        border-radius: 8px;
                    `;
                    
                    
                    formData.fields.forEach((field) => {
                        
                        if (field.type === 'email') {
                           
                            const emailContainer = document.createElement('div');
                            emailContainer.style.cssText = 'display: flex; flex-direction: column;';
                            
                            
                            const emailLabel = document.createElement('label');
                            emailLabel.textContent ='Email';
                            emailLabel.htmlFor = 'email';
                            emailLabel.style.cssText = 'margin-bottom: 5px; font-weight: bold;';
                            
                            
                            const emailInput = document.createElement('input');
                            emailInput.type =field.type;
                            emailInput.name = 'email';
                            emailInput.id = field.id || 'email';
                            emailInput.placeholder = field.placeholder;
                            emailInput.required = field.required;
                            //console.log(field.placeholder+" "field.required)
                            emailInput.style.cssText = `
                                padding: 10px;
                                border: 1px solid #ccc;
                                border-radius: 4px;
                                font-size: 16px;
                            `;
                            
                            
                            emailContainer.appendChild(emailLabel);
                            emailContainer.appendChild(emailInput);
                            form.appendChild(emailContainer);
                        }
                        
                       
                        else if (field.type === 'password') {
                            
                            const passContainer = document.createElement('div');
                            passContainer.style.cssText = 'display: flex; flex-direction: column;';
                            
                           
                            const passLabel = document.createElement('label');
                            passLabel.textContent = 'Password';
                            passLabel.htmlFor = field.id || 'password';
                            passLabel.style.cssText = 'margin-bottom: 5px; font-weight: bold;';
                            
                            
                            const passInput = document.createElement('input');
                            passInput.type = 'password';
                            passInput.name = 'pwd';
                            passInput.id = field.id;
                            passInput.placeholder = field.placeholder;
                            passInput.required = true;
                            passInput.style.cssText = `
                                padding: 10px;
                                border: 1px solid #ccc;
                                border-radius: 4px;
                                font-size: 16px;
                            `;
                            
                            
                            passContainer.appendChild(passLabel);
                            passContainer.appendChild(passInput);
                            form.appendChild(passContainer);
                        }
                        
                        
                        else if (field.type === 'submit') {
                            const submitBtn = document.createElement('button');
                            submitBtn.type = 'submit';
                            submitBtn.textContent = 'SignIn';
                            submitBtn.style.cssText = `
                                padding: 12px 20px;
                                background-color: #007bff;
                                color: white;
                                border: none;
                                border-radius: 4px;
                                font-size: 16px;
                                cursor: pointer;
                                margin-top: 10px;
                            `;
                            
                            
                            submitBtn.onmouseover = () => submitBtn.style.backgroundColor = '#0056b3';
                            submitBtn.onmouseout = () => submitBtn.style.backgroundColor = '#007bff';
                            
                            form.appendChild(submitBtn);
                        }
                        
                        // OTHER FIELD TYPES (text, number, etc.)
                        else {
                            const element = document.createElement('input');
                            element.type=field.type;
                            
                            if (field.name) element.name = field.name;
                            if (field.placeholder) {
                                element.placeholder = field.placeholder;
                            }
                            if (field.value) element.value = field.value;
                            
                            /*element.style.cssText = `
                                padding: 10px;
                                border: 1px solid #ccc;
                                border-radius: 4px;
                                font-size: 16px;
                            `;*/
                            
                            form.appendChild(element);
                        }
                    });
                    dv.appendChild(form);
                    
                } catch (error) {
                    console.error("Error:", error);
                    dv.innerHTML = "<div style='color: red; padding: 20px;'>Error loading form. Please check console.</div>";
                }
            } else {
                dv.innerHTML = `<div style='color: red; padding: 20px;'>Request failed: ${xhr.status}</div>`;
            }
        }
        //console.log(field.placeholder+" "field.required)
    };
    
    xhr.open("GET", "frmpro", true);
    xhr.send(null);
});
