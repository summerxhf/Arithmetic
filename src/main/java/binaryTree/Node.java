package binaryTree;

/**
 * 节点定义
 */
public class Node {
    public String value;//节点值
    public Node left;//左节点
    public Node right;//右节点
    //二叉树先序遍历 根左右
    public void preOrderRecur(Node head){
        if(head==null){
            return;
        }
        //先输出中间节点
        System.out.print(head.value + " ");

        preOrderRecur(head.left);
        preOrderRecur(head.right);
    }
    //二叉树中序遍历 左根右
    public void inOrderRecur(Node head){
        if(head==null){
            return;
        }
        inOrderRecur(head.left);
        System.out.print(head.value + " ");//头结点中间输出
        inOrderRecur(head.right);
    }
    //后序遍历 左右根
    public void postOrder(Node head){
        if(head==null){
            return;
        }

        postOrder(head.left);
        postOrder(head.right);
        System.out.print(head.value + " ");
    }
}
