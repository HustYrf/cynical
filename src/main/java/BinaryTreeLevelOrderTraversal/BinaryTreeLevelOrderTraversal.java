package BinaryTreeLevelOrderTraversal;

import java.util.ArrayList;
import java.util.List;


/**
 * @ClassName BinaryTreeLevelOrderTraversal
 * @Descripition TODO
 * @Author Administrator
 * @Date 2019/7/8 23:27
 **/
public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        List<TreeNode> list = new ArrayList<>();
        list.add(root);
        while (list.size() != 0) {
            List<Integer> num = new ArrayList<>();
            int count = list.size();
            for (int i = 0; i < count; i++) {
                TreeNode remove = list.remove(0);
                num.add(remove.val);
                if (remove.left != null) {
                    list.add(remove.left);
                }
                if (remove.right != null) {
                    list.add(remove.right);
                }
            }
            result.add(num);
        }
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
