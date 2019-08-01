package chapter1_StackAndQueue;


import java.util.Stack;

/**
 * Created by IntelliJ IDEA.
 * User: XINGHAIFANG
 * Date: 2019/8/1
 * Time: 11:41
 * 两个栈实现一个队列;
 *  1 必须一次性把数据要入第一个栈中;
 *  2 第二个栈需要是一个空栈;
 */
public class TwoStacksRealizeQueue {
    public Stack<Integer> stackPush;
    public Stack<Integer> stackPop;
    public Stack<Integer> stackPop1;

    public TwoStacksRealizeQueue(){
        stackPush = new Stack<Integer>();
        stackPop = new Stack<Integer>();
        stackPop1 = new Stack<Integer>();
    }

    public void add(int pushInt){
        stackPush.push(pushInt);
    }

    public int poll(){
        if(stackPop.empty()&&stackPush.empty()){
            throw new RuntimeException("queue is empty");
        }else if(stackPop.empty()){
            //把第一个栈的数据压入第二个栈;
            while (!stackPush.empty()){
                stackPop.push(stackPush.pop());
            }
        }
        return  stackPop.pop();
    }
    //取出队列顶端的数据;
    public int peek(){
        if(stackPop.empty()&& stackPush.empty()){
            throw  new RuntimeException("queue is empty");
        }else if(stackPop.empty()){
            while (!stackPush.empty()){
                stackPop.push(stackPush.pop());
            }

        }
        return stackPop.peek();
    }

    public boolean empty(){
       return stackPop.isEmpty();
    }

    public static void main(String[] args) {
        TwoStacksRealizeQueue twoStacksRealizeQueue = new TwoStacksRealizeQueue();
        twoStacksRealizeQueue.add(1);
        twoStacksRealizeQueue.add(2);
        twoStacksRealizeQueue.add(3);
        twoStacksRealizeQueue.add(4);
        twoStacksRealizeQueue.add(5);
        //输入队列中的值;
        System.out.println(twoStacksRealizeQueue.peek());
        System.out.println(twoStacksRealizeQueue.poll());
        System.out.println(twoStacksRealizeQueue.peek());
        System.out.println(twoStacksRealizeQueue.poll());
        System.out.println(twoStacksRealizeQueue.empty());
    }
}
