package test;

//�Ƴ��ظ����֣�ÿ����������������
public class Leetcode080 {
    //����ָ��������count��¼���ִ���
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