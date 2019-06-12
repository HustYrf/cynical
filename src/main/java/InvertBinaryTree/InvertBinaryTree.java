package InvertBinaryTree;


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode right = invertTree(root.right);
        TreeNode left = invertTree(root.left);
        root.left = right;
        root.right = left;
        return root;

//        root.left = invertTree(root.right);
//        root.right = invertTree(root.left);
//        return root;
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

/**
 * leetcode上非递归解法
 **/

//public TreeNode invertTree(TreeNode root) {
//    if (root == null) return null;
//    Queue<TreeNode> queue = new LinkedList<TreeNode>();
//    queue.add(root);
//    while (!queue.isEmpty()) {
//        TreeNode current = queue.poll();
//        TreeNode temp = current.left;
//        current.left = current.right;
//        current.right = temp;
//        if (current.left != null) queue.add(current.left);
//        if (current.right != null) queue.add(current.right);
//    }
//    return root;
//}
