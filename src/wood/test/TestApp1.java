package wood.test;

import wood.events.IProductListener;
import wood.events.ProductEvent;
import wood.events.ProductListener;
import wood.model.Timber;
import wood.model.Waste;
import wood.store.ProductStore;
import wood.store.WoodDirectory;

import javax.swing.*;

public class TestApp1 {



    private WoodDirectory wd = new WoodDirectory();
    private ProductStore ps = new ProductStore();


    public static void main(String[] args) throws Exception {
        TestApp1 app = new TestApp1();
        app.startApp();

    }

    private void startApp() throws Exception {

        ps.addProductListener((e -> System.err.println(e)));

        ps.addProductListener(new IProductListener(){
            @Override
            public void onProductEvent(ProductEvent e){
                System.out.println("***" + e);
            }
        });

        ProductListener listener = new ProductListener();
        ps.addProductListener(listener);
        ps.add(new Timber(wd.get(1), 10f, 0.3f, 0.4f));
        ps.add(new Timber(wd.get(2), 12f, 0.3f, 0.4f));
        /*try {
            ps.add(new Waste((float) 200));
        } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Введення продуктів", JOptionPane.ERROR_MESSAGE);
        }*/

        System.out.println(ps.toString());
        System.out.println("Загальна вага брусів = " + ps.calculateTotalWeight());
    }
}
