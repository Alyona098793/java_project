package wood.model;

import java.io.Serializable;

public class Timber extends AbstractForm implements Serializable {

    private float lehgth;
    private float height;
    private float widht;

    public Timber(Wood wood, float lehgth, float height, float widht) throws Exception {
        super(wood);
        if (lehgth<=0 || lehgth > 40)
            throw new Exception(lehgth +" is not correct!\n" + "Must be from >0 to 40");
        this.lehgth = lehgth;
        if (height<=0 || height > 10)
            throw new Exception(height +" is not correct!\n" + "Must be from >0 to 10");
        this.height = height;
        if (widht<=0 || widht > 10)
            throw new Exception(widht +" is not correct!\n" + "Must be from >0 to 10");
        this.widht = widht;
    }

    public float getLehgth() {
        return lehgth;
    }

    public float getHeight() {
        return height;
    }

    public float getWidth() {
        return widht;
    }

    //визначення об’єму бруса
    public float volume(){
        return lehgth*height*widht;
    }

    @Override
    public String toString() {
        return "Timber{" +
                "wood=" + wood +
                ", lehgth=" + lehgth +
                ", height=" + height +
                ", width=" + widht +
                '}';
    }
}
