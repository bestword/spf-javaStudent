package threads;

import java.util.concurrent.TimeUnit;

public class T_1114 extends  Thread{

    public static void main(String[] args) {
       // new T_1114().run();  //方法调用 ，同步

        new T_1114().start(); //线程 启动,异步

        for (int i = 0; i < 10; i++) {
            try {
                TimeUnit.MICROSECONDS.sleep(1);
            }catch (Exception e){
                e.printStackTrace();
            }
            System.out.println("main");
        }
    }


    @Override
    public void run() {
       // super.run();
        for (int i = 0; i < 10; i++) {
            try {
                TimeUnit.MICROSECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("t1");
        }

    }
}
