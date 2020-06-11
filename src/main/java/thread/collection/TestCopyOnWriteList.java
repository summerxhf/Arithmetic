package thread.collection;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by IntelliJ IDEA.
 * User: XINGHAIFANG
 * Date: 2020/6/11
 * Time: 10:16
 * 读的情况比较多,写的比较少的情况下;
 * 100000个节点, 大概4357毫秒;
 */
public class TestCopyOnWriteList {
    public static void main(String[] args) {
        List<String> lists = new CopyOnWriteArrayList<>();
        Random r = new Random();
        Thread[] ths = new Thread[100];
        //开启100个线程,每个线程向copyonwritArrayList中写入数据;
        for (int i = 0; i < ths.length; i++) {
            Runnable task = new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 1000; j++) {
                        lists.add("a"+r.nextInt(10000));
                    }
                }
            };
            ths[i] = new Thread(task);
        }
        //运行个计算时间;
        runAndComputeTime(ths);
        System.out.println(lists.size());
    }

    private static void runAndComputeTime(Thread[] ths) {
        long s1 = System.currentTimeMillis();
        Arrays.asList(ths).forEach(t->t.start());
        Arrays.asList(ths).forEach(t->{
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        long s2 = System.currentTimeMillis();
        System.out.println(s2-s1);
    }
}
