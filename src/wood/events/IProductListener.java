package wood.events;

import java.util.EventListener;

public interface IProductListener extends EventListener {

    public void onProductEvent(ProductEvent e);


}
