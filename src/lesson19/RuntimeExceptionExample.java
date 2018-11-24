package lesson19;

public class RuntimeExceptionExample {
    public static void main(String[] args) {

        //arithmetic exception
        try{
        arithmeticException(0);}
        catch (ArithmeticException e){
            System.out.println("Worng" + e);
        }
    }

    public static void arithmeticException (int a){
        System.out.println(10/a);
    }

}
