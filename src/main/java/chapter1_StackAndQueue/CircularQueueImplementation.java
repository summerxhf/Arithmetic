package chapter1_StackAndQueue;

import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 * User: XINGHAIFANG
 * 循环队列
 */
public class CircularQueueImplementation {
    public static void main(String[] args) {
        CircularQueue<Integer> circularQueue = new CircularQueue<>(8);
        circularQueue.enqueue(15);
        circularQueue.enqueue(16);
        circularQueue.enqueue(17);
        circularQueue.enqueue(18);
        circularQueue.enqueue(19);
        circularQueue.enqueue(20);
        circularQueue.enqueue(21);
        circularQueue.enqueue(22);
        System.out.println("full circular queue " + circularQueue);
        System.out.print("Dequeue following element from circular Queue");
        System.out.println(circularQueue.dequeue() + " ");
        circularQueue.enqueue(23);
        System.out.println("23入队后队列结果");
        System.out.println(circularQueue);
    }

}

//实现循环队列使用泛型;
class CircularQueue<E>{
    private int currentSize;//当前循环队列大小;
    private E[] circularQueueElements;
    private int maxSize;//循环队列最大容量;

    private int rear;//队尾位置,新元素入队到队尾;
    private int front;//队首位置,元素将会总队首出队;

    public CircularQueue(int maxSize){
        this.maxSize = maxSize;
        circularQueueElements = (E[]) new Object[this.maxSize];
        currentSize = 0;
        front = -1;
        rear = -1;
    }

    /**
     * 从对尾入队;
     * @param item
     * @throws QueueFullException
     */
    public void enqueue(E item) throws QueueFullException{
        if(ifFull()){
            throw new QueueFullException("循环队列已经满了,元素不能再加入");
        }else{
            //最新对尾的位置;
            rear = (rear + 1)% circularQueueElements.length;
            circularQueueElements[rear] = item;
            currentSize++;
            //第一次入队的时候,front设置为rear;
            if(front == -1){
                front = rear;
            }
        }
    }

    /**
     * 出队;
     * @return
     * @throws QueueEmptyException
     */
    public E dequeue() throws QueueEmptyException{
        E deQueueElement;
        if(isEmpty()){
            throw new QueueEmptyException("循环队列为空,不能出队列");
        }else{
            //从front 前面出队;
            deQueueElement = circularQueueElements[front];
            circularQueueElements[front] = null;//位置元素清空;
            front = (front +1 )%circularQueueElements.length;
            currentSize--;
        }
        return deQueueElement;
    }


    /**
     * 判断队列是否满了;
     * @return
     */
    public boolean ifFull(){
        return (currentSize == circularQueueElements.length);
    }

    /**
     * 判断队列是否为空;
     * @return
     */
    public boolean isEmpty(){
        return (currentSize==0);
    }
    @Override
    public String toString(){
        return "循环队列 [" + Arrays.toString(circularQueueElements) + " ]";
    }
}

class QueueFullException extends RuntimeException{
    private static final long serialVersionUID=-1L;
    public QueueFullException(){
        super();
    }
    public QueueFullException(String message){
        super(message);
    }
}
class QueueEmptyException extends RuntimeException{
    private static final long serialVersionUID= 1L;
    public QueueEmptyException(){
        super();
    }

    public QueueEmptyException(String message){
        super(message);
    }
}