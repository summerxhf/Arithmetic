package thread.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by IntelliJ IDEA.
 * User: XINGHAIFANG
 * Date: 2020/6/19
 * Time: 11:42
 */
public class ExecutorServiceTest {
    public static void main(String[] args) {
        //Executors 类似collectionUtils类, 可以创建;
        ExecutorService e =  Executors.newCachedThreadPool();
    }
}
