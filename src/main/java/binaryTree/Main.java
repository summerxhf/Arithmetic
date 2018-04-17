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


        nodeA.preOrderRecur(nodeA);//先序
        System.out.println();
        nodeA.inOrderRecur(nodeA);//中序
        System.out.println();
        nodeA.postOrder(nodeA);//后序
        System.out.println();
        System.out.println("非递归方式打印输出-----");
        nodeA.preOrderUnRecur(nodeA);
        nodeA.inOrderUnRecur(nodeA);
        nodeA.posOrderUnRecur1(nodeA);
        nodeA.posOrderUnRecur2(nodeA);
    }

}
