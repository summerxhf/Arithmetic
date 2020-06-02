package thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by IntelliJ IDEA.
 * User: XINGHAIFANG
 * Date: 2020/6/2
 * Time: 17:54
 */
public class SynchronizedReentrant2 {
    Lock lock = new ReentrantLock();
    void m1(){
        try{
            //手动加锁
            lock.lock();
            for (int i = 0; i < 10; i++) {
                TimeUnit.SECONDS.sleep(1);
                System.out.println(i);
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            //手动解锁
            lock.unlock();
        }
    }
    void m2(){
        try{
            //显示加锁
            lock.lock();
            System.out.println("lock 显示锁可重入,可以进入.../");
        }finally {
            //显示解锁
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        SynchronizedReentrant2 reentrant2 = new SynchronizedReentrant2();
        new Thread(reentrant2::m1).start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(reentrant2::m2).start();
    }
}
