package wood.store;

import wood.events.IProductListener;
import wood.events.ProductEvent;
import wood.model.AbstractForm;
import wood.model.IWeight;
import wood.model.Timber;
import wood.model.Wood;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;


public class ProductStore implements Serializable {
    private IWeight[] arr = new IWeight[3];
    private int count = 0;

    List<IProductListener> productListeners = new CopyOnWriteArrayList<>();

    public void addProductListener(IProductListener listener){
        productListeners.add(listener);
    }
    public void removeProductListener(IProductListener listener){
        productListeners.remove(listener);
    }

    private void fireProductEvent(ProductEvent event){
        productListeners.forEach((lsn) -> lsn.onProductEvent(event));
    }


    //метод для отримання масиву
    public IWeight[] getArr(){
        return Arrays.copyOf(arr, count);
    }
    //додати до каталогу
    public boolean add(IWeight newProduct){
        if (arr.length == count)
            arr =Arrays.copyOf(arr, count + count/2);
        arr[count++] = newProduct;
        ProductEvent event = new ProductEvent(this, newProduct);
        fireProductEvent(event);

        return true;

    }
    //метод підрахунку загальної ваги брусів
    public float calculateTotalWeight(){
        float totalWeight = 0;
        for (IWeight product: getArr()){
            totalWeight += product.weight();
        }
        return totalWeight;

    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Перелік продуктів:\n");
        for (int i = 0; i<count; i ++){
            sb.append(arr[i]).append("\n");
        }
        return sb.toString();
    }
}
