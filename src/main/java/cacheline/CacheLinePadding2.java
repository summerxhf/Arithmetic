package cacheline;

import org.openjdk.jmh.generators.core.SourceThrowableError;

/**
 * Created by IntelliJ IDEA.
 * User: XINGHAIFANG
 * Date: 2020/7/1
 * Time: 15:45
 */
public class CacheLinePadding2 {
    private static class Padding{
        //8*7=56 字节 <64 64字节对齐;
        private static long p1,p2,p3,p4,p5,p6,p7;
    }


    private static class T extends Padding{
        public volatile long x = 0L;
    }

    public static T[] arr = new T[2];

    static {
        arr[0] = new T();
        arr[1] = new T();
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(()->{
            for (int i = 0; i < 1000_0000L; i++) {
                arr[0].x = i;
            }
        });

        Thread t2 = new Thread(()->{
            for (int i = 0; i < 1000_0000L; i++) {
                arr[1].x = i;

            }
        });

        final long start = System.nanoTime();
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println((System.nanoTime()-start)/100_0000);
    }

}
