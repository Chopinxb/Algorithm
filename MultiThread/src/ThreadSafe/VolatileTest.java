package ThreadSafe;

import java.util.HashMap;
import java.util.Vector;

/**
 * Created by DELL on 2016/7/17.
 */
public class VolatileTest {
    public static  int race = 0;
    public  static synchronized void increase(){
        race++;
    }

    public static void main(String args[])throws InterruptedException{
        Thread[] threads = new Thread[20];
        for(int i=0;i<20;i++){
            threads[i]= new Thread(new Runnable() {
                @Override
                public void run() {
                    for(int i=0;i<10000;i++){
                        increase();
                    }
                }
            });
            threads[i].start();

        }
        Thread.sleep(60000);
        System.out.print(race);
    }
}
