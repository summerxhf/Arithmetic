package thread.threadpool;

import javafx.concurrent.Task;

import java.io.IOException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by IntelliJ IDEA.
 * User: XINGHAIFANG
 * Date: 2020/6/19
 * Time: 11:56
 */
public class ThreadPoolExecutorTest {

    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2,4,60, TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(4), Executors.defaultThreadFactory(),new ThreadPoolExecutor.CallerRunsPolicy());

        for (int i = 0; i < 8; i++) {
            threadPoolExecutor.execute(new Task(i));
        }

        System.out.println("任务队列--" + threadPoolExecutor.getQueue());

        threadPoolExecutor.execute(new Task(100));

        System.out.println("任务队列--" + threadPoolExecutor.getQueue());

        threadPoolExecutor.shutdown();


    }

    static class Task implements Runnable{
        private int i;
        public Task(int i){
            this.i = i;
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " Task " + i);
            try{
                System.in.read();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        @Override
        public String toString(){
            return  "Task{" + "i=" + i+ "}";
        }
    }
}
