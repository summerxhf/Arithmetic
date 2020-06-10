package thread.qrrx;

import java.lang.ref.SoftReference;

/**
 * Created by IntelliJ IDEA.
 * User: XINGHAIFANG
 * Date: 2020/6/10
 * Time: 10:46
 * 垃圾回收空间不足的时候会被回收;
 */
public class softreferenceTest {
    public static void main(String[] args) {
        SoftReference<byte[]> m = new SoftReference<>(new byte[1024*1024*10]);
        System.out.println(m.get());
        System.gc();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(m.get());
        //内存不够的时候则会被回收, m;可以用作缓存使用;
        byte[] b = new byte[1024*1024 *10];
        System.out.println(m.get());
    }
}
