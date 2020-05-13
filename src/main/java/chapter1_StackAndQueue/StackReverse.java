package chapter1_StackAndQueue;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by IntelliJ IDEA.
 * User: XINGHAIFANG
 * Date: 2019/8/6
 * Time: 20:07
 */
public class StackReverse {
    public static void main(String[] args) {
        Map<String,Object> map = new HashMap<>();
        Map<String,Object> synMap = Collections.synchronizedMap(map);

        ConcurrentHashMap m = new ConcurrentHashMap();
        m.put(100, "Hello");
        m.put(101, "xinghf");
        m.put(102, "henryyong");

        // Here we cant add Hello because 101 key
        // is already present in ConcurrentHashMap object
        m.putIfAbsent(101, "Hello");

        // We can remove entry because 101 key
        // is associated with For value
        m.remove(101, "xinghf");

        // Now we can add Hello
        m.putIfAbsent(103, "Hello");

        // We cant replace Hello with For
        m.replace(101, "Hello", "For");
        System.out.println(m);


    }
}
