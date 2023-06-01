package leetcode;

import edu.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class AllElementsTwoBinarySearchTrees {

    public static List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> res1 = new ArrayList<>();
        inOrder(root1, res1);
        List<Integer> res2 = new ArrayList<>();
        inOrder(root2, res2);
        int firstIndex = 0;
        int secondIndex = 0;

        List<Integer> res = new ArrayList<>();

        while (firstIndex < res1.size() && secondIndex < res2.size()){
            if(res1.get(firstIndex) < res2.get(secondIndex)){
                res.add(res1.get(firstIndex));
                firstIndex++;
            }else {
                res.add(res2.get(secondIndex));
                secondIndex++;
            }
        }

        while (firstIndex < res1.size()){
            res.add(res1.get(firstIndex));
            firstIndex++;
        }

        while (secondIndex < res2.size()){
            res.add(res2.get(secondIndex));
            secondIndex++;
        }
        return res;
    }

    public static void inOrder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        inOrder(root.left, res);
        res.add(root.val);
        inOrder(root.right, res);
    }

    public static void main(String[] args) {
        System.out.println(getAllElements(new TreeNode(2, new TreeNode(1), new TreeNode(4)),
                new TreeNode(1, new TreeNode(0), new TreeNode(3))));
    }
}
