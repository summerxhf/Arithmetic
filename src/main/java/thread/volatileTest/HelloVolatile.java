package thread.volatileTest;

import java.util.concurrent.TimeUnit;

/**
 * Created by IntelliJ IDEA.
 * User: XINGHAIFANG
 * Date: 2020/6/2
 * Time: 14:49
 */
public class HelloVolatile{
    volatile boolean running = true;
    void m(){
        System.out.println("m start");
        while (running){
//            System.out.println("1111");
        }
        System.out.println("m end!");
    }

    public static void main(String[] args) {
        HelloVolatile t = new HelloVolatile();
        new Thread(t::m,"t1").start();
        try{
            TimeUnit.SECONDS.sleep(1);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        t.running=false;
    }
}
