/**
 * 9.1 List shopping cart items (use <template id="cart-item-template"> in cart.html)
 */
document.addEventListener("DOMContentLoaded", function() {

  getJSON("/api/products").then(data => {
    listCartItems(data);
  });

  
  const listCartItems = data => {
    // Add cart items to cart page
    const cartContainer = document.querySelector("#cart-container");
    const template = document.querySelector("#cart-item-template").content;
    let cartItems = getAllProductsFromCart();
    cartItems.map((iterCartItems) => {
      let cartItem = iterCartItems;
      // Clone template elements
      const clone = template.cloneNode(true);

      // Set cart item's data properties into variables
      const cartItemData = data.find(function(product) {
        return product._id === cartItem;
      });
      const id = cartItemData._id;
      const name = cartItemData.name;
      const price = cartItemData.price;
      // Get product count (amount) from cart
      let cartItemAmount = getProductCountFromCart(cartItem);

      // Set cart item data into cloned template elements
      clone.querySelector(".item-row").id = "product-" + id;
      clone.querySelector(".product-name").id = "name-" + id;
      clone.querySelector(".product-name").innerHTML = name;
      clone.querySelector(".product-price").id = "price-" + id;
      clone.querySelector(".product-price").innerHTML = price;
      clone.querySelector(".product-amount").id = "amount-" + id;
      clone.querySelector(".product-amount").innerHTML = cartItemAmount + "x";

      //Add buttons for adding and removing item from cart
      clone.querySelectorAll(".cart-minus-plus-button")[0].id = "plus-" + id;
      clone.querySelectorAll(".cart-minus-plus-button")[1].id = "minus-" + id;

      //Append cloned elements into cart item container
      cartContainer.appendChild(clone);
    });

    // Add eventlisteners to "+" buttons
    let plusBtn = document.querySelectorAll("[id^='plus-']");
    Array.prototype.map.call(plusBtn, function(currentBtn){
      currentBtn.addEventListener("click", increaseProductCount);
    });

    // Add eventlisteners to "-" buttons
    let minusBtn = document.querySelectorAll("[id^='minus-']");
    Array.prototype.map.call(minusBtn, function(currentBtn){
      currentBtn.addEventListener("click", decreaseProductCount);
    });
  };

  // Function for placing order
  const placeOrder = () => {
    // User notification of successfully placing an order
    createNotification("Successfully created an order!", 'notifications-container');
    // Clear shopping cart
    clearCart();
  };

  // Function for clearing shopping cart
  const clearCart = () => {
    // Clear shopping cart (= SessionStorage)
    sessionStorage.clear();
    // Remove cart items from UI
    document.querySelector("#cart-container").innerHTML = "";
  };

  // Add eventlistener to "Place order" button
  const orderBtn = document.querySelector("#place-order-button");
  orderBtn.addEventListener("click", placeOrder)

  // Function for getting all products from cart.
  const getAllProductsFromCart = () => {
    return Object.keys(sessionStorage);
  };

  // Function for getting product count from cart
  const getProductCountFromCart = product => {
    return sessionStorage.getItem(product);
  };

  // Function for increasing product count (amount)
  const increaseProductCount = (event) => {
    const plusBtnId = event.target.id;
    const productId = plusBtnId.split("-")[1];
    // Increase item's amount by one (1)
    let productAmount = parseInt(sessionStorage.getItem(productId));
    productAmount += 1;
    sessionStorage.setItem(productId, productAmount);
    // Update amount on UI
    document.querySelector(`#amount-${productId}`).innerHTML = productAmount + "x";
  };

  // Function for decreasing product count (amount)
  const decreaseProductCount = (event) => {
    const minusBtnId = event.target.id;
    const productId = minusBtnId.split("-")[1];

    let productAmount = parseInt(sessionStorage.getItem(productId));
    //Decrease item's amount by one (1)
    if (productAmount > 1) {
      productAmount -= 1;
      sessionStorage.setItem(productId, productAmount);
      // Update amount on UI
      document.querySelector(`#amount-${productId}`).innerHTML = productAmount + "x";
    }
    // If item count (amount) is already one (1), remove item from cart and UI
    else{
      // Remove from shopping cart (= SessionStorage)
      sessionStorage.removeItem(productId);
      // Remove from UI
      document.querySelector(`#product-${productId}`).remove();
    }


  }
  
  });