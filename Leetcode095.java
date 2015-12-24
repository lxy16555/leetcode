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
    //DP问题，给定n，则有n种可能的root取值，然后两边重复操作
    public List<TreeNode> generateTrees(int n) {
        if (n == 0)
            return new ArrayList<TreeNode>();
        
        return uniqueBST(1, n);
    }
    
    public List<TreeNode> uniqueBST(int start, int end) {
        List<TreeNode> ans = new ArrayList<TreeNode>();
        
        if (start > end) {
            ans.add(null);
            return ans;
        }
        
        if (start == end) {
            TreeNode head = new TreeNode(start);
            ans.add(head);
            return ans;
        }
        
        for (int i=start; i<=end; i++) {
            List<TreeNode> left = uniqueBST(start, i-1);
            List<TreeNode> right = uniqueBST(i+1, end);
            
            for (TreeNode leftNode : left) {
                for (TreeNode rightNode : right) {
                    TreeNode head = new TreeNode(i);
                    head.left = leftNode;
                    head.right = rightNode;
                    ans.add(head);
                }
            }
        }
        
        return ans;
    }
}
