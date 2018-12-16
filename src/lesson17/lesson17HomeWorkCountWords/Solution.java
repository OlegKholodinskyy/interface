package lesson17.lesson17HomeWorkCountWords;

public class Solution {

    public static void main(String[] args) {
        String[] str = new String[]{
          //      "one1",
          //      "one two",
                "one t22wo2 three",
          //      "",
                null};

        for (String test : str)
            System.out.printf("%-30s contain %d word(s) %n", test, countWords(test));
    }

    public static int countWords(String input) {

        int result;

        if (input == null || input.trim().isEmpty()) {
            return 0;
        } else {
            result = conutingWords(input);
            return result;
        }
    }

    public static int conutingWords(String s){

        int counter = 0;

        for(int i=0; i<=s.length()-1; i++) {

            if(Character.isLetter(s.charAt(i))){
                counter++;

                for(;i<=s.length()-1; i++){
                    if(s.charAt(i)==' '){
                        counter++;
                    }
                    else if (!Character.isLetter(s.charAt(i))){
                        counter--;
                        break;
                    }
                }
            }
        }

        return counter;
    }
}