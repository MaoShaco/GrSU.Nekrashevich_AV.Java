/**
 * Created by Mao on 3/22/2015.
 */
public class OneThreading {

    double[] b;
    double[] a;
    int stage;

    public OneThreading(double[] a, int stage){
        this.a = a;
        this.stage = stage;
        this.b = new double[a.length];
    }
    public void Powering(){
        for(int i = 0; i < a.length; i++){
            for(int k =0; k < stage; k++){
                b[i] += Math.pow(a[i], 1.789);
            }
        }
    }
}
