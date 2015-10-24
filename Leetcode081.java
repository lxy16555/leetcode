package test;

//用binary search最快，但是用逐一比较也可
public class Leetcode081 {
    public boolean search(int[] nums, int target) {
        for (int i=0; i<nums.length; i++)
            if (nums[i] == target)
                return true;
        
        return false;
    }
}