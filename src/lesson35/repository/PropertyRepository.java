package lesson35.repository;

import lesson35.service.Loaders;

import java.io.*;
import java.util.Map;

public class PropertyRepository {

    public static void incrementIdsAndLoadToFile (String string) {
        long currentID;

        if (string.equals("idUser")) {
            currentID = Loaders.getMapObjectIds().get("idUser");
            Loaders.getMapObjectIds().put("idUser", ++currentID);
        }

        if (string.equals("idOrder")) {
            currentID = Loaders.getMapObjectIds().get("idOrder");
            Loaders.getMapObjectIds().put("idOrder", ++currentID);
        }

        if (string.equals("idRoom")) {
            currentID = Loaders.getMapObjectIds().get("idRoom");
            Loaders.getMapObjectIds().put("idRoom", ++currentID);
        }
        if (string.equals("idHotel")) {
            currentID = Loaders.getMapObjectIds().get("idHotel");
            Loaders.getMapObjectIds().put("idHotel", ++currentID);
        }

        StringBuffer stringBuffer = new StringBuffer();
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\java\\settings.txt"))) {
            for (Map.Entry<String,Long> entry : Loaders.getMapObjectIds().entrySet()){
                bw.append(entry.getKey() + ":" + entry.getValue() + "\n");
                }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
