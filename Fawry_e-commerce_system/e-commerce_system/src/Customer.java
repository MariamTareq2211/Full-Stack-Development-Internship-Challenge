public class Customer {
 private String name;
 private double balance;
 private Cart cart;

    public Customer(String Name , double balance){
    this.name = Name;
    this.balance = balance;
    this.cart = new Cart();
    }

    public String getName(){
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public Cart getCart() {
        return cart;
    }

    public double subtractFromBalance(double Amount) {
        this.balance -= Amount;
        return balance;
    }

    public void clearCart() {
        this.getCart().clearCart();
    }
}
