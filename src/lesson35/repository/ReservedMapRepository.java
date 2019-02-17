package lesson35.repository;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;

public class ReservedMapRepository {
    HashMap<Long, HashSet<Date>> reservedMap = new HashMap<>();

    public HashMap<Long, HashSet<Date>> getReservedMapFromFile() throws ParseException {
        try (BufferedReader br = new BufferedReader(new FileReader("c:\\java\\mapReserves.txt"))) {
            String s;
            while ((s = br.readLine()) != null) {
                String[] reserves = s.split(":");
                Long idRoom = Long.parseLong(reserves[0]);
                HashSet<Date> datesOfResrrvs = getDatesFromFile(reserves[1]);
                reservedMap.put(idRoom, datesOfResrrvs);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    private HashSet<Date> getDatesFromFile(String reservDates) throws ParseException {
        HashSet<Date> dates = new HashSet<>();
        String[] str = reservDates.trim().split(", ");
        for (String sDate : str) {
            dates.add(new SimpleDateFormat("DD-MM-YYYY").parse(sDate));
        }
        return dates;
    }

    public HashMap<Long, HashSet<Date>> saveToFileDateReserves(Long idRoom, HashSet<Date> dates) {
        HashMap<Long, HashSet<Date>> mapDates = new HashMap<>();
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("c:\\java\\dateReservesMap.txt", true))) {
            String s = idRoom + ":" + fillStringDates(dates);
            bw.append(s + "\n");
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return mapDates;
    }

    public StringBuffer fillStringDates(HashSet<Date> dates) {
        StringBuffer sb = new StringBuffer("");
        for (Date d : dates) {
            sb.append((new SimpleDateFormat("DD-MM-YYYY").format(d)) + ",");
        }
        return sb;
    }
}
