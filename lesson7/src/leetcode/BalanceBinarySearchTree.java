package leetcode;

import edu.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BalanceBinarySearchTree {

    public static TreeNode balanceBST(TreeNode root) {
        if(root == null){
            return root;
        }
        List<Integer> res = new ArrayList<>();
        inOrder(root, res);
        int left = 0;
        int right = res.size() -1;

        return balanceHelper(res, left, right);

    }

    public static void inOrder(TreeNode root, List<Integer> res){
        if(root == null){
            return;
        }
        inOrder(root.left, res);
        res.add(root.val);
        inOrder(root.right, res);
    }

    public static TreeNode balanceHelper(List<Integer> res, int left, int right){
        if(left < 0 || right < 0 || left >= res.size() || right >= res.size() || left > right){
            return null;
        }
        int mid = left + (right - left) /2;
        TreeNode resNode = new TreeNode(res.get(mid));
        if(left < mid){
            resNode.left = balanceHelper(res, left, mid-1);
        }
        if(mid < right){
            resNode.right = balanceHelper(res, mid +1, right);
        }
        return resNode;
    }

    public static void main(String[] args) {
        TreeNode bst = balanceBST(new TreeNode(1, null, new TreeNode(2, null, new TreeNode(3, null, new TreeNode(4)))));
        System.out.println();
    }
}
