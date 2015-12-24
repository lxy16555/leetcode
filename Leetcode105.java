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
    //通过inorder和preorder顺序创建BT，记录preorder的数在inorder里出现的位置，用stack记录每个可以增加右子树的位置，用另一个stack记录差值方便更新
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0)
            return null;
        TreeNode root = new TreeNode(preorder[0]);
        TreeNode cur = root;
        
        int length = preorder.length;
        int[] order = new int[length];
        
        for (int i=0; i<length; i++) {
            for (int j=0; j<length; j++) {
                if (inorder[j] == preorder[i]) {
                    order[i] = j;
                    break;
                }
            }
        }
        
        Stack<Integer> mark = new Stack<Integer>();
        Stack<TreeNode> insert = new Stack<TreeNode>();
        insert.push(root);
        mark.push(order[0]);
        
        for (int i=1; i<length; i++) {
            TreeNode tmp = new TreeNode(preorder[i]);
            
            if (order[i] < order[i-1]) {
                cur.left = tmp;
                if (order[i-1] - order[i] != 1) {
                    mark.push(order[i-1]);
                    insert.push(tmp);
                }
            } else {
                cur = insert.pop();
                if (mark.peek() - order[i] > 1 || mark.peek() - order[i] < 0) {
                    insert.push(tmp);
                } else {
                    mark.pop();
                }
                cur.right = tmp;
            }
            cur = tmp;
        }
        
        return root;
    }
}
