package wood.test;

import java.io.*;
import java.util.Scanner;

public class TestOutput {
   BufferedWriter writer = new BufferedWriter(new FileWriter("Log.txt"));

    public TestOutput() throws IOException {
    }

    public void writeString(String s) throws IOException {
        try {
            writer.write(s);
            writer.newLine();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void start() throws IOException {

        String baseInfo = "It`s ok";
        writeString(baseInfo);

    }

    public static void main(String[] args) throws IOException {
        //TestOutput test1 =new TestOutput();
        //test1.start();
        File file = new File("Log.txt");
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()){
            System.out.println(scanner.nextLine());
        }
        scanner.close();
    }

}



    
        //Формування текстового файлу з числами
        /*try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("f"));
            for (int i = 0; i < 10; i++){
                double x = Math.random();
                String s = String.valueOf(x);
                writer.write(s);
                writer.newLine();
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }*/


   /* public void writeString(String) {

        BufferedReader reader = null;
        if ( f != null){
            try {
                reader = new BufferedReader(new FileReader(f));
                String s;
                while ((s = reader.readLine()) != null){
                    System.out.println(s);
                }
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
    }

    public void start(){
        writer = new BufferedWriter (new FileWriter ("Log.txt"));
    }*/

