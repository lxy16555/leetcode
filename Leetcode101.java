/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    //是不是对称树，结构及val，同时dfs左右子树，注意left跟right比较
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        if (root.left == null && root.right == null)
            return true;
        if (root.left == null || root.right == null)
            return false;
        
        return dfs(root.left, root.right);
    }
    
    public boolean dfs(TreeNode left, TreeNode right) {
        if (left.val != right.val)
            return false;
        
        if (left.left != null && right.right != null) {
            if (!dfs(left.left, right.right))
                return false;
        } else if (left.left != null || right.right != null)
            return false;
        
        if (left.right != null && right.left != null) {
            if (!dfs(left.right, right.left))
                return false;
        } else if (left.right != null || right.left != null)
            return false;
        
        return true;
    }
}
