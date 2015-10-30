package test;

//找有重复数字的subset，做法跟找没重复subset一样，加一步比较是否已含有
public class Leetcode090 {
    List<Integer> temp = new ArrayList<>();
    
    public void addSubsets(int[] nums, int start, List<List<Integer>> ans) {
        if (start > nums.length)
            return;
            
        ans.add(new ArrayList<>(temp));
        
        for (int i=start; i<nums.length; i++) {
            if (i>start && nums[i] == nums[i-1])
                continue;
            temp.add(nums[i]);
            addSubsets(nums, i+1, ans);
            temp.remove(temp.size()-1);
        }
    }
    
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        
        Arrays.sort(nums);
        addSubsets(nums, 0, ans);
        
        return ans;
    }
}