package chapter1_StackAndQueue;

import com.sun.javafx.image.IntPixelGetter;

import java.util.Stack;

/**
 * Created by IntelliJ IDEA.
 * User: XINGHAIFANG
 * Date: 2019/8/1
 * Time: 9:57
 * 把最小的栈顶元素也重新压入栈中;
 * 时间复杂度o(1) 空间复杂度 o(n)
 * 方案一中 GetMinStackDemo stackMin 压入时省空间, 但是弹出操作费时间;
 *
 * 方案二中:GetMinStackDemo压入时稍费空间,但是弹出操作省时间;
 */
public class GetMinStackDemo2 {
    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;

    public GetMinStackDemo2(){
        this.stackData = new Stack<Integer>();
        this.stackMin = new Stack<Integer>();
    }
    public void push(int newNum){
        if(this.stackMin.isEmpty()){
            this.stackMin.push(newNum);
            //新入栈的数据和当前最小值比较;小于等于stack min中的值,则压入stackMin;
        }else if(newNum<=this.getMin()){
            this.stackMin.push(newNum);
        }else {
            //新入栈的数大于当前最小值,把当前最小值再押入栈中;
            this.stackMin.push(this.stackMin.peek());
        }
        this.stackData.push(newNum);
    }

    //返回当前最小值,栈顶元素是当前最小值;
    public int getMin(){
        if(this.stackMin.isEmpty()){
            throw new RuntimeException("the min stack is empty");
        }
        return this.stackMin.peek();
    }

    public int pop(){
        if(this.stackData.isEmpty()){
            throw new RuntimeException("you stack is empty");
        }
        //同时弹出stack min中的内容
        this.stackMin.pop();
        return this.stackData.pop();
    }

    public static void main(String[] args) {
        GetMinStackDemo2 getMinStackDemo2 = new GetMinStackDemo2();
        Integer array[] = new Integer[]{3,4,5,1,2,1};
        for (int i = 0; i < array.length; i++) {
            getMinStackDemo2.push(array[i]);
        }
        //输出minStack栈中的值;
        System.out.println(getMinStackDemo2.stackData.peek());

        System.out.println("获得栈中最小值"+getMinStackDemo2.stackMin.peek());

    }
}
