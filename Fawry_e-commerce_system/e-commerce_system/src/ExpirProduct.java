import java.time.LocalDate;
public class ExpirProduct extends Product{
    private LocalDate ExpirDate;

    public ExpirProduct(String Name ,float Price,long Quantity,LocalDate expiredate) throws Exception {
        super(Name, Price, Quantity);
        this.ExpirDate = expiredate;
    }

    public void setExpirDate(LocalDate expiredate){
        this.ExpirDate = expiredate;
    }
    public LocalDate getExpirDate(){
        return ExpirDate;
    }
    public boolean isExpired(){
        if(LocalDate.now().isAfter(ExpirDate)){
            return true;
        }else{
            return false;
        }
    }
    
}
