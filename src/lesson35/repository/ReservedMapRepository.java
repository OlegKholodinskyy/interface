package lesson35.repository;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class ReservedMapRepository {


    HashMap<Long, ArrayList<Date>> reservedMap = new HashMap<>();

    public HashMap<Long, ArrayList<Date>> getReservedMapFromFile() throws ParseException {
        reservedMap.clear();
        try (BufferedReader br = new BufferedReader(new FileReader("c:\\java\\dateReservesMap.txt"))) {
            String s;
            while ((s = br.readLine()) != null) {
                String[] reserves = s.split(":");
                Long idRoom = Long.parseLong(reserves[0]);
                ArrayList<Date> datesOfResrrvs = getDatesFromFile(reserves[1]);
                reservedMap.put(idRoom, datesOfResrrvs);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return reservedMap;
    }

    // створюємо арейліст дат з стрінги
    private ArrayList<Date> getDatesFromFile(String reservDates) throws ParseException {
        ArrayList<Date> dates = new ArrayList<>();
        String[] str = reservDates.trim().split(",");
        for (String sDate : str) {
            dates.add(new SimpleDateFormat("dd-MM-yyyy").parse(sDate));
        }
        return dates;
    }

    HashMap<Long, String> hashMap = new HashMap<>();

    public HashMap<Long, String> getMapOfReserves() throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("c:\\java\\dateReservesMap.txt"))) {
            String s;
            hashMap.clear();
            while ((s = br.readLine()) != null) {
                String[] reserves = s.split(":");
                Long idRoomInFile = Long.parseLong(reserves[0]);
                String stringOfDates = reserves[1];
                hashMap.put(idRoomInFile, stringOfDates);
            }
        }
        return hashMap;
    }

// date - список дат на які ми добавляємо резерв
    public void saveToFileDateReserves(Long idRoom, ArrayList<Date> dates) throws IOException {

        StringBuffer resultListOfOrderedDates = new StringBuffer();
        HashMap<Long, String> hashMap = getMapOfReserves();
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("c:\\java\\dateReservesMap.txt"))) {
            if (hashMap.containsKey(idRoom)) {
                StringBuffer listDatesAfterAddNewDates = new StringBuffer((hashMap.get(idRoom))).append(fillStringDates(dates));
                hashMap.put(idRoom, listDatesAfterAddNewDates.toString());
            } else {
                hashMap.put(idRoom, fillStringDates(dates).toString());
            }


            for (Map.Entry<Long, String> entry : hashMap.entrySet()) {
                Long key = entry.getKey();
                String value = entry.getValue();
                resultListOfOrderedDates.append(key).append(":").append(value).append("\n");
            }
bw.append("");
            bw.append(resultListOfOrderedDates);

        }

    }

    public StringBuffer fillStringDates(ArrayList<Date> dates) {
        StringBuffer sb = new StringBuffer("");
        for (Date d : dates) {
            sb.append((new SimpleDateFormat("dd-MM-yyyy").format(d)) + ",");
        }
        return sb;
    }

    /*
    1.  зчитати всю мапу . по номеру кімнати reservedMap.get(roomId) знаходимо значення списку дат.
    2.  listDatesAfterDell - видаляємо зі списку ті дати що були в ордері який видаляємо
    3.  resultListOfOrderedDates  - весь файл загружений в память  з видаленими датами
     */
    public void dellDataIfOrderIsDeleted(long roomId, ArrayList<Date> dates) throws ParseException, IOException {
        StringBuffer listDatesAfterDell;
        StringBuffer resultListOfOrderedDates = new StringBuffer();
        HashMap<Long, String> hashMap = getMapOfReserves();

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("c:\\java\\dateReservesMap.txt"))) {


            for (Map.Entry<Long, String> entry : hashMap.entrySet()) {
                Long key = entry.getKey();
                String value = entry.getValue();

                if (key != roomId) {
                    resultListOfOrderedDates.append(key).append(":").append(value).append("\n");
                } else {
                    listDatesAfterDell = cutString(value, dates);
                    resultListOfOrderedDates.append(key).append(":").append(listDatesAfterDell).append("\n");
                }
            }
            bw.append(resultListOfOrderedDates);
            bw.flush();
        }
    }


    private StringBuffer cutString(String sb, ArrayList<Date> dates) {

        StringBuffer listOfDatesAfterDeleting = new StringBuffer();

        ArrayList<String> listOfDates = new ArrayList<String>(Arrays.asList(sb.split(",")));
        ArrayList<String> listOfDatesForCutting = new ArrayList<>();

        for (Date d : dates) {
            listOfDatesForCutting.add(new SimpleDateFormat("dd-MM-yyyy").format(d));
        }

        listOfDates.removeAll(listOfDatesForCutting);

        for (String oneDateInString : listOfDates) {
            listOfDatesAfterDeleting.append(oneDateInString).append(",");
        }

        return listOfDatesAfterDeleting;
    }
}

