package leetcode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        if(root == null){
            return List.of();
        }
        List<Integer> left = inorderTraversal(root.left);
        List<Integer> res = new ArrayList<>(left);
        res.add(root.val);
        List<Integer> right = inorderTraversal(root.right);
        res.addAll(right);
        return res;
    }

    public static void main(String[] args) {

    }
}
