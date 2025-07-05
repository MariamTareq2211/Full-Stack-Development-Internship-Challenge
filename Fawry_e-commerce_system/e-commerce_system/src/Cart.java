import java.util.*;

public class Cart {
    private Map<Product,Long> items;
    

    public Cart(){
        items = new HashMap<>();
        
    }
    
    public void add(Product p, long q) throws Exception{
        if(q <= 0){
            throw new Exception("Quantity is Not Valied!");
        }
        if(q > p.getQuantity()){
            throw new Exception("Quantity exceed avalibale stock!");
        }
        
        long existInCart = items.getOrDefault(p, 0L);
        long totalQuantity = existInCart + q;

        if (totalQuantity > p.getQuantity()) {
        throw new Exception("Quantity exceeds available stock!");
        }

        items.put(p,totalQuantity);
    }

    public void deleteItem(Product p){
        items.remove(p);
    } 

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public Map<Product,Long> getCartItems(){
        return this.items;
    }


    public void displayItems(){
        for(Map.Entry<Product, Long> entry:items.entrySet()){
            Product p = entry.getKey();
            long q = entry.getValue();
            System.out.println(q + " x " + p.getName());
        }
    }
    public void clearCart() {
    items.clear();
    }
    public double calcSubTotal(){
        double subTotal = 0;
        for(Map.Entry<Product, Long> entry:items.entrySet()){
            subTotal += entry.getKey().getPrice() * entry.getValue();
        }
        return subTotal;
    }
    
    public List<Shippable> getShippableProducts() {
    List<Shippable> shippableProducts = new ArrayList<>();
    for (Product p : items.keySet()) {
        if (p instanceof Shippable) {
            shippableProducts.add((Shippable) p);
        }
    }
    return shippableProducts;
    }


}
