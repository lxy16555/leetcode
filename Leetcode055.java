package test;

//jump game的简单版本，遍历每一位能跳到的最末序列，只要大于长度就返回true
public class Leetcode055 {
    public boolean canJump(int[] nums) {
        if (nums.length <= 1)
            return true;
        
        int max = 0 + nums[0];
        int index = 1;
        
        while (index <= max) {
            max = max > (index + nums[index]) ? max : (index + nums[index]);
            if (max >= nums.length-1)
                return true;
            index++;
        }
        
        return false;
    }
}