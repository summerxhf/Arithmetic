package thread.interview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by IntelliJ IDEA.
 * User: XINGHAIFANG
 * Date: 2020/6/3
 * Time: 19:19
 * 实现一个容器,提供两个方法, add size;
 * 写两个线程, 线程1添加10个元素到容器中,线程2实现监控元素的个数, 当个数为5的时候,线程2给出提示并结束;
 *
 */
public class WithoutVolatile {
    /*volatile*/
    volatile List lists = new ArrayList();
//    volatile  List lists = Collections.synchronizedList(new ArrayList<>());
    public  void add(Object o){
        lists.add(o);
    }

    public  int size(){
        return lists.size();
    }

    public static void main(String[] args) {
        WithoutVolatile withoutVolatile = new WithoutVolatile();
//方法一:不可行
//        new Thread(()->{
//
//            for (int i = 0; i < 10; i++) {
//                withoutVolatile.add(new Object());
//                System.out.println("add "+i);
//                try{
//                    TimeUnit.SECONDS.sleep(1);
//                }catch (InterruptedException e){
//                    e.printStackTrace();
//                }
//            }
//
//
//        },"t1").start();
//
//        new Thread(()->{
//            while (true){
//                if(withoutVolatile.size()==5){
//                    break;
//                }
//            }
//            System.out.println("t2 结束...");
//        },"t2").start();
        //方法二个
        final Object lock = new Object();
        new Thread(()->{
            synchronized (lock){
                for (int i = 0; i < 10; i++) {
                    withoutVolatile.add(new Object());
                    System.out.println("add "+i);
                    if(withoutVolatile.size()==5){
                        //notify 不会释放当前锁, wait会释放锁
                        lock.notify();
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
//                    try{
//                        TimeUnit.SECONDS.sleep(1);
//                    }catch (InterruptedException e){
//                        e.printStackTrace();
//                    }
                }
            }

        },"t1").start();

        new Thread(()->{
            synchronized (lock){
                System.out.println("t2 启动....");
                if(withoutVolatile.size()!=5){
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("t2 结束");
                //通知t1继续执行
                lock.notify();
            }
        },"t2").start();

    }
}
