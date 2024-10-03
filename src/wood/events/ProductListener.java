package wood.events;

public class ProductListener implements IProductListener {

    public void onProductEvent(ProductEvent e){
        System.out.println(e);
    }
}
