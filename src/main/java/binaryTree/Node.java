package binaryTree;

import java.util.Stack;

/**
 * 节点定义
 */
public class Node {
    public String value;//节点值
    public Node left;//左节点
    public Node right;//右节点
    //递归方式打印.
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


    //非递归方式打印
    public void preOrderUnRecur(Node head){
        System.out.print("pre-order: ");
        if(head != null){
            Stack<Node> stack = new Stack<Node>();
            stack.add(head);
            while (!stack.isEmpty()){
                head = stack.pop();
                System.out.print(head.value + " ");
                if(head.right !=null){
                    stack.push(head.right);
                }
                if(head.left !=null){
                    stack.push(head.left);
                }
            }
        }
        System.out.println();
    }

    public void inOrderUnRecur(Node head){
        System.out.print("in-order: ");
        if(head!=null){
            Stack<Node> stack = new Stack<Node>();
            while (!stack.isEmpty() || head!=null){
                if(head!=null){
                    stack.push(head);
                    head = head.left;
                }else {
                    head = stack.pop();
                    System.out.print(head.value + " ");
                    head = head.right;
                }
            }

        }
        System.out.println();
    }

    //用两个队列形式
    public void posOrderUnRecur1(Node head){
        System.out.print("pos-order: ");
        if(head !=null){
            Stack<Node> s1 = new Stack<Node>();
            Stack<Node> s2 = new Stack<Node>();
            s1.push(head);
            while (!s1.isEmpty()){
                head= s1.pop();
                s2.push(head);
                if(head.left !=null){
                    s1.push(head.left);
                }

                if(head.right !=null){
                    s1.push(head.right);
                }
            }

            while (!s2.isEmpty()){
                System.out.print(s2.pop().value + " ");
            }
        }

        System.out.println();
    }
    //一个队列的形式
    public void posOrderUnRecur2(Node head){
        System.out.print("pos-order2 使用一个栈: ");
        if(head!=null){
            Stack<Node> stack = new Stack<Node>();
            stack.push(head);
            Node c = null;
            while (!stack.isEmpty()){
                c = stack.peek();
                if(c.left!=null && head!= c.left && head!=c.right){
                    stack.push(c.left);
                }else if(c.right!=null && head!=c.right){
                    stack.push(c.right);
                }else {
                    System.out.print(stack.pop().value + " ");
                    head = c;
                }
            }
        }
        System.out.println();
    }
}
