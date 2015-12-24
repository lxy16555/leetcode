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
    //采用与I相同的dfs解法，可用bfs
    List<List<Integer>> ans = new ArrayList<List<Integer>>();
    
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null)
            return ans;
        
        dfs(root, 1);
        return ans;
    }
    
    public void dfs(TreeNode root, int level) {
        if (level > ans.size())
            ans.add(0, new ArrayList<Integer>());
        ans.get(ans.size()-level).add(root.val);
        
        if (root.left != null)
            dfs(root.left, level+1);
        if (root.right != null)
            dfs(root.right, level+1);
    }
}
