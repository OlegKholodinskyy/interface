package lesson25.lecture;

public class Demo {

    public static void main(String[] args) throws Exception {
        GeneralDAO generalDAO = new GeneralDAO();
        generalDAO.validate(new Order(-1));
    }
}
