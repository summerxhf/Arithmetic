package thread;

/**
 * Created by IntelliJ IDEA.
 * User: XINGHAIFANG
 * Date: 2020/6/2
 * Time: 11:45
 */
public class c_005 implements Runnable {
    private volatile int count=100;
    public /*synchronized*/ void run(){
        count--;
        System.out.println(Thread.currentThread().getName()+ " count =" + count);
    }

    public  static void main(String[] args) {
        c_005 t = new c_005();
        for (int i = 0; i < 100; i++) {
            new Thread(t,"THREAD"+i).start();
        }
    }
}
