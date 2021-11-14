package threads;

public class T5 {
    /*
    * synchronized :必须是可重入锁，锁的是对象，不加指定锁this
    * 出现异常，默认情况下 锁会被释放
    * */

    synchronized  void m1(){
        try {
            System.out.println(Thread.currentThread().getName()+" : m1===s");
            Thread.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        m2();
        System.out.println(Thread.currentThread().getName()+" : m1====e");
    }
    synchronized  void m2(){
        try {
            System.out.println(Thread.currentThread().getName()+" : m2===stars");
            Thread.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        T5 t5= new T5();
        /*for (int i = 0; i < 10; i++) {
            new Thread(t5::m1,"thread: "+i).start();
        }*/
        t5.m1();
        new Thread(new Runnable() {
            @Override
            public void run() {
                t5.m1();
            }
        },"jdk8中lambdal 写法的解释").start();
    }

}
