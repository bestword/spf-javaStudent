package threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class T1 {
    /*
    *  常见方法 ：
    *   yield : 暂 退出一下 cpu，到就绪状态
    *   join：当前线程 加入另一个 线程，继续当前线程
    *   interrupt ：中断线程，适用 长时间 waiting ，sleep
    *   TERMINATED ：结束状态
    * */

    //创建线程两种方式
    static class Mythread extends Thread{
        @Override
        public void run() {
            //super.run();
            System.out.println("继承thread 类创建线程");

        }
    }
    static class Mythread1 implements Runnable{

        @Override
        public void run() {
            System.out.println("实现 runnable 接口");
        }
    }

    public static void main(String[] args) {
        //线程启动
        new Mythread().start();  // 第一种
        new Thread(new Mythread1()).start(); //第二种
        new Mythread1().run(); // 方法调用，非线程启动
        new Thread(()->{
            System.out.println("第二种变形 lambdal 表达式");
        }).start();

        /*
        *  第三种  ，线程池 启动 ，new exectors.new catchthread
        * */
        ExecutorService executorService = Executors.newCachedThreadPool(); //线程池
        executorService.execute(()->{
            System.out.println("线程池 启动");
        });
        executorService.shutdown();

    }
}
