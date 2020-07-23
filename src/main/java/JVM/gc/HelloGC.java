package JVM.gc;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: XINGHAIFANG
 * Date: 2020/7/20
 * Time: 14:42
 */
public class HelloGC {
    public static void main(String[] args) {
        System.out.println("HelloGC!");
        List list = new LinkedList();
        for(;;){
            byte[] b = new byte[1024*1024];
            list.add(b);
        }
    }
}
