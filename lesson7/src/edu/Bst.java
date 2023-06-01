package edu;

import java.util.Stack;

public class Bst {

    TreeNode root;

    public Bst(TreeNode root) {
        this.root = root;
    }

    void insert(TreeNode node) {
        if (root == null) {
            root = node;
            return;
        }
        TreeNode curr = root;
        TreeNode tmp = root;

        while (curr != null) {
            tmp = curr;
            if (curr.val > node.val) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }

        if (tmp.val > node.val) {
            tmp.left = node;
        } else {
            tmp.right = node;
        }


    }

    void delete(TreeNode node) {
        deleteHelper(node);
    }

    TreeNode deleteHelper(TreeNode node) {
        if (node == null) {
            return node;
        }
        TreeNode curr = root;

        if(curr.val > node.val){
            curr.left = deleteHelper(curr.left);
        }else if(curr.val < node.val){
            curr.right = deleteHelper(curr.right);
        }else {
            if(curr.left == null){
                return curr.right;
            }
            if (curr.right == null){
                return curr.left;
            }

            TreeNode tmp = getSuccessor(node);
            curr.val = tmp.val;
            curr.right = deleteHelper(curr.right);
        }

        return root;
    }

    int getHeight(TreeNode node) {
        if (node == null) {
            return -1;
        }
        return 1 + Math.max(getHeight(node.left), getHeight(node.right));
    }

    TreeNode getMax(TreeNode node) {
        if (node == null) {
            return node;
        }
        while (node.right != null) {
            node = node.right;
        }
        return node;
    }

    TreeNode getMin(TreeNode node) {
        if (node == null) {
            return node;
        }
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    TreeNode find(int key) {
        return findHelper(root, key);
    }

    TreeNode findHelper(TreeNode node, int key) {
        if (root.val == key) {
            return root;
        }
        if (root.val > key) {
            return findHelper(node.left, key);
        } else {
            return findHelper(node.right, key);
        }
    }

    TreeNode getSuccessor(TreeNode node) {
        if (node.right != null) {
            return getMin(node.right);
        }
        TreeNode ancestor = null;
        TreeNode curr = root;
        while (curr!= null){
            if(curr.val > node.val){
                ancestor = curr;
                curr = curr.left;
            }else {
                curr = curr.right;
            }
        }

        return ancestor;
    }

    TreeNode getPredecessor(TreeNode node) {
        if (node.left != null) {
            return getMax(node.left);
        }
        TreeNode ancestor = null;
        TreeNode curr = root;
        while (curr!= null){
            if(curr.val < node.val){
                curr = curr.left;
            }else {
                ancestor = curr;
                curr = curr.right;
            }
        }

        return ancestor;
    }

    void inOrderTraversalIterative(TreeNode root){
        TreeNode current = root;
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || current != null){
            stack.push(current);

            if(current.left != null){
                stack.push(current.left);
                current = current.left;
            }else {
                current = stack.pop();
                current = current.right;
            }
        }
    }

    void preOrderTraversalIterative(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode head = stack.pop();
            if(head.left != null){
                stack.push(head.left);
            }
            if(head.right != null){
                stack.push(head.right);
            }
        }
    }

    void postOrderTraversalIterative(TreeNode root){
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(root);
        while (!stack1.isEmpty()){
            TreeNode head = stack1.pop();
            stack2.push(head);
            if(head.left != null){
                stack1.push(head.left);
            }
            if(head.right != null){
                stack1.push(head.right);
            }
        }

        while (!stack2.isEmpty()) {
            System.out.print(stack2.pop().val + " ");
        }
    }
}
