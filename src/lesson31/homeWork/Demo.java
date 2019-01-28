package lesson31.homeWork;

public class Demo {

    public static void main(String[] args) {
        try {
            System.out.println(Solution.countSymbols(""));
        } catch (BadRequestException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println(Solution.countSymbols("245243 345"));
        } catch (BadRequestException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println(Solution.countSymbols("cdddddddddd   5  45 45trg r4 "));
        } catch (BadRequestException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println(Solution.countSymbols(null));
        } catch (BadRequestException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println(Solution.countSymbols("            "));
        } catch (BadRequestException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("WORDS");
        try {
            System.out.println(Solution.words(" get put get           "));
        } catch (BadRequestException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println(Solution.words("     "));
        } catch (BadRequestException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println(Solution.words(" g3et put3 g3et     tyry  null      "));
        } catch (BadRequestException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println(Solution.words( null));
        } catch (BadRequestException e) {
            System.out.println(e.getMessage());
        }

    }
}
