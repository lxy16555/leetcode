package test;

//移除重复数字，每个数字最多出现两次
public class Leetcode080 {
    //两个指针解决，用count记录出现次数
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0)
            return 0;
        
        Arrays.sort(nums);
        
        int current = 1;
        int count = 1;
        for (int i=1; i<nums.length; i++) {
            if (nums[i] == nums[i-1]) {
                if (count <= 1) {
                    count++;
                    nums[current] = nums[i];
                    current++;
                }
            } else {
                count = 1;
                nums[current] = nums[i];
                current++;
            }
        }
        
        return current;
    }
}