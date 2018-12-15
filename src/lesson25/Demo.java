package lesson25;

import lesson25.exception.BadRequestException;
import lesson25.exception.InternalServerException;

public class Demo {
    public static void main(String[] args) {
        GeneralDAO<Book> dao = new GeneralDAO<>();
        try {
            dao.save(new Book());
        } catch (BadRequestException e) {
            e.printStackTrace();
        } catch (InternalServerException e) {
            e.printStackTrace();
        }

        Object[] o = dao.getAll();

        for (Object ob : o) {
            System.out.println(ob.toString());
        }
    }
}
