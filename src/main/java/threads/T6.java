package threads;

import java.util.Timer;
import java.util.concurrent.TimeUnit;
/*
*  synchronized 锁升级
* 早期开始 ：锁是重量级锁，由CPU OS进行锁的强占
* 改进锁升级： 第一个 线程 进来是没有锁，但会记录线程ID == 偏向锁
*           其他线程争用时 ，升级为 自旋锁，用户态不过内核占CPU，等待状态，  默认自旋 10 ， 升级为 重量级锁OS,就绪状态
*   执行时间短，线程数少，用自旋锁
*   反之 用 重量系统锁
* */

public class T6 {
    private  int count =10;
    synchronized void m1(){
        for (int i = 0; i < 10; i++) {
            count++;
            System.out.println(Thread.currentThread().getName()+"==== count= "+count);
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (count == 16){
                int m=1/0;
            }
        }
    }

    public static void main(String[] args) {
        T6 t6= new T6();
        new Thread(t6::m1," thread1 ：").start();
        try {
            TimeUnit.MICROSECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(t6::m1," thread2 ：").start();

    }
}
