package MaximumDepthofBinaryTree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */

//class Solution {
//    public int maxDepth(TreeNode root) {
//        if(root == null)
//            return 0;
//        int left = maxDepth(root.left);
//        int right = maxDepth(root.right);
//        int height = 1 + Math.max(left, right);
//        return height;
//    }
//}

public class MaximumDepthofBinaryTree {
    public int maxDepth(TreeNode root) {
        LinkedList<TreeNode> list = new LinkedList();
        Map<TreeNode, Integer> map = new HashMap();
        int count = 0;
        TreeNode last = new TreeNode(0); // 最后一个节点
        if (root == null) {
            return count;
        } else {
            list.add(root);
            map.put(root, 1);
            while (list.size() != 0) {
                TreeNode td = list.pop();
                if(list.size()==0){
                    last = td;
                }
                if (td.left == null && td.right == null) {
                    continue;
                }
                if (td.left != null) {
                    list.add(td.left);
                    map.put(td.left, map.get(td) + 1);
                }
                if (td.right != null) {
                    list.add(td.right);
                    map.put(td.right, map.get(td) + 1);
                }
                map.remove(td);
            }
        }
        return map.get(last);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
