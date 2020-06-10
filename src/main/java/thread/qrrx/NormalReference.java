package thread.qrrx;

import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * User: XINGHAIFANG
 * Date: 2020/6/10
 * Time: 10:43
 */
public class NormalReference {
    public static void main(String[] args) throws IOException {
        M m = new M();
        //强引用只有设置m为null的时候才会被回收;
        m =null;
        System.gc();
        //阻塞main线程;
        System.in.read();
    }
}
