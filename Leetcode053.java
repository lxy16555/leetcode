package test;

//�Һ���������У�����O(n)�����洢max����temp��ֵС���㣬���¿�ʼ
public calss Leetcode053 {
    public int maxSubArray(int[] nums) {
	//max��¼���ͣ�temp��¼��ǰ�����Ƿ�Ϊ��
        int max = nums[0];
        int temp = 0;
        
	//ѭ����ÿ�αȽϴ�max������������к�С���㣬���¿�ʼ
        for (int i=0; i<nums.length; i++) {
            temp += nums[i];
            max = max > temp ? max : temp;
            
            if (temp < 0)
                temp = 0;
        }
        
        return max;
    }
}