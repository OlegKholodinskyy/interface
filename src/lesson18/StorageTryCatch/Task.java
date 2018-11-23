package lesson18.StorageTryCatch;

import java.io.FileNotFoundException;

public class Task {
    public void printer(Storage storage){
        try {
            System.out.println("5th name is "+storage.files[5]);
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("5h name can not be found...");
        }
    }
}
