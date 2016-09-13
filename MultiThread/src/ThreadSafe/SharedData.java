package ThreadSafe;

/**
 * Created by DELL on 2016/7/28.
 */
public class SharedData implements Runnable{
    private int ticket = 10;
    @Override
    public synchronized void run() {
        while(ticket>0){
            ticket--;
            System.out.println("Current Thread is "+ Thread.currentThread()+" 当前票数："+ticket);
        }
    }

    public static void main(String args[]){
        SharedData sharedData = new SharedData();
        new Thread(sharedData).start();
        new Thread(sharedData).start();
    }
}
