/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/ClientSide/javascript.js to edit this template
 */


let asynData=function(id,ut){
    let fdata=document.getElementById(id).value;
    let field=document.getElementById(ut);
    let xhr=new XMLHttpRequest();
    xhr.onreadystatechange=function(){
        if(xhr.readyState==4){
            if((xhr.status>=200 && xhr.status<300)||xhr.status==304){
                let jobj=JSON.parse(xhr.responseText);
            }else{
                alert("Request is unsuccesfull")
            }
        }
    };
    xhr.open("get","nameavail?email="+fdata,true);
    xhr.send(null);
};
