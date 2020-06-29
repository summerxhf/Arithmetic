package JVM;

/**
 * Created by IntelliJ IDEA.
 * User: XINGHAIFANG
 * Date: 2020/6/29
 * Time: 11:36
 */
public class ClassLoaderLevel {
    public static void main(String[] args) {
        System.out.println(Integer.class.getClassLoader());

        System.out.println(String.class.getClassLoader());
        System.out.println(sun.awt.HKSCS.class.getClassLoader());
        System.out.println(sun.net.spi.nameservice.dns.DNSNameService.class.getClassLoader());
        System.out.println(ClassLoaderLevel.class.getClassLoader());

        System.out.println(sun.net.spi.nameservice.dns.DNSNameService.class.getClassLoader().getClass().getClassLoader());
        System.out.println(ClassLoaderLevel.class.getClassLoader().getClass().getClassLoader());

        System.out.println(new T006_MSBClassLoader().getParent());
        System.out.println(ClassLoader.getSystemClassLoader());
    }

}
