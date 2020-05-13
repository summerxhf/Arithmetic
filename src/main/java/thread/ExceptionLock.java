package thread;

import java.util.concurrent.TimeUnit;

/**
 * Created by IntelliJ IDEA.
 * User: XINGHAIFANG
 * Date: 2020/5/13
 * Time: 16:28
 */
public class ExceptionLock {
    int count =0;
    synchronized void m() {
        System.out.println(Thread.currentThread().getName() + " start");
        while (true){
            count++;
            System.out.println(Thread.currentThread().getName() + " count =" + count);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(count==5){
                int i = 1/0;//异常
                System.out.println(i);
            }
        }
    }

    public static void main(String[] args) {
        ExceptionLock exceptionLock = new ExceptionLock();
        Runnable r = new Runnable() {
            @Override
            public void run() {
                exceptionLock.m();
            }
        };
        new Thread(r,"t1").start();
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(r,"t2").start();
    }
}
