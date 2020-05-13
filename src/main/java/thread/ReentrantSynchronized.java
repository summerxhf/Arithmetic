package thread;

import java.util.concurrent.TimeUnit;

/**
 * Created by IntelliJ IDEA.
 * User: XINGHAIFANG
 * Date: 2020/5/13
 * Time: 15:53
 * 可以进入方法一,同时方法一调用方法二也可以进入方法二
 */
public class ReentrantSynchronized {
    synchronized void m1() throws InterruptedException {
        System.out.println("m1 start");
        TimeUnit.SECONDS.sleep(1);
        m2();
        System.out.println("m1 end");
    }
    synchronized void m2() throws InterruptedException{
        TimeUnit.SECONDS.sleep(2);
        System.out.println("m2");
    }

    public static void main(String[] args) throws InterruptedException{
        new ReentrantSynchronized().m1();
    }
}
