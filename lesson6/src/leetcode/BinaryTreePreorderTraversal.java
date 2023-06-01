package leetcode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePreorderTraversal {

    public List<Integer> preorderTraversal(TreeNode root) {
        if(root == null){
            return List.of();
        }
        List<Integer> res = new ArrayList<>();
        res.add(root.val);
        List<Integer> left = preorderTraversal(root.left);
        res.addAll(left);
        List<Integer> right = preorderTraversal(root.right);
        res.addAll(right);
        return res;
    }
}
