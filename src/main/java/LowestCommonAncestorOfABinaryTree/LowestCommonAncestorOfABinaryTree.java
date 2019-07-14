package LowestCommonAncestorOfABinaryTree;

/**
 * @ClassName LowestCommonAncestorOfABinaryTree
 * @Descripition TODO
 * @Author Administrator
 * @Date 2019/7/14 9:45
 **/

//如果用递归的话，最重要的还是明白递归函数的作用是什么。这个题里面lowestCommonAncestor(root, p, q)函数的作用是判断p和q在root树中最低的公共祖先是什么,
// 返回值是公共祖先。
//
//这个题的模式叫做devide and conquer. 如果当前节点等于其中的p和q某一个节点，那么找到了节点，返回该节点，否则在左右子树分别寻找。
//
//左右子树两个返回的是什么呢？按照该递归函数的定义，即找到了左子树和右子树里p和q的公共祖先，注意祖先可以是节点自己。
// 然后根据左右侧找到的节点做进一步的判断。
//
//如果左右侧查找的结果都不为空，说明分别找到了p和q，那么LCA就是当前节点。否则就在不为空的那个结果就是所求。

public class LowestCommonAncestorOfABinaryTree {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }

        TreeNode leftNode = lowestCommonAncestor(root.left, p, q);
        TreeNode rightNode = lowestCommonAncestor(root.right, p, q);
        if (leftNode != null && rightNode != null) {
            return root;
        }
        if (leftNode != null) {
            return leftNode;
        }

        if (rightNode != null) {
            return rightNode;
        }
        return null;
    }
}
