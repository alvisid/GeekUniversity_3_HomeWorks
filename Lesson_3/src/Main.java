package src;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;

public class Main {

    static class Timer {
        static long t;

        static void start() {
            t = System.currentTimeMillis();
        }

        static void stopAndPrint() {
            System.out.println("time: " + (System.currentTimeMillis() - t));
        }
    }

// 1____________________________________________
// 1. Прочитать файл (около 50 байт) в байтовый массив и вывести этот массив в консоль;
//
//        public static void main(String[] args) throws Exception {
//            Timer.start();
//            FileInputStream in = new FileInputStream("resourse/1.txt");
//            byte[] bytes = new byte[in.available()];
//            StringBuffer sb = new StringBuffer("");
//            in.read(bytes);
//            for (byte aByte : bytes) {
//                sb.append((char) aByte);
//            }
//            System.out.println(new String());
//            in.close();
//            Timer.stopAndPrint();
//        }
//}

//____________________________________________


// 2___________________________________________
// 2. Последовательно сшить 5 файлов в один (файлы примерно 100 байт). Может пригодиться
// следующая конструкция:

//    private ArrayList<InputStream> arrayList1 = new ArrayList<>();
//    Enumeration<InputStream> enumeration = Collections.enumeration(arrayList1);
//
//    public static void main(String[] args) throws IOException {
//        Timer.start();
//        ArrayList<FileInputStream> arrayList2 = new ArrayList<>();
//        arrayList2.add(new FileInputStream("resourse/1.txt"));
//        arrayList2.add(new FileInputStream("resourse/2.txt"));
//        arrayList2.add(new FileInputStream("resourse/3.txt"));
//        arrayList2.add(new FileInputStream("resourse/4.txt"));
//        arrayList2.add(new FileInputStream("resourse/5.txt"));
//        SequenceInputStream sequenceInputStream = new SequenceInputStream(Collections.enumeration(arrayList2));
//
//        int x;
//        while ((x = sequenceInputStream.read()) != -1) {
//            System.out.println((char) x);
//        }
//        sequenceInputStream.close();
//        Timer.stopAndPrint();
//    }
//}


// 3___________________________________________
// 3. Написать консольное приложение, которое умеет постранично читать текстовые файлы
// (размером > 10 mb). Вводим страницу (за страницу можно принять 1800 символов), программа
// выводит ее в консоль. Контролируем время выполнения: программа не должна загружаться
// дольше 10 секунд, а чтение – занимать свыше 5 секунд.


    public static void main(String[] args) throws Exception {
        Timer.start();
        try (RandomAccessFile raf = new RandomAccessFile("str.txt", "r");
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            long fileLength = raf.length();
            long pageLength = 1800;
            long pagesCount = fileLength / pageLength;
            byte[] b = new byte[1800];
            System.out.println("fileLength: " + fileLength + " | pageLength: " + pageLength + " | pagesCount: " + pagesCount);
            while (true) {
                System.out.println("\nEnter the between 0 and " + pagesCount + ". -1 to Exit.");
                long p = Long.parseLong(br.readLine());
                if (p <= pagesCount && p >= 0) {
                    raf.seek(p * pageLength);
                    raf.read(b, 0, b.length);
                    for (byte bb : b) System.out.println((char) bb);
                } else if (p == -1) {
                    System.out.println("Bye!");
                    System.exit(0);
                } else {
                    System.out.println("Incorrect pages: " + p);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        Timer.stopAndPrint();
    }
}




