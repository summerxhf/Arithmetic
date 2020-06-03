package thread;

import java.util.concurrent.Semaphore;

/**
 * Created by IntelliJ IDEA.
 * User: XINGHAIFANG
 * Date: 2020/6/3
 * Time: 17:54
 */
public class TestSemaphore {
    public static void main(String[] args) {
        Semaphore s = new Semaphore(2,true);
        //下面是允许一个线程同时运行
//        Semaphore s = new Semaphore(1);
        new Thread(()->{
            try{
                s.acquire();
                System.out.println("T1 running .....");
                Thread.sleep(200);
                System.out.println("T1 running.......");
            }catch (InterruptedException e){
                e.printStackTrace();
            }finally {
                s.release();
            }
        }).start();

        new Thread(()->{
            try{
                s.acquire();
                System.out.println("T2 running....");
                Thread.sleep(200);
                System.out.println("T2 running");
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }).start();
    }
}
