package JVM;

import org.apache.lucene.util.RamUsageEstimator;

/**
 * Created by IntelliJ IDEA.
 * User: XINGHAIFANG
 * Date: 2020/7/9
 * Time: 15:02
 */
public class SizeOfObject {
    public static void main(String[] args) {
        Object o = new Object();
        P p = new P();
        System.out.println("自定义P对象大小-- "+RamUsageEstimator.sizeOf(p));
        System.out.println("RamUsageEstimator.sizeOf(Object obj)大小---"+RamUsageEstimator.sizeOf(o));
        System.out.println("RamUsageEstimator.sizeOf(new int[]{})大小---"+RamUsageEstimator.sizeOf(new int[]{}));
    }
    private static class P {
        //8 _markword
        //4 _oop指针
        int id;         //4
        String name;    //4
        int age;        //4

        byte b1;        //1
        byte b2;        //1

        Object o;       //4
        byte b3;        //1

    }

}
