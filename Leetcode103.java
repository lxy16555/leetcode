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
    //zigzag存入，上一题dfs方法行不通，使用bfs，用treenodes存该层应该读取的节点，并不断改写保证time limit和memory limit
    List<List<Integer>> ans = new ArrayList<List<Integer>>();
    List<TreeNode> treenodes = new ArrayList<TreeNode>();
    
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null)
            return ans;
        treenodes.add(root);
        int mark = 0;
        
        while (!treenodes.isEmpty()) {
            List<Integer> cur = new ArrayList<Integer>();
            if (mark == 0) {
                int point = 0;
                while (point < treenodes.size()) {
                    TreeNode tmp = treenodes.get(point);
                    cur.add(tmp.val);
                    treenodes.remove(point);
                    if (tmp.left != null) {
                        treenodes.add(point, tmp.left);
                        point++;
                    }
                    if (tmp.right != null) {
                        treenodes.add(point, tmp.right);
                        point++;
                    }
                }
                mark = 1;
            } else {
                int point = treenodes.size() - 1;
                while (point >= 0) {
                    TreeNode tmp = treenodes.get(point);
                    cur.add(tmp.val);
                    treenodes.remove(point);
                    if (tmp.right != null) 
                        treenodes.add(point, tmp.right);
                    if (tmp.left != null) 
                        treenodes.add(point, tmp.left);
                    point--;
                }
                mark = 0;
            }
            ans.add(new ArrayList<Integer>(cur));
            cur.clear();
        }
        
        return ans;
    }
}
