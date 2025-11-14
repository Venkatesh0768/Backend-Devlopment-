package BinaryTree;

class NodeA {
    int data;
    NodeA left;
    NodeA right;
    int height;

    NodeA(int key) {
        this.data = key;
        height = 1;
    }
}

class AVL {
    NodeA root;

    int height(NodeA node) {
        if (node == null) return 0;
        return node.height;
    }

    int getBalance(NodeA node) {
        if (node == null) return 0;
        return height(node.left) - height(node.right);
    }

    // RIGHT ROTATE (LL case)
    NodeA rightRotate(NodeA y) {
        NodeA x = y.left;
        NodeA T2 = x.right;

        // rotation
        x.right = y;
        y.left = T2;

        // update height
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        return x;  // IMPORTANT
    }

    // LEFT ROTATE (RR case)
    NodeA leftRotate(NodeA x) {
        NodeA y = x.right;
        NodeA T2 = y.left;

        // rotation
        y.left = x;
        x.right = T2;

        // update height
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        return y; // IMPORTANT
    }

    // public insert method
    void insert(int value) {
        root = insert(root, value);
    }

    // actual insert logic
    private NodeA insert(NodeA node, int value) {
        if (node == null)
            return new NodeA(value);

        if (value < node.data)
            node.left = insert(node.left, value);
        else if (value > node.data)
            node.right = insert(node.right, value);
        else
            return node;

        // update height
        node.height = Math.max(height(node.left), height(node.right)) + 1;

        int balance = getBalance(node);

        // ------------------- ROTATION CASES -------------------

        // 1️⃣ LL
        if (balance > 1 && value < node.left.data)
            return rightRotate(node);

        // 2️⃣ RR
        if (balance < -1 && value > node.right.data)
            return leftRotate(node);

        // 3️⃣ LR
        if (balance > 1 && value > node.left.data) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // 4️⃣ RL
        if (balance < -1 && value < node.right.data) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    // PRINT AVL TREE SIDEWAYS
    void printTree() {
        printTree(root, 0);
    }

    void printTree(NodeA node, int space) {
        if (node == null) return;

        space += 10;

        printTree(node.right, space);

        System.out.println();
        for (int i = 10; i < space; i++)
            System.out.print(" ");
        System.out.println(node.data);

        printTree(node.left, space);
    }
}

public class AVLTree {
    public static void main(String[] args) {
        AVL tree = new AVL();

        for (int i = 0; i < 10; i++) {
            tree.insert(i);
        }

        System.out.println("\nAVL Tree:");
        tree.printTree();
    }
}
