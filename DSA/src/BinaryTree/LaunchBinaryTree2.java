package BinaryTree;
import java.util.LinkedList;
import java.util.Queue;

public class LaunchBinaryTree2 {

    static void preOrderTravel(Node node){
        if (node == null) return;
        System.out.print(node.data + " ");
        preOrderTravel(node.left);
        preOrderTravel(node.right);
    }
    static void postOrderTravel(Node node){
        if (node == null) return;
        preOrderTravel(node.left);
        preOrderTravel(node.right);
        System.out.print(node.data + " ");
    }
    static void inOrderTravel(Node node){
        if (node == null) return;
        preOrderTravel(node.left);
        System.out.print(node.data + " ");
        preOrderTravel(node.right);
    }

    static void levelOrder(Node node){
        if (node == null) return;

        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()){
            Node currentNode = queue.poll();
            System.out.print(currentNode.data + " ");
            if (currentNode.left  != null) queue.add(currentNode.left);
            if (currentNode.right  != null) queue.add(currentNode.right);
        }


    }

    static int height(Node node){
        if (node == null) return 0;
        return 1+ Math.max(height(node.left) ,height(node.right));
    }

    int countNodes(Node node){
        if (node == null) return 0;
        return 1+ countNodes(node.left) + countNodes(node.right);
    }

    int leafNode(Node node){
        if (node == null) return 0;
        if (node.left == null && node.right == null) return 1;
        return leafNode(node.left) + leafNode(node.right);
    }

    int sumOfNodes(Node node){
        if (node == null) return 0;
        return node.data + sumOfNodes(node.left) + sumOfNodes(node.right);
    }

    boolean search(Node node , int key){
        if (node == null) return false;
        if (node.data == key) return true;
        return search(node.left , key) || search(node.right , key);
    }


   static boolean isBalanced(Node root){
        if (root == null) return  false;
        return Math.abs(height(root.left) - height(root.right)) <=1 && isBalanced(root.left) && isBalanced(root.right);
    }




    public static void main(String[] args) {
        Node tree;
        tree = new Node(1);
        tree.left = new Node(2);
        tree.right = new Node(3);
        tree.left.left = new Node(4);
        tree.left.right = new Node(5);
        System.out.print("pre Order Travel");
        preOrderTravel(tree);

        System.out.println();
        System.out.print("post Order Travel");
        postOrderTravel(tree);

        System.out.println();
        System.out.print("In Order Travel");
        inOrderTravel(tree);

        System.out.println();
        System.out.println("Level order Travels" );
        levelOrder(tree);


        System.out.println(isBalanced(tree));

    }
}
