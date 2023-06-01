package leetcode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePostorderTraversal {

    public List<Integer> postorderTraversal(TreeNode root) {
        if(root == null){
            return List.of();
        }
        List<Integer> left = postorderTraversal(root.left);
        List<Integer> res = new ArrayList<>(left);
        List<Integer> right = postorderTraversal(root.right);
        res.addAll(right);
        res.add(root.val);
        return res;

    }
}
