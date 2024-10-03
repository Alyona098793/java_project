package wood.test;

import wood.model.Wood;
import wood.store.WoodDirectory;

public class TestWoodDirectory {

    public static void main(String[] args) {
        WoodDirectory wd = new WoodDirectory();

        System.out.println(wd.get(3)+"\n");
        // Створюємо новий вид деревини
        Wood w = null;
        try {
            w = new Wood(4, "Дуб", 1f);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        // Перевіряємо метод додавання
        if(wd.add(w))
            System.out.println(wd);
        // Спроба додати з існуючим id
        if(!wd.add(w))
            System.out.println(w + " вже існує\n");
    }


}
