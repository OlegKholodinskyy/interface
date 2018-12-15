package lesson25.lecture;

public class GeneralDAO {

    private void print(Order order){
        System.out.println("order is: " + order.toString());
    }
    public <T extends  IdEntity> void validate(T t) throws Exception{
        if (t.gerId()<=0)
            throw new Exception("id can`t be negative");
    }
}
