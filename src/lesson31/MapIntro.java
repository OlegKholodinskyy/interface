package lesson31;

import java.util.HashMap;
import java.util.Map;

public class MapIntro {
    public static void main(String[] args) throws Exception {
        Map<String, Building> map = new HashMap<>();

        Building building = new Building("School",5) ;
        Building building2 = new Building("School1",5) ;
        Building building3 = new Building("School111",5) ;


        map.put("TTT",  building);
        map.put("DDD", building);
        System.out.println(map);

        System.out.println(map.keySet());
        System.out.println(map.values());

        System.out.println(map.get("TTT"));
        System.out.println(map.get("TdddTT"));

        map.remove("TTT");
        System.out.println(map);

        map.put("DDD", building);
        map.put("DDD", building2);
        map.put("DDD", building3);

        System.out.println(map);


        if (map.put("DDD", building)==null){
            throw new Exception("");
        }
    }
}
