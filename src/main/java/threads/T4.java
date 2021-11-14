package threads;

public class T4 {

    public void m1(){
        try {
            System.out.println("m1==start");
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("m1==end");
    }
    public  void m2(){
        try {
            Thread.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("m2===start");
    }

    public static void main(String[] args) {
        T4 t4 = new T4();
        new Thread(t4::m1,"m1").start();
        new Thread(t4::m2,"m2").start();

    }
}
