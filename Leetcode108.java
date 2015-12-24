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
    //转变sorted array为BST，找root然后分隔，用s，e表示左右子树的范围
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0)
            return null;
        
        int fullTree = 1;
        while (fullTree < nums.length) {
            fullTree = fullTree*2 + 1;
        }
        
        return buildTree(nums, fullTree, 0, nums.length);
    }
    
    public TreeNode buildTree(int[] nums, int fullTree, int start, int end) {
        if (start >= end)
            return null;
        
        int distance = fullTree- (end - start);
        int cur = start+(fullTree/2) - (distance+1)/2;
        TreeNode root = new TreeNode(nums[cur]);
        
        if (fullTree == 1)
            return root;
        
        root.left = buildTree(nums, fullTree/2, start, cur);
        root.right = buildTree(nums, fullTree/2, cur+1, end);
        
        return root;
    }
}
