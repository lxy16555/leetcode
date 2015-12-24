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
    //比较两个Tree是不是一样，用dfs比较，边遍历边比较，发现结构或者val不一样则返回false，遍历结束返回true
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;
        else if (p == null || q == null)
            return false;
        else
            return dfs(p, q);
    }
    
    public boolean dfs(TreeNode p, TreeNode q) {
        if (p.left != null && q.left != null) {
            if (!dfs(p.left, q.left))
                return false;
        } else if (p.left != null || q.left != null)
            return false;
            
        if (p.val != q.val)
            return false;
        
        if (p.right != null && q.right != null) {
            if (!dfs(p.right, q.right))
                return false;
        } else if (p.right != null || q.right != null)
            return false;
        
        return true;
    }
}
