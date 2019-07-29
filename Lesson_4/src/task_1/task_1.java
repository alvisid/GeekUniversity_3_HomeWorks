package task_1;

//
//1.  Создать три потока, каждый из которых выводит определенную букву (A, B и C) 5 раз (порядок
//    ABСABСABС). Используйте wait/notify/notifyAll.


public class task_1 {
    private final Object mon = new Object();
    private volatile char currentLetter = 'A';

    public static void main(String[] args) {
        task_1 w = new task_1();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public synchronized void run() {
                w.printA();
            }
        });
        Thread t2 = new Thread(new Runnable(){
            @Override
            public synchronized void run() {
                w.printB();
            }
        });
        Thread t3 = new Thread(new Runnable() {
            @Override
            public synchronized void run() {
                w.printC();
            }
        });
        t1.start();
        t2.start();
        t3.start();
    }

    private void printA() {
        synchronized (mon) {
            try {
                for (int i = 0; i < 5; i++) {
                    while (currentLetter != 'A')
                        mon.wait();
                    Thread.sleep(5);
                    System.out.print('A');
                    currentLetter = 'B';
                    mon.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void printB() {
        synchronized (mon) {
            try {
                for (int i = 0; i < 5; i++) {
                    while (currentLetter != 'B')
                        mon.wait();
                    Thread.sleep(5);

                    System.out.print('B');
                    currentLetter = 'C';
                    mon.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void printC() {
        synchronized (mon) {
            try {
                for (int i = 0; i < 5; i++){
                    while (currentLetter != 'C')
                        mon.wait();
                    Thread.sleep(5);

                    System.out.print('C');
                    currentLetter = 'A';
                    mon.notifyAll();
                }
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
