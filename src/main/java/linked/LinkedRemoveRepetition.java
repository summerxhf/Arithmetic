package linked;

import java.util.HashSet;

/**
 * 无序链表删除重复的节点
 */
public class LinkedRemoveRepetition {
    public void removeRep1(Node head){
        if(head == null){
            return;
        }

        HashSet<Integer> set = new HashSet<Integer>();
        Node pre = head;
        Node cur = head.next;
        set.add(head.value);
        while (cur!=null){
            if(set.contains(cur.value)){
                pre.next = cur.next;
            }else {
                set.add(cur.value);
                pre = cur;
            }
            cur = cur.next;
        }
    }
}
