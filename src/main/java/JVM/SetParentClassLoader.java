package JVM;

/**
 * Created by IntelliJ IDEA.
 * User: XINGHAIFANG
 * Date: 2020/7/1
 * Time: 10:31
 */
public class SetParentClassLoader {
    private static XHFClassLoader parent = new XHFClassLoader();
    private static class MyLoader extends ClassLoader{
        public MyLoader(){
            super(parent);
        }
    }

    public static void main(String[] args) {
        //输出系统默认的classloader application class loader
        System.out.println(ClassLoader.getSystemClassLoader());;
    }
}
