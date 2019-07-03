package HW_1;

import java.util.ArrayList;

//        3. Задача:
//        a. Даны классы Fruit -> Apple, Orange;
//        b. Класс Box, в который можно складывать фрукты. Коробки условно сортируются по
//        типу фрукта, поэтому в одну коробку нельзя сложить и яблоки, и апельсины;
//        c. Для хранения фруктов внутри коробки можно использовать ArrayList;
//        d. Сделать метод getWeight(), который высчитывает вес коробки. Задать вес одного
//        фрукта и их количество: вес яблока – 1.0f, апельсина – 1.5f (единицы измерения не
//        важны);
//        e. Внутри класса Box сделать метод Compare, который позволяет сравнить текущую
//        коробку с той, которую подадут в Compare в качестве параметра. True – если их массы
//        равны, False в противоположном случае. Можно сравнивать коробки с яблоками и
//        апельсинами;
//        f. Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую.
//        Помним про сортировку фруктов: нельзя яблоки высыпать в коробку с апельсинами.
//        Соответственно, в текущей коробке фруктов не остается, а в другую перекидываются
//        объекты, которые были в первой;
//        g. Не забываем про метод добавления фрукта в коробку.
public class Main {

    public static void main(String[] args) {
        ArrayList<Integer> allInt = new ArrayList<Integer>();
        ArrayList<Number> allNumb = new ArrayList<Number>();

        copyElements(allInt, allNumb);
    }

    ;

    public static void printNumber(Number number) {
        System.out.println(number);
    }

    ;

    public static <T extends Number> boolean compareTwoBoxes(AppleBox<T> box1, OrangeBox<T> box2) {
        return true;
    }

    ;

    public static <T> void copyElements(ArrayList<? extends T> src, ArrayList<T> dst) {
        for (int i = 0; i < src.size(); i++) {
            dst.add(src.get(i));
        }
    }

    ;

    public static double calcAvg(ArrayList<? extends Number> allNumb) {
        double d = 0.0;
        for (int i = 0; i < allNumb.size(); i++) {
            d += allNumb.get(i).doubleValue();
        }
        d /= allNumb.size();
        return d;
    }

    ;

    interface Apple {
    }

    interface Orange {
    }

    class Fruit {
    }

    class Box {
    }

    class GenClass<T extends Apple & Orange> {
    }

}
