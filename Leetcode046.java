package test;

//找到所有的permutation，用回溯法
public class Leetcode046 {
    //用于储存排序的解
    List<Integer> temp = new ArrayList<Integer>();

    //回溯法，isUsed存储已取的位置，rest存储剩下的数，ans存答案
    public void backTrack(int[]nums, int[] isUsed, int rest, List<List<Integer>> ans) {
        //当取完，加入ans并返回
        if (rest == 0) {
            ans.add(new ArrayList<Integer>(temp));
            return;
        }
        
        //回溯法本体
        for (int i=0; i<nums.length; i++) {
            if (isUsed[i] == 1)
                continue;
            temp.add(nums[i]);
            isUsed[i] = 1;
            rest--;
            backTrack(nums, isUsed, rest, ans);
            temp.remove(temp.size()-1);
            isUsed[i] = 0;
            rest++;
        }
        
        return;
    }
    
    //调用回溯法
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        int[] isUsed = new int[nums.length];
        for (int i=0; i<isUsed.length; i++)
            isUsed[i] = 0;
        backTrack(nums, isUsed, nums.length, ans);
        return ans;
    }
}