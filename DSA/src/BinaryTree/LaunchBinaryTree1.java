package BinaryTree;

import java.util.Scanner;

class Node {
    int data;
    Node left;
    Node right;

    Node(int value) {
        this.data = value;
        left = right = null;
    }
}

class BinaryTree {
    private Node root;
    public void populate(Scanner scanner) {
        System.out.print("Enter the root Node: ");
        int value = scanner.nextInt();
        root = new Node(value);
        populate(scanner, root);
    }

    // Recursive helper to build left and right subtrees
    private void populate(Scanner scanner, Node node) {
        System.out.print("Do you want to add a left child of " + node.data + "? (true/false): ");
        boolean left = scanner.nextBoolean();
        if (left) {
            System.out.print("Enter value for left node of " + node.data + ": ");
            int value = scanner.nextInt();
            node.left = new Node(value);
            populate(scanner, node.left);
        }

        System.out.print("Do you want to add a right child of " + node.data + "? (true/false): ");
        boolean right = scanner.nextBoolean();
        if (right) {
            System.out.print("Enter value for right node of " + node.data + ": ");
            int value = scanner.nextInt();
            node.right = new Node(value);
            populate(scanner, node.right);
        }
    }

    // Display the tree (Preorder Traversal)
    public void display() {
        System.out.println("\nTree Structure (Preorder):");
        display(root, "Root Node: ");
    }

    private void display(Node node, String details) {
        if (node == null) return;
        System.out.println(details + node.data);
        display(node.left, "  Left child of " + node.data + ": ");
        display(node.right, "  Right child of " + node.data + ": ");
    }
}

public class LaunchBinaryTree1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BinaryTree bt = new BinaryTree();
        bt.populate(sc);
        bt.display();
    }
}
