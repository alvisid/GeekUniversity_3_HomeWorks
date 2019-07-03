package HW_1;

import java.util.ArrayList;

public class OrangeBox<OrangeBox extends Number> {

    ArrayList<Double> orangeBox = new ArrayList<Double>();

    OrangeBox[] obj;

    public OrangeBox(OrangeBox[] obj) {
        this.obj = obj;
    }

    public double getWeight() {
        double Orange = 1.5f;
        for (int i = 0; i < obj.length; i++) {
            Orange += obj[i].doubleValue();
        }
        Orange /= obj.length;
        return Orange;
    }

    public boolean compare(HW_1.OrangeBox<?> another) {
        return Math.abs(getWeight() - another.getWeight()) < 0.01f;
    }
}
