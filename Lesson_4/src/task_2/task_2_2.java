package task_2;
//2.  Написать небольшой метод, в котором 3 потока построчно пишут данные в файл (по 10
//    записей с периодом в 20 мс).

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class task_2_2 {
    private static final String FILE_NAME = "file.txt";
    private static final int MESSENGERS_COUNT = 10;

    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        CountDownLatch latch = new CountDownLatch(MESSENGERS_COUNT + 1);
        ExecutorService es  = Executors.newFixedThreadPool(4);
        FileWriter writer = null;
        try{
            writer = new FileWriter(FILE_NAME, false);
            for (int i = 0; i < MESSENGERS_COUNT; i++){
                es.execute(new Messenger("mess " + i, lock, writer, latch));
            }
        } catch (FileNotFoundException e){
            System.out.println("Cant't open " + FILE_NAME );
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("IO Error");
            e.printStackTrace();
        }
        es.shutdown();
        latch.countDown();
        try {
            latch.await();
        }catch (InterruptedException e){
            e.printStackTrace();
        } try {
            /*!!!*/
            assert writer != null;
            /*!!!*/
            writer.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private static class Messenger implements Runnable {

        private String name;
        private Lock lock;
        private FileWriter fw;
        private CountDownLatch latch;
        private final int MESSAGE_COUNT = 3;

        public Messenger(String name, Lock lock, FileWriter fw, CountDownLatch latch) {
            super();
            this.name = name;
            this.lock = lock;
            this.fw = fw;
            this.latch = latch;
        }

        @Override
        public void run() {

            for (int i = 0; i < MESSAGE_COUNT; i++){
                lock.lock();
                try{
                    fw.write("Thread " + name + " message #" + (i + 1) + "\n");
                    fw.flush();
                }catch (IOException e){
                    System.out.println("IO Error in thread " + name + e.getLocalizedMessage());
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }
            }
            latch.countDown();

        }
    }
}
