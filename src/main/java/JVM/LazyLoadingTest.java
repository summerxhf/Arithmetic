package JVM;

/**
 * Created by IntelliJ IDEA.
 * User: XINGHAIFANG
 * Date: 2020/6/30
 * Time: 17:50
 */
public class LazyLoadingTest {

    public static class P{
        final static int i = 8;
        static int j =9;
        //静态模块
        static {
            System.out.println("P");
        }
    }

    public static class X extends P{
        static {
            System.out.println("X");
        }
    }

    public static void main(String[] args) {
        P p;
//        X x = new X();
//        System.out.println(P.i);
//        System.out.println(P.j);
//        Class.forName("")
    }
}
