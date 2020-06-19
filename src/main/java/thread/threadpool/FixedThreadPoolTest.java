package thread.threadpool;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by IntelliJ IDEA.
 * User: XINGHAIFANG
 * Date: 2020/6/19
 * Time: 14:24
 */
public class FixedThreadPoolTest {
    public static void main(String[] args) throws InterruptedException{
        ExecutorService service = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 6; i++) {
            service.execute(()->{
                try{
                    TimeUnit.MILLISECONDS.sleep(500);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName());
            });
        }

        System.out.println(service);

        service.shutdown();
        //未完成的时候;
        System.out.println(service.isTerminated());
        System.out.println(service.isShutdown());
        System.out.println(service);
        //最后均完成;
        TimeUnit.SECONDS.sleep(5);
        System.out.println(service.isTerminated());
        System.out.println(service.isShutdown());
        System.out.println(service);
    }
}
