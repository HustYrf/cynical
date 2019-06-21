package DiameterOfBinaryTree;


public class DiameterOfBinaryTree {
    private int ans = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root, 1);
        return ans;
    }


    public int dfs(TreeNode root, int level) {
        if (root == null) {
            level -= 1;
            return level;
        }
        int lt = dfs(root.left, level + 1);
        int rt = dfs(root.right, level + 1);
        ans = Math.max(ans, lt - level + rt - level);
        return Math.max(lt, rt);
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
