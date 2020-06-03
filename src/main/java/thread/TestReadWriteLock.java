package thread;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by IntelliJ IDEA.
 * User: XINGHAIFANG
 * Date: 2020/6/3
 * Time: 17:09
 */
public class TestReadWriteLock {
    static Lock lock = new ReentrantLock();
    private static int value;

    static ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    static Lock readLock = readWriteLock.readLock();
    static Lock writeLock = readWriteLock.writeLock();

    public static void read(Lock lock){
        try{
            lock.lock();
            Thread.sleep(1000);
            System.out.println("read over!");
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    public static void write(Lock lock,int v){
        try{
            lock.lock();
            Thread.sleep(1000);
            value = v;
            System.out.println("write over!");
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        //之前的显示锁;
        Runnable readR = ()->read(lock);
        Runnable writeR =()->write(lock,new Random().nextInt());

        Runnable readR1 = ()->read(readLock);
        Runnable writeR1 = ()->write(writeLock,new Random().nextInt());
        //读锁不受sleep()限制
        for (int i = 0; i < 18; i++) {
            new Thread(readR1).start();
        }
        for (int i = 0; i < 2; i++) {
            new Thread(writeR1).start();
        }

//        for (int i = 0; i < 18; i++) {
//            new Thread(readR).start();
//        }
//        for (int i = 0; i < 2; i++) {
//            new Thread(writeR).start();
//        }
    }
}
