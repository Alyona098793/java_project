package wood.test;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.awt.*;
import java.io.File;

public class TestFileChooser {

    public static void main(String[] args) throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

        Frame frame = new Frame();

        FileDialog dialog1 = new FileDialog(frame,"Association Chubby Cheeks", FileDialog.LOAD );

        dialog1.setDirectory("User");
        dialog1.setFile("*.java");

        dialog1.setVisible (true);
        System.out.println(dialog1.getFile());
        System.out.println(dialog1.getDirectory());
        frame.dispose();



        /*JFileChooser dialog = new JFileChooser();
        dialog.setDialogTitle("Association Chubby Cheeks");
        dialog.setApproveButtonText("Відкрити");
        dialog.setMultiSelectionEnabled(true);

        dialog.setFileFilter(new FileFilter() {
            @Override
            public boolean accept(File f) {
                if (f != null){
                    return f.isDirectory() || f.toString().endsWith(".txt");
                }

                return false;
            }

            @Override
            public String getDescription() {
                return "файли типу .txt";
            }
        });


        dialog.showOpenDialog(null);
        File [] ff = dialog.getSelectedFiles();

        if (ff != null){
            for (File f : ff)
            System.out.println(f.getName());
            //System.out.println(f.getAbsolutePath());
        }*/

    }
}
