package JVM.jmm;

/**
 * Created by IntelliJ IDEA.
 * User: XINGHAIFANG
 * Date: 2020/7/2
 * Time: 16:32
 */
public class TestSync {
    synchronized void m(){

    }

    void n(){
        synchronized (this){

        }
    }

    public static void main(String[] args) {

    }
}
