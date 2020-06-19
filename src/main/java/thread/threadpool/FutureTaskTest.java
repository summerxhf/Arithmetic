package thread.threadpool;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * Created by IntelliJ IDEA.
 * User: XINGHAIFANG
 * Date: 2020/6/19
 * Time: 14:40
 */
public class FutureTaskTest {
    public static void main(String[] args) throws InterruptedException,ExecutionException {
        FutureTask<Integer> task = new FutureTask<>(()->{
            TimeUnit.MILLISECONDS.sleep(500);
            return 1000;
        });
        new Thread(task).start();
        System.out.println(task.get());
    }
}
