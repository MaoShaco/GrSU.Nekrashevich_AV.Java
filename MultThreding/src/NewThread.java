/**
 * Created by Mao on 3/22/2015.
 */
class NewThread implements Runnable {

    double[] b;
    double[] a;
    int stage;

    int inc;
    int start;

    public NewThread(double[] a, int stage, int inc, int start) {
        this.a = a;
        this.stage = stage;
        this.b = new double[a.length];
        this.inc = inc;
        this.start = start;
    }

    public void run(){
        for(int i = start; i < a.length; i += inc){
            for(int k =0; k < stage; k++){
                b[i] += Math.pow(a[i], 1.789);
            }
        }
    }
}
