package test;

//同上题，加入重复元素，先排序，当第二次取重复值时，跳过
public class Leetcode047 {
    //存储可能排序
    List<Integer> temp = new ArrayList<Integer>();

    //回溯法，isUsed存储已取的位置，rest存储剩下的数，ans存答案
    public void backTrack(int[]nums, int[] isUsed, int rest, List<List<Integer>> ans) {
        //当取完，加入ans并返回
        if (rest == 0) {
            ans.add(new ArrayList<Integer>(temp));
            return;
        }
        
        //回溯法本体，用pre记录上一个数字，若重复出现则跳过，否则更新pre，加入list
        int pre = -1;
        for (int i=0; i<nums.length; i++) {
            if (isUsed[i] == 1)
                continue;
            if (pre == -1 || nums[i] != nums[pre]) {
                pre = i;
                temp.add(nums[i]);
                isUsed[i] = 1;
                rest--;
                backTrack(nums, isUsed, rest, ans);
                temp.remove(temp.size()-1);
                isUsed[i] = 0;
                rest++;
            }
        }
        
        return;
    }
    
    //调用回溯法
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        int[] isUsed = new int[nums.length];
        for (int i=0; i<isUsed.length; i++)
            isUsed[i] = 0;
        backTrack(nums, isUsed, nums.length, ans);
        return ans;
    }
}