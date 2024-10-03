package wood.test;

import wood.store.WoodDirectory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream;

public class TestRestoreObject {
    public static void main(String[] args) {
        WoodDirectory wd = null;
        //відновлення довідника з файлами

        File f = new File("wd.object");
        try{
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis);
            wd = (WoodDirectory) ois.readObject();
            ois.close();
        } catch (Exception e){
            e.printStackTrace();
            System.out.println("Помилка під час десеріалізації об'єкта.");
        }


        //виведення довідника на консоль
        if (wd != null){
            for(Object w : wd.getArr())
                System.out.println(w.toString());
        }
    }
}
