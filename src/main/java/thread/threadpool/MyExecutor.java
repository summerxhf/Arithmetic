package thread.threadpool;

import java.util.concurrent.Executor;

/**
 * Created by IntelliJ IDEA.
 * User: XINGHAIFANG
 * Date: 2020/6/19
 * Time: 11:02
 */
public class MyExecutor implements Executor {

    @Override
    public void execute(Runnable command) {
        command.run();
    }

    public static void main(String[] args) {
        new MyExecutor().execute(()-> System.out.println("hello executor"));
    }
}
