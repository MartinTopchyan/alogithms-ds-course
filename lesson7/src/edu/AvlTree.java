package edu;

public class AvlTree {

    TreeNode root;

    public AvlTree(TreeNode root) {
        this.root = root;
    }

    int getBF(TreeNode node){
        if(node == null){
            return 0;
        }
        int leftBF = getHeight(node.left);
        int rightBF = getHeight(node.right);
        return leftBF - rightBF;
    }

    int getHeight(TreeNode node) {
        if (node == null) {
            return -1;
        }
        return 1 + Math.max(getHeight(node.left), getHeight(node.right));
    }

    TreeNode insert(TreeNode node){
        return insertHelper(root, node);
    }

    TreeNode insertHelper(TreeNode root, TreeNode node){
        if(root == null){
            root = node;
            return root;
        }
        if(node.val < root.val){
            node.left = insertHelper(root.left, node);
        }else {
            node.right = insertHelper(root.right, node);
        }

        int bf = getBF(root);
        if(bf > 1 && getBF(root.left) >= 0){
            return rightRotate(root);
        }
        if(bf > 1 && getBF(root.left) < 0){
            root.left = leftRotate(root.left);
            rightRotate(root);
        }

        if(bf < -1 && getBF(root.left) > 0){
            root.right = rightRotate(root.right);
            leftRotate(root);
        }

        if(bf < -1 && getBF(root.left) <= 0){
            return leftRotate(root);
        }

        return root;
    }

    TreeNode delete(TreeNode node){
        return deleteHelper(root, node);
    }
    TreeNode deleteHelper(TreeNode root, TreeNode node){
        if (node == null) {
            return node;
        }

        if(root.val > node.val){
            root.left = deleteHelper(root.left, node);
        }else if(root.val < node.val){
            root.right = deleteHelper(root.right, node);
        }else {
            if(root.left == null){
                return root.right;
            }
            if (root.right == null){
                return root.left;
            }

            TreeNode tmp = getSuccessor(node);
            root.val = tmp.val;
            root.right = deleteHelper(root.right, node);
        }

        int bf = getBF(root);

        if(bf > 1 && getBF(node.left) >= 0){
            return rightRotate(node);
        }
        if(bf > 1 && getBF(node.left) < 0){
            node.left = leftRotate(node.left);
            rightRotate(node);
        }

        if(bf < -1 && getBF(node.left) > 0){
            node.right = rightRotate(node.right);
            leftRotate(node);
        }

        if(bf < -1 && getBF(node.left) <= 0){
            return leftRotate(node);
        }

        return root;
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

    TreeNode getMin(TreeNode node) {
        if (node == null) {
            return node;
        }
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    TreeNode rightRotate(TreeNode node) {
        if (node == null) {
            return node;
        }

        TreeNode right = node.right;
        TreeNode T2 = right.left;
        right.left = node;
        node.right = T2;
        return node;

    }

    TreeNode leftRotate(TreeNode node) {
        if (node == null) {
            return node;
        }
        TreeNode left = node.left;
        TreeNode T2 = left.right;
        left.right = node;
        node.left = T2;
        return node;

    }
}
