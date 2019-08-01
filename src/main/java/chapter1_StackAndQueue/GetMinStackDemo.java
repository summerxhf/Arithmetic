package chapter1_StackAndQueue;

import java.util.Stack;

/**
 * Created by IntelliJ IDEA.
 * User: XINGHAIFANG
 * Date: 2019/7/31
 * Time: 17:36
 * 返回栈中最小元素;
 */
public class GetMinStackDemo {
    private  Stack<Integer> stackData;
    private  Stack<Integer> stackMin;

    public GetMinStackDemo(){
        this.stackData = new Stack<Integer>();
        this.stackMin = new Stack<Integer>();
    }

    public int getmin(){
        if(this.stackMin.isEmpty()){
            throw  new RuntimeException("You stack is empty");
        }
        //返回栈顶元素,并不移出;
        return this.stackMin.peek();
    }

    public void  push(int newNum){
        if(this.stackMin.isEmpty()){
            this.stackMin.push(newNum);
        }else if(newNum <= this.getmin()){
            this.stackMin.push(newNum);
        }

        this.stackData.push(newNum);
    }

    public int  pop(){
        if(this.stackData.isEmpty()){
            throw new  RuntimeException("you stack is empty.");
        }
        int value = this.stackData.pop();
        if(value == this.getmin()){
            this.stackMin.pop();
        }
        return value;
    }

    public static void main(String[] args) {
        GetMinStackDemo getMinStackDemo = new GetMinStackDemo();
        Integer array[] = new Integer[]{3,4,5,1,2,1};
        for (int i = 0; i < array.length; i++) {
            getMinStackDemo.push(array[i]);

        }
        //输出minStack栈中的值;
        for(int i:getMinStackDemo.stackMin){
            System.out.println(i);
        }

        System.out.println("通过两个栈获得最小元素为:--" +getMinStackDemo.stackMin.peek());
    }

}
