🛍️ Overview
A basic Java-based e-commerce simulation that supports shopping cart operations, product types (shippable, expirable), and checkout logic with shipping fees and stock validation.

🧱 Features
Define products with:

Name, Price, Quantity

Optional Expiry (e.g., Cheese, Biscuits)

Optional Shipping (e.g., TV, Cheese)

Customer can:

Add items to cart (with stock check)

Checkout (with subtotal, shipping cost, final amount)

Get error if:

Cart is empty

Balance is insufficient

Product is out of stock or expired

Shipping Service: collects items to be shipped and calculates total weight

Prints formatted receipt on checkout

🧩 Structure
Product (base class)

ExpirProduct, ShippableProduct, Expirable_and_shippable (extensions)

Customer (holds balance and cart)

Cart (holds product-quantity mapping)

App (handles checkout logic and main)

🚀 How to Run
Compile all .java files

Run App.java

![Screenshot 2025-07-09 034249](https://github.com/user-attachments/assets/f0768f89-b746-472c-99b5-ffd2c6c0289d)
