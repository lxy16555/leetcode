package test;

//�ҵ���һ����������������Ҫ��O(n)ʱ�估�����ռ�
public class Leetcode041 {
    public int firstMissingPositive(int[] nums) {
    	//�趨�����ռ�
    	int[] temp = new int[nums.length];
    	
    	//��ʼ��
    	for (int i=0; i<nums.length; i++)
    		temp[i] = 0;
    	
    	//�������ĸ�����������Ч��Χ�ڣ��������ռ��Ϊ1
        for (int i=0; i<nums.length; i++)
        	if (nums[i] > 0 && nums[i] <= nums.length)
        		temp[nums[i]-1] = 1;
        
        //�ҵ���һ������0
        for (int i=0; i<nums.length; i++)
        	if (temp[i] == 0)
        		return i+1;
        
        //�����鳤��Ϊ0������ȫ����������+1������
        return nums.length+1;
    }
}
