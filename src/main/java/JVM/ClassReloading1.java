package JVM;

/**
 * Created by IntelliJ IDEA.
 * User: XINGHAIFANG
 * Date: 2020/7/1
 * Time: 10:43
 * 无论重新load几次,都加载一次,所以相等;
 */
public class ClassReloading1 {
    public static void main(String[] args) throws Exception{
        XHFClassLoader msbClassLoader = new XHFClassLoader();
        Class clazz = msbClassLoader.loadClass("JVM.Hello");

        msbClassLoader = null;
        System.out.println(clazz.hashCode());

        msbClassLoader = null;

        msbClassLoader = new XHFClassLoader();
        Class clazz1 = msbClassLoader.loadClass("JVM.Hello");
        System.out.println(clazz1.hashCode());

        System.out.println(clazz == clazz1);
    }

}
