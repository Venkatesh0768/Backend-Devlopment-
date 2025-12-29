package BinaryTree;
class  NodeA{
    int key;
    int height;
    NodeA left , right;

    NodeA(int key){
        this.key = key;
        this.height =1;
    }
}

class AVLTree{

    NodeA root;

    int height(NodeA n){
        return n==null ? 0 : n.height;
    }

    int max(int a , int b){
        return Math.max(a, b);
    }


    //Right Rotate
    NodeA rightRotate(NodeA node){
        NodeA leftChild = node.left;
        NodeA temp = leftChild.right;

        leftChild.right =node;
        node.left = temp;

        node.height = max(height(node.left) , height(node.right)) +1;
        leftChild.height = max(height(leftChild.left) , height(leftChild.right)) +1;


        return leftChild;
    }

    //Left Rotate
    NodeA leftRotate(NodeA node){
        NodeA rightChild = node.right;
        NodeA temp = rightChild.left;

        rightChild.left = node;
        node.right = temp;

        node.height = max(height(node.left) , height(node.right)) + 1;
        rightChild.height = max(height(rightChild.left) , height(rightChild.right))+1;

        return rightChild;

    }


    int getBalance(NodeA node){
        if (node == null) return 0;
        return height(node.left) - height(node.right);
    }

    NodeA insert(NodeA root , int key){
        if (root == null) return new NodeA(key);

        if(key < root.key){
            root.left = insert(root.left , key);
        }else if(key > root.key){
            root.right = insert(root.right, key);
        }else {
            return root;
        }


        root.height = 1 + max(height(root.left) , height(root.right));

        int balance = getBalance(root);

        //Left-Left Case
        if(balance > 1 && key < root.left.key){
            return rightRotate(root);
        }

        //Right-Right Case
        if(balance < -1 && key > root.right.key){
            return leftRotate(root);
        }


        //Left-Right
        if (balance > 1 && key > root.left.key){
            root.left = leftRotate(root);
            return rightRotate(root);
        }


        if(balance < -1 && key < root.right.key){
            root.right = rightRotate(root);
            return leftRotate(root);
        }

        return root;

    }

    void preOrder(NodeA node) {
        if (node != null) {
            System.out.print(node.key + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    void inOrder(NodeA node) {
        if (node != null) {
            inOrder(node.left);
            System.out.print(node.key + " ");
            inOrder(node.right);
        }
    }

    void postOrder(NodeA node) {
        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            System.out.print(node.key + " ");
        }
    }


    public static void main(String[] args) {
        AVLTree tree = new AVLTree();

        for (int i = 1; i <100 ; i++) {
            tree.root = tree.insert(tree.root ,i);
        }
        System.out.println("Preorder traversal of constructed AVL tree is : ");
        tree.preOrder(tree.root);
        System.out.println();

        System.out.println("Inorder traversal of constructed AVL tree is : ");
        tree.inOrder(tree.root);
        System.out.println();

        System.out.println("Postorder traversal of constructed AVL tree is : ");
        tree.postOrder(tree.root);
        System.out.println();
    }


}