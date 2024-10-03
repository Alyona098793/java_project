package wood.test;

import wood.store.WoodDirectory;

import java.io.*;

public class TestInput {
    public static void main(String[] args) {
        File f = new File("f");

        try {
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
        }


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


    }


}
