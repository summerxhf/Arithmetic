package thread;

import java.util.concurrent.TimeUnit;

/**
 * Created by IntelliJ IDEA.
 * User: XINGHAIFANG
 * Date: 2020/6/2
 * Time: 17:45
 */
public class SynchronizedReentrant1 {
    synchronized void m1(){
        for (int i = 0; i < 10; i++) {
            try{
                TimeUnit.SECONDS.sleep(1);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println(i);
            if(i ==2 ){
                m2();
            }
        }
    }

    synchronized void m2(){
        System.out.println("m2 ... 一个对象中可重入");
    }

    public static void main(String[] args) {
        SynchronizedReentrant1 r1= new SynchronizedReentrant1();
        new Thread(r1::m1).start();
        try{
            TimeUnit.SECONDS.sleep(1);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
