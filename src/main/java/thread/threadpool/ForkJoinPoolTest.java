package thread.threadpool;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;

/**
 * Created by IntelliJ IDEA.
 * User: XINGHAIFANG
 * Date: 2020/6/19
 * Time: 15:47
 */
public class ForkJoinPoolTest {
    static int[] nums = new int[1000000];
    static final int MAX_NUM = 50000;
    static Random r = new Random();

    static {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = r.nextInt(100);
        }
        //sum
        System.out.println("---sum:" + Arrays.stream(nums).sum());//stream api;
    }
    //增加任务;
//    static class  AddTask extends RecursiveAction{
//        int start,end;
//        AddTask(int s,int e){
//            start = s;
//            end = e;
//        }
//        @Override
//        protected void compute() {
//            if(end-start <= MAX_NUM){
//                long sum = 0L;
//                for (int i = 0; i < end; i++) {
//                    sum+= nums[i];
//                }
//                System.out.println("from:" + start + " to:"+ end + " =" + sum);
//            }else {
//                int middle = start + (end-start)/2;
//                AddTask subTask1 = new AddTask(start,middle);
//                AddTask subTask2 = new AddTask(middle,end);
//                subTask1.fork();
//                subTask2.fork();
//            }
//        }
//    }

    static class AddTaskReturn extends RecursiveTask<Long>{
        private static final long serialVersionUID = 1L;
        int start, end;

        AddTaskReturn(int s, int e) {
            start = s;
            end = e;
        }
        @Override
        protected Long compute() {
            if(end-start <=MAX_NUM){
                long sum = 0L;
                for (int i = start; i < end; i++) {
                    sum +=nums[i];
                }
                return sum;
            }
            int middle = start + (end - start)/2;
            AddTaskReturn subTask1 = new AddTaskReturn(start,middle);
            AddTaskReturn subTask2 = new AddTaskReturn(middle,end);
            subTask1.fork();
            subTask2.fork();
            return subTask1.join() + subTask2.join();
        }
    }

    public static void main(String[] args) {

        ForkJoinPool fjp = new ForkJoinPool();
        AddTaskReturn task = new AddTaskReturn(0,nums.length);
        fjp.execute(task);
        long result = task.join();
        System.out.println("计算结果:"+result);
    }
}
