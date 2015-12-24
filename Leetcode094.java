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
    //inorder方法读取BT，可以用stack或者哈希表存dfs读的顺序然后再取出到list，这里用dfs执行插入list操作，稍慢
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<Integer>();
        
        if (root != null)
            inorder(root, ans, 0);
            
        return ans;
    }
    
    public void inorder(TreeNode root, List<Integer> ans, int index) {
        ans.add(index, root.val);
        if (root.right != null)
            inorder(root.right, ans, index+1);
        if (root.left != null)
            inorder(root.left, ans, index);
        
        return;
    }
}
