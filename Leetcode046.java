package test;

//�ҵ����е�permutation���û��ݷ�
public class Leetcode046 {
    //���ڴ�������Ľ�
    List<Integer> temp = new ArrayList<Integer>();

    //���ݷ���isUsed�洢��ȡ��λ�ã�rest�洢ʣ�µ�����ans���
    public void backTrack(int[]nums, int[] isUsed, int rest, List<List<Integer>> ans) {
        //��ȡ�꣬����ans������
        if (rest == 0) {
            ans.add(new ArrayList<Integer>(temp));
            return;
        }
        
        //���ݷ�����
        for (int i=0; i<nums.length; i++) {
            if (isUsed[i] == 1)
                continue;
            temp.add(nums[i]);
            isUsed[i] = 1;
            rest--;
            backTrack(nums, isUsed, rest, ans);
            temp.remove(temp.size()-1);
            isUsed[i] = 0;
            rest++;
        }
        
        return;
    }
    
    //���û��ݷ�
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        int[] isUsed = new int[nums.length];
        for (int i=0; i<isUsed.length; i++)
            isUsed[i] = 0;
        backTrack(nums, isUsed, nums.length, ans);
        return ans;
    }
}