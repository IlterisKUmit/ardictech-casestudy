package com.ardic.tech.newgradproject;

public class BinaryTree {

    Node root;

    private int data = 0;

    private int  size = 0;

    private int edgeCtr = 0;

    public BinaryTree() {
        root = new Node(data);
    }

    private static class Node {
        Node left;
        Node right;
        int data;

        public Node(int data) {
            this.data = data;
        }
    }

    public void addNode(int value) {

        if (size == 0) {
            root.data = value;
            size++;
        } else {
            addChild(root, new Node(value));
        }
    }

    public void addChild(Node parent, Node child) {

        if (parent == null) {
            return;
        }

        if (child.data < parent.data) {

            if (parent.left == null) {
                parent.left = child;
                size++;
                edgeCtr++;
            } else {
                addChild(parent.left, child);
            }
        } else {

            if (parent.right == null) {
                parent.right = child;
                size++;
                edgeCtr++;
            } else {
                addChild(parent.right, child);
            }
        }
    }

    public String toString() {

        BinaryTree.Node current = root;
        System.out.print("Traverse From Left ");

        while (current.left != null && current.right != null) {

            System.out.print(current.data + "->[" + current.left.data + " " + current.right.data + "] ");
            current = current.left;
        }

        System.out.println();
        System.out.print("Traverse From Right ");

        current = root;

        while (current.left != null && current.right != null) {

            System.out.print(current.data + "->[" + current.left.data + " " + current.right.data + "] ");
            current = current.right;
        }

        return "";
    }

    private void preOrder(BinaryTree.Node node) {

        if (node != null) {

            System.out.print(node.data + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    private void postOrder(BinaryTree.Node node) {

        if (node != null) {

            postOrder(node.left);
            postOrder(node.right);
            System.out.print(node.data + " ");
        }
    }

    private void inOrder(BinaryTree.Node node) {

        if (node != null) {

            inOrder(node.left);
            System.out.print(node.data + " ");
            inOrder(node.right);
        }
    }

    public void preOrder() {

        System.out.print("Preorder Traversal->");
        preOrder(root);
        System.out.println();
    }

    public void postOrder() {

        System.out.print("Postorder Traversal->");
        postOrder(root);
        System.out.println();
    }

    public void inOrder() {

        System.out.print("Inorder Traversal->");
        inOrder(root);
        System.out.println();
    }

    public boolean detectAnomaly(BinaryTree t){
        if(t.edgeCtr >= (t.size)){
            return true;
        }else{
            return false;
        }
    }

    public static void main(String[] args) {

        int array [] = {50,13,51,19,32,75,61,5,12,37,48,44};

        BinaryTree t = new BinaryTree();

        for (int i = 0; i< array.length; i++){
            t.addNode(array[i]);
        }

        System.out.println("Size: " + t.size + ". " + "Edge count: " + t.edgeCtr + ".");
        t.preOrder();
        t.postOrder();
        t.inOrder();
        System.out.println("Anomaly detected?: " + t.detectAnomaly(t));

    }
}
