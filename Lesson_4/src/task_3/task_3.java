package task_3;

//3.  Написать класс МФУ, на котором возможно одновременно выполнять печать и сканирование
//    документов, но нельзя одновременно печатать или сканировать два документа. При печати в
//    консоль выводится сообщения «Отпечатано 1, 2, 3,... страницы», при сканировании –
//    аналогично «Отсканировано...». Вывод в консоль с периодом в 50 мс

public class task_3 {
    private Object mfu = new Object();
    private volatile char action = 's';
    private int printed = 0, scanned = 0;

    public static void main(String[] args) {
        task_3 t = new task_3();
        t.copyDocuments(150);
    }

    public void printDocuments(int count){
        synchronized (mfu){
            try{
                for (int i = 0; i < count; i++){
                    while(action != 'p') mfu.wait();
                    setPrinted(getPrinted() + 1);
                    System.out.println("printed: " + getPrinted() + " pages");
                    action = 's';
                    Thread.sleep(50);
                    mfu.notifyAll();
                }
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public void scanDocuments(int count){
        synchronized (mfu){
            try{
                for (int i = 0; i < count; i++){
                    while(action != 's') mfu.wait();
                    setScanned(getScanned() + 1);
                    System.out.println("Scanned: " + getScanned() + " pages");
                    action = 'p';
                    Thread.sleep(50);
                    mfu.notifyAll();
                }
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    private void copyDocuments(int count) {
        new Thread(() -> this.scanDocuments(count)).start();
        new Thread(() -> this.printDocuments(count)).start();
    }

    public int getPrinted() {
        return printed;
    }

    public void setPrinted(int printed) {
        this.printed = printed;
    }

    public int getScanned() {
        return scanned;
    }

    public void setScanned(int scanned) {
        this.scanned = scanned;
    }
}
