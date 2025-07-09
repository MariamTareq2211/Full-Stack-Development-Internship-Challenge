# 🛒 Java E-Commerce System

## 📖 Overview
This is a console-based **Java e-commerce system** that allows customers to shop for different types of products (shippable, expirable, regular), manage their cart, and perform secure checkouts with validations and shipping logic.

---

## 🧩 Features

- 🛍️ **Product Management**
  - Each product has a name, price, and quantity
  - Some products can **expire** (e.g., Cheese, Biscuits)
  - Some products require **shipping** (e.g., TV, Cheese)
  - Shipping requires product weight in kg

- 👤 **Customer Features**
  - Can add products to their cart (quantity must not exceed stock)
  - Can view cart contents
  - Can checkout

- 💳 **Checkout Process**
  - Calculates:
    - Subtotal (sum of price × quantity)
    - Shipping fee (10 EGP per kg)
    - Total amount
  - Validates:
    - Cart is not empty
    - Product stock is available
    - Product is not expired
    - Customer has enough balance
  - Shipping notice displays total weight and shipped items

---

## 🧱 Class Structure

- `Product` – base class for all product types
- `ExpirProduct` – extends `Product`, adds expiration logic
- `Shippable` – interface for products that require shipping
- `Expirable_and_shippable` – combines expirable and shippable
- `Customer` – owns cart and balance
- `Cart` – stores items and quantities
- `App` – contains the `checkout()` method and `main()` function

---


![Screenshot 2025-07-09 034249](https://github.com/user-attachments/assets/8bc9fcd8-2112-409e-a31e-dd302e951add)
