package HW_1;
//        2. Написать метод, который преобразует массив в ArrayList;
//        ArrayList<String> arrayList = new ArrayList<String>(Arrays.asList(arrays));


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class work2 {
    public static void main(String[] args) {
        String[] arrays = {"1", "2", "3", "4", "5"};

        List<String> listofString = new ArrayList<String>();
        listofString = Arrays.asList(arrays);

        System.out.println("Полученный ArrayList с помощью Arrays.asList()");
        for (String str : listofString) {
            System.out.print(" " + str);
        }

        /////////////////////////////////

        listofString = new ArrayList<String>();

        Collections.addAll(listofString, arrays);

        System.out.println("\n" + "ArrayList с помощью метода Collections.addAll()");
        for (Object o : listofString) {
            System.out.print(" " + o);
        }
    }
}
