package thread.interview;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * Created by IntelliJ IDEA.
 * User: XINGHAIFANG
 * Date: 2020/6/4
 * Time: 10:00
 */
public class UseCountDownLatch {
    volatile List lists = new ArrayList();
    public void add(Object o){
        lists.add(o);
    }

    public int size(){
        return lists.size();
    }

    public static void main(String[] args) {
        UseCountDownLatch c = new UseCountDownLatch();
        CountDownLatch countDownLatch1 = new CountDownLatch(1);
        CountDownLatch countDownLatch2 = new CountDownLatch(1);


        new Thread(()->{
            System.out.println("t1 启动");
            for (int i = 0; i < 10; i++) {
                c.add(new Object());
                System.out.println("t1 add " + i);
                if(c.size()==5){
                    //让t2开始运行;
                    countDownLatch1.countDown();
                    try {
                        countDownLatch2.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            System.out.println("t1 结束..");
        },"t1").start();
        //t2
        new Thread(()->{
            try {
                countDownLatch1.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("t2 启动....");
            System.out.println("t2 结束...");
            //让t1继续执行;
            countDownLatch2.countDown();
        },"t2").start();

    }
}
