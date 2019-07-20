package HW_1;

import java.lang.reflect.Array;

//        1. Написать метод, который меняет два элемента массива местами (массив может быть любого
//        ссылочного типа);
public class work1 {

    public static void main(String[] args) {

        Array[] arrays = new Array[5];

        Array temp = arrays[2];

        arrays[2] = arrays[4];

        arrays[4] = temp;
        
    }
}
