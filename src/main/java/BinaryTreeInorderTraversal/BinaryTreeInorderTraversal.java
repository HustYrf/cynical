package BinaryTreeInorderTraversal;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName BinaryTreeInorderTraversal
 * @Descripition TODO
 * @Author Administrator
 * @Date 2019/7/8 23:18
 **/
public class BinaryTreeInorderTraversal {
    List<Integer> result = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) return result;
        inorderTraversal(root.left);
        result.add(root.val);
        inorderTraversal(root.right);
        return result;
    }

    private class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
