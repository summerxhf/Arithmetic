package thread.qrrx;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: XINGHAIFANG
 * Date: 2020/6/10
 * Time: 11:41
 * 虚引用
 */
public class PhantomReferenceTest {
    private static final List<Object> LIST = new LinkedList<>();
    //队列中全是引用
    private static final ReferenceQueue<M> QUEUE = new ReferenceQueue<>();

    public static void main(String[] args) {
        //虚引用被回收会放到队列中, 虚引用被回收给通知, 只要有垃圾回收看到就会被回收;
        PhantomReference<M> phantomReference = new PhantomReference<>(new M(), QUEUE);
        new Thread(() -> {
            while (true) {
                //1M
                LIST.add(new byte[1024 * 1024]);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    Thread.currentThread().interrupt();
                }
                //虚引用无法获取get()里面的值; 只是为了给通知,放到队列中;
                System.out.println(phantomReference.get());
            }
        }).start();

        new Thread(() -> {
            while (true) {
                Reference<? extends M> poll = QUEUE.poll();
                if (poll != null) {
                    System.out.println("--- 虚引用对象被jvm回收了 ---- " + poll);
                }
            }
        }).start();

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
