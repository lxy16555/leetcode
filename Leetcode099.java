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
    //复原BST，用dfs以inorder顺序读tree，用left和right标记第一个以及第二个错误，注意left只标记第一次，right有可能改写，如果想加快速度，可以判定right改变一次后停止
    TreeNode left = null, right = null, tmp = null;
    public void recoverTree(TreeNode root) {
        if (root == null)
            return;
        
        dfs(root);
        
        if (left != null && right != null) {
            int temp = left.val;
            left.val = right.val;
            right.val = temp;
        }
    }
        
    public void dfs(TreeNode root) {
        if (root.left != null)
            dfs(root.left);
        
        if (tmp != null && tmp.val > root.val) {
            if (left == null)
                left = tmp;
            right = root;
        }
            
        tmp = root;
        
        if (root.right != null)
            dfs(root.right);
    }
}
