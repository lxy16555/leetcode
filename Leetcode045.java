package test;

//���ַ���ͷ��Ծ��β���Ƚ�ÿ�������ĸ�����´�����������Զ��һ��������õ���ʵ����ʱ�临�Ӷ�ΪO(n^2)��������ָ��Ľ���ΪO(n)
public class Leetcode045 {
    //������
    public int jump(int[] nums) {
        //��ʼ���������鳤��Ϊ0����1��������
        if (nums.length <= 1)
            return 0;
        
        //��д���飬�洢ÿһλ����������Զ���
        for (int i=0; i<nums.length-1; i++)
            nums[i] = (i+nums[i]) < (nums.length-1) ? (i+nums[i]) : (nums.length-1);
        
        //preǰһ����curĿǰΪֹ��count����
        int pre = -1;
        int cur = 0;
        int count = 0;
        
        //��ͷ����������cur����Զ������cur������ʱi����pre����Ծ��Χ������pre������������λ����ֱ��������β��ֱ�ӷ���count+1
        for (int i=0; i<nums.length; i++) {
            if (nums[i] > nums[cur] && (pre == -1 || i > nums[pre])) {
                pre = cur;
                cur = i;
                count++;
            } else {
                if (nums[i] > nums[cur])
                    cur = i;
            }
            
            if (nums[i] == nums.length-1)
                return (count+1);
        }
        
        return 0;
    }
}