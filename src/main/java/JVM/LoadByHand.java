package JVM;

/**
 * Created by IntelliJ IDEA.
 * User: XINGHAIFANG
 * Date: 2020/6/29
 * Time: 17:53
 */
public class LoadByHand {
    public static void main(String[] args)throws ClassNotFoundException {
        Class clazz = LoadByHand.class.getClassLoader().loadClass("JVM.LoadByHand");
        System.out.println(clazz.getName());
    }
}
