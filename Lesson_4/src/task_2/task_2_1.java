package task_2;
//2.  Написать небольшой метод, в котором 3 потока построчно пишут данные в файл (по 10
//    записей с периодом в 20 мс).

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class task_2_1 {
    public static void main(String[] args) {
        printToFile pf = new printToFile();
        new Thread(() -> pf.printToFile("thread1")).start();
        new Thread(() -> pf.printToFile("thread2")).start();
        new Thread(() -> pf.printToFile("thread3")).start();
    }

    private static class printToFile {
        private Object m = new Object();

        public void printToFile(String s) {
            for (int i = 0; i < 10; i++){
                synchronized (m) {
                    try (BufferedWriter bw = new BufferedWriter(new FileWriter("123.txt", true))){
                        bw.write(s);
                        bw.newLine();
                        System.out.println(s + " printing");
                    } catch (IOException e){
                        e.printStackTrace();
                    }
                }
                try {
                    Thread.sleep(200);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }
}
