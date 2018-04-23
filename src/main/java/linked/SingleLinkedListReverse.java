package linked;

import java.util.concurrent.Callable;

/**
 * 单链表反转
 * 1->2->3->5->null
 * 调整后结果为: 1->2->5->3->null
 */
public class SingleLinkedListReverse {
//    public Node reversePart(Node head,int from ,int to){
//        int len = 0;
//        Node node1 = head;
//        Node fPre = null;
//        Node tPos = null;
//        while (node1!=null){
//            len ++;
//            fPre = len==from -1 ?node1:fPre;
//            tPos =len ==to + 1 ? node1:tPos;
//            node1 = node1.next;
//        }
//
//        if(from>to || from<1 ||to>len){
//            return head;
//        }
//
//        node1 = fPre == null ?head :fPre.next;
//        Node node2 = node1.next;
//        node1.next = tPos;
//        Node next = tPos;
//
//    }

    final public int MAX_LENGTH = 1;
    public final int MAX_LENGTH2 =2;


}
