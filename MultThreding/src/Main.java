import java.util.Random;

public class Main {

    public static void main(String[] args) {

        System.out.println("Start Doing OneThreading");
        long timeForThreading = 0;
        for(int o = 0; o < 10; o++){

            double[] a = new double[100];
            for(int i = 0; i < a.length; i++){
                a[i] = new Random().nextDouble()*(10+10)-10;
            }

            long before = System.currentTimeMillis();
            OneThreading ot = new OneThreading(a, 1000000);
            ot.Powering();
            long after = System.currentTimeMillis();
            long time = (after - before);
            System.out.println(o + "." + time);
            timeForThreading += time;
        }

        System.out.println("Total Time for one Threading = " + timeForThreading);

        System.out.println("Start Doing DuoThreading");
        timeForThreading = 0;
        for(int d = 0; d < 10; d++){

            double[] a = new double[100];
            for(int i = 0; i < a.length; i++){
                a[i] = new Random().nextDouble()*(10+10)-10;
            }

            long before = System.currentTimeMillis();
            DuoThreading dt = new DuoThreading(a, 1000000, 4);
            dt.Do2Threads();
            long after = System.currentTimeMillis();
            long time = (after - before);
            System.out.println(d + "." + time);
            timeForThreading += time;
        }
        System.out.println("Total Time for Duo Threading = " + timeForThreading);

    }
}
