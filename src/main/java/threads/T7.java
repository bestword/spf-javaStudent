package threads;

public class T7 {
    private static Object o;
    private int count =10;
    public static void main(String[] args) {
        T7 t7 = new T7();
        for (int i = 0; i < 10; i++) {
            o=3456435;
            new Thread(t7::m1,"t7").start();
            o=121;
        }
    }
    public void m1(){
        synchronized (o){
            System.out.println(o+"count== :"+--count);
        }
    }
}
