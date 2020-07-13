package JVM.jmm;

import java.util.concurrent.TimeUnit;


/**
 * Created by IntelliJ IDEA.
 * User: XINGHAIFANG
 * Date: 2020/7/2
 * Time: 17:43
 */
public class TestAdd {
    private static int count;
    public static void main(String[] args) {
        for (int i = 0; i < 10000; i++) {
            new Thread() {
                public void run() {
                    //System.out.println(">>>:");
                    synchronized(TestAdd.class){
                        //System.out.println(">>>>:");
                        count++;
                        //System.out.println("<<<<:");
                    }
                }
            }.start();
        }
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("count:" + count);
    }


}
