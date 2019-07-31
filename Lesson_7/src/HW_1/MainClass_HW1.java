package HW_1;


import com.sun.istack.internal.NotNull;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class MainClass_HW1 {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, InstantiationException {
//        start(HW_1.Test.class);
//        System.out.println();
        start(Test1_HW1.class);
        System.out.println();
        start(Test2_HW1.class);
        System.out.println();
        start(Test3_HW1.class);
        System.out.println();
//        start(HW_1.Test4.class);
//        System.out.println();

    }

    public static void start(@NotNull Class c) throws InvocationTargetException, IllegalAccessException, InstantiationException {
        Method[] methods = c.getDeclaredMethods();
        int bsCount = 0, asCount = 0;
        List<Method> tests = new ArrayList<>();

        //check on uniqueness for DEFORE & AFTER SUITES. Adding TEST to ArrayList
        for (Method o : methods) {
            String type = o.getDeclaredAnnotations()[0].annotationType().getSimpleName();
            if (type.equals("HW_1.BeforeSuite")) {
                bsCount++;
                if (bsCount > 1) throw new RuntimeException("You can use only 1 before annotation.");
            } else if (type.equals("HW_1.AfterSuite")) {
                asCount++;
                if (asCount > 1) throw new RuntimeException("You can use only 1 after annotation.");
            } else if (type.equals("HW_1.Test")) {
                tests.add(o);
            }
        }

        //Sort TESTS list by VALUE
        tests.sort((o1, o2) -> o1.getAnnotation(Test_HW1.class).value() - o2.getAnnotation(Test_HW1.class).value());

        //Add BEFORESUITE to begin of TESTS & AFTER SUITE to the end.
        for (Method o : methods) {
            String type = o.getDeclaredAnnotations()[0].annotationType().getSimpleName();
            if (type.equals("HW_1.BeforeSuite")) {
                tests.add(0, o);
            }
            if (type.equals("HW_1.AfterSuite")) {
                tests.add(o);
            }
        }

        //Show info. Run TEST
        for (Method i : tests) {
            try {
                System.out.print("(" + i.getDeclaredAnnotation(Test_HW1.class).value() + ") ");
            } catch (NullPointerException e) {

            }
            i.invoke(c.newInstance(), null);
        }
    }

    public static void start(String className) {
        try {
            Class<?> c = Class.forName(className);
            Constructor<?> constructor = c.getConstructor(null);
            start(c);
        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
