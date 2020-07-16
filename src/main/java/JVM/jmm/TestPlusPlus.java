package JVM.jmm;

/**
 * Created by IntelliJ IDEA.
 * User: XINGHAIFANG
 * Date: 2020/7/13
 * Time: 19:28
 */
public class TestPlusPlus {
    public static void main(String[] args) {
        int i = 300;
        i = ++i;
        System.out.println(i);
    }
}
