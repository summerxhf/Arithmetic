package linked;

import java.util.concurrent.Callable;

/**
 * 单链表反转
 * 1->2->3->4->5->null
 * 调整后结果为: 1->4->3->2->5->null
 */
public class SingleLinkedListReverse {
    public static Node reversePart(Node head,int from ,int to){
        int len = 0;
        Node node1 = head;
        Node fPre = null;
        Node tPos = null;
        //找到反转的部分,也就是不需要改变的部分,fpre和tpos from的前一个和to的后一个不需要动.
        while (node1!=null){
            len ++;
            fPre = len==from -1 ?node1:fPre;
            tPos =len ==to + 1 ? node1:tPos;
            node1 = node1.next;
        }
        //from>=1 from<to to <N
        //一下几种情况为
        if(from>to || from<1 ||to>len){
            return head;
        }

        node1 = fPre == null ?head :fPre.next;
        Node node2 = node1.next;
        node1.next = tPos;
        Node next = null;

        while (node2 !=tPos){
            next = node2.next;
            node2.next = node1;
            node1 = node2;
            node2 = next;
        }

        if(fPre!=null){
            fPre.next = node1;
            return head;
        }
        return node1;

    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        System.out.println("原始链表:" +node1.value + "-->" + node1.next.value+"-->" + node1.next.next.value+"-->"
                + node1.next.next.next.value+ "-->" +node1.next.next.next.next.value);

        Node nodeNew1 = new Node(0);
        nodeNew1 = reversePart(node1,2,4);
        System.out.println("反转从2 到 节点4的链表---,结果如下");
        System.out.println("反转部分链表后结果:" +nodeNew1.value + "-->" + nodeNew1.next.value+"-->" + nodeNew1.next.next.value+"-->"
                + nodeNew1.next.next.next.value+ "-->" +nodeNew1.next.next.next.next.value);

    }

}
