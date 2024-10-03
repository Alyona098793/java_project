package wood.model;


import java.io.Serializable;

public class Wood implements Serializable {
    private int id;
    private String name;
    private float density;

    public Wood(int id, String name, float density) throws Exception {
        if (id<=0 )
            throw new Exception(id +" is not correct!\n" + "Must be from > 0");
        this.id = id;
        if (name == null)
            throw new Exception(name +" is not correct!\n" + "Must be not null");
        this.name = name;
        if (density<=0 || density > 5)
            throw new Exception(density +" is not correct!\n" + "Must be from >0 to 5");
        this.density = density;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public float getDensity() {
        return density;
    }

    @Override
    public String toString() {
        return "Wood{" + "id=" + id + ", name='" + name + '\'' + ", density=" + density + '}';
    }
}
