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
    //BT的深度，dfs读取，不断改写level，可以用recursive方法
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;

        return 1 + max(maxDepth(root.left), maxDepth(root.right));
    }
    
    public int max(int a, int b) {
        return a > b ? a : b;
    }
}
