package thread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by IntelliJ IDEA.
 * User: XINGHAIFANG
 * Date: 2020/6/3
 * Time: 10:56
 */
public class FairLock extends Thread {
    private static ReentrantLock lock = new ReentrantLock(true);//true 表示公平;

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            lock.lock();
            try{
                System.out.println(Thread.currentThread().getName()+"获取的锁");
            }finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        FairLock fairLock = new FairLock();
        Thread th1 = new Thread(fairLock);
        Thread th2 = new Thread(fairLock);
        th1.start();
        th2.start();
    }
}
