package thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;

/**
 * Created by IntelliJ IDEA.
 * User: XINGHAIFANG
 * Date: 2020/6/2
 * Time: 17:17
 */
public class AtomicVsSyncVsLongAdder {
    static AtomicLong count1 = new AtomicLong(0l);
    static  long count2 = 0l;
    static LongAdder count3 = new LongAdder();

    static void microSleep(int m){
        try{
            TimeUnit.MICROSECONDS.sleep(m);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args)  {
        Thread[] threads = new Thread[1000];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(()->{
                for (int j = 0; j <100000 ; j++) {
                    count1.incrementAndGet();
                }
            });
        }

        long start = System.currentTimeMillis();
        for(Thread t:threads){
            t.start();
        }
        for (Thread t:threads){
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        long end = System.currentTimeMillis();
        System.out.println("Atomic: "+count1.get() + " time" + (end-start));
        //-------------------------------------------------

        //下面是synchronized的测试方法;
        Object lock = new Object();
        for (int i = 0; i <threads.length; i++) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 100000; j++) {
                        synchronized (lock){
                            count2++;
                        }
                    }
                }
            });
        }
        start = System.currentTimeMillis();

        for(Thread t : threads ){
            t.start();
        }

        for (Thread t : threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        end = System.currentTimeMillis();


        System.out.println("Sync: " + count2 + " time " + (end-start));
        //----------------------------------
        for(int i=0; i<threads.length; i++) {
            threads[i] =
                    new Thread(()-> {
                        for(int k=0; k<100000; k++) count3.increment();
                    });
        }

        start = System.currentTimeMillis();

        for(Thread t : threads ) t.start();

        for (Thread t : threads) {
            try {
                //让所有线程顺序执行;
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        end = System.currentTimeMillis();

        //TimeUnit.SECONDS.sleep(10);

        System.out.println("LongAdder: " + count1.longValue() + " time " + (end-start));

    }
}
