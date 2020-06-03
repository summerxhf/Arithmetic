package thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by IntelliJ IDEA.
 * User: XINGHAIFANG
 * Date: 2020/6/3
 * Time: 11:14
 */
public class TestCyclicBarrier {
    public static void main(String[] args) {
//        CyclicBarrier cyclicBarrier = new CyclicBarrier(20);
        CyclicBarrier barrier = new CyclicBarrier(20, () -> System.out.println("满人发车"));
        //另外一种写法
           /*CyclicBarrier barrier = new CyclicBarrier(20, new Runnable() {
            @Override
            public void run() {
                System.out.println("满人，发车");
            }
        });*/
        for(int i=0; i<100; i++) {

            new Thread(()->{
                try {
                    barrier.await();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();

        }
    }


}
