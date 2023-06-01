package leetcode;

import edu.TreeNode;

public class BinarySearchTreeGreaterSumTree {


    public static TreeNode bstToGst(TreeNode root) {
        if (root == null) {
            return root;
        }

        reverseInOrder(root, 0);
        return root;

    }


    public static int reverseInOrder(TreeNode root, int sum) {
        if (root == null) {
            return sum;
        }
        sum = reverseInOrder(root.right, sum);
        sum += root.val;
        root.val = sum;
        sum = reverseInOrder(root.left, sum);

        return sum;
    }


    public static void main(String[] args) {
        bstToGst(new TreeNode(4, new TreeNode(1, new TreeNode(0), new TreeNode(2, null, new TreeNode(3))),
                new TreeNode(6, new TreeNode(5), new TreeNode(7, null, new TreeNode(8)))));
    }
}
