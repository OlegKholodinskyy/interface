package lesson17Validate;

public class Solution {
    private static boolean validate(String address) {
        if (check(address)) {
            if (    checkHttp(address) &&
                    checkDomain(address) &&
                    chechBody(address)) {
                return true;
            }
        }
        return false;
    }

    private static boolean chechBody(String address) {
        char[] ch = address.toCharArray();
        int startIndex = 0;
        int endIndex = address.length() - 4;
        if (ch[6] == '/' && ch[7] == '/') {
            startIndex = 8;
        } else {
            startIndex = 7;
        }

        String str = address.substring(startIndex, endIndex);
        String strWWW = str.substring(0,4);
        if (strWWW.equals("www.")){ startIndex = startIndex + 4 ;}
        str = address.substring(startIndex, endIndex);

        if (checkLetterOrDigit(str)) {
            return true;
        } else {
            return false;
        }

    }

    private static boolean checkLetterOrDigit(String str) {
        char[] arr = str.toCharArray();
        boolean flag = true;
        for(char c : arr){
            if (!Character.isLetter(c) && !Character.isDigit(c)) {
                flag = false;
                break;
            }
        }
        return flag;
    }

    private static boolean checkDomain(String address) {

        String str = address.substring((address.length() - 4), (address.length()));
        if (str.equals(".com") || str.equals(".org") || str.equals(".net")) {
            return true;
        } else {
            return false;
        }

    }

    private static boolean checkHttp(String address) {
        String str = address.substring(0, 7);
        String str2 = address.substring(0, 8);

        if (str2.equals("https://") || str.equals("http://")) {
            return true;
        } else {
            return false;
        }
    }

    private static boolean check(String input) {
        return !(input == null || input.equals(null) || input.trim().isEmpty() || input.length() == 0);
    }


    public static void main(String[] args) {
        String address = "http://gromcode.com";
        if (validate(address)){
            System.out.println("true");
        }
        else {
            System.out.println("false");
        }
    }
}
