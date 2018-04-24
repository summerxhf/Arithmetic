package linked;

/**
 * 单链表反转
 */
public class SingleLinkedReverseAll {
    public static Node Reverse(Node head){
        if(head ==null || head.next ==null){
            return head;
        }
        Node reHead = Reverse(head.next);
        head.next = head;
        head.next = null;
        return reHead;
    }

    public static void main(String[] args) {
        Node head = new Node(0);
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3  = new Node(3);
        head.next=node1;
        node1.next=node2;
        node2.next=node3;

        //打印反转前的链表
        Node h = head;
        while (null !=h){
            System.out.print(h.value + " " );
            h = h.next;
        }

        //调用反转方法
        head = Reverse(head);
        System.out.println("\n********打印反转后的结果");
        while (null != head){
            System.out.print(head.value + " ");
            head = head.next;
        }
    }
}
