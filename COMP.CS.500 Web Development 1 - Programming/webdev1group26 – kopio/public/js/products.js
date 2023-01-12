/**
 * 9.1 List all products (use <template id="product-template"> in products.html)
 */
document.addEventListener("DOMContentLoaded", function() {
    getJSON("/api/products").then(data => {
      listProducts(data);
    });
  
    const listProducts = data => {
      const productsContainer = document.querySelector("#products-container");
      const template = document.querySelector("#product-template").content;
      data.map((iterData) => {
        // Clone template elements
        const clone = template.cloneNode(true);
  
        // Set product's data properties into variables
        const product = iterData;
        const id = product._id;
        const name = product.name;
        const description = product.description;
        const price = product.price;
        // Set product data into cloned template elements
        clone.querySelector(".item-row").id = "product-" + id;
        clone.querySelector(".product-name").id = "name-" + id;
        clone.querySelector(".product-name").innerHTML = name;
        clone.querySelector(".product-description").id = "description-" + id;
        clone.querySelector(".product-description").innerHTML = description;
        clone.querySelector(".product-price").id = "price-" + id;
        clone.querySelector(".product-price").innerHTML = price;
        // Add "Add to cart" button from cloned template
        clone.querySelector("button").id = "add-to-cart-" + id;
        //Append cloned elements into products container
        productsContainer.appendChild(clone);
      });

      // Add eventlisteners to "Add to cart" buttons
      let addToCartBtn = document.querySelectorAll('.item-row > button');
      Array.prototype.map.call(addToCartBtn, function(currentBtn){
        currentBtn.addEventListener("click", addProductToCart);
      });
    };
    // Function for adding products to cart
    const addProductToCart = (event) => {
      // Add item to cart (= SessionStorage)
      const cartBtnId = event.target.id;
      const tempList = cartBtnId.split("-");
      const productId = tempList[tempList.length - 1];
      // Set item to cart (= SeassionStorage) with amout of one (1)
      // if it doesn't exist in cart.
      if (sessionStorage.getItem(productId) === null){
        sessionStorage.setItem(productId, 1)
      }
      // Increase item's amount by one (1) if it already exists in cart.
      else {
        let productAmount = parseInt(sessionStorage.getItem(productId));
        productAmount += 1;
        sessionStorage.setItem(productId, productAmount);
      }
      //Show user notification of successful add to cart
      const productName = document.querySelector(`#name-${productId}`).innerHTML;
      createNotification(`Added ${productName} to cart!`, 'notifications-container');
    };
  });