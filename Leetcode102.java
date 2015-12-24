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
    //可用bfs也可用dfs，bfs需要存一个treenode序列，这里用dfs，记录level来决定加入哪一层，inorder顺序确保排列
    List<List<Integer>> ans = new ArrayList<List<Integer>>();
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null)
            return ans;
        
        dfs(root, 1);
        
        return ans;
    }
    
    public void dfs(TreeNode root, int level) {
        if (ans.size() < level)
            ans.add(new ArrayList<Integer>());
        ans.get(level-1).add(root.val);
        
        if (root.left != null)
            dfs(root.left, level+1);
        if (root.right != null)
            dfs(root.right, level+1);
    }
}
