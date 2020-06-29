package JVM;

/**
 * Created by IntelliJ IDEA.
 * User: XINGHAIFANG
 * Date: 2020/6/29
 * Time: 14:53
 * Bootstrap-->Extension-->App-->Custom ClassLoader
 */
public class ParentAndChild {
    public static void main(String[] args) {
        //custom classloader
        System.out.println(ParentAndChild.class.getClassLoader());
        System.out.println(ParentAndChild.class.getClassLoader().getClass().getClassLoader());
        System.out.println(ParentAndChild.class.getClassLoader().getParent());
        //上级app的上级(extension)bootstrap
        System.out.println(ParentAndChild.class.getClassLoader().getParent().getParent());
    }
}
