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
    //有效二叉树，用dfs解，注意int的最大最小值，可以分别出现一次，用mark记录
    public boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;
        return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE, 0, 0);
    }
    
    public boolean isValidBST(TreeNode root, int left, int right, int markLeft, int markRight) {
        if (root.val <= left || root.val >= right) {
            if (root.val == Integer.MIN_VALUE && root.val == left && markLeft == 0) {
                markLeft = 1;
            } else if (root.val == Integer.MAX_VALUE && root.val == right && markRight == 0) {
                markRight = 1;
            } else {
                return false;
            }
        }
        
        if (root.left != null)
            if (!isValidBST(root.left, left, root.val, markLeft, markRight))
                return false;
        if (root.right != null)
            if (!isValidBST(root.right, root.val, right, markLeft, markRight))
                return false;
        
        return true;
    }
}
