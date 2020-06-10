package thread;

import java.util.concurrent.TimeUnit;

/**
 * Created by IntelliJ IDEA.
 * User: XINGHAIFANG
 * Date: 2020/6/9
 * Time: 14:03
 * threadlocal一个线程独享只能在一个线程中获取get
 * threadlocal 线程独有的数据;
 */
public class ThreadLocal2Test {
    static  ThreadLocal<Person> tl = new ThreadLocal<>();

    public static void main(String[] args) {

        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("other thread...." + tl.get());
        }).start();

        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            tl.set(new Person());
            System.out.println(tl.get().name);
        }).start();
    }

    static class Person {
        String name = "zhangsan";
    }
}
