package test;

//��binary search��죬��������һ�Ƚ�Ҳ��
public class Leetcode081 {
    public boolean search(int[] nums, int target) {
        for (int i=0; i<nums.length; i++)
            if (nums[i] == target)
                return true;
        
        return false;
    }
}