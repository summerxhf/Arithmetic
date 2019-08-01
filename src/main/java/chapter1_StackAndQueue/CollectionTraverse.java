package chapter1_StackAndQueue;

import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created by IntelliJ IDEA.
 * User: XINGHAIFANG
 * Date: 2019/8/1
 * Time: 11:18
 */
public class CollectionTraverse {
    public static void main(String[] args) {
        Map<String,String > map = new HashMap<String, String>();
        map.put("1","a");
        map.put("2","b");
        map.put("3","c");
        map.put("4","d");

        //普通遍历方式;
        for(Map.Entry<String,String> entry: map.entrySet()){
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
        for(Iterator<Map.Entry<String,String>> iterator = map.entrySet().iterator(); iterator.hasNext();){
            Map.Entry<String,String> entry = iterator.next();
            System.out.println(entry.getKey() + " = " + entry.getValue() );
        }


        //Queue的遍历方式;
        Queue<Integer> queue = new LinkedBlockingDeque<Integer>();
        for(int i = 0;i< 5;i++){
            queue.offer(i);
        }
        System.out.println("集合遍历方式,元素不会被移除; ");
        for(int i:queue){
            System.out.println(i);
        }
        System.out.println("队列遍历方式, 元素逐个被移除");
        while (queue.peek()!=null){
            System.out.println(queue.poll());
        }

        //Stack 遍历方式;
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < 10; i++) {
            stack.push(i);
        }

        //集合遍历方式;
        System.out.println("集合遍历方式");
         for (Integer i:stack){
             System.out.println(i);
         }
         //栈弹出遍历方式;

        System.out.println("栈弹出遍历方式;--可以看出弹出遍历方式是逆序的,先进后出原则;");
        while (!stack.empty()){
            System.out.println(stack.pop());
        }

    }
}
