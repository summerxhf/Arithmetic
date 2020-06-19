package thread.threadpool;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by IntelliJ IDEA.
 * User: XINGHAIFANG
 * Date: 2020/6/19
 * Time: 15:42
 * 顾名思义，它基于 工作窃取算法，其中任务可以生成其他较小的任务，这些任务将添加到并行处理线程的队列中。如果一个线程完成了工作并且无事可做，则可以从另一线程的队列中“窃取”工作。
 */
public class WorkStealingPoolTest {
    public static void main(String[] args) throws IOException {
        ExecutorService service = Executors.newWorkStealingPool();
        System.out.println(Runtime.getRuntime().availableProcessors());

        service.execute(new R(1000));
        service.execute(new R(2000));
        service.execute(new R(2000));
        service.execute(new R(2000));
        service.execute(new R(2000));
        //产生的守护进程或者后台线程, 主程序不阻塞的话, 看不到输出;
        System.in.read();
    }

    static class R implements Runnable {

        int time;

        R(int t) {
            this.time = t;
        }

        @Override
        public void run() {

            try {
                TimeUnit.MILLISECONDS.sleep(time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(time  + " " + Thread.currentThread().getName());

        }

    }
}
