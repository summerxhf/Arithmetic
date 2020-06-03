package thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * Created by IntelliJ IDEA.
 * User: XINGHAIFANG
 * Date: 2020/6/3
 * Time: 18:59
 */
public class TestLockSupport {
    public static void main(String[] args) {
        Thread t = new Thread(()->{
            for (int i = 0; i < 10; i++) {
                System.out.println(i);
                if(i==5){
                    LockSupport.park();
                }
                try{
                    TimeUnit.SECONDS.sleep(1);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        });
        t.start();
        try{
            TimeUnit.SECONDS.sleep(8);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("after 8 seconds");
        //主线程;unpark可以先于park之前调用
        LockSupport.unpark(t);


    }
}
