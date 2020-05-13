package thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * Created by IntelliJ IDEA.
 * User: XINGHAIFANG
 * Date: 2020/5/13
 * Time: 14:29
 */
public class CreateThread {
    //方式一
    static class MyThread extends Thread{
        @Override
        public void run() {
            System.out.println("hello myThread!");
        }
    }

    //方式二
    static class MyRun implements Runnable{
        @Override
        public void run() {
            System.out.println("hello myRun!");
        }
    }
    //方式三
    public static class MyCall implements Callable<String>{
        @Override
        public String call() {
            System.out.println("hello myCall!");
            return "success";
        }
    }
    //线程启动;
    public static void main(String[] args){
        new MyThread().start();
        new Thread(new MyRun()).start();

        //lambda 方式
        new Thread(()->{
            System.out.println("hello lambda!");
        }).start();

        Thread t = new Thread(new FutureTask<String>(new MyCall()));
        t.start();

        //线程池方式;
        ExecutorService service = Executors.newCachedThreadPool();
        service.execute(()->{
            System.out.println("hello ThreadPool!");
        });
        service.shutdown();
    }

}
