package lesson35.repository;

import lesson35.exception.BadRequestException;

import java.io.*;

public class RepositoryHelper {

    // append file
    public static void append(String objectString, File file) throws IOException {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true))) {
            bufferedWriter.append(objectString + "\n");
        }
    }


    //load File To StringBuffer Except Object With Necessary Id
    public static StringBuffer excludeRequired(long id, File file) throws IOException {
        StringBuffer stringBuffer = new StringBuffer();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String objInString;
            while ((objInString = bufferedReader.readLine()) != null) {
                String arrObjects[] = objInString.split(", ");
                if (Long.parseLong(arrObjects[0]) != id) {
                    stringBuffer.append(objInString + "\n");
                }
            }
            return stringBuffer;
        }
    }

    public static StringBuffer excludeRequired(long roomId, long userId, File file) throws IOException {
        StringBuffer stringBuffer = new StringBuffer();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String orderInString;
            while ((orderInString = bufferedReader.readLine()) != null) {
                String orderInArr[] = orderInString.split(", ");
                if (Long.parseLong(orderInArr[1]) == userId && Long.parseLong(orderInArr[2]) == roomId) {
                    continue;
                } else {
                    stringBuffer.append(orderInString + "\n");
                }
            }
            return stringBuffer;
        }
    }

    // write to File
    public static void writeToFile(StringBuffer buffer, File file) throws IOException {
        try (BufferedWriter br = new BufferedWriter(new FileWriter(file))) {
            br.append(buffer);
        }
    }

    // get by id in String Presentation
    public static String getStringById(Long id, File file) throws IOException {
        StringBuffer stringBuffer = new StringBuffer();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String objInString;
            while ((objInString = bufferedReader.readLine()) != null) {
                String arrObjects[] = objInString.split(", ");
                if (Long.parseLong(arrObjects[0]) == id) {
                    return objInString;
                }
            }
        }
        return null;
    }
}