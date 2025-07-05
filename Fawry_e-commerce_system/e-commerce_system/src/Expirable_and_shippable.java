import java.time.LocalDate;

public class Expirable_and_shippable extends ExpirProduct implements Shippable {
    private double weight;
    
    public Expirable_and_shippable(String Name ,float Price,long Quantity,LocalDate expiredate, double weight) throws Exception{
        super(Name, Price, Quantity,expiredate);
        if(weight < 0){
            throw new Exception("Weight must be positive number");
        }
        this.weight = weight;
    }

    public void setWeight(double w) throws Exception{
        if(w < 0){
            throw new Exception ("Weight must be positive number");
        }
        this.weight = w;
    }

    @Override
    public double getWeight(){
        return weight;
    }
}
