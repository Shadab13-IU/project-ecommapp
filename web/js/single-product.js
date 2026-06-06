/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/ClientSide/javascript.js to edit this template
 */
const params = new URLSearchParams(window.location.search);
const productId = params.get("id");

console.log(productId);

let xh = new XMLHttpRequest();

xh.onreadystatechange = function() {
    if (xh.readyState==4) {
        if(xh.status >= 200 &&
           xh.status < 300){
            console.log(xh.responseText);
            let product = JSON.parse(xh.responseText);

            function ProductDetails({product}) {

                return (
                    <div
                        style={{
                            display: "flex",
                            gap: "50px",
                            padding: "30px"
                        }}
                    >

                        
                    <div>
                        <img
                            src={`data:image/jpeg;base64,${product.product_image_path}`}
                            alt={product.product_name}
                            style={{
                                width: "350px",
                                height: "350px",
                                objectFit: "contain",
                                border: "1px solid #ddd",
                                padding: "10px"
                            }}
                        />
                    </div>

                        
                    <div style={{maxWidth: "600px"}}>

                        <h1>{product.product_name}</h1>

                        <h3 style={{color: "#555"}}>
                              {product.product_brand}
                        </h3>

                            
                        <div style={{marginTop: "20px"}}>

                            <span
                                style={{
                                    textDecoration: "line-through",
                                    color: "gray",
                                    fontSize: "20px"
                                }}
                            >
                            ₹{product.product_price}
                            </span>

                            <span
                                style={{
                                    color: "green",
                                    fontWeight: "bold",
                                    marginLeft: "15px",
                                    fontSize: "18px"
                                }}
                            >
                            {product.product_discount}% OFF
                            </span>

                            <h2
                                style={{
                                    color: "#B12704",
                                    marginTop: "10px"
                                }}
                            >
                            ₹{product.product_selling_price}
                            </h2>

                            </div>

                            
                            <h3>Description</h3>

                            <p>
                                {product.product_description}
                            </p>

                         
                            <p>
                                <b>Warranty:</b> {product.product_warranty}
                            </p>

                            <p>
                                <b>Weight:</b> {product.product_weight}
                            </p>

                            <p>
                                <b>Dimension:</b> {product.product_dimension}
                            </p>

                            <div
                                style={{
                                    marginTop: "30px",
                                    display: "flex",
                                    gap: "15px"
                                }}
                            >

                                <button
                                    onClick={() => {
                                        let xh = new XMLHttpRequest();

                                        xh.open(
                                            "GET",
                                            `addToCart?id=${product.product_id}`,
                                            true
                                        );

                                        xh.send();
                                    }}
                                >
                                    Add To Cart
                                </button>

                                <button
                                    style={{
                                        padding: "12px 25px",
                                        border: "none",
                                        borderRadius: "5px",
                                        cursor: "pointer",
                                        fontWeight: "bold"
                                    }}
                                >
                                    Buy Now
                                </button>

                            </div>

                        </div>

                    </div>
                );
            }
            ReactDOM.render(
                <ProductDetails product={product}/>,
                document.getElementById("root")
            );
        }
    }
};
xh.open("GET", "spd?id=" + productId, true);
xh.send(null);            
                
