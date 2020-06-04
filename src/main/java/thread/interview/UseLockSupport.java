package thread.interview;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.LockSupport;

/**
 * Created by IntelliJ IDEA.
 * User: XINGHAIFANG
 * Date: 2020/6/4
 * Time: 11:25
 */
public class UseLockSupport {
    volatile List lists = new ArrayList();
    public void add(Object o) {
        lists.add(o);
    }

    public int size() {
        return lists.size();
    }
    static Thread t1 = null, t2 = null;
    public static void main(String[] args) {
        UseLockSupport c = new UseLockSupport();
         t1 = new Thread(()->{
            System.out.println("t1 启动");
            for (int i = 0; i < 10; i++) {
                c.add(new Object());
                System.out.println("t1 add" + i);
                if(c.size()==5){
                    LockSupport.unpark(t2);
                    LockSupport.park();
                }
            }
            System.out.println("t1结束启动...");
        },"t1");
        t1.start();

         t2 = new Thread(()->{
            if(c.size()!=5){
                LockSupport.park();
            }
            System.out.println("t2 启动...");
            System.out.println("t2结束...");
            LockSupport.unpark(t1);
        },"t2");
        t2.start();
    }



}
