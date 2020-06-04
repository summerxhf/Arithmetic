package thread.productConsumer;

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by IntelliJ IDEA.
 * User: XINGHAIFANG
 * Date: 2020/6/4
 * Time: 14:19
 */
public class Container2<T> {
    final private LinkedList<T> lists = new LinkedList<T>();
    final private int MAX = 10;
    private int count = 0;

    private Lock lock = new ReentrantLock();
    private Condition producer = lock.newCondition();
    private Condition consumer = lock.newCondition();

    public void put(T t){
        try {
            lock.lock();
            while (lists.size()==MAX){
                producer.await();
            }
            lists.add(t);
            ++count;
            consumer.signalAll();//通知消费者消费;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    public T get(){
        T t = null;
        try{
            lock.lock();
            while (lists.size()==0){
                consumer.await();
            }
            t = lists.removeFirst();
            count--;
            producer.signalAll();//通知生产者生产;
            return t;
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
        return t;
    }

    public static void main(String[] args) {
        Container2<String> container2 = new Container2<>();
        //10个消费者;
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                for (int j = 0; j < 25; j++) {
                    System.out.println( container2.get());
                }
            },"conusmer"+i).start();
        }
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //2个线程生产者;
        for (int i = 0; i < 2; i++) {
            new Thread(()->{
                for (int j = 0; j < 25; j++) {
                    container2.put(Thread.currentThread().getName()+"  资源名称:" + j);
                }
            },"product"+i).start();
        }
    }
}
