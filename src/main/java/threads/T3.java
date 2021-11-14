package threads;

public class T3 implements Runnable{
    private  int count =10;

    @Override
    public synchronized void run() {
        count --;
        System.out.println(Thread.currentThread().getName()+"count=="+count);
    }

    public static void main(String[] args) {
        T3 t3 = new T3();
        for (int i = 0; i < 10; i++) {
            new Thread(t3,"thread"+i).start();
        }
    }
}
