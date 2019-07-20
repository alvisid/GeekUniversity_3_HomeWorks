package HW_1;

import java.util.ArrayList;

public class AppleBox<AppleBox extends Number> {

    ArrayList<Double> appleBox = new ArrayList<Double>();
    AppleBox[] obj;

    public AppleBox(AppleBox[] obj) {
        this.obj = obj;
    }

    public double getWeight() {
        double Apple = 1.0f;

        for (int i = 0; i < obj.length; i++) {
            Apple += obj[i].doubleValue();
        }

        Apple /= obj.length;
        return Apple;
    }

    public boolean compare(HW_1.AppleBox<?> another) {
        return Math.abs(getWeight() - another.getWeight()) < 0.01f;
    }
}

