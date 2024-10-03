package wood.model;

import java.io.Serializable;

public class Waste implements IWeight, Serializable {

   private float weight;

    @Override
    public float weight() {
        return weight;
    }

    public Waste(float weight) throws Exception {
        if (weight<=0 || weight > 100)
            throw new Exception(weight +" is not correct!\n" + "Must be from >0 to 100");
        this.weight = weight;
    }


    @Override
    public String toString() {
        return "Waste{" +
                "weight=" + weight +
                '}';
    }
}
