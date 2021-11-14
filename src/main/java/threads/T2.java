package threads;

import java.util.concurrent.TimeUnit;

public class T2 {
    /*
    * synchronized
    * */

    private int counts =10;
    private  Object o = new  Object();
    public static T2 t2;

    public T2() {
    }

    public void m(){
        synchronized (o){
            counts --;
            System.out.println(Thread.currentThread().getName()+"---"+ counts+"---");
        }
    }

    public static void main(String[] args) {
        t2 = new T2();
        new Mythread1().start();
        //new Mythread2().start();
    }

    static class Mythread1 extends Thread{


        @Override
        public void run() {

            for (int i = 0; i < 10; i++) {
                t2.m();
                try {
                    TimeUnit.MICROSECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    static class Mythread2 extends Thread{
        @Override
        public void run() {

            for (int i = 0; i < 10; i++) {
                t2.m();
                try {
                    TimeUnit.MICROSECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
