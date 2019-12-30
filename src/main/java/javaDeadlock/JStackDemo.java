package javaDeadlock;

public class JStackDemo {
    private static final Object left = new Object();
    private static final Object right = new Object();
    public static void main(String[] args) {
        new Thread(()->{
            while(true){
                synchronized (left) {
                    System.out.println("left " + Thread.currentThread().getName());
                    synchronized (right) {
                        System.out.println("right " + Thread.currentThread().getName());
                    }
                }
            }
        }).start();

        new Thread(()->{
            while(true){
                synchronized (right) {
                    System.out.println("right " + Thread.currentThread().getName());
                    synchronized (left) {
                        System.out.println("left " + Thread.currentThread().getName());
                    }
                }
            }
        }).start();
    }
}
