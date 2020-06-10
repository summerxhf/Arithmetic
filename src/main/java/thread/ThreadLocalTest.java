package thread;

import java.util.concurrent.TimeUnit;

/**
 * Created by IntelliJ IDEA.
 * User: XINGHAIFANG
 * Date: 2020/6/9
 * Time: 10:45
 * //一个线程输出,一个线程设置name为lisi;
 */
public class ThreadLocalTest {
    static class Person{
        String name = "zhangsan";
    }
    volatile static Person p = new Person();


    public static void main(String[] args) {
        new Thread(()->{
            try{
                TimeUnit.SECONDS.sleep(2);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println(p.name);
        }).start();

        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            p.name="lisi";
        }).start();
    }
}


