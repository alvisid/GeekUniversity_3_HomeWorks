package task_1;

public class task_1_2 {
    private static final Object mon = new Object();
    private volatile char currentLetter = 'A';

    public static void main(String[] args) {

        new Thread(new Runnable() {
            @Override
            public synchronized void run() {
                for (int i = 0; i < 5; i++){
                    System.out.print("A");
                    try {
//                        mon.wait(5);
                        Thread.sleep(5);
                        notifyAll();

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public synchronized void run() {
                for (int i = 0; i < 5; i++){
                    System.out.print("B");
                    try{
//                        mon.wait(5);
                        Thread.sleep(5);
                        notifyAll();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public synchronized void run() {
                for (int i = 0; i < 5; i++){
                    System.out.print("C");
                    try{
//                        mon.wait(5);
                        Thread.sleep(5);
                        notifyAll();

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}
