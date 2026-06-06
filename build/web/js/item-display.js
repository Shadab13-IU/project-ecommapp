/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/ClientSide/javascript.js to edit this template
 */
////ReactDOM.render(el,document.getElementById("root"));
let xh=new XMLHttpRequest();
    xh.onreadystatechange=function(){
        if(xh.readyState==4){
            if((xh.status>=200 && xh.status<300)||xh.status==304){
                //alert("shadaab");
                //field.innerHTML=xhr.responseText;
                let jobj=JSON.parse(xh.responseText);
                let data=jobj.items;
                console.log(data);
                function Items({ items }) {
                    return (
                        <div style={{
                            display: "flex",
                            flexWrap: "wrap",
                            gap: "20px"
                            }}>
                            {items.map((item, index) => (
                                <div
                                    key={index}
                                    onClick={() =>{
                                        window.location.href=`/ecommapp/controller/productDetails?id=${item.product_id}`;
                                    }}
                                    style={{
                                        width: "30%",              // 3 items per row
                                        border: "1px solid #ddd",
                                        borderRadius: "8px",
                                        padding: "10px",
                                        boxShadow: "0 2px 5px rgba(0,0,0,0.1)",
                                        background: "#fff"
                                    }}
                                >
                                <div style={{
                                                    width: "100%",
                                                    height: "130px",          // 🔥 reduced size
                                                    display: "flex",
                                                    alignItems: "center",
                                                    justifyContent: "center",
                                                    background: "#f9f9f9",
                                                    borderRadius: "6px",
                                                    overflow: "hidden"
                                            }}>
                                                
                                            <img
                                            src={`data:image/jpeg;base64,${item.product_image_path}`}
                                                        alt={item.product_name}
                                                        style={{
                                                            maxWidth: "100%",
                                                            maxHeight: "100%",
                                                            objectFit: "contain"
                                                        }}
                                                    />
                                </div>
                                <h4 style={{ margin: "10px 0 5px" }}>
                                                    {item.product_name}
                                                </h4>

                                                <p style={{ margin: "0", color: "gray", fontSize: "14px" }}>
                                                    {item.product_brand}
                                                </p>

                                                <p style={{ margin: "5px 0", fontWeight: "bold", color: "green" }}>
                                                    ₹{item.product_selling_price}
                                                </p>

                                            </div>
                                        ))}
                                    </div>
                                );
                            }

                            ReactDOM.render(<Items items={data}/>,document.getElementById("root"));
        }else{
            alert("Request is unsuccesfull");
        }
                    }
    };
    xh.open("get","idisplay",true);
    xh.send(null);
                