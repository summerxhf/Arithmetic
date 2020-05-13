package thread;

/**
 * Created by IntelliJ IDEA.
 * User: XINGHAIFANG
 * Date: 2020/5/13
 * Time: 14:39
 */
public class Thread_Sleep_Yield_Join {
    static void testSleep(){
        new Thread(()->{
            for (int i = 0; i < 100; i++) {
                System.out.println("A" +i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }).start();
    }

    /**
     * 让出cpu
     */
    static void testYield(){
        new Thread(()->{
            for (int i = 0; i < 100; i++) {
                System.out.println("A" + i);
                if (i%10 ==0){
                    Thread.yield();
                }
            }
        }).start();
        new Thread(()->{
            for (int i = 0; i < 100; i++) {
                System.out.println("----------B"  +i);
                if(i%10 ==0){
                    Thread.yield();
                }
            }
        }).start();
    }

    /**
     * t1 t2 t1.join t2 先让t2执行,t2执行完再执行t1
     */
    static void testJoin(){
        Thread t1 = new Thread(()->{
            for (int i = 0; i < 100; i++) {
                System.out.println("A"+i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        });
        Thread t2 = new Thread(()->{
            try {
                t1.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (int i = 0; i < 100; i++) {
                System.out.println("B" + i);
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        });

        t1.start();
        t2.start();
    }

    public static void main(String[] args) {
//        testSleep();
        testJoin();
//        testYield();
    }
}
