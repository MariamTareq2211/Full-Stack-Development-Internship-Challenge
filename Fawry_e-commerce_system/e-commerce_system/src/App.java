import java.time.LocalDate;
import java.util.*;
public class App {
    public static void checkout(Customer customer, Cart cart) throws Exception {
    if (cart.isEmpty()) {
        throw new Exception("Cart is empty!");
    }

    Map<Product, Long> cartItems = cart.getCartItems();
    for (Map.Entry<Product, Long> entry : cartItems.entrySet()) {
        Product p = entry.getKey();
        long quantityInCart = entry.getValue();

        if (p instanceof ExpirProduct) {
            ExpirProduct exp = (ExpirProduct) p;
            if (exp.isExpired()) {
                throw new Exception("Product Expired: " + p.getName());
            }
        }

        if (quantityInCart > p.getQuantity()) {
            throw new Exception("Insufficient stock for product: " + p.getName());
        }
    }
    double subtotal = cart.calcSubTotal();

    List<Shippable> shippingList = cart.getShippableProducts();
    double totalWeight = 0;

    if (!shippingList.isEmpty()) {
        System.out.println("** Shipment notice **");
        for (Shippable shp : shippingList) {
            long quantity = cartItems.get(shp);
            double grams = shp.getWeight() * 1000;
            double totalProductWeight = grams * quantity;
            totalWeight += totalProductWeight;
            System.out.printf("%-2dx %-12s %5.0fg\n", quantity, shp.getName(), totalProductWeight);
        }

        if (totalWeight >= 1000) {
            System.out.printf("Total package weight %.1fkg\n", totalWeight / 1000);
        } else {
            System.out.printf("Total package weight %.0fg\n", totalWeight);
        }
        System.out.println();
    }
    Shipping fee (10 per kg)
    double shippingFee = (totalWeight / 1000.0) * 10;
    double totalAmount = subtotal + shippingFee;

    if (customer.getBalance() < totalAmount) {
        throw new Exception("No enough balance in your wallet");
    }

    customer.subtractFromBalance(totalAmount);
    for (Map.Entry<Product, Long> entry : cartItems.entrySet()) {
        Product p = entry.getKey();
        long newStock = p.getQuantity() - entry.getValue();
        p.setQuantity(newStock);
    }

    System.out.println("** Checkout receipt **");
    for (Map.Entry<Product, Long> entry : cartItems.entrySet()) {
        Product p = entry.getKey();
        long quantity = entry.getValue();
        double lineTotal = p.getPrice() * quantity;
        System.out.printf("%-2dx %-12s %.0f\n", quantity, p.getName(), lineTotal);
    }

    System.out.println("------------------------");
    System.out.printf("%-18s %.0f\n", "Subtotal", subtotal);
    System.out.printf("%-18s %.0f\n", "Shipping", shippingFee);
    System.out.printf("%-18s %.0f\n", "Amount", totalAmount);
    System.out.println();
    customer.clearCart();
}

    public static void main(String[] args) throws Exception {
            Customer customer = new Customer("Mariam", 1000.0);
            Expirable_and_shippable cheese = new Expirable_and_shippable("Cheese", 100, 5, LocalDate.now().plusDays(2), 0.2);  // 200g
            Expirable_and_shippable biscuits = new Expirable_and_shippable("Biscuits", 150, 3, LocalDate.now().plusDays(5), 0.7); // 700g
            Product mobileCard = new Product("Mobile Card", 50, 10);  // Not shippable or expirable
            Cart cart = customer.getCart();
            cart.add(cheese, 2);
            cart.add(biscuits, 1);
            cart.add(mobileCard, 1);
            checkout(customer, cart);
    }

    
}
