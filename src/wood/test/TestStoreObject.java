package wood.test;

import wood.model.Wood;
import wood.store.WoodDirectory;

import java.io.*;

public class TestStoreObject {
    public static void main(String[] args) throws Exception {
       WoodDirectory wd = new WoodDirectory();

        //додаємо новий вид деревини
        wd.add(new Wood(4, "Дуб", 1f));
        //сереалізація
        try {
            FileOutputStream fos = new FileOutputStream("wd.object");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(wd);
            oos.close();
        } catch (Exception e){
            e.printStackTrace();
        }


        // Десеріалізація об'єкта
        WoodDirectory wdDeserialized = null;
        File f = new File("wd.object");
        try {
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis);
            wdDeserialized = (WoodDirectory) ois.readObject();
            ois.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Помилка під час десеріалізації об'єкта.");
        }

        // Виведення довідника на консоль
        if (wdDeserialized != null) {
            for (Object w : wdDeserialized.getArr()) {
                System.out.println(w.toString());
            }
        } else {
            System.out.println("wdDeserialized залишився null.");
        }

    }
}
