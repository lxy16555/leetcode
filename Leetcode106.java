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
    //用inorder和postorder顺序创建BT，此种问题的优质解法，用s，e记录每次recursive的起点及终点
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0)
            return null;
        
        return buildTree(inorder, postorder, 0, inorder.length-1, 0, postorder.length-1);
    }
    
    public TreeNode buildTree(int[] inorder, int[] postorder, int is, int ie, int ps, int pe) {
        if (is > ie || ps > pe)
            return null;
        
        TreeNode root = new TreeNode(postorder[pe]);
        if (is == ie)
            return root;
        
        int mark = 0;
        for (int i=is; i<=ie; i++) {
            if (inorder[i] == root.val) {
                mark = i;
                break;
            }
        }
        
        root.right = buildTree(inorder, postorder, mark+1, ie, ps, pe-1);
        root.left = buildTree(inorder, postorder, is, mark-1, ps, pe-1-ie+mark);
        return root;
    }
}
