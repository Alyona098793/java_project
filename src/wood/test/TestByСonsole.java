package wood.test;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import wood.events.ProductListener;
import wood.model.Cylinder;
import wood.model.Timber;
import wood.model.Waste;
import wood.model.Wood;
import wood.store.ProductStore;
import wood.store.WoodDirectory;

import javax.swing.*;

public class TestByСonsole {
//    /BufferedWriter writer = new BufferedWriter(new FileWriter("Log.txt"));

    public TestByСonsole() throws IOException {
    }

    public void writeString(String s) throws IOException {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter("Log.txt", true));) {
            writer.write(s);
            writer.newLine();
            //writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {

        TestByСonsole test1 = new TestByСonsole();

        Test test = new Test();

        //Визначаємо та форматуємо дату
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        //приводимо до строкового значення
        String dataFormat = now.format(myFormatObj);
        //записуємо в файл дату та ім'я студента
        test1.writeString(String.valueOf(dataFormat));
        test1.writeString("Association of chubby cheeks");

        Scanner scanner = new Scanner(System.in);
        int menuItem;
        int menuItemSerialization;

        while (true) {
            test.selectMenuItem();
            menuItem = scanner.nextInt();

            switch (menuItem) {
                case 1:
                    test.addWood1();
                    break;
                case 2:
                    test.addTimber();
                    break;
                case 3:
                    test.addCylinder();
                    break;
                case 4:
                    test.addWaste();
                    break;
                case 5:
                    System.out.println("Total weight of products = " + test.ps.calculateTotalWeight());
                    break;
                case 6:
                    System.out.println("Виберіть пункт миню");
                    boolean i = true;
                    while (i) {
                        test.selectMenuItemSerialization();
                        menuItemSerialization = scanner.nextInt();

                        switch (menuItemSerialization) {
                            case 1:
                                test.serializationWoodCatalog();
                                break;
                            case 2:
                                test.serializationListProduct();
                                break;
                            case 3:
                                test.deserializationWoodCatalog();
                                break;
                            case 4:
                                test.deserializationListProduct();
                                break;
                            case 5:
                                test.outputProductFile();
                                break;
                            case 6:
                                //System.out.println("Total weight of products = " + test.ps.calculateTotalWeight());
                                break;
                            case 7:
                                System.out.println("Exit the serialization menu");
                                i = false;
                            default:
                                System.out.println("Invalid menu item. Select again.");
                                break;
                        }
                    } break;
                case 7:
                    System.out.println("Exit the program.");
                    return;
                default:
                    System.out.println("Invalid menu item. Select again.");
                    break;
            }
        }


    }
}

class Test{

    TestByСonsole test2 = new TestByСonsole();

    Scanner scanner = new Scanner(System.in);
    WoodDirectory wd = new WoodDirectory();
    ProductStore ps = new ProductStore();

    Test() throws IOException {
    }

    public  void selectMenuItem() {
            System.out.println("Select a menu item:\n" +
                    "1. Add wood\n" +
                    "2. Add a beam\n" +
                    "3. Add a cylinder\n" +
                    "4. Add a waste\n" +
                    "5. Calculate the total weight\n" +
                    "6. Other functions\n" +
                    "7. Finish the work");
        }




        public void checkInputFloat(){
            while (!scanner.hasNextFloat()) {
                System.out.println("Invalid input. Please enter a valid float number for the wood density, for example: 0,9");
                scanner.next(); // "З'їсти" некоректне введення
            }
        }
    public void addWood1(){
        boolean repeat = false;
        do {

            System.out.println("Enter the id of the wood, for example: 4");
            int id = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Enter the name of the wood, for example: oak");
            String name = scanner.nextLine();
            System.out.println("Enter the wood density, for example: 0,9f");
            checkInputFloat();
            float density = scanner.nextFloat();


            try {
                Wood w = new Wood (id, name, density);
                // Спроба додати з існуючим id
                if(!wd.add(w)) {
                    System.out.println("Wood with id " + id + " already exists " + wd);
                }else
                    System.out.println("You have added new wood to the catalog: " + wd);
                    String woodString = w.toString();
                    test2.writeString("Added new wood " + woodString);
                    repeat = true;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Введення продуктів", JOptionPane.ERROR_MESSAGE);

            }
        }while (!repeat);


    }

    public void addTimber(){
        boolean repeat = false;
        do {
            System.out.println("Enter the id of the wood, for example: 4");
            Wood wood = wd.get(scanner.nextInt());
            scanner.nextLine();
            System.out.println("Enter the Timber length, for example: 2,7f");
            checkInputFloat();
            float length = scanner.nextFloat();
            System.out.println("Enter the Timber height, for example: 0,9f");
            checkInputFloat();
            float height = scanner.nextFloat();
            System.out.println("Enter the Timber width, for example: 1.1f");
            checkInputFloat();
            float width = scanner.nextFloat();

            try {
                ProductListener listener = new ProductListener();
                ps.addProductListener(listener);

                ps.add(new Timber(wood, length, height, width));
                System.out.println("You have added new timber to the catalog: " + ps);
                String timberString = ps.toString();
                test2.writeString("Added new timber " + timberString);
                repeat = true;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Введення продуктів", JOptionPane.ERROR_MESSAGE);

            }
        }while (!repeat);
    }

    public void addCylinder() {
            boolean repeat = false;
            do {
                System.out.println("Enter the id of the wood, for example: 4");
                Wood wood = wd.get(scanner.nextInt());
                scanner.nextLine();
                System.out.println("Enter the Cylinder length, for example: 2,7f");
                checkInputFloat();
                float length = scanner.nextFloat();
                System.out.println("Enter the Cylinder diameter, for example: 0,9f");
                checkInputFloat();
                float diameter = scanner.nextFloat();

                try {
                    ps.add(new Cylinder(wood, length, diameter));
                    System.out.println("You have added new cylinder to the catalog: " + ps);
                    String cylinderString = ps.toString();
                    test2.writeString("Added new cylinder " + cylinderString);
                    repeat = true;
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e.getMessage(), "Введення продуктів", JOptionPane.ERROR_MESSAGE);

                }
            }while (!repeat);

    }

    public void addWaste(){
        boolean repeat = false;
        do {
            System.out.println("Enter the Waste weight, for example: 2,7f");
            checkInputFloat();
            float weight = scanner.nextFloat();

        try {
            ps.add(new Waste(weight));
            System.out.println("You have added new waste to the catalog: " + ps);
            String wasteString = ps.toString();
            test2.writeString("Added new waste " + wasteString);

            repeat = true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Введення продуктів", JOptionPane.ERROR_MESSAGE);
        }
        }while (!repeat);

    }

    public  void selectMenuItemSerialization() {
        System.out.println("Select a menu item:\n" +
                "1. Serialization of the wood catalog\n" +
                "2. Serialization of the list of shipped products\n" +
                "3. Deserialization of the wood directory\n" +
                "4. Deserialization of the list of sent products\n" +
                "5. Output of the list of shipped products to a text file\n" +
                "6. Logging of product input actions in a text file\n" +
                "7. Finish the work");
    }

    public void serializationWoodCatalog(){

        //сереалізація
        try {
            FileOutputStream fos = new FileOutputStream("wd.object");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(wd);
            oos.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void serializationListProduct(){

        //сереалізація
        try {
            FileOutputStream fos = new FileOutputStream("ps.object");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(ps);
            oos.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void deserializationWoodCatalog(){

        //десереалізація
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

    public void deserializationListProduct(){

        //десереалізація
        ProductStore ps = null;
        //відновлення довідника з файлами

        File f = new File("ps.object");
        try{
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis);
            ps = (ProductStore) ois.readObject();
            ois.close();
        } catch (Exception e){
            e.printStackTrace();
            System.out.println("Помилка під час десеріалізації об'єкта.");
        }


        //виведення довідника на консоль
        if (ps != null){
            for(Object p : ps.getArr())
                System.out.println(p.toString());
        }
    }

    public void outputProductFile(){
        File textProduct = new File("textProduct");

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("textProduct"));
            writer.write(ps.toString());
            System.out.println(ps.toString());
            writer.newLine();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


        BufferedReader reader = null;
        if ( textProduct != null){
            try {
                reader = new BufferedReader(new FileReader(textProduct));
                String s;
                while ((s = reader.readLine()) != null){
                    System.out.println(s);
                }
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }




}







