package chapter1_StackAndQueue;

import java.util.Stack;

/**
 * @author xhf
 * @description: 两个栈实现一个队列
 * appendTail 时间复杂度O(1)   deleteHead 空间复杂度O(n)
 **/
public class CQueue {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public CQueue(){
        this.stack1 = new Stack<Integer>();
        this.stack2 = new Stack<Integer>();
    }

    public void appendTail(int value){
        stack1.push(value);
    }

    public Integer deleteHead(){
        //stack1 压入stack2,stack2 用于出栈
        if(stack2.isEmpty()){
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        if(stack2.isEmpty()){
            return -1;
        }else {
            return stack2.pop();
        }
    }

    public boolean empty(){
        if(stack1.isEmpty() && stack2.isEmpty()){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        CQueue cQueue = new CQueue();
        for (int i = 1;i<=5;i++){

            cQueue.appendTail(i);
            System.out.println(" 入队列-----" + i);
        }

        while (!cQueue.empty()){
            System.out.println(" 出队列------"+ cQueue.deleteHead());
        }

    }

}
