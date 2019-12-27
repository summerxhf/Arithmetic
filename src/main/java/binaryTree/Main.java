package binaryTree;

public class Main {
    public static void main(String[] args) {
        Node nodeE = new Node();
        nodeE.value="e";
        Node nodeG = new Node();
        nodeG.value="g";

        Node nodeD = new Node();
        nodeD.right=nodeE;
        nodeD.value="d";

        Node nodeF = new Node();
        nodeF.value= "f";
        nodeF.left = nodeG;

        Node nodeB = new Node();
        nodeB.value = "b";
        nodeB.left = nodeD;
        nodeB.right = nodeF;

        Node nodeC = new Node();
        nodeC.value = "c";

        Node nodeA = new Node();
        nodeA.value = "a";
        nodeA.left = nodeB;
        nodeA.right = nodeC;

        Node node1 = new Node();
        Node node2 = new Node();
        Node node3 = new Node();
        Node node4 = new Node();
        Node node5 = new Node();
        Node node6 = new Node();
        Node node7 = new Node();
        Node node8 = new Node();
        node1.value="1";
        node2.value="2";
        node3.value="3";
        node4.value="4";
        node5.value="5";
        node6.value="6";
        node7.value="7";
        node8.value="8";
        node1.left=node2;
        node1.right=node3;
        node2.left=node4;
        node2.right=node5;
        node5.left=node7;
        node5.right=node8;
        node3.right=node6;
        System.out.println("递归方式调用---");
        nodeA.preOrderRecur(node1);//先序
        System.out.println();
        nodeA.inOrderRecur(node1);//中序
        System.out.println();
        nodeA.postOrder(node1);//后序
        System.out.println();

        System.out.println("非递归方式打印输出-----");
        node1.preOrderUnRecur(node1);
        node1.inOrderUnRecur(node1);
        node1.posOrderUnRecur1(node1);
        node1.posOrderUnRecur2(node1);


    }

}
