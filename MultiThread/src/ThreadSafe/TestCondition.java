package ThreadSafe;

import java.io.*;
import java.util.Base64;
import java.util.HashMap;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by DELL on 2016/8/31.
 */

    public class TestCondition{
        private static int value = 1;
        private Lock lock = new ReentrantLock();
        private Condition Condition456 = lock.newCondition();
        private Condition Condition789 = lock.newCondition();

        class ThreadA implements Runnable{
            @Override
            public void run(){
                try{
                    lock.lock();
                    System.out.println("首先输出1-3");
                    while(value<=3) {
                        System.out.println(value++);
                    }
                    Condition456.signal();
                }
                finally{
                    lock.unlock();
                }

                try {
                    lock.lock();
                    while(value<=6) {
                        Condition789.await();
                    }
                    System.out.println("输出7-9");
                    while(value<=9) {
                        System.out.println(value++);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally{
                    lock.unlock();
                }

            }
        }

        class ThreadB implements Runnable{
            @Override
            public void run() {
                try {
                    lock.lock();
                    while(value<=3) {
                        Condition456.await();
                    }
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                finally{
                    lock.unlock();
                }

                try{
                    lock.lock();
                    System.out.println("输出4-6");
                    while(value<=6) {
                        System.out.println(value++);
                    }
                    Condition789.signal();
                }
                finally {
                    lock.unlock();
                }
            }
        }

        public static void main(String[] args) throws FileNotFoundException {
            TestCondition test = new TestCondition();
            Thread threadA = new Thread(test.new ThreadA());
            Thread threadB = new Thread(test.new ThreadB());

            threadB.start();
            threadA.start() ;
            File in = new File("");

            BufferedReader fileInputStream = new BufferedReader(new FileReader(in));
            HashMap<String,Integer> hashMap = new HashMap<>();


            if(hashMap.get("s")!=null){
                    hashMap.put("s", hashMap.get("s")+1);
            }
            else
                hashMap.put("s", 1);

            //a[10]

        }
    }


