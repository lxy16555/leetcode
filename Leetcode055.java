package test;

//jump game�ļ򵥰汾������ÿһλ����������ĩ���У�ֻҪ���ڳ��Ⱦͷ���true
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