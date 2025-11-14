package BinaryTree;

class BST {
    Node root;

    public  void insert(int value){
        root = insert(root , value);
    }

    private Node insert(Node node, int value) {
        if (node == null) return new Node(value);

        if (value < node.data) {
            node.left = insert(node.left, value);
        } else {
            node.right = insert(node.right, value);
        }
        return node;

    }
    public void printTree(Node node) {
        printTreeRec(node, 0);
    }

    private void printTreeRec(Node node, int level) {
        if (node == null) return;

        printTreeRec(node.right, level + 1);

        if (level != 0) {
            for (int i = 0; i < level - 1; i++)
                System.out.print("|\t");
            System.out.println("|------- " + node.data);
        } else {
            System.out.println(node.data);
        }

        printTreeRec(node.left, level + 1);
    }


    public void inorder(Node node) {
        if (node == null) return;
        inorder(node.left);
        System.out.print(node.data + " ");
        inorder(node.right);
    }
}

public class InserationBinaryTree {

    public static void main(String[] args) {

        BST bt = new BST();
        bt.insert(50);
        bt.insert(30);
        bt.insert(70);
        bt.insert(20);
        bt.insert(40);


        bt.printTree(bt.root);
    }

}
