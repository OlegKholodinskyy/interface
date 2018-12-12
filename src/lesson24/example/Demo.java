package lesson24.example;

import lesson24.example.GeneralDAO;
import lesson24.example.Sys;
import lesson24.example.Tool;

import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {
        GeneralDAO<Sys> systemDAO = new GeneralDAO<>();
        Sys system1 = new Sys(11, "..");

        systemDAO.save(system1);
        System.out.println(Arrays.deepToString(systemDAO.getAll()));
        systemDAO.save(system1);
        System.out.println(Arrays.deepToString(systemDAO.getAll()));

        GeneralDAO<Tool> toolDAO = new GeneralDAO<>();
        Tool tool = new Tool("4rt", "fse");
        toolDAO.save(tool);
        System.out.println(Arrays.deepToString(toolDAO.getAll()));

    }
}
