public class Product {
    private String Name;
    private float Price;
    private long Quantity;
    
    public Product(){
        Name = "Not assigned yet";
        Price = 0;
        Quantity = 0;
    }
    public Product(String Name ,float Price,long Quantity) throws Exception{
        if(Price < 0 || Quantity < 0){
            throw new Exception("Price and Quantity should be a positive number");
        }
        this.Name = Name;
        this.Price = Price;
        this.Quantity = Quantity;
    }

    public void setName(String n){
        this.Name = n;
    }
    public void setPrice(float p) throws Exception{
        if(p < 0){
            throw new Exception("Price should be a positive number.");
        }
        this.Price = p;
    }
    public void setQuantity(long q) throws Exception{
        if(q < 0){
            throw new Exception("Quantity should be a positive number.");
        }
        this.Quantity = q;
    }

    public String getName(){
        return Name;
    }
    public float getPrice(){
        return Price;
    }
    public long getQuantity(){
        return Quantity;
    }

}
