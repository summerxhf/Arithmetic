package thread;

/**
 * Created by IntelliJ IDEA.
 * User: XINGHAIFANG
 * Date: 2020/5/13
 * Time: 14:20
 */
public class ThreadStateTest {
    static class MyThread extends Thread{
        @Override
        public void run(){
            System.out.println(this.getState());
            for (int i = 0; i <10 ; i++) {
                try{
                    Thread.sleep(500);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                System.out.println(i);
            }
        }
    }

    public static void main(String[] args) {
        Thread t = new MyThread();
        System.out.println(t.getState());
        t.start();

        try{
            t.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println(t.getState());
    }
}
