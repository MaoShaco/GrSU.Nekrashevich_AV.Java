/**
 * Created by Mao on 3/22/2015.
 */
public class DuoThreading {

    double[] b;
    double[] a;
    int stage;

    Runnable r, r1, r2;
    Thread t, t1, t2;

    public DuoThreading(double[] a, int stage, int inc) {
        this.a = a;
        this.stage = stage;
        this.b = new double[a.length];

        this.r = new NewThread(a, stage, inc, 1);
        this.t = new Thread(r);

        this.r1= new NewThread(a, stage, inc, 2);
        this.t1 = new Thread(r1);

        this.r2= new NewThread(a, stage, inc, 3);
        this.t2 = new Thread(r2);

    }
    public void Do2Threads(){
        t.start();
        t1.start();
        t2.start();
        for(int i = 0; i < a.length; i += 4) {
            for (int k = 0; k < stage; k++) {
                b[i] += Math.pow(a[i], 1.789);
            }
        }
    }
}
