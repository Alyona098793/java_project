package wood.model;

import java.io.Serializable;

public class Cylinder extends AbstractForm implements Serializable {

    private float length;
    private float diameter;


    public Cylinder() {
        super();
    }

    public Cylinder(Wood wood, float length, float diameter) throws Exception {
        super(wood);
        if (length<=0 || length > 40)
            throw new Exception(length +" is not correct!\n" + "Must be from >0 to 40");
        this.length = length;
        if (diameter<=0 || diameter > 5)
            throw new Exception(diameter +" is not correct!\n" + "Must be from >0 to 5");
        this.diameter = diameter;
    }

    public float getLength() {
        return length;
    }

    public float getDiameter() {
        return diameter;
    }

    @Override
    public String toString() {
        return "Cylinder{" +
                "length=" + length +
                ", diameter=" + diameter +
                '}';
    }

    @Override
    public float volume() {
        return (float) ((float) Math.PI*Math.pow(diameter/2, 2));
    }


}
