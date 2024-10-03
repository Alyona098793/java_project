package wood.store;

import wood.model.Wood;

import java.io.Serializable;
import java.util.Arrays;

public class WoodDirectory implements Serializable {
    private Wood[] arr = new Wood[3];
    private int count = 0;
 //ініціалізуємо
    {
        try {
            arr[0] = new Wood (1, "Модрина", 1.1f) ;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        try {
            arr[1] = new Wood(2, "Ялина", 0.9f);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        try {
            arr[2] = new Wood(3, "Сосна", 0.7f);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        count = 3;
    }
//метод для отримання масиву
    public Wood[] getArr(){
        return Arrays.copyOf(arr, count);
    }
//вибрати деревину з каталогу
    public Wood get (int id){
        for (int i = 0; i < count; i++){
            if(arr[i].getId() == id) return arr[i];
        }
        return null;
    }

    //додати до каталогу
    public boolean add(Wood newWood){
        if (get(newWood.getId()) != null)
            return false;
        if (arr.length == count)
            arr =Arrays.copyOf(arr, count + count/2);
        arr[count++] = newWood;
        return true;
    }
//метод для виведення каталогу
    public String toString(){
        StringBuilder sb = new StringBuilder("Каталог деревини:\n");
        for (int i = 0; i<count; i ++){
            sb.append(arr[i]).append("\n");
        }
        return sb.toString();
    }

}
