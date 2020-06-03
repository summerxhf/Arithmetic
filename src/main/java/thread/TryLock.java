package thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by IntelliJ IDEA.
 * User: XINGHAIFANG
 * Date: 2020/6/2
 * Time: 18:00
 */
public class TryLock {
    Lock lock = new ReentrantLock();
    void m1(){
        try{
            lock.lock();
            for (int i = 0; i < 3; i++) {
                TimeUnit.SECONDS.sleep(1);
                System.out.println(i);
            }
        }catch (InterruptedException e){

        }finally {
            lock.unlock();
        }
    }

    void m2(){
        boolean locked = true;
        try{
            locked = lock.tryLock(5,TimeUnit.SECONDS);
            System.out.println("m2 .....");
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            if(locked){
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        TryLock tryLock = new TryLock();
        new Thread(tryLock::m1).start();
        try{
            TimeUnit.SECONDS.sleep(1);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        new Thread(tryLock::m2).start();
    }


}
