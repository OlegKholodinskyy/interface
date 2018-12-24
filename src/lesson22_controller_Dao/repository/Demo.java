package lesson22_controller_Dao.repository;

import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {

        User user1 = new User(111, "nick", "jhkll");
        UserRepository.save(user1);

        User user2 = new User(345, "dfwef", "kjh;l");
        UserRepository.save(user2);

        System.out.println(Arrays.deepToString(UserRepository.getUsers()));
    }
}
