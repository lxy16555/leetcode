package test;

//找一个数组的所有子数组，DFS问题，不同点是为了加快速度，在遍历树的时候即可以存入temp作为答案
public class Leetcode078 {
    List<Integer> temp = new ArrayList<Integer>();
    
    //DFS算法，在遍历时即加入答案
    public void dfsAlgorithm(int[] nums, int startpoint, int k, List<List<Integer>> ans) {
        ans.add(new ArrayList<Integer>(temp));
        
        for (int i=startpoint; i<nums.length; i++) {
            temp.add(nums[i]);
            dfsAlgorithm(nums, i+1, k, ans);
            temp.remove(temp.size()-1);
        }
    }
    
    //调用dfs
    public List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        
        dfsAlgorithm(nums, 0, nums.length, ans);
        
        return ans;
    }
}