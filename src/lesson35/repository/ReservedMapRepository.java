package lesson35.repository;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;

public class ReservedMapRepository {
    HashMap<Long, ArrayList<Date>> reservedMap = new HashMap<>();

    public HashMap<Long, ArrayList<Date>> getReservedMapFromFile() throws ParseException {
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


    private ArrayList<Date> getDatesFromFile(String reservDates) throws ParseException {
        ArrayList<Date> dates = new ArrayList<>();
        String[] str = reservDates.trim().split(",");
        for (String sDate : str) {
            dates.add(new SimpleDateFormat("dd-MM-yyyy").parse(sDate));
        }
        return dates;
    }
/*

saveToFileDateReserves    ????????????//

 */
    public HashMap<Long, ArrayList<Date>> saveToFileDateReserves(Long idRoom, ArrayList<Date> dates) {
        HashMap<Long, ArrayList<Date>> mapDates = new HashMap<>();
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("c:\\java\\dateReservesMap.txt", true))) {
            String s = idRoom + ":" + fillStringDates(dates);
            bw.append(s + "\n");
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return mapDates;
    }

    public StringBuffer fillStringDates(ArrayList<Date> dates) {
        StringBuffer sb = new StringBuffer("");
        for (Date d : dates) {
            sb.append((new SimpleDateFormat("dd-MM-yyyy").format(d)) + ",");
        }
        return sb;
    }
}
