package thread.threadpool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

/**
 * Created by IntelliJ IDEA.
 * User: XINGHAIFANG
 * Date: 2020/7/8
 * Time: 10:22
 */
public class ThreadPoolExecutor_Callable {
    public  void test() {
        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNameFormat("user-defined-pool-%d").build();

        ExecutorService threadPoolExecutor = new ThreadPoolExecutor(2,4,5L, TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(1024),namedThreadFactory,new ThreadPoolExecutor.AbortPolicy()
        );
        List<Future<Long>> futureLists = new ArrayList<>();
        List<String> taskList = new ArrayList<>();
        taskList.add("2020-07-08");
        for (int i = 0; i < 4; i++) {
            Future<Long> result = threadPoolExecutor.submit(new Task(taskList));
            futureLists.add(result);
        }

    }
    public class Task implements Callable<Long>{
        private List<String> dateList;
        public Task(List<String> dateList){
            this.dateList = dateList;
        }
        @Override
        public Long call()  {
            Long beginTime = System.currentTimeMillis();
            //do things
            Long endTime = System.currentTimeMillis();
            return (endTime - beginTime)/1000;
        }
    }
}

