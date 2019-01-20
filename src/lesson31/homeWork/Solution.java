package lesson31.homeWork;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static Map<Character, Integer> countSymbols(String text) throws BadRequestException {
        Map<Character, Integer> map = new HashMap();
        if (checkerInputData(text)) {
            char[] arrayCharsInText = text.toCharArray();

            for (char ch : arrayCharsInText) {
                if (Character.isLetter(ch))
                    map.put(ch, map.containsKey(ch) ? map.get(ch) + 1 : 1);
            }
        } else {
            throw new BadRequestException("Bad intut data");
        }
        return map;
    }

    private static boolean checkerInputData(String text) {
        return (text != null && text.length() != 0);
    }


    public static Map<String, Integer> words(String text) throws BadRequestException {
        Map<String, Integer> map = new HashMap<>();


        if (checkerInputData(text)) {

            String[] arrayWords = text.trim().split(" ");
            for (String oneWord : arrayWords) {
                if (oneWord.length() >=2 && checkContainsNonLeter(oneWord))
                map.put(oneWord, map.containsKey(oneWord) ? map.get(oneWord) + 1 : 1);
            }

        } else {
            throw new BadRequestException("Bad intut data");
        }
        return map;
    }

    private static boolean checkContainsNonLeter(String oneWord) {
        char[] arrayCharsInOneWord = oneWord.toCharArray();

        for(char ch : arrayCharsInOneWord){
            if (!Character.isLetter(ch)){
                return false;
            }
        }
        return true;
    }
}