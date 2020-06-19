package thread.threadpool;

import java.util.concurrent.*;

/**
 * Created by IntelliJ IDEA.
 * User: XINGHAIFANG
 * Date: 2020/6/19
 * Time: 11:52
 */
public class CallableTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<String> c = new Callable(){
            @Override
            public String call() throws Exception{
                return "hello callable";
            }
        };

        ExecutorService service = Executors.newCachedThreadPool();
        Future<String> future = service.submit(c);//异步
        System.out.println(future.get());//阻塞;

        service.shutdown();
    }
}
